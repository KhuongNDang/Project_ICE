import java.util.Random;

public class Combat {
    private int attack;
    private int defense;
    private int health;


    public void fight(Player player, Creature creature) {


        System.out.println(player.getName() + " and " + creature.getName() + " will now fight");

        int playerAttack = player.getAttack();
        int creatureAttack = creature.getAttack();
        System.out.println(player.getName() + " attacks with " + playerAttack);
        System.out.println(creature.getName() + " attacks with " + creatureAttack);

        if (playerAttack > creatureAttack || playerAttack < creatureAttack) {
            System.out.println(creature.getName() + " is damages by " + playerAttack + " points");
           playerAttack -= creature.health;
            System.out.println(player.getName() + " is damaged by " + creatureAttack + " points");
            creatureAttack -= player.health;
        }
         else {
            System.out.println("It is a tie! Nobody is damaged");

        }
        }
    }
/*
        public void heavyAttack(){}

        public void lightAttack(){
        }

        public void consume(){}

        public void flee(){}


*/

