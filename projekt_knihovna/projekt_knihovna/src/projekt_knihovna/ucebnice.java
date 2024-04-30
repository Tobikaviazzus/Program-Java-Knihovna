package projekt_knihovna;
public class ucebnice extends kniha {
    private int rocnik;

    // Konstruktor
    public ucebnice(String nazev, String[] autori, int rokVydani, boolean b, int rocnik) {
        super(nazev, autori, rokVydani, b);
        this.rocnik = rocnik;
    }


    // Getter a setter pro ročník
    public int getRocnik() {
        return rocnik;
    }

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    // Přepsaná metoda toString pro výpis informací o učebnici
    @Override
    public String toString() {
        return super.toString() + ", Ročník: " + rocnik;
    }
}
