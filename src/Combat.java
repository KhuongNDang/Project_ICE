import java.util.ArrayList;

public class Combat {
    private int attack;
    private int defense;
    private int health;
    TextUI ui = new TextUI();
    private Bag bag;


    // Update constructor to accept a Bag
    public Combat(Bag bag) {
        this.bag = bag;  // Initialize the bag
    }

    public void fight(Player player, Creature creature, Bag bag) {


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
                    flee(player);
                    break;
            }

        }
        if (player.getHealth() <= 0) {
            ui.Msg(player.getName() + " has been defeated.");
        } else if (creature.getHealth() <= 0) {
            ui.Msg(creature.getName() + " has been defeated.");
            ui.Msg(" ");
            ui.Msg("you have gained " + creature.getXp() + " XP.");
            int playerXp = player.getXp();
            player.setXp(playerXp + creature.getXp());
            ui.Msg(" ");
            player.levelUp();
            ui.Msg(" ");
            ui.Msg("your currrent xp is now: " + player.getXp());


        }

        player.levelUp();
    }


        public void proceedTofight (Player player, Creature creature){
            int playerAttack = player.getAttack();
            int creatureAttack = creature.getAttack();

            int playerDefense = player.getDefense();
            int creatureDefense = creature.getDefense();

            int playerHealth = player.getHealth();

            System.out.println(player.getName() + " attacks with " + playerAttack + " attack ");
            System.out.println();
            System.out.println(creature.getName() + " attacks with " + creatureAttack + " attack " + "and " + player.getName() + " blocks with " + player.getDefense() + " defense ");
// pænere med player defence tekst
            System.out.println();
            playerHealth -= creatureAttack - playerDefense;
            creature.health -= playerAttack - creatureDefense;

// betydning af tal
            //  System.out.println("Remaning health: ");
            System.out.println("player's remaning health: ");
            System.out.println(player.getHealth());
            //System.out.println("Remaning health: ");
            System.out.println("Enemy's remaning health:  ");
            System.out.println(creature.getHealth());
            //System.out.println("Enemys remaning health:  ");


            System.out.println();
            System.out.println();
            //System.out.println();
        }
    }


/*
    public void heavyAttack() {
    }

    public void lightAttack() {
    }

    public void consume(Player player) {
    }
*/
    public void flee(Player player) {

    }




