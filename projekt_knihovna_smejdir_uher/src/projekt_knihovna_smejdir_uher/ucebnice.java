package projekt_knihovna_smejdir_uher;

public class ucebnice extends kniha {
    private int rocnik;

    public ucebnice(String nazev, String[] autori, int rokVydani, boolean b, int rocnik) {
        super(nazev, autori, rokVydani, b);
        this.rocnik = rocnik;
    }


    public int getRocnik() {
        return rocnik;
    }

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ročník: " + rocnik;
    }
}
