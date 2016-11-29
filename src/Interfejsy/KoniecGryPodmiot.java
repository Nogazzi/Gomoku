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
public interface KoniecGryPodmiot {
    public void dodajKoniecGryListenera(KoniecGryListener l);
    public void usunKoniecGryListenera(KoniecGryListener l);
    public void powiadomOKoncuGry();
}
