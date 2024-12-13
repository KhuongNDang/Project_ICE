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

        this.attack = attack;
        this.xp = xp;
        this.currency = currency;

    }


    //        public void equipItem () { }


    public String getName() {
        return name;

    }
  
  
  
    public void consume(Player player) {
        // Prompt the user to choose an item ID to consume
        int potionId = ui.promptNumeric("Enter the ID of the item you want to consume:");

        // Get the item from the database
        Potion potion = DBConnector.getPotionId(potionId);

        if (potion != null) {
            ui.Msg("You consumed " + potion.getName() + ".");

            // Check which attribute the item adds and apply it to the player
            if (potion.getAddHealth() > 0) {
                player.health += potion.getAddHealth();
                ui.Msg("Player's health increased by " + potion.getAddHealth() + ".");
                ui.Msg("Player's new health is: " + player.health);

            }
            if (potion.getAddAttack() > 0) {
                player.attack += potion.getAddAttack();
                ui.Msg("Player's attack increased by " + potion.getAddAttack() + ".");
                ui.Msg("Player's new attack is: " + player.attack);
            }
            if (potion.getAddDefense() > 0) {
                player.defense += potion.getAddDefense();
                ui.Msg("Player's defense increased by " + potion.getAddDefense() + ".");
                ui.Msg("Player's new defense is: " + player.defense);
            }
            if (potion.getAddXp() > 0) {
                player.xp += potion.getAddXp();
                ui.Msg("Player's XP increased by " + potion.getAddXp() + ".");
                ui.Msg("Player's new XP is: " + player.xp);
            }

        } else {
            ui.Msg("No item with ID " + potionId + " found.");
        }
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





    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCurrency(){
        return currency;
    }

    public int getXp() {
        return xp;
    }

    public int getHealth() {return health;}

    public int setAttack(int i){ return attack; }

    public int setDefense(int i){ return defense; }

    public int setHealth(){ return health; }

    public int setCurrency(){return currency; }

    public void setXp(int i){ xp = i; }

    public int getMaxHealth(){ return maxHealth; }

    public int getLevel() {return level;}
}


