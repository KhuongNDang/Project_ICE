import java.sql.*;

public class DBConnector {
    static Connection conn;

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
        String query = "SELECT * FROM Potion WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Assuming Ascii is a subclass of Creature
                    return new Potion(
                            rs.getString("name"),
                            rs.getInt("attack"),
                            rs.getInt("defense"),
                            rs.getInt("health")
                    );
                } else {
                    System.out.println("No potion found with ID " + id);
                    return null; // Optionally return Optional.empty() instead
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Ascii getCreatureAsciiById(int id) {
        String query = "SELECT * FROM AsciiCreature WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Assuming Ascii is a subclass of Creature
                    return new Ascii(
                            rs.getString("picture")
                    );
                } else {
                    System.out.println("No creature found with ID " + id);
                    return null; // Optionally return Optional.empty() instead
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Ascii getAsciiGearById(int id) {
        String query = "SELECT * FROM AsciiGear WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Assuming Ascii is a subclass of Creature
                    return new Ascii(
                            rs.getString("picture")
                    );
                } else {
                    System.out.println("No gear found with ID " + id);
                    return null; // Optionally return Optional.empty() instead
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Ascii getAsciiLocationById(int id) {
        String query = "SELECT * FROM AsciiLocation WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Assuming Ascii is a subclass of Creature
                    return new Ascii(
                            rs.getString("picture")
                    );
                } else {
                    System.out.println("No gear found with ID " + id);
                    return null; // Optionally return Optional.empty() instead
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
