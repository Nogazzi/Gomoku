/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gracze;

import Interfejsy.GraczInterfejs;

/**
 *
 * @author Nogaz
 */
public class Gracz {

    int numerGracza;
    String imieGracza;
    
    GraczInterfejs zachowanieGracza;
    
    public Gracz(int numerGracza, String imieGracza){
        this.numerGracza = numerGracza;
        this.imieGracza = imieGracza;
    }
    
    public int getNumerGracza(){
        return this.numerGracza;
    }
    
    public String getImieGracza(){
        return this.imieGracza;
    }
    
}
