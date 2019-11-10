package OwnMath;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse MathDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MathDialog  
{

 //private berechneTeilSumme Mathfunktions01;
 private Scanner input = new Scanner(System.in);
    
    
 private static final int TEILSUMME= 1;
 private static final int PRUEFZIFFER = 2; 
 private static final int NULLSTELLE = 3;
 private static final int BEENDEN = 0;

 private int einlesenFunktion() {
 System.out.println("Was wollen sie berechen ?");
 System.out.println();
 System.out.print(TEILSUMME + ":Teilsumme ; "+
                  PRUEFZIFFER+ ":Prüfziffer ; "+
                  NULLSTELLE+ ":Nullstelle ; "+
                  BEENDEN+ " :Beenden-> ");
                  return input.nextInt();
 }

 private void  ausfuehrenFunktion(int funktion) {
     long zahl;
     double p;
     double q;
     long isbn;
     MathFunctions summe = new MathFunctions();
     
        if (funktion == TEILSUMME) { 
            System.out.println("Positive Ganze Zahl eingeben : ");
            zahl = input.nextLong();
            System.out.println(summe.berechneTeilSumme(zahl));
            
            
             
             
        }else if (funktion == PRUEFZIFFER) {
            System.out.println("9-stellige ISBN eingeben");
            isbn = input.nextLong();
            System.out.println(summe.berechneChecksummeIsbn(isbn));
                   
            
        }else if (funktion == NULLSTELLE) {
            System.out.println("p und q bitte eingeben ");
            System.out.println("p ? ");
            p = input.nextDouble();
            System.out.println("q ? ");
            q = input.nextDouble();
            System.out.println(summe.berechneNullstelle (p,q));
                  
        }else if (funktion == BEENDEN) {
                  
        }else {
                 System.out.println("Falsche Eingabe!");
        }
        System.out.println();
    }
    
    
    
    
    
    
 
 
 
 
 
 

public void start() {
         int funktion = -1;
        while (funktion != BEENDEN) {
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
 
 
 
 public static void main (String[] args) {
        new MathDialog().start();



}
}