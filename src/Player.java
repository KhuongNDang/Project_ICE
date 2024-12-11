public class Player {

    private String name;
    private int attack;
    private int defense;
    public int health = 100;
    public int xp;
    private int currency;
    public int maxHealth =100;
    public int level = 1;
    TextUI ui = new TextUI();


    public Player(String name, int attack, int defense, int xp, int currency) {
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
        int itemId = ui.promptNumeric("Enter the ID of the item you want to consume:");

        // Get the item from the database
        Item item = DBConnector.getPotionId(itemId);

        if (item != null) {
            ui.Msg("You consumed " + item.getName() + ".");

            // Check which attribute the item adds and apply it to the player
            if (item.getAddHealth() > 0) {
                player.health += item.getAddHealth();
                ui.Msg("Player's health increased by " + item.getAddHealth() + ".");
                ui.Msg("Player's new health is: " + player.health);

            }
            if (item.getAddAttack() > 0) {
                player.attack += item.getAddAttack();
                ui.Msg("Player's attack increased by " + item.getAddAttack() + ".");
                ui.Msg("Player's new attack is: " + player.attack);
            }
            if (item.getAddDefense() > 0) {
                player.defense += item.getAddDefense();
                ui.Msg("Player's defense increased by " + item.getAddDefense() + ".");
                ui.Msg("Player's new defense is: " + player.defense);
            }
            if (item.getAddXp() > 0) {
                player.xp += item.getAddXp();
                ui.Msg("Player's XP increased by " + item.getAddXp() + ".");
                ui.Msg("Player's new XP is: " + player.xp);
            }

        } else {
            ui.Msg("No item with ID " + itemId + " found.");
        }
    }
    public void levelUp(Player player) {

        if(player.xp >= 50) {
            level += 1;
            xp -= 50;
            maxHealth += 10;
            health = maxHealth;
            ui.Msg("You have level " + getLevel() + ".");
            ui.Msg("ur max health has risen to" + getMaxHealth() + ".");
        } else if (getXp() <= 50) {
            ui.Msg("u did not level up");
        }
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

    public int setXp(int i){ return xp; }

    public int getMaxHealth(){ return maxHealth; }

    public int getLevel() {return level;}
}


