package statistiche;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Statistiche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            cDatiCondivisi dati = new cDatiCondivisi();
            System.out.println("Quanti caratteri vuoi generare?");
            int c = input.nextInt();
            dati.setCaratteri(c);
            ThGenera th1 = new ThGenera(dati);
            ThContaSpazi th2 = new ThContaSpazi(dati);
            ThContaPunti th3 = new ThContaPunti(dati);
            ThVisualizza th4 = new ThVisualizza(dati);
            th1.start();
            th2.start();
            th3.start();
            th4.start();
            dati.waitSemJoin();
            if ((dati.getNumPuntiInseriti() == dati.getNumPuntiLetti()) && (dati.getNumSpaziInseriti() == dati.getNumSpaziLetti())) {
                System.out.println("I punti inseriti e letti corrispondono! Complimenti!");
            } else {
                System.out.println("I punti inseriti e letti non corrispondono");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Statistiche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
