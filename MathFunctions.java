import java.lang.Math;
import java.util.Scanner;
/**
 * Klasse mit Methoden in welchen Formeln , fuer verschiedene mathematische Rechnungen, programmiert sind.
 * @author  Oliver Theobald
 * @author Nicolas Schnur
 * @version (1.0)
 */
public class MathFunctions {
    private Scanner input = new Scanner(System.in);
    private static final long MAX =1000000000;
    private static final long MIN =100000000;
    private static final double EPSILON = 0.0000001;
    /** Methode zum berechnen der Teilersumme.
    * Hier wird die eingegebene Zahl durch jede kleinere Zahl geteilt und daraus die Summe gebildet.
    */ 
    public static long berechneTeilerSumme(long zahl) {
        if (zahl<0){
            throw new IllegalArgumentException("es dürfen nur natuerliche Zahlen"+
            " eingegeben werden ");}
        if (zahl ==0) {
            throw new IllegalArgumentException("die Zahl 0 hat keine Teiler");  }
        long summe = 0;
        for (long i=1; i <=zahl/2; i++) {
          if(zahl % i==0) { 
             summe = summe + i;
          }
        }
        return summe+zahl;
    } 
    
    /**Methode zum berechnen der Pruefziffer einer 10-stelligen ISBN.
     * Hier wird die ISBN in ihre ersten neun Ziffern zerlegt und mit den Zahlen von 1-9 multipliziert und anschließend die Summe gebildet.
     * Das Ergebnis wird mit mod 11 verrechnet um die Pruefziffer zu erhalten.
     */
    public static String berechneChecksummeIsbn( long isbn){
        if( isbn<=MIN ||isbn>MAX){
            throw new IllegalArgumentException(
            "Zahl ist nicht 9-stellig"); }
        long isbn1=0;
        while(isbn>0){
            for (long i=9; i>0; i--) {
             isbn1 = isbn1 + (isbn % 10) * i;
             isbn= isbn/10 ;
            }
        }
        isbn1 = isbn1 % 11;
        if(isbn1 == 10) {
            return String.valueOf("X");
        }
        return String.valueOf(isbn1);
    }
    
    /**Methode zur berechnung der Nullstellen einer quadratischen Funktion .
     * Hierzu wird die Pq-Formel angewendet.
     * Dann wird die Art der Nullstelle mit ihren Werten ausgegeben.
     */
    public static String berechneNullstelle (double p, double q) {
        double x1 = 0;
        double x2 = 0;
        String Ergebnis;
        x1 = -p/2 +  Math.sqrt(Math.pow(p/2,2)-q);
        x2 = -p/2 - Math.sqrt(Math.pow(p/2,2)-q);
        if (Math.sqrt(Math.pow(p/2,2)-q) >EPSILON) {
            System.out.println();
            Ergebnis="Zwei Nullstellen : "+ x1 +" | "+ x2; 
        }else if (Math.sqrt(Math.pow(p/2,2)-q) ==EPSILON){
           System.out.println();
           Ergebnis = "Doppelte Nullstelle : "+ x1;
        }else{
           System.out.println();
           Ergebnis = "Komplexe Nullstellen";
        } 
        return Ergebnis; 
    }
    
    public static double berechneReihensumme(int n, double x) {
        double reihensumme=0;
        double reihensumme1=0;
        for(int i=1;i<=n;i++) {
            reihensumme = reihensumme+(Math.pow((x-1),i)/(i*Math.pow(x,i)));
        }
        return reihensumme;
    } 
    public static boolean istSummevonPotenzen(int n) {
        int A;
        int B;
        int C;
        for(int a=1;a<=n; a++) {
            for(int b=1;b<=n;b++){
                for(int c=1;c<=n ;c++){
                A =a*a*a*a;
                B =b*b*b;
                C =c*c;
                if(n==A+B+C) {
                    return true;
                }
            }
        }
      }
      return false;
    }
}
    














        
        
        
        
