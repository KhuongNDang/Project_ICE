import java.sql.*;

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
                        rs.getInt("xp"),
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


    public static Potion getPotionId(int id) {
        // Connection string to the database (update the database name, user, and password)
        String url = "jdbc:sqlite:C:\\Users\\khnda\\IdeaProjects\\Project_ICE\\creature.db";

        // SQL query to fetch the item
        String query = "SELECT * FROM Potion WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the ID parameter to prevent SQL injection
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Create and return an Item object using data from the database
                    return new Potion(
                            rs.getString("name"),
                            rs.getInt("attack"),
                            rs.getInt("defense"),
                            rs.getInt("health")
                    );
                } else {
                    System.out.println("No item found with ID " + id);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
