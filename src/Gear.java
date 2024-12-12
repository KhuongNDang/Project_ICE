import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




    public class Gear {
        private int id;
        private String name;
        private String slot;
        private int attack;
        private int defense;
        private int health;
        private Connection conn;


        public Gear(String name, int attack, int defense, int health, String slot) {
            this.id = id;
            this.name = name;
            this.slot = slot;
            this.attack = attack;
            this.defense = defense;
            this.health = health;

        }

        public Gear loadGearById (int id){
            String query = "SELECT * FROM Gear WHERE id = " + id;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                if (rs.next()) {
                    // Create and return a Creature object
                    return new Gear(
                            rs.getString("name"),
                            rs.getInt("attack"),
                            rs.getInt("defence"),
                            rs.getInt("health"),
                            rs.getString("slot")
                    );

                } else {
                    System.out.println("No gear found with ID " + id);
                    return null;
                }

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return null;
            }
        }


    }




}
