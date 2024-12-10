import java.util.Random;

public class Combat {
    private int attack;
    private int defense;
    private int health;


    public void fight(Player player, Creature creature) {

        for (int c = 1; player.getHealth() > 0 && creature.getHealth() > 0; c++) {
            System.out.println(player.getName() + " and " + creature.getName() + " will now fight");


            int playerAttack = player.getAttack();
            int creatureAttack = creature.getAttack();

            int playerDefense = player.getDefense();
            int creatureDefense = creature.getDefense();

            System.out.println(player.getName() + " attacks with " + playerAttack);
            System.out.println(creature.getName() + " attacks with " + creatureAttack);


            player.health -= creatureAttack - playerDefense;
            creature.health -= playerAttack - creatureDefense;



            System.out.println(creature.getHealth());
            System.out.println(player.getHealth());


            System.out.println();
            System.out.println();





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

