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
public class GraczCPU extends Gracz implements GraczInterfejs{

    public GraczCPU(int numerGracza, String imieGracza) {
        super(numerGracza, imieGracza);
    }

    
    @Override
    public void wykonajRuch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
