
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
    
    public static long berechneTeilSumme(long zahl) {
    long summe = 0;
        for (long i=1; i <=zahl; i++) {
            if(zahl % i==0) {
                summe = summe + i;
        }
      }
    return summe;
    }

   public static String berechneChecksummeIsbn(long isbn){
       long prüfziffer= 0;
       long summe = 0;
       
       for (long i=1; i <=9; i++) {
           do{ 
               summe = isbn*i;
               
            }while(i<=9); 
           summe%11 =prüfziffer;    
               
            }
    return summe + "Summe = ";
   }
      
      
    
    
       
     

   
   
   public static String berechneNullstelle (double p, double q) {
    double x1 = 0;
    double x2 = 0;
    x1 = -p/2 +  Math.sqrt(Math.pow(p/2,2)-q);
    x2 = -p/2 - Math.sqrt(Math.pow(p/2,2)-q);
    if (Math.sqrt(Math.pow(p/2,2)-q) >0) {
        System.out.println();
        System.out.println("Zwei Nullstellen : "+ x1 +" | "+ x2); 
    }else if (Math.sqrt(Math.pow(p/2,2)-q) ==0){
        System.out.println();
        System.out.println("Doppelte Nullstelle : "+ x1);
    }else{
        System.out.println();
        System.out.println("Komplexe Nullstellen");
    } 
   return x1+" | "+x2;
  }
}
    














        
        
        
        
