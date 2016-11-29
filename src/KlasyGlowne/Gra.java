package KlasyGlowne;


import Gracze.Gracz;
import Interfejsy.SterowaniePodczasGry;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
public class Gra implements MouseMotionListener, MouseListener{
    int wynikGry;   //0 - remis, 1 - wygrana gracza1, 2 - wygrana gracza 2
    int czyjRuch;
    Gracz gracz1;
    Gracz gracz2;
    int poziomCPU1;
    int poziomCPU2;
    Pole plansza[][];
    int liczbaKolumn = 15;
    int liczbaWierszy = 15;
    int dlPola = 40;
    SterowaniePodczasGry sterowanie;
    Goban poleGry;     //referencja do polaGry żebym mogl sie potem zarejestrowac jako sluchacz
    Graphics g;
    
    public Gra(int trybGry, String gracz1, String gracz2, Goban poleGry){
        System.out.println("\nWlasnie utworzylem nowa gre w trybie " + trybGry);
        plansza = new Pole[liczbaWierszy][liczbaKolumn];
        for( int i = 0 ; i < liczbaWierszy ; ++i ){
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                plansza[i][j] = new Pole(i, j, dlPola);
                //poleGry.zarejestrujObserwatora(plansza[i][j]);
            }
        }
        this.poleGry = poleGry;
        this.poleGry.addMouseMotionListener(this);
        this.poleGry.addMouseListener(this);
        poleGry.addMouseMotionListener(this);
        //plotno = new PoleGry();
        //poleGry.add(plotno);
        
        //utworzenie graczy
        this.gracz1 = new Gracz(1, gracz1);
        this.gracz2 = new Gracz(2, gracz2);
        
        czyjRuch = 1;
        poleGry.repaint();
    }

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
    
    public int czyjRuch(){
        return czyjRuch;
    }
    
    public void zmienGracza(){
        if( czyjRuch() == 1 ){
            czyjRuch = 2;
        }else if( czyjRuch() == 2 ){
            czyjRuch = 1;
        }
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
                            if( czyWygral(gracz1) == true ){
                                
                            }else{
                                zmienGracza();
                            }
                            break;                            
                        }else if( czyjRuch() == 2 ){
                            plansza[i][j].ustawStanPola(gracz2.getNumerGracza());
                            if( czyWygral(gracz2) ){
                                
                            }else{
                                zmienGracza();
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public void powiadomOWygranej(Gracz gracz){
        System.out.println("Wygral gracz " + gracz.getImieGracza() + "!!!");
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

    
    public boolean czyWygral(Gracz gracz){
        int licznik = 0;
        //sprawdzanie w pionie
        for( int j = 0 ; j < liczbaKolumn ; ++j ){
            licznik = 0;
            for( int i = 0 ; i < liczbaWierszy ; ++i ){
                if( plansza[i][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        powiadomOWygranej(gracz);
                        return true;
                    }
                }else{
                    licznik = 0;
                }
            }
        }
        //sprawdzanie w poziomie
        for( int i = 0 ; i < liczbaWierszy ; ++i ){
            licznik = 0;
            for( int j = 0 ; j < liczbaKolumn ; ++j ){
                if( plansza[i][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        powiadomOWygranej(gracz);
                        return true;
                    }
                }else{
                    licznik = 0;
                }
            }
        }
        //sprawdzanie po skosie w kierunku prawy dol
        //1: dla znakow na oraz ponizej glownej przekatnej
        for( int i = 0; i<(liczbaWierszy - 4 ) ; ++i ){
            licznik = 0;
            for( int j = 0 ; j < liczbaKolumn-i-4 ; ++j ){
		if( plansza[i+j][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        powiadomOWygranej(gracz);
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
            for(int i = 0 ; i < liczbaWierszy - j ; ++i ){
		if( plansza[i][j+i].getStanPola() == gracz.getNumerGracza()){
                    licznik++;
                    if( licznik >= 5 ){
                        powiadomOWygranej(gracz);
                        return true;
                    }
		}else{
                    licznik = 0;
		}
		
            }	
	}
        //sprawdzanie po skosie w kierunku prawa gora
        //1: dla elementow na glownej przekatnej i powyzej
	for( int i = liczbaWierszy - 1 ; i >= 4 ; --i ){
            for( int j = 0 ; j <= i ; ++j ){
		if( plansza[i-j][j].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        powiadomOWygranej(gracz);
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
            for( int i = liczbaWierszy - 1 ; i >= j ; ++i ){
		if( plansza[i][a++].getStanPola() == gracz.getNumerGracza() ){
                    licznik++;
                    if( licznik >= 5 ){
                        powiadomOWygranej(gracz);
			return true;	//wygrana
                    }   
		}else{
                    licznik = 0;
		}
            }
	}
        System.out.println("Gracz nie wygral");
        return false;
    }
    
}
