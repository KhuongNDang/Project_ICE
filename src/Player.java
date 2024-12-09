
public class Player {

    private String name;
    private int attack;
    private int defense;
    private int health;
    private int xp;

    public Player(String name, int attack, int defense, int health, int xp) {
        this.name = name;
        this.defense = defense;
        this.health = health;
        this.attack = attack;
        this.xp = xp;


//        public void equipItem () {
//        }
//
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

    public int getXp() {
        return xp;
    }

}


