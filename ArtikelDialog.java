
//Klasse ArtikelDialog


import java.util.Scanner;
import java.util.InputMismatchException;
/**Interativer Dialog um die Klasse Artikel zu testen.
*/
 public class ArtikelDialog {
    /**
     * Attribute für die Klasse ArtikelDialog
     * Attribut Scanner ermöglicht Eingaben während das Programm läuft.
     */
    private Artikel  artikel;
    private Scanner input = new Scanner(System.in);
    
    /**
     * Klassenkonstanten die den Umgang mit dem Programm erleichtern.
     */
    private static final int ANLEGEN = 1;
    private static final int ZUGANG = 2;
    private static final int ABGANG = 3;
    private static final int SET_BEZEICHNUNG = 4;
    private static final int ENDE = 0;
    private static final int JA = 5;
    private static final int NEIN = 6;
    
    /**
     * Methode zum Darstellen eines Menues.
     *
     */
    private int einlesenFunktion() {
        System.out.print( ANLEGEN         + ":anlegen; "       +
        ZUGANG          + ":zugang; "        +
        ABGANG          + ":abgang; "        +
        SET_BEZEICHNUNG + ":setBezeichnung; "+
        ENDE            + ":beenden ");
        return input.nextInt();
    }
  
    /**
     * Verknüpfung von Methoden die durch Eingabe des Benutzers abgerufen werden  
     *
     * @param funktion Ein Parameter
     */
    private void  ausfuehrenFunktion(int funktion) {
        if (funktion == ANLEGEN) { 
             // if (artikel != null) {
                  // System.out.println("Bereits bestehenden Artikel"+
                  // "überschreiben?(j=5 / n=6 "); 
                  
                
                // if (auswahl == NEIN) {
                // }
                // if (auswahl == JA) {
             System.out.println("Anfangsbestand Eingeben (j=5/n=6)");
             int auswahl = input.nextInt();      
                // }}
             if  (auswahl == JA) {
                  artikel = artikelAnlegen1();
                }
             if (auswahl == NEIN ) {
                   artikel = artikelAnlegen2();
                }
        }else if (funktion == ZUGANG) {
                   if (artikel == null) {
                        System.out.println("Es wurde noch kein Artikel" 
                        +" erstellt ."); }
                   else artikel.bucheZugang(einleseMenge());
            
        }else if (funktion == ABGANG) {
                  if (artikel == null) {
                      System.out.println("Es wurde noch kein Artikel" +
                      "erstellt");}
                  else artikel.bucheAbgang(einleseMenge());
        }else if (funktion == SET_BEZEICHNUNG) {
                  artikel.setBezeichnung(einleseBezeichnung());
        
        }else if (funktion == ENDE) {
                  System.out.println("Programmende");
            
        }else {
                 System.out.println("Falsche Funktion!");
        }
        System.out.println(artikel);
    }
    
    /**
     * Methode soll Eingabe von ArtikelNr, Bezeichnung und Bestand ermöglichen.
     * Danach werden diese Werte in einer Zeile ausgegeben.
     */
    private Artikel artikelAnlegen1() {
        int artikelNr;
        String bezeichnung;
        int menge;
        int bestand;
        System.out.print( "ArtikelNr: " );
        artikelNr = input.nextInt();
        bezeichnung = input.nextLine();
        System.out.print( " Bezeichnung: " );
        bezeichnung = input.nextLine();
        System.out.print( " Bestand: " );
        bestand = input.nextInt();
        return new Artikel(artikelNr  , bezeichnung  , bestand  );
    }
    private Artikel artikelAnlegen2() {
        int artikelNr;
        String bezeichnung;
        int menge;
        int bestand;
        System.out.print( "ArtikelNr: " );
        artikelNr = input.nextInt();
        input.nextLine();
        System.out.print(" Bezeichnung: " );
        bezeichnung = input.nextLine();
        System.out.print( " Bestand: " );
        bestand = 0;
        return new Artikel(artikelNr , bezeichnung , bestand);
    }
    
    /**
     * Methode soll Eingabe einer Menge zur Bestandsveränderung ermöglichen.
     * Danach wird der neue Bestand ausgegeben. 
     */
    private int einleseMenge() {
        System.out.print("Menge: ");
        return input.nextInt();
    }
    
    /**
     * Methode soll die Eingabe einer neuen Bezeichnung ermöglichen.
     * Danach wird die neue Bezeichnung ausgegeben.
     */
    private String einleseBezeichnung() {
        String bezeichnung;
        System.out.println("Neue Bezeichung: ");
        input.nextLine();
        bezeichnung = input.nextLine();
        return bezeichnung;
    }
    
    /**
     * Hauptschleife des Programmes Artikel-Dialog.
     * Soll ungültige Eingaben abfangen und eine exception ausgeben, falls 
     * eine ungütige Eingabe getätigt wurde.
     */
    public void start() {
        artikel = null;
        int funktion = -1;
        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            
            }catch (IllegalArgumentException e) {
                System.out.println(e);
            }catch (InputMismatchException e) {
                System.out.println(e); 
                input.nextLine();
            }catch (Exception e) {
                System.out.println("Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
            }          
        }
    } 
    
    /**
     * Main-Methode 
     * erzeugt das KontoDialog-Objekt und startet die Testschleife.
     */
    public static void main (String[] args) {
        new ArtikelDialog().start();
    }
}    

