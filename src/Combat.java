import java.util.ArrayList;

public class Combat {
    private int attack;
    private int defense;
    private int health;
    TextUI ui = new TextUI();

    public void fight(Player player, Creature creature) {


        for (int c = 1; player.getHealth() > 0 && creature.getHealth() > 0; c++) {
            ui.Msg(player.getName() + " and " + creature.getName() + " will now fight");
            ArrayList<String> options = new ArrayList<>();
            options.add("proceed to Fight");
            options.add("consume Item");
            options.add("Flee");

            int choice = ui.promptNumericChoice(options, "what`s your next Move?");

            switch (choice) {

                case 1:
                    proceedTofight(player, creature);
                    break;
                case 2:
                    player.consume(player);
                    break;
                case 3:
                   // flee(player, creature);
                    return;
            }

        }
        if(player.getHealth() <= 0) {
            ui.Msg(player.getName() + " has been defeated.");
        } else if (creature.getHealth() <= 0) {
            ui.Msg(creature.getName() + " has been defeated.");
        }
    }


    public void proceedTofight(Player player, Creature creature) {
        int playerAttack = player.getAttack();
        int creatureAttack = creature.getAttack();

        int playerDefense = player.getDefense();
        int creatureDefense = creature.getDefense();

        System.out.println(player.getName() + " attacks with " + playerAttack);
        System.out.println(creature.getName() + " attacks with " + creatureAttack);


        player.health -= creatureAttack - playerDefense;
        creature.health -= playerAttack - creatureDefense;


        System.out.println(player.getHealth());
        System.out.println(creature.getHealth());


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


