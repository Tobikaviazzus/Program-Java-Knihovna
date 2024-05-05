package projekt_knihovna_smejdir_uher;

public class romany extends kniha {
    private String zanr;

    
    public romany(String nazev, String[] autori, int rokVydani, boolean dostupnost, String zanr) {
        super(nazev, autori, rokVydani, dostupnost);
        this.zanr = zanr;
    }

   
    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

   
    @Override
    public String toString() {
        return super.toString() + ", Žánr: " + zanr;
    }
}
