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

        Creature creature1 = dbConnector.getCreatureById(10);
        if (creature1 == null) {
            System.out.println("Unable to start fight. Creature not found.");
            return;
        }




        // Create a Player object
        Player player = new Player("Player1", 15, 3, 20, 10, 10);


        Combat combat = new Combat();
        combat.fight(player, creature);


    }

    }


