import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    Connection conn;
    public void connect(String url) {


        try {

            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public ArrayList<String> selectPlayers(){
        // initialize a List to return the selected data as string elements
        ArrayList<String> data = new ArrayList<>();
        // make the query string
        String sql = "SELECT id, name, health, attack, defense, currency FROM Creature";

        try {
            Statement stmt = conn.createStatement();

            // execute the query
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //read each row of the result set ( = response from the query execution)
                String row = rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getInt("attack") + ", " + rs.getString("defense") + ", " + rs.getInt("health") + ", " + rs.getString("currency") ;
                //add the string to the ArrayList
                data.add(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public Creature getCreatureById(int id) {
        String query = "SELECT * FROM Creature WHERE id = " + id;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                // Create and return a Creature object
                return new Creature(
                        rs.getString("name"),
                        rs.getInt("attack"),
                        rs.getInt("defense"),
                        rs.getInt("health"),
                        rs.getInt("currency")
                );
            } else {
                System.out.println("No creature found with ID " + id);
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
