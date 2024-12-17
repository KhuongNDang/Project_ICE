import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:database/database(1)";
        TextUI ui = new TextUI();
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect(url);
        Ascii.initialize(url);
        Inventory inventory = new Inventory();
        Player player = new Player("FartMaster2000", 100, 10, 0, 0, 0, inventory);

        Bag bag = new Bag(dbConnector, inventory, ui, player);
        Combat combat = new Combat(bag, inventory);

        Creature creature = dbConnector.getCreatureById(2);
        GameDialogue gamedialogue = new GameDialogue();

        gamedialogue.fwBarracks(player);
        player.createUsername();
        gamedialogue.storyPartIntro(player);
        gamedialogue.mainMenu(player);
        //gamedialogue.storyPartMarket(player);
        gamedialogue.storyPartDarkAlley(player);
        gamedialogue.storyPartVillageBurn(player);
        gamedialogue.arrivalCheeseCity(player);
        gamedialogue.cheeseCity(player);


        bag.addItemFromDB(1);
        bag.addItemFromDB(1);
        bag.addItemFromDB(1);
        bag.addItemFromDB(1);


        combat.fight(player,creature,bag);




        }
    }




