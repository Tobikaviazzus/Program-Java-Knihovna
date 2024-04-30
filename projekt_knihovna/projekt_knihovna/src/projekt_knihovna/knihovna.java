package projekt_knihovna;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class knihovna {
    private ArrayList<kniha> knihovnaSeznam;
    public ArrayList<kniha> getKnihovnaSeznam() {
        return knihovnaSeznam;
    }
    
    
    // Konstruktor
    public knihovna() {
        this.knihovnaSeznam = new ArrayList<>();
    }
    
void predemDaneKnihy() {
	String[] autorRomanu = {"W. Shakespeare"};
	String[] nakladatelstvi = {"Cermat"};

    knihovnaSeznam.add(new romany("Romeo a Julie", autorRomanu, 1595, true, "Román"));
    knihovnaSeznam.add(new romany("Sen noci svatojánské", autorRomanu, 1600, false, "Komedie"));
    knihovnaSeznam.add(new romany("Jindřich IV.", autorRomanu, 1558, true, "Drama"));
    knihovnaSeznam.add(new romany("Komedie omylů", autorRomanu, 1607, true, "Komedie"));

    knihovnaSeznam.add(new ucebnice("Čítanka", nakladatelstvi, 2017, true, 2));
    knihovnaSeznam.add(new ucebnice("Malá nasobilka", nakladatelstvi, 2019, false, 1));
    knihovnaSeznam.add(new ucebnice("Fyzika", nakladatelstvi, 2024, true, 7));



}

    // přidání nové knihy do knihovny
    public void pridatNovouKnihu(Scanner scanner) {
        System.out.println("Vyberte typ knihy:");
        System.out.println("1. Román");
        System.out.println("2. Učebnice");
        System.out.print("Váš výběr: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // pro odstranění zbytku řádku

        switch (choice) {
            case 1:
                pridatRoman(scanner);
                break;
            case 2:
                pridatucebnice(scanner);
                break;
            default:
                System.out.println("Neplatná volba");
        }
    }

    //přidání románu do knihovny
    private void pridatRoman(Scanner scanner) {
    	String zanr = null;
        System.out.print("Název románu: ");
        String nazev = scanner.nextLine();
        System.out.print("Autor románu: ");
        String autor = scanner.nextLine();
        System.out.print("Rok vydání: ");
        int rokVydani = scanner.nextInt();
        scanner.nextLine(); //odstranění zbytku řádku
        
        System.out.println("-----------------------------------------");
        System.out.println("1. Komedie ");
        System.out.println("2. Román ");
        System.out.println("3. Horror ");
        System.out.println("4. Drama ");
        System.out.println("5. Poezie ");   //ze zadani je, ze mame 5 zanru, ale nejake presne
        System.out.println("-----------------------------------------");

        System.out.print("Vyberte žánr knihy: ");
        int volba = scanner.nextInt();
        scanner.nextLine(); 
        switch (volba) {
        	case 1:
        		zanr = "Komedie";
        		 break;
        	case 2:
        		zanr = "Román";
        		 break;
        	case 3:
        		zanr = "Horror";
        		 break;
        	case 4:
        		zanr = "Drama";
        		 break;
        	case 5:
        		zanr = "Poezie";
        		 break;
        }

        knihovnaSeznam.add(new romany(nazev, new String[]{autor}, rokVydani, true, zanr));
        System.out.println("Román byl úspěšně přidán do knihovny");
    }

    // přidání učebnice do knihovny
    private void pridatucebnice(Scanner scanner) {
        System.out.print("Název učebnice: ");
        String nazev = scanner.nextLine();
        System.out.print("Autor učebnice: ");
        String autor = scanner.nextLine();
        System.out.print("Rok vydání: ");
        int rokVydani = scanner.nextInt();
        scanner.nextLine(); // Pro odstranění zbytku řádku
        System.out.print("Ročník učebnice: ");
        int rocnik = scanner.nextInt();

        knihovnaSeznam.add(new ucebnice(nazev, new String[]{autor}, rokVydani, true, rocnik));
        System.out.println("Učebnice byla úspěšně přidána do knihovny");
    }

   
    
    
    // úprava knihy
    public void upravitKnihu(Scanner scanner) {
        System.out.print("Zadejte název knihy, kterou chcete upravit: ");
        String nazev = scanner.nextLine();
        kniha kniha = najitKnihu(nazev);

        if (kniha != null) {
            System.out.println("Co si přejete upravit?");
            System.out.println("1. Autora");
            System.out.println("2. Rok vydání");
            System.out.println("3. Stavu dostupnosti");
            System.out.print("Vyberte, co chcete upravit: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Pro odstranění zbytku řádku

            switch (choice) {
                case 1:
                    System.out.print("Nový autor knihy: ");
                    String novyAutor = scanner.nextLine();
                    kniha.setAutori(new String[]{novyAutor});
                    break;
                case 2:
                    System.out.print("Nový rok vydání: ");
                    int novyRokVydani = scanner.nextInt();
                    kniha.setRokVydani(novyRokVydani);
                    break;
                case 3:
                    System.out.print("Nový stav dostupnosti (true/k dispozici, false/vypůjčeno): ");
                    boolean novaDostupnost = scanner.nextBoolean();
                    kniha.setDostupnost(novaDostupnost);
                    break;
                default:
                    System.out.println("Neplatná volba.");
            }
        }
    }

     // vyhledání knihy podle názvu
    	public kniha najitKnihu(String nazev) {
        for (kniha kniha : knihovnaSeznam) {     //prochazi knihy
            if (kniha.getNazev().equalsIgnoreCase(nazev)) {
                return kniha;
            }
        }
        return null;
    }


        // mazání knihy ze seznamu
        public void smazatKnihu(Scanner scanner) {
            System.out.print("Zadejte nazev knihy, kterou chcete smazat: ");
            String nazev = scanner.nextLine();
            kniha kniha = najitKnihu(nazev);

            if (kniha != null) {
                knihovnaSeznam.remove(kniha);
                System.out.println("kniha byla uspesne smazana ze seznamu");
            } else {
                System.out.println("kniha s timto nazvem neexistuje");
            }
        }

        // označení knihy jako vypůjčené/vrácené
        public void oznacitVypujcenou(Scanner scanner) {
            System.out.print("Zadejte název knihy, kterou chcete vypůjčit/vrátit: ");
            String nazev = scanner.nextLine();
            kniha kniha = najitKnihu(nazev);

            if (kniha != null) {
                boolean aktualniStav = kniha.isDostupnost();
                kniha.setDostupnost(!aktualniStav);
                String stav = kniha.isDostupnost() ? "vrácena" : "vypůjčena";
                System.out.println("kniha byla úspěšně označena jako " + stav);
            } else {
                System.out.println("kniha nebyla nalezena");
            }
        }
        
        
        
        
        // uložení informace o vybrané knize podle jejího názvu do souboruu
        public void ulozitKnihuDoSouboru(String nazevKnihy) {
            kniha kniha = najitKnihu(nazevKnihy);
            if (kniha != null) {
                try (FileWriter writer = new FileWriter("knihovna.txt")) {
                    writer.write(kniha.toString());
                    System.out.println("Informace o knize '" + nazevKnihy + "' byly úspěšně uloženy do souboru 'knihovna.txt' ");
                } catch (IOException e) {
                    System.out.println("Chyba při zápisu do souboru: " + e.getMessage());
                }
            } else {
                System.out.println("Kniha s názvem '" + nazevKnihy + "' nebyla nalezena");
            }
        }

        // načtení všech informací o dané knize ze souboru 
        public void nacistKnihuZeSouboru() {
            File file = new File("knihovna.txt");
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Informace o knize ze souboru: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Chyba při čtení ze souboru: " + e.getMessage());
                }
            } else {
                System.out.println("Soubor 'knihovna.txt' neexistuje");
            }
        }



		public void setKnihovnaSeznam(ArrayList<kniha> knihyZDatabaze) {
			// TODO Auto-generated method stub
			
		}
        
        }

