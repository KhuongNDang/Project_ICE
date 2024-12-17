public class Potion{

    private int id; // Add an ID field
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int currency;

    public Potion(String name, int attack, int defense, int health, int currency) {
        this.id = id;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.currency = currency;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getAttack() {
        return 0;
    }


    public int getDefense() {
        return 0;
    }


    public int getHealth() {
        return 0;
    }


    public String getSlot() {
        return "";
    }

    public int getAddAttack() {
        return attack;
    }

    public int getAddDefense() {
        return defense;
    }

    public int getAddHealth() {
        return health;
    }
    public int getCurrency() {
        return currency;
    }
    public int setCurrency(int currency) {return currency;}
}
