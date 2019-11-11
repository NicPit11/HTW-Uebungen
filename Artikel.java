//Klasse Artikel

public class Artikel{
    //Attribute
    private int artikelNr;
    private String bezeichnung;
    private int bestand;
    private static final int MAX = 10000;
    private static final int MIN = 1000;
    /**
     * Konstruktor zum initialisieren eines neuen Objektes.
     *
     * @param artikelnr muss 4-stellig sein
     * @param artikelbezeichnung darf nicht leer sein
     * @param artikelbestand darf nicht kleiner 0 sein
     */
    
    public Artikel(int artikelNr, String artikelbezeichnung, int artikelbestand) {
        check(artikelNr >= MIN && artikelNr <MAX,
            "Artikelnr muss 4-stellig sein");
        
        check(artikelbestand >= 0, "Artikelbestand darf nicht kleiner 0 sein");    
            
        this.artikelNr = artikelNr;
        setBezeichnung(artikelbezeichnung);
        this.bestand = artikelbestand;
    }
    
    /**
     * Konstruktor zum initialisieren eines neuen Objektes mit einem Bestand von 0 Stk.
     *
     * @param artikelnr muss 4-stellig sein
     * @param artikelbezeichnung darf nicht leer sein
     * @param artikelbestand soll = 0 sein
       */
    public Artikel(int artikelNr, String bezeichnung) {
        this(artikelNr, bezeichnung, 0);
    }
    
    //Methode check zur Überprüfung von Bedingungen.
    public static void check(boolean bedingung, String msg){
        if (!bedingung) 
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Methode um den Bestand um eine gewisse Menge zu erhöhen.
     *
     * @param menge muss >= 0 sein
     */
    public void bucheZugang(int menge) {
        check(menge >= 0, "Menge muss >= 0 sein");
       bestand = bestand + menge;
    }
    
    /**
     * Methode um den Bestand um eine gewisse Menge zu mindern.
     *
     * @param menge muss >= 0 sein
     */
    public void bucheAbgang(int menge) {
        check(menge >= 0, "Menge muss >= 0 sein");
        check(menge <= bestand, "Abgang darf nicht groeßer als Bestand sein");
        bestand = bestand - menge;
    }
    
    /**
     * Methode zur Aenderung der Artikelbezeichnung
     *
     * @param artikelbezeichnung darf nicht leer sein
     */
    public void setBezeichnung(String bezeichnung) {
        check(bezeichnung != null && !bezeichnung.trim(). isEmpty(),
            "Artikelbezeichnung darf nicht leer sein");
        this.bezeichnung = bezeichnung.trim();
    }
    //Keine Set-Methode für Attribut "Artikelbestand", da dieser nur durch Methode bucheZu/-Abgang veraendert werden sollte.
    //Keine Set-Methode für Attribut "Artikelnummer", da diese nicht verändert werden sollte.
    /**
     * Methode zum Abrufen der Artikelnummer.
     *
     * @return Wert von Artikelnummer
     */
    public int getArtikelNr() {
        return artikelNr;
    }
    
    /**
     * Methodezum Abrufen der Artikelbezeichnung.
     *
     * @return Wert von Artikelbezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }
    
    /**
     * Methode zum Abrufen des Artikelbestandes.
     *
     * @return Wert vom Artikelbestand
     */
    public int getBestand() {
        return bestand;
    }

    /**
     * Methode um alle Attribute einsehen zu können.
     * 
     * @return soll Artikelnr, Artikelbezeichnung und Artikelbestand ausgeben.
     */
    public String toString() {
        return  "Artikel: "     + artikelNr
             +  "Bezeichnung: " + bezeichnung  
             +  "Bestand: "     + bestand;
    }
} 
