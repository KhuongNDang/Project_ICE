import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        //Todo: tilføj stien til din .db fil
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
        Player player = new Player("Player1", 15, 3, 45, 10);


        Combat combat = new Combat();
        combat.fight(player, creature1);
        combat.fight(player, creature2);


    }
    }



