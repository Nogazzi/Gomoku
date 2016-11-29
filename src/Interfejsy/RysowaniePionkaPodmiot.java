/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejsy;

import java.awt.Graphics;

/**
 *
 * @author Nogaz
 */
public interface RysowaniePionkaPodmiot {
    public void zarejestrujObserwatora(RysowaniePionkaListener o);
    public void usunObserwatora(RysowaniePionkaListener o);
    public void namalujObserwatorowNaPlanszy(Graphics g);
}
