package projekt_knihovna;
public class romany extends kniha {
    private String zanr;

    // konstruktor
    public romany(String nazev, String[] autori, int rokVydani, boolean dostupnost, String zanr) {
        super(nazev, autori, rokVydani, dostupnost);
        this.zanr = zanr;
    }

    // Getter a setter pro žánr
    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    // přepsaná metoda toString pro výpis informací o románu
    @Override
    public String toString() {
        return super.toString() + ", Žánr: " + zanr;
    }
}
