/*package projekt_knihovna;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;

public class Queries {
		private static Connection conn; 
		public static boolean connect() { 
		       conn= null; 
		       try {
		              conn = DriverManager.getConnection("jdbc:mysql/myDB.db");                       
		       } 
		      catch (SQLException e) { 
		            System.out.println(e.getMessage());
			    return false;
		      }
		      return true;
		}
		public static void disconnect() { 
			if (conn != null) {
			       try {     conn.close();  } 
		               catch (SQLException ex) { System.out.println(ex.getMessage()); }
			}
		}

		
		 // uložení knih do databáze
	    public void ulozitKnihy(ArrayList<kniha> knihy) {

	        if (connect()) {
	            try {
	                for (kniha kniha : knihy) {
	                    String query = "INSERT INTO knihovna (nazev, autori, rok_vydani, dostupnost) VALUES (?, ?, ?, ?)";
	                    PreparedStatement preparedStatement = conn.prepareStatement(query);
	                    preparedStatement.setString(1, kniha.getNazev());
	                    preparedStatement.setString(2, String.join(", ", kniha.getAutori()));
	                    preparedStatement.setInt(3, kniha.getRokVydani());
	                    preparedStatement.setBoolean(4, kniha.isDostupnost());
	                    preparedStatement.executeUpdate();
	                }
	                System.out.println("Informace o knihách byly úspěšně uloženy do databáze.");
	            } catch (SQLException e) {
	                System.out.println("Chyba při práci s databází: " + e.getMessage());
	            } finally {
	                disconnect();
	            }
	        }
	    }
	    
	    
	    // načtení knih z databáze 
	    public static ArrayList<kniha> nacistKnihyZDatabaze() {
	        ArrayList<kniha> knihy = new ArrayList<>();
	        if (connect()) {
	            try {
	                String query = "SELECT * FROM knihovna";
	                PreparedStatement preparedStatement = conn.prepareStatement(query);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                    String nazev = resultSet.getString("nazev");
	                    String[] autori = resultSet.getString("autori").split(", ");
	                    int rokVydani = resultSet.getInt("rok_vydani");
	                    boolean dostupnost = resultSet.getBoolean("dostupnost");
	                  
	                    knihy.add(new kniha(nazev, autori, rokVydani, dostupnost));
	                }
	            } catch (SQLException e) {
	                System.out.println("Chyba při práci s databází: " + e.getMessage());
	            } finally {
	                disconnect();
	            }
	        }
	        return knihy;
	    }
	}

*/

