
import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Todo: tilføj stien til din .db fil
        String url = "jdbc:sqlite:creature.db";
        DBConnector dbConnector = new DBConnector();

        dbConnector.connect(url);

        Creature creature = dbConnector.getCreatureById(1);
        if (creature == null) {
            System.out.println("Unable to start fight. Creature not found.");
            return;
        }

        // Create a Player object
        Player player = new Player("Player1", 5, 3, 20, 10);

        // Create a Combat instance and start the fight
        Combat combat = new Combat();
        combat.fight(player, creature);
    }

    }


