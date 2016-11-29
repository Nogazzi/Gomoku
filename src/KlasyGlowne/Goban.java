package KlasyGlowne;


import Interfejsy.AktualizacjaGobanListener;
import Interfejsy.KoniecGryListener;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nogaz
 */
public class Goban extends JPanel  implements AktualizacjaGobanListener, KoniecGryListener /*implements RysowaniePionkaPodmiot*/  {
   
    WatekNowejGry watekNowejGry;
    
    //private ArrayList obserwatorzy;
    
    int liczbaKolumn = 15;
    int liczbaWierszy = 15;
    int rozmiarPola = 40;
    Color kolor;
    
    
    public Goban(){
        //obserwatorzy = new ArrayList();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        rozmiarPola = getWidth()/liczbaKolumn;
        //System.out.println("Goban auto: " + getWidth() + "x" + getHeight());
        //System.out.println("rozmiar pola: " + rozmiarPola);
        
        super.paintComponent(g);
        //rysuj siatke gry
        kolor = new Color(0,0,0);
        for( int i = 0 ; i < liczbaWierszy + 1 ; ++i ){
            if( i != 0 ){
            //linie pomocnicze
            kolor = new Color(255,222,173);
            g.setColor(kolor);
            g.drawLine(0, i*rozmiarPola, getWidth(), i*rozmiarPola);
            g.drawLine(i*rozmiarPola, 0, i*rozmiarPola, getHeight());
            }
            kolor = new Color(0,0,0);
            g.setColor(kolor);
            //rysuje poziome linie
            g.drawLine(0, i*rozmiarPola + rozmiarPola/2, getWidth(), i*rozmiarPola + rozmiarPola/2);
            //rysuje pionowe linie
            g.drawLine(i*rozmiarPola + rozmiarPola/2, 0, i*rozmiarPola + rozmiarPola/2, getHeight());
            //rysuje pole postawienia pionka           
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                g.fillOval((i*rozmiarPola + rozmiarPola/2)-4, (j*rozmiarPola + rozmiarPola/2)-4, 8, 8);
            }
            //namalujObserwatorowNaPlanszy(g);
        }
        if( watekNowejGry != null ) {
            for( int i = 0 ; i < watekNowejGry.liczbaKolumn ; ++i ){
                for( int j = 0 ; j < watekNowejGry.liczbaRzedow ; ++j ){
                    watekNowejGry.plansza[i][j].namalujSieNaPlanszy(g);
                }
            }
        }
        
    }
/*
    @Override
    public void zarejestrujObserwatora(RysowaniePionkaListener o) {
        obserwatorzy.add(o);
    }

    @Override
    public void usunObserwatora(RysowaniePionkaListener o) {
        int i = obserwatorzy.indexOf(o);
        if( i >= 0 ){
            obserwatorzy.remove(i);
        }
    }

    @Override
    public void namalujObserwatorowNaPlanszy(Graphics g) {
        for( int i = 0 ; i < obserwatorzy.size() ; ++i ){
            RysowaniePionkaListener obs = (RysowaniePionkaListener)obserwatorzy.get(i);
            obs.namalujSieNaPlanszy(g);
        }
    }*/

    public void uruchomNowaGre(int trybGry, String gracz1, String gracz2){
        watekNowejGry = new WatekNowejGry(trybGry, gracz1, gracz2);
        this.addMouseListener(watekNowejGry);
        this.addMouseMotionListener(watekNowejGry);
        watekNowejGry.dodajListeneraAktualizacjiGoban(this);
        watekNowejGry.dodajKoniecGryListenera(this);
        System.out.println("Stworzylem watek nowej gry. Tryb: " + trybGry + ", gracz1: " + gracz1 + ", gracz2: " + gracz2);
        watekNowejGry.start();
    }

    @Override
    public void aktualizujStanPlanszy() {
        repaint();
    }

    @Override
    public void zakonczRozgrywke() {
        //watekNowejGry.usunKoniecGryListenera(this);
        this.removeMouseListener(watekNowejGry);
        this.removeMouseMotionListener(watekNowejGry);
        KoniecGryDialog koniecGryDialog = new KoniecGryDialog(null, true);
        koniecGryDialog.setLocationByPlatform(true);
        koniecGryDialog.ktoWygralLabel.setText("Wygrał(a) " + watekNowejGry.getKtoWygral());
        koniecGryDialog.setVisible(true);
        watekNowejGry = null;   
//wrzuc alerta o wygranej!
    }
    
    
}
