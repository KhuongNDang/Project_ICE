import java.util.Scanner;

public class Player {

    private String name;
    private int attack;
    private int defense;
    private int health = 100;
    private int xp;
    private int currency;
    private int maxHealth = 100;
    private int level = 1;
    private int xpLimit = 50;
     TextUI ui = new TextUI();


    public Player(String name,int health, int attack, int defense, int xp, int currency) {
        this.name = name;
        this.defense = defense;
        this.health = health;
        this.attack = attack;
        this.xp = xp;
        this.currency = currency;

    }

    public void displayStats() {
        System.out.println("Player Stats:");
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
    }       public void equipItem () { }


    public String getName() {
        return name;

    }


    public void levelUp() {

        while (xp >= xpLimit) {
            level += 1;
            xp -= xpLimit;
            maxHealth += 10;
            health = maxHealth;

            xpLimit *= 1.1;

            ui.Msg("You have reached level " + getLevel() + ".");
            ui.Msg(" ");
            ui.Msg("your max Health has risen to " + getMaxHealth() + ".");
            ui.Msg(" ");
            ui.Msg("you have to reach " + xpLimit + " XP to reach next level!");

        }

    }
    public void createUsername () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("type your username: ");
        this.name = scanner.nextLine(); // Sætter brugerens input som spillernavn
        System.out.println("welcome, " + name + "!");
    }



public String getUsername() {
        return name;
}
public String setUsername() {
        return name;
}
    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }


    public int getXp() {
        return xp;
    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public void setXp(int i){ xp = i; }

    public int getMaxHealth(){ return maxHealth; }

    public int getLevel() {return level;}
    public int getCurrency() {return currency;}
    public void setCurrency(int i) { currency = i;}
}


