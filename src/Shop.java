import java.util.ArrayList;
import java.util.Currency;

public class Shop {
    private TextUI ui = new TextUI();

    public void shopPotionMenu(Player player, Currency currency) {


        while (true) {
            ui.Msg("Welcome to my Humble Shop");

            ArrayList<String> options = new ArrayList<>();
            options.add("Buy Potion");
            options.add("Buy Gear");
            options.add("Sell Items");
            options.add("Exit");

            int choice = ui.promptNumericChoice(options, "pick a one");

            switch (choice) {

                case 1:
                    buyPotion(player,currency);
                    break;
                case 2:
                    sellItems(player,currency);
                    break;
                case 3:
                    return;
            }

        }



    }
    public void shopGearMenu(Player player, Currency currency) {


        while (true) {
            ui.Msg("Welcome to my Humble Shop");

            ArrayList<String> options = new ArrayList<>();
            options.add("Buy Gear");
            options.add("Sell Items");
            options.add("Exit");

            int choice = ui.promptNumericChoice(options, "pick a one");

            switch (choice) {

                case 1:
                    buyGear(player,currency);
                    break;
                case 2:
                    sellItems(player,currency);
                    break;
                case 3:
                    return;
            }

        }



    }

    public void buyPotion(Player player, Currency currency) {

    }
    public void buyGear(Player player, Currency currency) {}
    public void sellItems(Player player, Currency currency) {}
}