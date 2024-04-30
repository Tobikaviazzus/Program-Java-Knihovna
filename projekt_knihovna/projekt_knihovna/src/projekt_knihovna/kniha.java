package projekt_knihovna;
public class kniha {
    private String nazev;
    private String[] autori;
    private int rokVydani;
    private boolean dostupnost;

    // konstruktor
    public kniha(String nazev, String[] autori, int rokVydani, boolean dostupnost) {
        this.nazev = nazev;
        this.autori = autori;
        this.rokVydani = rokVydani;
        this.dostupnost = dostupnost;
    }

    // Gettery a settery
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    

    public boolean obsahujeAutora(String hledanyAutor) {
        for (String autor : autori) {
            if (autor.equalsIgnoreCase(hledanyAutor)) {
                return true;
            }
        }
        return false;
    }

    
    public String[] getAutori() {
        return autori;
    }

    public void setAutori(String[] autori) {
        this.autori = autori;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        this.rokVydani = rokVydani;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    // Přepsaná metoda toString pro výpis informací o knize
    @Override
    public String toString() {
        return "Název: " + nazev + ", Autoři: " + String.join(", ", autori) + ", Rok vydání: " + rokVydani + ", Stav: " + (dostupnost ? "k dispozici" : "vypůjčeno");
    }
}
