

public class Creature {

    public String name;
    public int attack;
    public int defense;
    public int health;
    public int xp;
    public int currency;

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

    public int getHealth() {return health;}

    public void setHealth(int health) {
        if (health >= 0) { // Ensures health never goes negative
            this.health = health;
        } else {
            this.health = 0; // Set health to 0 if it goes negative
        }
    }

    public int getXp() { return xp; }

    public int getCurrency() {
        return currency;
    }


}

