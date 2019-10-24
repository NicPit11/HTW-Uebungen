
/**
 * Beschreiben Sie hier die Klasse Artikel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Artikel  {
   private int artikelnummer;
   private String artikelbezeichnung;
   private int artikelbestand; 
   /**
    * Konstruktor zum Bestimmen der Variablen 
    * @param artikelnummer muss 4-stellig sein 
    * @param atrikelbezeichnung darf nicht null/leer sein
    * @param artikelbestand muss >0 sein 
    */
   public Artikel (int artikelnummer , String artikelbezeichnung , 
                   int artikelbestand) {
       if (artikelnummer <=1000 || artikelnummer >10000)
       throw new IllegalArgumentException(
       "Artikelnummer muss 4-stellig sein!");
       if (artikelbezeichnung ==null || artikelbezeichnung.isEmpty())
       throw new IllegalArgumentException(
       "Artikelbezeichnung darf nicht null beziehungsweise leer sein ");
       if (artikelbestand <0) 
       throw new IllegalArgumentException(
       "Artikelbestand muss <0 sein");
       this.artikelnummer = artikelnummer;
       this.artikelbezeichnung = artikelbezeichnung;
       this.artikelbestand = artikelbestand ;
   }
   /**Konstruktor für Artikelnummer und Artikelbezeichnug , 
    * Bestand ist hier 0
    */
   public Artikel (int artikelnummer, String artikelbezeichnung) {
       if (artikelnummer <=1000|| artikelnummer >10000)
       throw new IllegalArgumentException(
       "Artikelnummer muss 4-stellig sein!");
       if (artikelbezeichnung !=null || artikelbezeichnung.isEmpty())
       throw new IllegalArgumentException(
       "Artikelbezeichnung darf nicht null beziehungsweise leer sein ");
       this.artikelnummer = artikelnummer; 
       this.artikelbezeichnung = artikelbezeichnung;
   }
   /**
    * Buchung von Zu- und Abgang des Artikelbestandes
    */
    
   public void bucheZugang(int menge) {
       if (menge <0) throw new IllegalArgumentException(
       "Zugang muss >0 sein");
       artikelbestand = artikelbestand + menge ;
   }
   public void bucheAbgang(int menge) {
       if (menge <0) throw new IllegalArgumentException(
       "Abgang muss <0 sein");
       artikelbestand = artikelbestand - menge ; 
   }
   /**
    * Get-Methoden zum Abfragen der privaten Attribute 
    * 
    */
   public int getArtikelnummer() {
       return artikelnummer;
   }
   public String getArtikelbezeichnung () {
        return artikelbezeichnung;
   }
   public int  getArtikelbestand () {
       return artikelbestand;
   }
   /** 
    * Set-Methode zum verändern der Artikelbezeichnung und
    * der Artikelnummer 
    */
   public void setArtikelbezeichnung (String artikelbezeichnung) {
       if (artikelbezeichnung ==null || artikelbezeichnung.isEmpty())
       throw new IllegalArgumentException(
       "Artikelbezeichnung darf nicht null beziehungsweise leer sein ");
       this.artikelbezeichnung = artikelbezeichnung ;
   }
   public void setArtikelnummer (int artikelnummer) {
       if (artikelnummer <=1000 || artikelnummer >10000)
       throw new IllegalArgumentException(
       "Artikelnummer muss 4-stellig sein!");
       this.artikelnummer = artikelnummer ;
   }
   /**
    * String toString
    * textuelle Aufarbeitung der Attribute des Objekts
    * 
    */
   public String toString() {
       return "Artikelnummer : " +  artikelnummer
            + ", Artikelbezeichnung : " +  artikelbezeichnung 
            + ", Artikelbestand : " +  artikelbestand;
   }
}
