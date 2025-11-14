import java.util.Scanner;

/**
 * Progetto di thread concorrenti di {@author lorenzogiuliano},
 * che simula la produzione di <b>coperchi di plastica</b>.
 *
 * Per ogni coperchio vengono avviati tre thread distinti:
 * {@code Stampa}: genera il coperchio tramite parametri geometrici, {@code Colorazione}: colora il coperchio in parallelo alla stampa, {@code Imballaggio}: imballa il prodotto una volta conclusi stampa e colorazione.
 * {@version 1.0.0}
 */
public class Main {

    /**
     * Metodo principale che gestisce l'intero processo di produzione.
     * Richiede all'utente il numero di coperchi da produrre, per ogni coperchio chiede raggio e altezza, crea i thread di stampa, colorazione e imballaggio, avvia in parallelo stampa e colorazione, attende il completamento tramite {@code join()}, avvia l'imballaggio, attende l'imballaggio e avvisa l'utente del completamento.
     * @throws InterruptedException se un thread viene interrotto durante l'attesa tramite {@code join()}
     */
    public static void main(String[] args) throws InterruptedException {
        int raggio;
        int altezza;
        int area;
        Scanner sc = new Scanner(System.in);
        System.out.println("Quanti coperchi vuoi produrre? ");
        int numero = sc.nextInt();

        Stampa[] s = new Stampa[numero];
        Colorazione[] c = new Colorazione[numero];
        Imballaggio[] imb = new Imballaggio[numero];

        for (int i = 0; i < numero; i++) {
            System.out.println("Inserisci la dimensione del raggio (mm): ");
            raggio = sc.nextInt();
            System.out.println("Inserisci la dimensione dell'altezza (mm): ");
            altezza = sc.nextInt();
            area = (int) ((Math.PI * raggio * raggio) + (2 * Math.PI * raggio * altezza));

            s[i] = new Stampa(raggio, altezza);
            c[i] = new Colorazione(area);
            imb[i] = new Imballaggio();
        }

        for (int j = 0; j < numero; j++) {
            s[j].start();
            System.out.println("Attendi " + s[j].getTEMPO() + " secondi al termine della stampa del tappo " + j);
            c[j].start();
        }

        for (int k = 0; k < numero; k++) {
            s[k].join();
            c[k].join();
            System.out.println("Attendi " + s[k].getTEMPO() + " secondi al termine dell'imballaggio del tappo " + k);
            imb[k].start();
        }

        for (int l = 0; l < numero; l++) {
            imb[l].join();
            System.out.println("Tappo " + l + " pronto!");
        }
    }
}
