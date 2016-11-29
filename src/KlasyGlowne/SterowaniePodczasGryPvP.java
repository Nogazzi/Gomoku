package KlasyGlowne;


import Gracze.Gracz;
import Interfejsy.SterowaniePodczasGry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nogaz
 */
public class SterowaniePodczasGryPvP implements SterowaniePodczasGry/*, MouseListener, MouseMotionListener*/{

    public SterowaniePodczasGryPvP() {
    }

    

    @Override
    public void uruchomGre() {
        
    }

    @Override
    public int ustawRozpoczynajacego() {
        int czyjaKolej = (int)(Math.random()*10);
        czyjaKolej%=2;
        return czyjaKolej+1;
    }
    
    @Override
    public void przygotujGracza(Gracz gracz) {
        
        
    }

    @Override
    public void zmienGracza(Gracz gracz) {
        
    }

    @Override
    public void zapiszRuch(Pole pole, int nowyStan, int x, int y) {
        pole.ustawStanPola(nowyStan);
    }

    @Override
    public void cofnijRuch(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void powiadomOWygranej() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //System.out.println("ruch mysza na X,Y=( " + x + ", " + y + ")");
        for( int i = 0 ; i < liczbaWierszy ; ++i ){
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                if( plansza[i][j].czyNaPolu(x, y) ){
                    //mysz znajduje sie na polu
                    //System.out.println("Mysz znajduje sie na polu: [" + i + "," + j + "]");
                    int stan = plansza[i][j].getStanPola();
                    if( stan != 1 && stan != 2 ){
                        if( czyjRuch() == 1 ){
                            plansza[i][j].ustawStanPola(11);
                            //poleGry.repaint();
                            break;
                        }else if( czyjRuch() == 2 ){
                            plansza[i][j].ustawStanPola(21);
                            //plansza[i][j].repaint();
                            break;
                        }
                    }
                    
                }else{
                    int stan = plansza[i][j].getStanPola();
                    if( stan != 1 && stan != 2 ){
                        plansza[i][j].ustawStanPola(0);
                    }
                }
            }
        }
        poleGry.repaint();
    }
    
   
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for( int i = 0 ; i < liczbaWierszy ; ++i ){
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                if( plansza[i][j].czyNaPolu(x, y)){
                    int stan = plansza[i][j].getStanPola();
                    if(  stan != 1 && stan != 2 ){
                        if( czyjRuch() == 1 ){
                            plansza[i][j].ustawStanPola(gracz1.getNumerGracza());
                            break;
                            
                        }else if( czyjRuch() == 2 ){
                            plansza[i][j].ustawStanPola(gracz2.getNumerGracza());
                            break;
                        }
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/

    @Override
    public void ustawCienPionka() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
