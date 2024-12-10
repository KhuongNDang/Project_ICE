

public class Creature {

    private String name;
    private int attack;
    private int defense;
    public int health;
    public int xp;
    private int currency;

// final

    public Creature(String name, int attack, int defense, int health, int xp, int currency) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.xp = xp;
        this.currency = currency;
    }

    public String getName() {return name;}

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getXp() { return xp; }

    public int getCurrency() {
        return currency;
    }


}

