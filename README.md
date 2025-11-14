# Produzione concorrente di coperchi di plastica

Questo progetto, realizzato da  **Lorenzo Giuliano**, simula un processo industriale di produzione di  **coperchi di plastica** utilizzando  **thread concorrenti**  in Java.
Ogni coperchio passa attraverso tre fasi eseguite da thread distinti:

1.  **Stampa**  – genera il coperchio usando parametri geometrici
    
2.  **Colorazione**  – colora il coperchio in parallelo alla fase di stampa
    
3.  **Imballaggio**  – confeziona il coperchio dopo la conclusione delle prime due fasi

## Versione

Questo progetto è nella sua prima versione, la 1.0.0

## Funzionamento del programma

All’avvio, il programma:

1.  Chiede all’utente  **quanti coperchi produrre**
    
2.  Per ogni coperchio richiede:
    
    -   **Raggio (mm)**
        
    -   **Altezza (mm)**
        
3.  Calcola l’**area superficiale**  necessaria per la colorazione
    
4.  Crea tre thread per ogni coperchio:
    
    -   `Stampa`
        
    -   `Colorazione`
        
    -   `Imballaggio`
        
5.  Avvia in parallelo stampa e colorazione
    
6.  Attende il completamento con  `join()`
    
7.  Avvia l’imballaggio
    
8.  Al termine, comunica che ogni coperchio è pronto

## Analisi dei Thread

### **Stampa**

-   Riceve raggio e altezza
    
-   Simula il tempo di stampa
    
-   Restituisce un tempo di lavorazione (`getTEMPO()`)
    

### **Colorazione**

-   Riceve l’area del coperchio
    
-   Simula il tempo necessario alla colorazione
    

### **Imballaggio**

-   Parte dopo la conclusione di stampa e colorazione
    
-   Simula il processo di confezionamento

## Esempio di Input/Output

```
Quanti coperchi vuoi produrre?
> 2

Inserisci la dimensione del raggio (mm):
> 30
Inserisci la dimensione dell'altezza (mm):
> 10

Inserisci la dimensione del raggio (mm):
> 50
Inserisci la dimensione dell'altezza (mm):
> 15

Attendi 3 secondi al termine della stampa del tappo 0
Attendi 2 secondi al termine della stampa del tappo 1
Tappo 0 pronto!
Tappo 1 pronto!

```

## Note

-   Il progetto mostra un esempio di  **programmazione concorrente**  in Java.
    
-   Mostra l'uso di thread,  `start()`,  `join()`  e sincronizzazione implicita tramite flusso di lavoro.

## Autore

**Lorenzo Giuliano**
