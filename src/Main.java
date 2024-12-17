

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:database/database(1)";
        TextUI ui = new TextUI();
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect(url);
        Ascii.initialize(url);
        Inventory inventory = new Inventory();
        Player player = new Player("FartMaster2000", 100, 10, 0, 0, 0, inventory);


        GameDialogue gamedialogue = new GameDialogue();

        player.createUsername();
        gamedialogue.storyPartIntro(player);
        gamedialogue.mainMenu(player);
        gamedialogue.storyPartMarket(player);
        gamedialogue.storyPartDarkAlley(player);
        gamedialogue.storyPartVillageBurn(player);
        gamedialogue.arrivalCheeseCity(player);
        gamedialogue.cheeseCity(player);


        }
    }




