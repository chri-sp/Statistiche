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
public class ThContaSpazi extends Thread {

    private cDatiCondivisi ptrDati;

    public ThContaSpazi(cDatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        for (int i = 0; i < ptrDati.getCaratteri(); i++) {
            ptrDati.waitSem2();
            if (ptrDati.getV(i).equals(" ")) {
                ptrDati.setNumSpaziLetti();
            }
            ptrDati.signalSem3();
           
        }
    }
}
