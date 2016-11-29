package KlasyGlowne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Interfejsy.RysowaniePionkaListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Nogaz
 */
public class Pole extends JPanel implements RysowaniePionkaListener{
    int indeksX;
    int indeksY;
    int stanPola;
    int dlugoscPola;
    int xPoczatek;
    int yPoczatek;
    int rozmiarPola;
    Color kolor;
    
    public Pole(int indeksX, int indeksY, int dlPola){
        this.indeksX = indeksX;
        this.indeksY = indeksY;
        this.dlugoscPola = dlPola;
        this.rozmiarPola = dlPola;
        //this.stanPola = (int)(Math.random()*3);
        //System.out.println("stan pola = " + stanPola);
        xPoczatek = indeksX*dlPola;
        yPoczatek = indeksY*dlPola;
       // System.out.println("pole[" + indeksX + ", " + indeksY + "]");
        //System.out.println("Dlugosc pola " + dlPola);
        //System.out.println("xPoczatek: " + xPoczatek + ", yPoczatek: " + yPoczatek);
    }
    
    public void ustawStanPola(int nowyStan){
        //System.out.println("Ustawiam stan pola [" + indeksX + "," + indeksY + "] na wartosc: " + nowyStan);
        this.stanPola = nowyStan;
    }    
    public int getStanPola(){
        return stanPola;
    }
    public int getIndeksX(){
        return indeksX;
    }
    public int getndeksY(){
        return indeksY;
    }
    //metoda sprawdzajaca czy podany punkt o wspolrzednych x,y znajduje sie na danym polu
    boolean czyNaPolu(int x, int y){
        //System.out.println("wspolrzedne: " + x + "," + y);
        if( (x >= xPoczatek) && (x <= xPoczatek + dlugoscPola)){
            if( (y >= yPoczatek) && (y <= yPoczatek + dlugoscPola) ){
                //System.out.println("Znajduje się w kwadracie x=[" + xPoczatek + "," + (xPoczatek+dlugoscPola) + "], y=[" + yPoczatek + "," + (yPoczatek+dlugoscPola) + "]");
                return true;
            }
        }
        //System.out.println("Znajduje NIE się w kwadracie x=[" + xPoczatek + "," + (xPoczatek+dlugoscPola) + "], y=[" + yPoczatek + "," + (yPoczatek+dlugoscPola) + "]");
        return false;
    }
    protected void wypelnijPole(Graphics g){
        
        if( stanPola == 1 ){    //na polu jest pionek gracza1(czarny)
            kolor = new Color(0,0,0);
            g.setColor(kolor);
            g.fillOval((indeksX*rozmiarPola + rozmiarPola/2)-15, (indeksY*rozmiarPola + rozmiarPola/2)-15, 30, 30);
        }else if( stanPola == 2 ){  //na polu jest pionek gracza2(bialy)
            kolor = new Color(255,255,255);
            g.setColor(kolor);
            g.fillOval((indeksX*rozmiarPola + rozmiarPola/2)-15, (indeksY*rozmiarPola + rozmiarPola/2)-15, 30, 30);
        }else if( stanPola == 11 ){ //gracz1(czarny) przesunal kursor nad dane pole, rysuj przeswitujacy pionek
            kolor = new Color(0f,0f,0f, 0.5f);
            g.setColor(kolor);
            g.fillOval((indeksX*rozmiarPola + rozmiarPola/2)-15, (indeksY*rozmiarPola + rozmiarPola/2)-15, 30, 30);
        }else if( stanPola == 12 ){ //gracz2(bialy) przesunal kursor nad dane pole, rysuj przeswitujacy pionek
            kolor = new Color(1f,1f,1f,0.5f);
            g.setColor(kolor);
            g.fillOval((indeksX*rozmiarPola + rozmiarPola/2)-15, (indeksY*rozmiarPola + rozmiarPola/2)-15, 30, 30);
        }
    }

    @Override
    public void namalujSieNaPlanszy(Graphics g) {
        wypelnijPole(g);
        //System.out.println("Wypelniam sie");
    }
    

}
