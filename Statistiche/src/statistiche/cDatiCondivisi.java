package statistiche;

import java.util.concurrent.Semaphore;
import java.util.Vector;

public class cDatiCondivisi {

    private int caratteri;
    private int caratteriInseriti;
    private int numSpaziLetti;
    private int numPuntiLetti;
    private int numSpaziInseriti;
    private int numPuntiInseriti;
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sincVisualizza1;
    private Semaphore sincVisualizza2;
    private Vector<String> v = new Vector<String>();

    public cDatiCondivisi() {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
        sincVisualizza1 = new Semaphore(0);
        sincVisualizza2 = new Semaphore(1);
        this.caratteri = 0;
        this.caratteriInseriti = 0;
        this.numSpaziLetti = 0;
        this.numPuntiLetti = 0;
        this.numSpaziInseriti = 0;
        this.numPuntiInseriti = 0;

    }

    public synchronized void setCaratteri(int caratteri) {
        this.caratteri = caratteri;
    }

    public synchronized void setNumSpaziLetti() {
        this.numSpaziLetti = numSpaziLetti + 1;
    }

    public synchronized void setNumPuntiLetti() {
        this.numPuntiLetti = numPuntiLetti + 1;
    }

    public synchronized void setNumSpaziInseriti() {
        this.numSpaziInseriti = numSpaziInseriti + 1;
    }

    public synchronized void setNumPuntiInseriti() {
        this.numPuntiInseriti = numPuntiInseriti + 1;
    }

    public synchronized void setV(String l) {
        v.add(l);
    }

    public synchronized int getCaratteri() {
        return caratteri;
    }

    public synchronized int getNumSpaziLetti() {
        return numSpaziLetti;
    }

    public synchronized int getNumPuntiLetti() {
        return numPuntiLetti;
    }

    public synchronized int getNumSpaziInseriti() {
        return numSpaziInseriti;
    }

    public synchronized int getNumPuntiInseriti() {
        return numPuntiInseriti;
    }

    public synchronized String getV(int pos) {
        return v.get(pos);
    }

    public synchronized void setCaratteriInseriti() {
        this.caratteriInseriti = caratteriInseriti + 1;
    }

    public synchronized int getCaratteriInseriti() {
        return caratteriInseriti;
    }

    public void waitSem1() throws InterruptedException {
        sem1.acquire();
    }

    public void signalSem1() {
        sem1.release();
    }

    public void waitSem2() throws InterruptedException {
        sem2.acquire();
    }

    public void signalSem2() {
        sem2.release();
    }

    public void waitSem3() throws InterruptedException {
        sem3.acquire();
    }

    public void signalSem3() {
        sem3.release();
    }
      public void waitsincVisualizza1() throws InterruptedException {
        sincVisualizza1.acquire();
    }

    public void signalsincVisualizza1() {
        sincVisualizza1.release();
    }

}
