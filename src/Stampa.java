public class Stampa extends Thread {
    private final int TEMPO = 30;
    private final int raggio;
    private final int altezza;

    public Stampa(int raggio, int altezza) {
        this.raggio = raggio;
        this.altezza = altezza;
    }

    @Override
    public void run() throws RuntimeException {
        System.out.println(Thread.currentThread().getName() + ": stampa in corso...");
        for (int i = TEMPO; i > 0; i--) {
            try {
                System.out.println(i + " secondi rimanenti...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public int getTEMPO() {
        return TEMPO;
    }
}