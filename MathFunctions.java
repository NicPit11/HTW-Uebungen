
package OwnMath;

import java.lang.Math;
import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse MathFunctions.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MathFunctions {
    private Scanner input = new Scanner(System.in);
    private static final long MAX =1000000000;
    private static final long MIN =100000000;
    public static long berechneTeilSumme(long zahl) {
       if (zahl<0){
       throw new IllegalArgumentException("es dürfen nur natürliche Zahlen"+
       "eingegeben werden ");}
    long summe = 0;
        for (long i=1; i <=zahl; i++) {
            if(zahl % i==0) {
                summe = summe + i;
        }
      }
    return summe;
   }

   public static String berechneChecksummeIsbn( long isbn){
        if( isbn<=MIN ||isbn>MAX){
               throw new IllegalArgumentException(
               "Zahl ist nicht 9-stellig"); }
      long summe= 0;
      long pruefziffer= 0;
      long isbn1=0;
       
        while(isbn>0){
              for (long i=9; i>0; i--) {
              isbn1 = isbn1 + (isbn % 10) * i;
              isbn= isbn/10 ;
              summe = isbn1;
              }
        }
      pruefziffer = summe % 11;
      if(pruefziffer == 10) {
          return "Pruefziffer : X mod 11";
        }
      return "Pruefziffer: "+pruefziffer +" mod 11";
  }
    
   public static String berechneNullstelle (double p, double q) {
    double x1 = 0;
    double x2 = 0;
    String Ergebnis;
    x1 = -p/2 +  Math.sqrt(Math.pow(p/2,2)-q);
    x2 = -p/2 - Math.sqrt(Math.pow(p/2,2)-q);
    if (Math.sqrt(Math.pow(p/2,2)-q) >0) {
        System.out.println();
        Ergebnis="Zwei Nullstellen : "+ x1 +" | "+ x2; 
    }else if (Math.sqrt(Math.pow(p/2,2)-q) ==0){
        System.out.println();
        Ergebnis = "Doppelte Nullstelle : "+ x1;
    }else{
        System.out.println();
        Ergebnis = "Komplexe Nullstellen";
    } 
    return Ergebnis;
  }
  
}
    














        
        
        
        
