public class Imballaggio extends Thread {
    private final int TEMPO = 15;

    public Imballaggio() {

    }

    @Override
    public void run() {
        System.out.println("Imballaggio in corso...");
        for (int i = TEMPO; i > 0; i--) {
            try {
                System.out.println(i + " secondi rimanenti");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Prodotto confezionato e pronto!");
    }
}
