package KlasyGlowne;


import Gracze.Gracz;
import Gracze.GraczCPU;
import Gracze.GraczZywy;
import Interfejsy.AktualizacjaGobanListener;
import Interfejsy.AktualizacjaGobanPodmiot;
import Interfejsy.KoniecGryListener;
import Interfejsy.KoniecGryPodmiot;
import Interfejsy.SterowaniePodczasGry;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwa
 */
public class WatekNowejGry extends Thread implements MouseListener, MouseMotionListener, AktualizacjaGobanPodmiot, KoniecGryPodmiot{
    
    AktualizacjaGobanListener gobanListener;
    KoniecGryListener listenerKoncaGry;
    SterowaniePodczasGry sterowaniePodczasGry;
    Pole[][] plansza;
    int liczbaRzedow = 15;
    int liczbaKolumn = 15;
    int czyjaKolej;
    boolean brakWygranej;
    String ktoWygral;
    
    Gracz gracz1;
    Gracz gracz2;
    
    public WatekNowejGry(int typGry, String nazwaGracza1, String nazwaGracza2){
        //typGry = new SterowaniePodczasGryPvP(typGry, "Ziemowit", "Zygmunt", null);
        System.out.println("WLACZYLEM WATEK");
        plansza = new Pole[15][15];
        for(int i = 0 ; i < 15 ; ++i ){
            for(int j = 0 ; j < 15 ; ++j ){
                plansza[i][j] = new Pole(i, j, 40);
            }
        }
        czyjaKolej = 1;
        System.out.println("NrTypugry = " + typGry);
        //ustawienie typu gry
        if( typGry == 49 ){  //gra PvP
            sterowaniePodczasGry = new SterowaniePodczasGryPvP();
            gracz1 = new GraczZywy(1, nazwaGracza1);
            gracz2 = new GraczZywy(2, nazwaGracza2);
        }else if( typGry == 50 ){    //gra PvC
            sterowaniePodczasGry = new SterowaniePodczasGryPvC();
            gracz1 = new GraczZywy(1, nazwaGracza1);
            gracz2 = new GraczCPU(2, nazwaGracza2);
        }else if( typGry == 51 ){    //gra CvC
            sterowaniePodczasGry = new SterowaniePodczasGryCvC();
            gracz1 = new GraczCPU(1, nazwaGracza1);
            gracz2 = new GraczCPU(2, nazwaGracza2);
        }else{
            System.out.println("ERROR");
        }
        brakWygranej = true;
    }
    
    @Override
    public void start(){
        czyjaKolej = sterowaniePodczasGry.ustawRozpoczynajacego();
        run();
    }
    @Override
    public void run(){
        sterowaniePodczasGry.przygotujGracza(null);
       /*
       while( brakWygranej == true ){
           sterowaniePodczasGry.przygotujGracza(null);
           
       }*/
       
    }
    
    public void zmienGracza(){
        System.out.println("ZmieniamGracza");
        if( czyjaKolej == 1){
            czyjaKolej = 2;
        }else{
            czyjaKolej = 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int x = e.getX();
        int y = e.getY();
        System.out.println("X = " + x + ", Y = " +y);
        System.out.println("Stan tego pola: " + znajdzPoleOWspolrzednych(x, y).getStanPola());
        //znajdzPoleOWspolrzednych(x, y).ustawStanPola(czyjaKolej);
        
        
        for( int i = 0 ; i < liczbaRzedow ; ++i ){
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                if( plansza[i][j].czyNaPolu(x, y) ){    //pionek znajduje sie na polu pod kursorem
                    if( plansza[i][j].getStanPola() != 1 && plansza[i][j].getStanPola() != 2 ){
                        sterowaniePodczasGry.zapiszRuch(plansza[i][j], czyjaKolej, x, y);
                        odmalujGoban();
                        System.out.println("Czyja kolej = " + czyjaKolej);
                        if( czyjaKolej == 1 ){
                            System.out.println("Sprawdzam wygrana gracza1(czarny)");
                            if( czyWygral(gracz1) == true ){
                                setKtoWygral(gracz1.getImieGracza());
                                powiadomOKoncuGry();
                            }
                        }else if( czyjaKolej == 2 ){
                            System.out.println("Sprawdzam wygrana gracza2(bialy)");
                            if( czyWygral(gracz2) == true ){
                                setKtoWygral(gracz2.getImieGracza());
                                powiadomOKoncuGry();
                            }
                            
                        }
                        zmienGracza();
                    }
                }
            }
        }
        
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for( int i = 0 ; i < liczbaRzedow ; ++i ){
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                if( (plansza[i][j].getStanPola() != 1) && (plansza[i][j].getStanPola() != 2) ){
                    plansza[i][j].ustawStanPola(0);
                    odmalujGoban();
                }
                
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("Ruszam mysza");
        //System.out.println(e.getX() + ", " + e.getY() );
        int x = e.getX();
        int y = e.getY();
        
        
        for( int i = 0 ; i < liczbaRzedow ; ++i ){
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                if( plansza[i][j].czyNaPolu(x, y) ){    //pionek znajduje sie na polu pod kursorem
                    if( plansza[i][j].getStanPola() == 0 ){     //pole było puste, wiec moge umiescic cień
                        if( czyjaKolej == 1 ){
                            //plansza[i][j].ustawStanPola(11);
                            sterowaniePodczasGry.zapiszRuch(plansza[i][j], 11, x, y);
                        }else if( czyjaKolej == 2 ){
                            //plansza[i][j].ustawStanPola(12);
                            sterowaniePodczasGry.zapiszRuch(plansza[i][j], 12, x, y);
                        }
                    }else{  //pole nie bylo puste
                           //na polu znajduje sie jakis pionek, wiec nic z nim nie robie
                    }
                }else{      //pionek nie znajduje sie na polu pod kursorem
                    if( (plansza[i][j].getStanPola() == 11) || (plansza[i][j].getStanPola() == 12) ){   //jesli pole bylo zacieniowane to mozemy je odcieniowac
                        //plansza[i][j].ustawStanPola(0);
                        sterowaniePodczasGry.zapiszRuch(plansza[i][j], 0, x, y);
                    }
                }
            }
        }
        odmalujGoban();
        //znajdzPoleOWspolrzednych(x, y).ustawStanPola(czyjaKolej+10);
        
        
    }

  
    public Pole znajdzPoleOWspolrzednych(int x, int y){
        //Pole result;
        for( int i = 0 ; i < liczbaKolumn ; ++i ){
            for( int j = 0 ; j < liczbaRzedow ; ++j ){
                if( plansza[i][j].czyNaPolu(x, y) ){
                    return plansza[i][j];
                }
            }
        }
        return null;
    }

    @Override
    public void dodajListeneraAktualizacjiGoban(AktualizacjaGobanListener l) {
        gobanListener = l;
    }

    @Override
    public void usunListeneraAktualizacjiGoban(AktualizacjaGobanListener l) {
        gobanListener = null;
    }

    @Override
    public void odmalujGoban() {
        gobanListener.aktualizujStanPlanszy();
    }
    
    
    public boolean czyWygral(Gracz gracz){
        System.out.println("Metoda sprawdzania wygranej");
        int licznik = 0;
        //sprawdzanie w pionie
        for( int j = 0 ; j < liczbaKolumn ; ++j ){
            licznik = 0;
            for( int i = 0 ; i < liczbaRzedow ; ++i ){
                if( plansza[i][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        System.out.println("\n"+ gracz.getImieGracza() + " wygral\n");
                        //powiadomOWygranej(gracz);
                        return true;
                    }
                }else{
                    licznik = 0;
                }
            }
        }
        //sprawdzanie w poziomie
        for( int i = 0 ; i < liczbaRzedow ; ++i ){
            licznik = 0;
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                if( plansza[i][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        System.out.println("\n"+ gracz.getImieGracza() + " wygral\n");
                        //powiadomOWygranej(gracz);
                        return true;
                    }
                }else{
                    licznik = 0;
                }
            }
        }
        //sprawdzanie po skosie w kierunku prawy dol
        //1: dla znakow na oraz ponizej glownej przekatnej
        for( int i = 0; i<(liczbaRzedow - 4 ) ; ++i ){
            licznik = 0;
            for( int j = 0 ; j < liczbaKolumn-i-4 ; ++j ){
		if( plansza[i+j][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        System.out.println("\n"+ gracz.getImieGracza() + " wygral\n");
                        //powiadomOWygranej(gracz);
                        return true;
                    }
		}
		else{
                    licznik = 0;
		}
		
            }
	}
	//2: dla znakow powyzej gornej przekatnej
	for( int j = 1 ; j < liczbaKolumn - 4 ; ++j ){
            for(int i = 0 ; i < liczbaRzedow - j ; ++i ){
		if( plansza[i][j+i].getStanPola() == gracz.getNumerGracza()){
                    licznik++;
                    if( licznik >= 5 ){
                        System.out.println("\n"+ gracz.getImieGracza() + " wygral\n");
                        //powiadomOWygranej(gracz);
                        return true;
                    }
		}else{
                    licznik = 0;
		}
		
            }	
	}
        //sprawdzanie po skosie w kierunku prawa gora
        //1: dla elementow na glownej przekatnej i powyzej
	for( int i = liczbaRzedow - 1 ; i >= 4 ; --i ){
            for( int j = 0 ; j <= i ; ++j ){
		if( plansza[i-j][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        System.out.println("\n"+ gracz.getImieGracza() + " wygral\n");
                        //powiadomOWygranej(gracz);
			return true;	//wygrana
                    }
                }else{
                    licznik = 0;
		}
			
            }
	}
	//2: dla znakow ponizej przekatnej
	for( int j = 1 ; j < liczbaKolumn - 4 ; ++j ){
            int a = j;	//zmienna pomocnicza
            for( int i = liczbaRzedow - 1 ; i >= j ; --i ){
		if( plansza[i][a+1].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        System.out.println("\n"+ gracz.getImieGracza() + " wygral\n");
                        //powiadomOWygranej(gracz);
			return true;	//wygrana
                    }   
		}else{
                    licznik = 0;
		}
            }
	}
        System.out.println("\n" + gracz.getImieGracza() + " nie wygral\n");
        return false;
    }

    @Override
    public void dodajKoniecGryListenera(KoniecGryListener l) {
        listenerKoncaGry = l;
    }

    @Override
    public void usunKoniecGryListenera(KoniecGryListener l) {
        listenerKoncaGry = null;
    }

    @Override
    public void powiadomOKoncuGry() {
        listenerKoncaGry.zakonczRozgrywke();
    }
    
    public void setKtoWygral(String ktoWygral){
        this.ktoWygral = ktoWygral;
    }
    public String getKtoWygral(){
        return ktoWygral;
    }
    
}
