/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejsy;

import KlasyGlowne.Pole;
import Gracze.Gracz;

/**
 *
 * @author Nogaz
 */
public interface SterowaniePodczasGry {
    public void uruchomGre();
    public int ustawRozpoczynajacego();
    public void ustawCienPionka();
    public void przygotujGracza(Gracz gracz);
    public void zmienGracza(Gracz gracz);
    public void zapiszRuch(Pole pole, int nowyStan, int x, int y);
    public void cofnijRuch(int x, int y);
    public void powiadomOWygranej();
}
