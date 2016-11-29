/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejsy;
/**
 *
 * @author dwa
 */
public interface AktualizacjaGobanPodmiot {
    public void dodajListeneraAktualizacjiGoban(AktualizacjaGobanListener l);
    public void usunListeneraAktualizacjiGoban(AktualizacjaGobanListener l);
    public void odmalujGoban();
}
