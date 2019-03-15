/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistiche;

/**
 *
 * @author sipione_christian
 */
public class ThContaPunti extends Thread {

    private cDatiCondivisi ptrDati;

    public ThContaPunti(cDatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        for (int i = 0; i < ptrDati.getCaratteri(); i++) {
            ptrDati.waitSem3();
            if (ptrDati.getV(i).equals(".")) {
                ptrDati.setNumPuntiLetti();
            }
            ptrDati.signalSem1();
        }
    }
}
