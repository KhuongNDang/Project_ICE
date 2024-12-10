

public class Item {

    private int id; // Primary key for the database
    private String name;
    private Integer addAttack; // Using Integer to allow null values
    private Integer addDefense;
    private Integer addHealth;
    private Integer addXP;


    public Item(int id, String name, Integer addAttack, Integer addDefense, Integer addHealth, Integer addXP) {
        this.id = id;
        this.name = name;
        this.addAttack = addAttack;
        this.addDefense = addDefense;
        this.addHealth = addHealth;
        this.addXP = addXP;
    }


    // Reset all attributes to null so that only one is set
    private void resetAttributes() {
        this.addAttack = null;
        this.addDefense = null;
        this.addHealth = null;
        this.addXP = null;
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAddAttack() {
        return addAttack;
    }

    // Setters (only one of these should be used)
    public void setAddAttack(int value) {
        resetAttributes();
        this.addAttack = value;
    }


    public Integer getAddDefense() {
        return addDefense;
    }

    public void setAddDefense(int value) {
        resetAttributes();
        this.addDefense = value;
    }

    public Integer getAddHealth() {
        return addHealth;
    }

    public void setAddHealth(int value) {
        resetAttributes();
        this.addHealth = value;
    }

    public Integer getAddXP() {
        return addXP;
    }

    public void setAddXP(int value) {
        resetAttributes();
        this.addXP = value;
    }
}