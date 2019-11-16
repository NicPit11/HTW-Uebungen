

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *Eine Dialogklasse zum Testen der Methoden(berechneTeilersumme/BerechneCheckIsbn/berechneNullstellen).
 *Soll interativ genutzt werden können und bei falschen Eingaben eine sinnvolle Aussage anzeigen 
 *aus welchem Grund diese Eingabe nicht gültig war. 
 * @author Oliver Theobald
 * @author Nicolas Schnur
 * @version (1.0)
 */
public class MathDialog extends MathFunctions  {
   private Scanner input = new Scanner(System.in);
   MathFunctions rechnung = new MathFunctions();
 
   private static final int TEILERSUMME= 1;
   private static final int PRUEFZIFFER = 2; 
   private static final int NULLSTELLE = 3;
   private static final int REIHENSUMME = 4;
   private static final int BEENDEN = 0;
   /**
    *Abbildung des Menues und Eingabe von auszufuehrender Methode. 
    */
   private int einlesenFunktion() {
        System.out.println("Was wollen Sie berechnen ?");
        System.out.println();
        System.out.print(TEILERSUMME + ":Teilersumme ; "+
        PRUEFZIFFER+ ":Pruefziffer ; "+
        NULLSTELLE+ ":Nullstelle ; "+
        REIHENSUMME+ ":Reihensumme ; "+
        BEENDEN+ " :Beenden-> ");
 
        return input.nextInt();
   }

   /**
    * Verknuepfung der Eingabe des Benutzers mit den verschiedenen Methoden.
    */
   private void  ausfuehrenFunktion(int funktion) {
        if (funktion == TEILERSUMME) { 
            berechneTeilersumme();
        }else if (funktion == PRUEFZIFFER) {
            berechneChecksummeIsbn();
        }else if (funktion == NULLSTELLE) {
            berechneNullstellen();
            
        }else if (funktion == REIHENSUMME) {
            berechneReihensumme();
            
        }else if (funktion == BEENDEN) {
            System.out.println("Programmende");     
        }else {
            System.out.println("Falsche Eingabe!");
        }
   }
    
   /**
    * Methode greift auf auf die Methode zur Berechnung einer Teilersumme zu und gibt
    * den erechneten Wert  aus .
    *
    */
   private void berechneTeilersumme(){
       long zahl;
       System.out.print("Positive Ganze Zahl eingeben : ");
       zahl = input.nextLong();
            System.out.println(rechnung.berechneTeilerSumme(zahl)); 
    
   }
   
   /**
   * Methode greift auf auf die Methode zur Berechnung einer Pruefziffer zu und gibt
   * den erechneten Wert  aus.
   */
   private void berechneChecksummeIsbn(){
        long isbn;
        System.out.println("9-stellige ISBN eingeben");
        isbn = input.nextLong();
        System.out.println(rechnung.berechneChecksummeIsbn(isbn));
    
   }
   
    /**
     * Methode greift auf auf die Methode zur Berechnung von Nullstellen zu und gibt
     * die erechneten Werte  aus.
     */
    private void berechneNullstellen() {
        double p;
        double q;
        System.out.println("p und q bitte eingeben ");
        System.out.print("p = ");
        p = input.nextDouble();
        System.out.print("q = ");
        q = input.nextDouble();
        System.out.println(rechnung.berechneNullstelle (p,q));
   }
   private void berechneReihensumme(){
   double x;
   int n;
   System.out.println(" x und n bitte eingeben " );
   System.out.print("x : ");
   x=input.nextDouble();
   System.out.print("n : ");
   n=input.nextInt();
}
    
   /**
   * Hauptschleife des Dialogs
   * ermoeglicht die wiederholte Eingabe von auszufuehrenden Methoden
   * und faengt nicht zulässige Eingaben ab.
   */
   public void start() {
       int funktion = -1;
       while (funktion != BEENDEN) {
           try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
           }catch (IllegalArgumentException e) {
                System.out.println(e);
           }catch (InputMismatchException e) {
                System.out.println("unzulässige Eingabe"); 
                input.nextLine();
           }catch (Exception e) {
                System.out.println("Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
           }          
        }
   }  
 
   /**
    * Methode startet den Dialog und die Hauptschleife. 
    */
   public static void main (String[] args) {
       new MathDialog().start();
   }
}