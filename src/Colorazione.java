public class Colorazione extends Thread {
    private final int area;

    public Colorazione(int area) {
        this.area = area;
    }

    @Override
    public void run() throws RuntimeException {
        System.out.println("Stampa in corso...");
        for (int i = 0; i <= area; i++) {
            try {
                System.out.println(i + " mm2 verniciati...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
