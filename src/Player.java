
public class Player {

    private String name;
    private int attack;
    private int defense;
    public int health;
    private int xp;
    private int currency;

    TextUI ui = new TextUI();


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
                player.setAttack(player.getAttack() + item.getAddAttack());
                ui.Msg("Player's attack increased by " + item.getAddAttack() + ".");
            }
            if (item.getAddDefense() > 0) {
                player.setDefense(player.getDefense() + item.getAddDefense());
                ui.Msg("Player's defense increased by " + item.getAddDefense() + ".");
            }
            if (item.getAddXp() > 0) {
                player.setXp(player.getXp() + item.getAddXp());
                ui.Msg("Player's XP increased by " + item.getAddXp() + ".");
            }

        } else {
            ui.Msg("No item with ID " + itemId + " found.");
        }
    }


    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {

          return this.health = health;
    }

    public int getCurrency(){
        return currency;
    }

    public int getXp() {
        return xp;
    }

    public int setAttack(int i){ return attack; }

    public int setDefense(int i){ return defense; }

    public int setHealth(int i){ return health; }

    public int setCurrency(){return currency; }

    public int setXp(int i){ return xp; }


}


