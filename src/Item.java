import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




    public class Item {
        private int id;
        private String name;
        private int attack;
        private int defense;
        private int health;
        private String slot;
        private Connection conn;


        public Item(String name, int attack, int defense, int health, String slot) {
            this.id = id;
            this.name = name;
            this.slot = slot;
            this.attack = attack;
            this.defense = defense;
            this.health = health;

        }

        public Item loadItemById (int id){
            String query = "SELECT * FROM Item WHERE id = " + id;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                if (rs.next()) {
                    // Create and return a Creature object
                    return new Item(
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





