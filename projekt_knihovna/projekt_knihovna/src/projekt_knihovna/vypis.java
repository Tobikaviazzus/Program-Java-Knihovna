package projekt_knihovna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class vypis {
	
	
    // výpis všech knih podle abecedy
	public static void vypisKnihy(ArrayList<kniha> knihy) { // výpis všech knih ze seznamu knih
        if (knihy.isEmpty()) { // pokud je seznam knih prazdny
            System.out.println("Knihovna je prázdná."); 
            return; 
        }
        
        Collections.sort(knihy, Comparator.comparing(kniha::getNazev)); // seřaďí seznam knih podle názvu
        for (kniha kniha : knihy) { // pro vsechny knihy ze seznamu
            System.out.println(kniha); // vypíše informace o knize
        }
    }


    // vyhledání knihy podle názvu
    public static void vyhledatKnihu(ArrayList<kniha> knihy, Scanner scanner) {
        System.out.print("Zadejte název knihy, kterou chcete vyhledat: ");
        String nazev = scanner.nextLine();
        
        boolean knihaNalezena = false;
        for (kniha kniha : knihy) {  //projde vsechny knihy
            if (kniha.getNazev().equalsIgnoreCase(nazev)) {  //hleda shodu nazvu, ignoruje CAPS
                System.out.println(kniha);
                knihaNalezena = true;    //zmeni hodnotu z false na true
                break;
            }
        }
        
        if (!knihaNalezena) {     //pokud nebyla nalezena
            System.out.println("kniha s tímto názvem nebyla nalezena");
        }
    }

  
    
    /*
    
    // výpis všech knih podle autora chronologicky 
    public static void vypisKnihyAutora(ArrayList<kniha> knihy, Scanner scanner) {
        System.out.print("Zadejte jméno autora: ");
        String autor = scanner.nextLine();
        
        // seznam pro uchování knih daného autora
        ArrayList<kniha> knihyAutora = new ArrayList<>();
        // projde knihy autora a pridani do seznamu
        for (kniha kniha : knihy) {
            if (kniha.obsahujeAutora(autor)) {  //pokud je kniha od daneho autora
                knihyAutora.add(kniha);         //prida knihu do seznamu autora
            }
        }

        // pokud jsou nalezeny knihy daného autora
        if (!knihyAutora.isEmpty()) {
            Collections.sort(knihyAutora, Comparator.comparing(kniha::getRokVydani)); //serazeni podle roku vydani
            for (kniha kniha : knihyAutora) {
                System.out.println(kniha);
            }
        } else {
            System.out.println("kniha tohoto autora nebyla nalezena.");
        }
    }
*/
 // výpis všech autorů a jejich čísel
    public static void vypisVsechnyAutory(ArrayList<kniha> knihy) {
        System.out.println("Seznam všech autorů:");
        int cisloAutora = 1;
        // HashSet "autorSet" slouží k ukládání autorů a kontroluje jestli se autor již v seznamu nevyskytuje
        HashSet<String> autorSet = new HashSet<>(); // použijeme HashSet k zamezení opakování autorů
        for (kniha kniha : knihy) {          
            for (String autor : kniha.getAutori()) {     // pokud se autor ještě nevyskytuje v HashSetu 
                if (!autorSet.contains(autor)) {
                    System.out.println(cisloAutora + ". " + autor);
                    autorSet.add(autor);        //přidáme autora do HashSetu 
                    cisloAutora++;           // +1
                }
            }
        }
    }

    // výpis knih vybraného autora chronologicky 
    public static void vypisKnihyAutora(ArrayList<kniha> knihy, Scanner scanner) {
        // vypsání všech autorů a jejich čísel
        vypisVsechnyAutory(knihy);
        
        System.out.print("Zadejte číslo autora: ");
        int cisloAutora = scanner.nextInt();
        scanner.nextLine(); //odstranění zbytku řádku po čísle
   
        
        String autor = null;
        int aktualniCisloAutora = 1; 
        HashSet<String> autorSet = new HashSet<>(); //HashSet pro uchování autorů a zamezení opakování

        for (kniha kniha : knihy) {
            
            for (String aut : kniha.getAutori()) {   // pro každého autora v seznamu autorů knihy
                if (!autorSet.contains(aut)) {
                	
                    if (aktualniCisloAutora == cisloAutora) {
                        // Uložení aktuálního autora do proměnné autor
                        autor = aut;
                        break;
                    }                
                    autorSet.add(aut);
                    aktualniCisloAutora++;
                }
            }
            if (autor != null) {
                break;
            }
        }

        
        // seznam pro uchování knih daného autora
        ArrayList<kniha> knihyAutora = new ArrayList<>();
        // Projde knihy autora a přidá je do seznamu
        for (kniha kniha : knihy) {
            if (kniha.obsahujeAutora(autor)) {
                knihyAutora.add(kniha);
            }
        }

        // pokud jsou nalezeny knihy daného autora
        if (!knihyAutora.isEmpty()) {
            Collections.sort(knihyAutora, Comparator.comparing(kniha::getRokVydani)); // seřazení podle roku vydání
            for (kniha kniha : knihyAutora) {
                System.out.println(kniha);
            }
        } else {
            System.out.println("Kniha tohoto autora nebyla nalezena.");
        }
    }

    
    
    // výpis všech knih podle žánru
    public static void vypisKnihyZanru(ArrayList<kniha> knihy, Scanner scanner) 
    {
    	String zanr = null;
        System.out.println("-----------------------------------------");
        System.out.println("1. Komedie ");
        System.out.println("2. Román ");
        System.out.println("3. Horror ");
        System.out.println("4. Drama ");
        System.out.println("5. Poezie ");   //ze zadani je, ze mame 5 zanru, ale nejsou presne dane ktere
        System.out.println("-----------------------------------------");
        System.out.println("Vyberte žánr knihy: ");
        
        int hledanyzanr = scanner.nextInt();
        scanner.nextLine(); 
        switch (hledanyzanr) {
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
        boolean existujeKnihyZanru = false;
        for (kniha kniha : knihy) {   //projde vsechny knihy
            if (kniha instanceof romany) {     //pokud se jedna o roman
                romany roman = (romany) kniha;    
                		// pokud je žánr knihy shodný s hledaným 
                if (roman.getZanr().equalsIgnoreCase(zanr)) {
                    System.out.println(roman);
                    existujeKnihyZanru = true;
                }
            } else if (kniha instanceof ucebnice) {    //pokud se jedna o ucebnici
                ucebnice ucebnice = (ucebnice) kniha;
                if (Integer.toString(ucebnice.getRocnik()).equalsIgnoreCase(zanr)) {
                    System.out.println(ucebnice);
                    existujeKnihyZanru = true;
                }
            }
        }

        if (!existujeKnihyZanru) {
            System.out.println("Nebyly nalezeny žádné knihy tohoto žánru.");
        }
    }

    // výpis všech vypůjčených knih
    public static void vypisVypujceneKnihy(ArrayList<kniha> knihy) {
        boolean existujeVypujcenakniha = false;  //sleduje existenci vypujcenych knih a predpokladame, ze neni zadna kniha vypujcena
        
        for (kniha kniha : knihy) {
            if (!kniha.isDostupnost()) {
                if (kniha instanceof romany) {    // pokud je kniha roman
                    System.out.println(kniha.getNazev() + " (Žánr: Román)");
                } else if (kniha instanceof ucebnice) { //pokud je kniha ucebnice
                    System.out.println(kniha.getNazev() + " (Žánr: Učebnice)");
                }
                existujeVypujcenakniha = true;
            }
        }

        if (!existujeVypujcenakniha) {      //kontrola, jestli existuje aspon jedna vypujcena kniha
            System.out.println("Vaše knihovna je plná a nepostrádá žádnou knihu! :-) ");
        }
    }
}
