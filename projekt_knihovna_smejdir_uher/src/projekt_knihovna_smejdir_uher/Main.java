package projekt_knihovna_smejdir_uher;
import java.util.Scanner;

public class Main {
	
	
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        knihovna knihovna = new knihovna();
        vypis vypis = new vypis();
        knihovna.predemDaneKnihy();
       
        boolean running = true;

        while (running) {
            System.out.println("-----------------------------------------");
            System.out.println("1. Přidat novou knihu");
            System.out.println("2. Upravit knihu");
            System.out.println("3. Smazat knihu");
            System.out.println("4. Označit knihu jako vypůjčenou/vrácenou");
            System.out.println("5. Výpis knih");
            System.out.println("6. Vyhledání knihy");
            System.out.println("7. Výpis knih daného autora");
            System.out.println("8. Výpis knih daného žánru");
            System.out.println("9. Výpis vypůjčených knih");
            System.out.println("10. Konec - Opuštění knihovny");
            System.out.println("-----------------------------------------");
            System.out.println("20. Uložit informace o vybrané knize do souboru");
            System.out.println("30. Načíst informace o dané knize ze souboru");
            System.out.println("-----------------------------------------");


            System.out.print("\nVyberte akci: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) 
            {
                case 1:
                    knihovna.pridatNovouKnihu(scanner);
                    break;
                case 2:
                    knihovna.upravitKnihu(scanner);
                    break;
                case 3:
                    knihovna.smazatKnihu(scanner);
                    break;
                case 4:
                    knihovna.oznacitVypujcenou(scanner);
                    break;
                case 5:
                    vypis.vypisKnihy(knihovna.getKnihovnaSeznam());
                    break;
                case 6:
                    vypis.vyhledatKnihu(knihovna.getKnihovnaSeznam(), scanner);
                    break;
                case 7:
                    vypis.vypisKnihyAutora(knihovna.getKnihovnaSeznam(), scanner);
                    break;
                case 8:
                    vypis.vypisKnihyZanru(knihovna.getKnihovnaSeznam(), scanner);
                    break;
                case 9:
                    vypis.vypisVypujceneKnihy(knihovna.getKnihovnaSeznam());
                    break;
                case 10:
                    System.out.println("Dekujeme za návštěvu naší knihovny! :-) ");
                    running = false;
                    return;
                case 20:
                    System.out.print("Zadejte název knihy, kterou chcete uložit do souboru: ");
                    String nazevKUlozeni = scanner.nextLine();
                    knihovna.ulozitKnihuDoSouboru(nazevKUlozeni);
                    break;
                case 30:
                    knihovna.nacistKnihuZeSouboru();
                    break;
                default:
                    System.out.println("Neplatná volba, zvolte dostupnou možnost");
                    break;
            }
        }
           
        scanner.close();
        
    }
}
