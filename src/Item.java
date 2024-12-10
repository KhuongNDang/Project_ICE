import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Item {


    private String name;
    private int addAttack; // Using Integer to allow null values
    private int addDefense;
    private int addHealth;
    private int addXP;
    private int addCurrency;



    public Item(String name, int addAttack, int addDefense, int addHealth, int addXP, int addCurrency) {
        this.name = name;
        this.addAttack = addAttack;
        this.addDefense = addDefense;
        this.addHealth = addHealth;
        this.addXP = addXP;
        this.addCurrency = addCurrency;
    }


    public static Item getPotionId(int id) {

        Connection conn = null;

        String query = "SELECT * FROM Item WHERE id = " + id;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                // Create and return a Creature object
                return new Item(
                        rs.getString("name"),
                        rs.getInt("addAttack"),
                        rs.getInt("addDefense"),
                        rs.getInt("addHealth"),
                        rs.getInt("addXp"),
                        rs.getInt("addCurrency")
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


    // Getters

    public String getName() {
        return name;
    }

    public int getAddAttack() {
        return addAttack;
    }

    // Setters (only one of these should be used)
    public void setAddAttack(int value) {
        this.addAttack = value;
    }


    public int getAddDefense() {
        return addDefense;
    }

    public void setAddDefense(int value) {
        this.addDefense = value;
    }

    public int getAddHealth() {
        return addHealth;
    }

    public void setAddHealth(int value) {

        this.addHealth = value;
    }

    public int getAddXP() {
        return addXP;
    }

    public void setAddXP(int value) {

        this.addXP = value;
    }
}