/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistiche;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sipione_christian
 */
public class ThGenera extends Thread {

    Random rnd = new Random();
    private cDatiCondivisi ptrDati;
    private String abc;

    public ThGenera(cDatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ .";;
    }

    public void run() {
        for (int i = 0; i < ptrDati.getCaratteri(); i++) {
            try {
                ptrDati.waitSem1();
                char lettera = abc.charAt(rnd.nextInt(abc.length()));
                if (lettera == '.') {
                    ptrDati.setNumPuntiInseriti();
                }
                if (lettera == ' ') {
                    ptrDati.setNumSpaziInseriti();
                }
                String l = String.valueOf(lettera);
                ptrDati.setV(l);
                ptrDati.setCaratteriInseriti();
                ptrDati.signalSem2();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThGenera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
