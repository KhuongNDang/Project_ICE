import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            Player player = new Player("FartMaster2000", 10, 5, 100, 0, 50); // Eksempel på spilleroprettelse
            GameDialogue dialogue = new GameDialogue();
            // Opret player()
            dialogue.storyPartIntro(player);
            //Titelscreen
            // Main Menu
            dialogue.storyPartUncleBen(player); //Samtale med Uncle Ben
            dialogue.storyPartMarket(player);
            dialogue.storyPartDarkAlley(player);
            //Battle med bandit
            dialogue.storyPartDarkAlleyResult(player);



        }
    }


/*

        String url = "jdbc:sqlite:creature.db";
        DBConnector dbConnector = new DBConnector();

        dbConnector.connect(url);

        Map<Integer, Creature> creatures = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            Creature creature = dbConnector.getCreatureById(i);
            creatures.put(i, creature);
        }
            Creature creature1 = creatures.get(1); // Get first creature from the list
            Creature creature2 = creatures.get(2); // Get second creature from the list

//        Creature creature = dbConnector.getCreatureById(1);
//        if (creature == null) {
//            System.out.println("Unable to start fight. Creature not found.");
//            return;
//        }
//
//        Creature creature1 = dbConnector.getCreatureById(10);
//        if (creature1 == null) {
//            System.out.println("Unable to start fight. Creature not found.");
//            return;
//        }


        // Create a Player object
        Player player = new Player("Player1", 15, 3, 20, 10, 10);


        Combat combat = new Combat();
        combat.fight(player, creature1);
        combat.fight(player, creature2);


    }
    }
*/


