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



//        for (int i = 1; i <= 10; i++) {
//            Creature creature = dbConnector.getCreatureById(i);
//            creatures.put(i, creature);
//
//            // Create a Player object
//
//            Player player = new Player("", 100, 200, 3, 49, 10);
//            player.createUsername();
//
//
//            Creature creature1 = creatures.get(1); // Get first creature from the list
//            Creature creature2 = creatures.get(2); // Get second creature from the list
//            Creature creature3 = creatures.get(3); // Get second creature from the list
//            Creature creature4 = creatures.get(4); // Get second creature from the list
//
//
//            Combat combat = new Combat();
//            combat.fight(player, creature1);
//            combat.fight(player, creature2);
//            combat.fight(player, creature3);
//            combat.fight(player, creature4);
//
//
//        }
        Map<Integer, Ascii> asciis = new HashMap<>();


            for (int i = 1; i <= 24; i++) {
                Ascii ascii = dbConnector.getCreatureAsciiById(i);
                if (ascii != null) {
                    asciis.put(i, ascii);
                }
            }

            Map<Integer, Ascii> asciisGear = new HashMap<>();

            for (int i = 1; i <= 21; i++) {
                Ascii ascii = dbConnector.getAsciiGearById(i);
                if (ascii != null) {
                    asciisGear.put(i, ascii);
                }
            }

            Ascii ascii1 = asciis.get(1);
            Ascii ascii2 = asciis.get(2);
            Ascii ascii3 = asciis.get(3);
            Ascii ascii4 = asciis.get(4);
            Ascii ascii22 = asciis.get(22);
            Ascii ascii23 = asciis.get(23);
            Ascii asciiGear = asciisGear.get(1);
            System.out.println(ascii1);
            System.out.println(ascii2);
            System.out.println(ascii3);
            System.out.println(ascii4);
            System.out.println(ascii22);
            System.out.println(ascii23);



        }
    }



