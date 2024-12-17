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
    private Inventory inventory;


    public Player(String name, int health, int attack, int defense, int xp, int currency, Inventory inventory) {
        this.name = name;
        this.defense = defense;
        this.health = health;
        this.attack = attack;
        this.xp = xp;
        this.currency = currency;
        this.inventory = inventory;
    }

    public void displayStats() {

        updateStatsFromInventory(inventory);
        System.out.println("Player Stats:");
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("XP: " + xp);
        System.out.println("Currency: " + currency);
        System.out.println("Level: " + level);

    }


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
            ui.Msg("Your max Health has risen to " + getMaxHealth() + ".");
            ui.Msg(" ");
            ui.Msg("You need to reach " + xpLimit + " XP to reach the next level!");
        }
    }

    public void createUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your username: ");
        this.name = scanner.nextLine();
        System.out.println("Welcome, " + name + "!");
    }


    public void updateStatsFromInventory(Inventory inventory) {
        int totalAttack = getAttack(); // Start with player's base attack
        int totalDefense = getDefense(); // Start with player's base defense
        int totalHealth = getHealth(); // Start with player's base health

        for (String slot : inventory.getSlots()) {
            Item item = inventory.getItemFromSlot(slot);
            if (item != null) {
                totalAttack += item.getAttack(); // Add only the item's attack
                totalDefense += item.getDefense(); // Add only the item's defense
                totalHealth += item.getHealth(); // Add only the item's health
            }
        }

        setAttack(totalAttack);
        setDefense(totalDefense);
        setHealth(Math.min(totalHealth, maxHealth)); // Ensure health does not exceed maxHealth

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

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void addCurrency(int amount) {
        this.currency += amount;
        ui.Msg("You have gained " + amount + " currency. Total currency: " + this.currency);
    }

    public boolean deductCurrency(int amount) {
        if (this.currency >= amount) {
            this.currency -= amount;
            ui.Msg("You have spent " + amount + " currency. Remaining currency: " + this.currency);
            return true;
        } else {
            ui.Msg("Insufficient currency. You have " + this.currency + " currency.");
            return false;
        }
    }
}
