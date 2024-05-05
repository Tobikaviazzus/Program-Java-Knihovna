package projekt_knihovna_smejdir_uher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class vypis {
	
	
	public static void vypisKnihy(ArrayList<kniha> knihy) { 
        if (knihy.isEmpty()) { 
            System.out.println("Knihovna je prázdná."); 
            return; 
        }
        
        Collections.sort(knihy, Comparator.comparing(kniha::getNazev)); 
        for (kniha kniha : knihy) { 
            System.out.println(kniha); 
        }
    }


    public static void vyhledatKnihu(ArrayList<kniha> knihy, Scanner scanner) {
        System.out.print("Zadejte název knihy, kterou chcete vyhledat: ");
        String nazev = scanner.nextLine();
        
        boolean knihaNalezena = false;
        for (kniha kniha : knihy) {  
            if (kniha.getNazev().equalsIgnoreCase(nazev)) {  
                System.out.println(kniha);
                knihaNalezena = true;    
                break;
            }
        }
        
        if (!knihaNalezena) {     
            System.out.println("kniha s tímto názvem nebyla nalezena");
        }
    }

  
    
  
    public static void vypisVsechnyAutory(ArrayList<kniha> knihy) {
        System.out.println("Seznam všech autorů:");
        int cisloAutora = 1;
        HashSet<String> autorSet = new HashSet<>();
        for (kniha kniha : knihy) {          
            for (String autor : kniha.getAutori()) {       
                if (!autorSet.contains(autor)) {
                    System.out.println(cisloAutora + ". " + autor);
                    autorSet.add(autor);        
                    cisloAutora++;           
                }
            }
        }
    }
    
    
    public static void vypisKnihyAutora(ArrayList<kniha> knihy, Scanner scanner) {
        vypisVsechnyAutory(knihy);
        
        System.out.print("Zadejte číslo autora: ");
        int cisloAutora = scanner.nextInt();
        scanner.nextLine(); 
   
        
        String autor = null;
        int aktualniCisloAutora = 1; 
        HashSet<String> autorSet = new HashSet<>(); 

        for (kniha kniha : knihy) {
            
            for (String aut : kniha.getAutori()) {   
                if (!autorSet.contains(aut)) {
                	
                    if (aktualniCisloAutora == cisloAutora) {
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

        
        ArrayList<kniha> knihyAutora = new ArrayList<>();
        for (kniha kniha : knihy) {
            if (kniha.obsahujeAutora(autor)) {
                knihyAutora.add(kniha);
            }
        }

        if (!knihyAutora.isEmpty()) {
            Collections.sort(knihyAutora, Comparator.comparing(kniha::getRokVydani)); 
            for (kniha kniha : knihyAutora) {
                System.out.println(kniha);
            }
        } else {
            System.out.println("Kniha tohoto autora nebyla nalezena");
        }
    }

    
    public static void vypisKnihyZanru(ArrayList<kniha> knihy, Scanner scanner) 
    {
    	String zanr = null;
        System.out.println("-----------------------------------------");
        System.out.println("1. Komedie ");
        System.out.println("2. Román ");
        System.out.println("3. Horror ");
        System.out.println("4. Drama ");
        System.out.println("5. Poezie ");  
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
        for (kniha kniha : knihy) {   
            if (kniha instanceof romany) {     
                romany roman = (romany) kniha;    
                		
                if (roman.getZanr().equalsIgnoreCase(zanr)) {
                    System.out.println(roman);
                    existujeKnihyZanru = true;
                }
            } else if (kniha instanceof ucebnice) {   
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

    public static void vypisVypujceneKnihy(ArrayList<kniha> knihy) {
        boolean existujeVypujcenakniha = false;  
        
        for (kniha kniha : knihy) {
            if (!kniha.isDostupnost()) {
                if (kniha instanceof romany) {    
                    System.out.println(kniha.getNazev() + " (Žánr: Román)");
                } else if (kniha instanceof ucebnice) { 
                    System.out.println(kniha.getNazev() + " (Žánr: Učebnice)");
                }
                existujeVypujcenakniha = true;
            }
        }

        if (!existujeVypujcenakniha) {     
            System.out.println("Vaše knihovna je plná a nepostrádá žádnou knihu! :-) ");
        }
    }
}
