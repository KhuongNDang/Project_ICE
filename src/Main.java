import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            Player player = new Player("FartMaster2000", 10, 5, 100, 0, 50); // Eksempel på spilleroprettelse
            GameDialogue dialogue = new GameDialogue();

            // Opret player() // todo: lav metode til at oprette spiller
            dialogue.storyPartIntro(player);
            //Titelscreen// todo: lav titel screen
            // Main Menu // todo: Lav main menu
            dialogue.storyPartUncleBen(player); //Samtale med Uncle Ben
            dialogue.storyPartMarket(player);

            //dialogue.storyPartDarkAlley(player);

            //dialogue.storyPartDarkAlleyResult(player);
            dialogue.cheeseCity(player);
            //todo sørg for man kommer ud af CheeseCity metoden så spillet også slutter.


        }
    }





        String url = "jdbc:sqlite:creature.db";

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



