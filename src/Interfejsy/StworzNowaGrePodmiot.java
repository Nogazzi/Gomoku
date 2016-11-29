/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejsy;

/**
 *
 * @author Nogaz
 */
public interface StworzNowaGrePodmiot {
    public void zarejestrujObserwatora(StworzNowaGreListener o);
    public void usunObserwatora(StworzNowaGreListener o);
    public void powiadomObserwatorow(int trybgry, String gracz1, String gracz2);
}
