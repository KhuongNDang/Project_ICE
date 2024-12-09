

public class Creature {

    private String name;
    private int attack;
    private int defense;
    public int health;
    private int currency;

// final

    public Creature(String name, int attack, int defense, int health, int currency) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.currency = currency;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrency() {
        return currency;
    }

    public String getName() {return name;}

}

