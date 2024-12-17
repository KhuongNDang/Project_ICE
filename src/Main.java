import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        String url = "jdbc:sqlite:database/database";
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect(url);

        Inventory inventory = new Inventory();
        TextUI textUI = new TextUI();


        Player player = new Player("David",100,20,10,0,0,inventory);
        Bag bag = new Bag(dbConnector, inventory, textUI, player);


        bag.addItemFromDB(1);
        bag.addItemFromDB(2);
        bag.addItemFromDB(3);
        bag.addItemFromDB(4);
        bag.addItemFromDB(5);
        bag.addItemFromDB(6);
        bag.addItemFromDB(7);
        bag.addItemFromDB(8);
        bag.addItemFromDB(3);
        bag.addPotionFromDB(1);
        bag.addPotionFromDB(9);
        Creature creature1 = dbConnector.getCreatureById(1);
        Creature creature2 = dbConnector.getCreatureById(2);
        Creature creature3 = dbConnector.getCreatureById(3);


        Combat combat = new Combat(bag,inventory);

        System.out.println();
        System.out.println();

        player.displayStats();
        System.out.println();
        System.out.println();
        combat.fight(player, creature1, bag);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        player.displayStats();
        System.out.println();
        System.out.println();




    }
}



