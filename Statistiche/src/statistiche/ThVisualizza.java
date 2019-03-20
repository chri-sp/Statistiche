/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistiche;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sipione_christian
 */
public class ThVisualizza extends Thread {

    private cDatiCondivisi ptrDati;

    public ThVisualizza(cDatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        for (int i = 0; i < ptrDati.getCaratteri(); i++) {
            try {
                ptrDati.waitSem4();
                System.out.println("buffer: " + ptrDati.getV(i));
                System.out.println("spazi inseriti: " + ptrDati.getNumSpaziInseriti());
                System.out.println("spazi letti: " + ptrDati.getNumSpaziLetti());
                System.out.println("punti inseriti: " + ptrDati.getNumPuntiInseriti());
                System.out.println("punti letti: " + ptrDati.getNumPuntiLetti());
                ptrDati.signalSem1();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThVisualizza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ptrDati.signalSemJoin();
    }
}
