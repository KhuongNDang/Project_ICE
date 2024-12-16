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


        Player player = new Player("David",10,10,10,0,0);
        Bag bag = new Bag(dbConnector, inventory, textUI, player);


     //   bag.addItemFromDB(1);
      //  bag.addItemFromDB(20);
       // bag.addItemFromDB(3);
       // bag.addPotionFromDB(1);
       // bag.addPotionFromDB(5);
        Creature creature1 = dbConnector.getCreatureById(1);
        Creature creature2 = dbConnector.getCreatureById(2);
        Creature creature3 = dbConnector.getCreatureById(3);


      //  bag.displayBag();

        Combat combat = new Combat(bag);
        combat.fight(player, creature1, bag);

        System.out.println();
        System.out.println();

       // bag.useBag();
       // player.displayStats();


        System.out.println();
        System.out.println();

     //   inventory.displayInventory();

        System.out.println();
        System.out.println();




    }
}



