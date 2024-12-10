
public class Player {

    private String name;
    private int attack;
    private int defense;
    public int health;
    private int xp;
    private int currency;


    public Player(String name, int attack, int defense, int health, int xp, int currency) {
        this.name = name;
        this.defense = defense;
        this.health = health;
        this.attack = attack;
        this.xp = xp;
        this.currency = currency;

        }


    //        public void equipItem () { }


    public String getName() {
        return name;}


    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrency(){
        return currency;
    }

    public int getXp() {
        return xp;
    }




}


