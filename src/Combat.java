import java.util.ArrayList;

public class Combat {
    private int attack;
    private int defense;
    private int health;
    TextUI ui = new TextUI();
    private Bag bag;
    private Inventory inventory;


    // Update constructor to accept a Bag
    public Combat(Bag bag, Inventory inventory) {
        this.bag = bag;  // Initialize the bag
        this.inventory = inventory;
    }

    public void fight(Player player, Creature creature, Bag bag) {
        // Step 1: Save player's original attack and defense

        int originalAttack = player.getAttack();
        int originalDefense = player.getDefense();


        for (int c = 1; player.getHealth() > 0 && creature.getHealth() > 0; c++) {
            System.out.println();

            ArrayList<String> options = new ArrayList<>();
            options.add("Proceed to fight");
            options.add("Consume item");
            options.add("Flee");
            ui.Msg(player.getName() + " and " + creature.getName() + " will now fight");
            ui.displayList(options,"");
            int choice = ui.promptNumericChoice(options, "What's your next move?");

            switch (choice) {
                case 1:
                    proceedTofight(player, creature);
                    break;
                case 2:
                    bag.useBag();
                    break;
                case 3:
                    return; // Exit the fight, player flees
            }
        }

        if (player.getHealth() <= 0) {
            ui.Msg(player.getName() + " has been defeated.");
            System.out.println();
        } else if (creature.getHealth() <= 0) {
            ui.Msg(creature.getName() + " has been defeated.");
            System.out.println();
            ui.Msg("You have gained " + creature.getXp() + " XP.");
            player.setXp(player.getXp() + creature.getXp());
            player.levelUp();
        }

        // Step 2: Restore original stats after the fight is over
        player.setAttack(originalAttack);
        player.setDefense(originalDefense);

        player.updateStatsFromInventory(inventory);

        player.levelUp();
    }



    public void proceedTofight (Player player, Creature creature){

            int playerAttack = player.getAttack();
            int creatureAttack = creature.getAttack();

            int playerDefense = player.getDefense();
            int creatureDefense = creature.getDefense();

            int playerHealth = player.getHealth();
            int creatureHealth = creature.getHealth();

            System.out.println(player.getName() + " attacks with " + playerAttack + " attack ");
            System.out.println();
            System.out.println(creature.getName() + " attacks with " + creatureAttack + " attack " + "and " + player.getName() + " blocks with " + player.getDefense() + " defense ");

            System.out.println();
            int newPlayerHealth = playerHealth - Math.max(0, creatureAttack - playerDefense);
            int newCreatureHealth = creatureHealth - Math.max(0, playerAttack - creatureDefense);

            player.setHealth(newPlayerHealth);
            creature.setHealth(newCreatureHealth);

            //  System.out.println("Remaning health: ");
            System.out.println(player.getName() + "'s remaning health: ");
            System.out.println(newPlayerHealth);
            //System.out.println("Remaning health: ");
            System.out.println(creature.getName() + "'s remaning health:  ");
            System.out.println(newCreatureHealth);
            //System.out.println("Enemys remaning health:  ");


            System.out.println();
            System.out.println();

        }
    }


/*
    public void heavyAttack() {
    }

    public void lightAttack() {
    }

    public void consume(Player player) {
    }

    public void flee() {
    }
*/


