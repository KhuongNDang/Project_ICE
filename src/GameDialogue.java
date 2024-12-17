import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class GameDialogue {
    TextUI ui = new TextUI();
    Scanner input = new Scanner(System.in);
    private Bag bag;
    private Inventory inventory;
    String picture;
    Ascii ascii = new Ascii(picture);

    public void storyPartIntro(Player player) {
        Ascii ascii = Ascii.getAsciiById(201);
        ui.Msg(String.valueOf(ascii));
        ui.Msg("");

        for (int i = 1; i <= 6; i++) {
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
    }

    public void storyPartUncleBen(Player player) {
        Ascii ascii = Ascii.getAsciiById(202);
        ui.Msg(String.valueOf(ascii));
        ui.Msg("");
        for (int i = 7; i <= 13; i++) {
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
        ArrayList<String> options = new ArrayList<>();
        options.add("Yes - I'll go to the market");
        options.add("No - Do it yourself, oldie!");
        ui.displayList(options, "");
        int choice = ui.promptNumericChoice(options, "What do you say to 'Uncle Ben'?");
        switch (choice) {
            case 1:
                player.addCurrency(20);
                for (int i = 14; i <= 17; i++) {
                    Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                    ui.Msg(String.valueOf(dialog));
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
                break;
            case 2:
                player.addCurrency(20);
                Dialog dialogNo = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 149, player);
                ui.Msg(String.valueOf(dialogNo));
                System.out.println("Press enter to continue...");
                input.nextLine();
                for (int i = 15; i <= 17; i++) {
                    Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                    ui.Msg(String.valueOf(dialog));
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
                break;
            default:
                ui.Msg("Uncle Ben, doesnt understand what you said");
        }

    }

    public void storyPartMarket(Player player) {
        Ascii ascii = Ascii.getAsciiById(203);
        ui.Msg(String.valueOf(ascii));
        ui.Msg("");
        for (int i = 18; i <= 26; i++) {
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
        storyVendor(player);
    }

    public void storyVendor(Player player) {
        ArrayList<String> options = new ArrayList<>();
        options.add("Vendor nr 1");
        options.add("Vendor nr 2");
        options.add("Vendor nr 3");
        ui.displayList(options, "");
        int Vendors = ui.promptNumericChoice(options, "Which Vendor do you want to visit?");
        switch (Vendors) {
            case 1:
                ChoiceVendor1(player);
                storyVendor(player);
                break;
            case 2:
                ChoiceVendor2(player);
                storyVendor(player);
                break;
            case 3:
                ChoiceVendor3(player);
                storyPartDarkAlley(player);
                break;
            default:
                ui.Msg("Where do you think your going?");

        }
    }

    private void ChoiceVendor1(Player player) {
        Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 27, player);
        ui.Msg(String.valueOf(dialog));

        ArrayList<String> ynOptions = new ArrayList<>();
        ynOptions.add("Do you have (QUEST ITEM)?");
        ynOptions.add("I'm not looking for Apples.");
        ui.displayList(ynOptions, "");
        int vendorYN = ui.promptNumericChoice(ynOptions, "What do you ask the vendor?");

        switch (vendorYN) {
            case 1:
                ui.Msg("Oh, I'm afraid I don't stock that. Perhaps try one of the other stalls?");
                break;
            case 2:
                ui.Msg("The vendor shrugs and says, 'Suit yourself.'");
                break;
            default:
                ui.Msg("The vendor doesn't understand your question.");
        }
    }

    private void ChoiceVendor2(Player player) {
        Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 29, player);
        ui.Msg(String.valueOf(dialog));

        ArrayList<String> ynOptions = new ArrayList<>();
        ynOptions.add("Do you have (QUEST ITEM)?");
        ynOptions.add("I'm not looking for fish");
        ui.displayList(ynOptions, "");
        int vendorYN = ui.promptNumericChoice(ynOptions, "What do you ask the vendor?");

        switch (vendorYN) {
            case 1:
                ui.Msg("Sorry, I don’t deal in that sort of thing. Maybe try the dry goods vendor over there.");
                break;
            case 2:
                ui.Msg("The vendor shrugs and says, 'Suit yourself.'");
                break;
            default:
                ui.Msg("The vendor doesn't understand your question.");
        }
    }

    private void ChoiceVendor3(Player player) {
        Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 31, player);
        ui.Msg(String.valueOf(dialog));

        ArrayList<String> ynOptions = new ArrayList<>();
        ynOptions.add("Do you have (QUEST ITEM)?");
        ynOptions.add("I'm not looking for Apples.");
        ui.displayList(ynOptions, "");
        int vendorYN = ui.promptNumericChoice(ynOptions, "What do you ask the vendor?");

        switch (vendorYN) {
            case 1:
                Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 32, player);
                ui.Msg(String.valueOf(dialog1));
                player.deductCurrency(20);
                // todo Tag penge
                break;
            case 2:
                ui.Msg("The vendor shrugs and says, 'Suit yourself.'");
                break;
            default:
                ui.Msg("The vendor doesn't understand your question.");
        }
    }

    public void storyPartDarkAlley(Player player) {
        Combat combat = new Combat(bag, inventory);
        DBConnector dbConnector = new DBConnector();

        for (int i = 34; i <= 36; i++) {
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
        Ascii ascii = Ascii.getAsciiById(204);
        ui.Msg(String.valueOf(ascii));
        ui.Msg("");

        ArrayList<String> options = new ArrayList<>();
        options.add("Check out the Alley");
        options.add("Go home to Uncle Ben");
        ui.displayList(options, "");
        int choice = ui.promptNumericChoice(options, "You hear a noise from the alley. Do you want to check it out?");
        switch (choice) {
            case 1:
                for (int i = 38; i <= 40; i++) {
                    Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                    ui.Msg(String.valueOf(dialog));
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
                Ascii asciiBandit = Ascii.getAsciiById(21);
                ui.Msg(String.valueOf(asciiBandit));
                ui.Msg("");

                combat.fight(player, dbConnector.getCreatureById(21), bag);
                storyPartDarkAlleyResult(player);
                break;
            case 2:
                for (int i = 41; i <= 43; i++) {
                    Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                    ui.Msg(String.valueOf(dialog));
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
                Ascii asciiBandit2 = Ascii.getAsciiById(21);
                ui.Msg(String.valueOf(asciiBandit2));
                ui.Msg("");

                combat.fight(player, dbConnector.getCreatureById(21), bag);
                storyPartDarkAlleyResult(player);
                break;
            default:
                ui.Msg("Where do you think your going?");
        }
    }


    public void storyPartDarkAlleyResult(Player player) {
        Dialog dialog;
        if (player.getHealth() >= 0) {
            dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 44, player);
        } else {
            dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 45, player);
        }
        ui.Msg(String.valueOf(dialog));
    }

    public void storyPartVillageBurn(Player player) {
        Combat combat = new Combat(bag, inventory);
        DBConnector dbConnector = new DBConnector();
        for (int i = 46; i <= 47; i++) {
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
        //todo: Potentiel tjekke om Quest Item er til stede

        for (int i = 49; i <= 63; i++) { //Billeder af Fontina, Village i brænd osv.
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }

        Ascii asciiFire = Ascii.getAsciiById(205);
        ui.Msg(String.valueOf(asciiFire));
        ui.Msg("");

        for (int i = 64; i <= 72; i++) { //Billeder af Fontina, Village i brænd osv.
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();

        }
        Ascii asciiRR = Ascii.getAsciiById(19);
        ui.Msg(String.valueOf(asciiRR));
        ui.Msg("");

        ArrayList<String> options = new ArrayList<>();
        options.add("Fight the rat");
        options.add("Try to escape!");
        ui.displayList(options, "");
        int choice = ui.promptNumericChoice(options, "What would like to do?");
        switch (choice) {
            case 1:
                Dialog dialogFight = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 73, player);
                ui.Msg(String.valueOf(dialogFight));
                combat.fight(player, dbConnector.getCreatureById(19), bag);
                break;
            case 2:
                Dialog dialog2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 74, player);
                ui.Msg(String.valueOf(dialog2));
                break;
            default:
                ui.Msg("Where do you think your going?");
        }
    }

    public void arrivalCheeseCity(Player player) {

        Ascii asciiCC = Ascii.getAsciiById(206);
        ui.Msg(String.valueOf(asciiCC));
        ui.Msg("");

        for (int i = 75; i <= 78; i++) {
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
    }

    public void cheeseCity(Player player) {
        ArrayList<String> options = new ArrayList<>();
        options.add("Go to the Tavern");
        options.add("Go to the Barracks");
        options.add("Go to the Potion Shop");
        options.add("Go to the Sewer Gate");
        options.add("Go to the road out of town");
        ui.displayList(options, "");
        int choice = ui.promptNumericChoice(options, "What would like to do?");
        switch (choice) {
            case 1:
                Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 79, player);
                ui.Msg(String.valueOf(dialog1));
                System.out.println("Press enter to continue...");
                input.nextLine();
                // todo if(Player.getItemID == fontina)
                //swTavernFight
                //else swTavern(player);
                break;
            case 2:
                Dialog dialog2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 82, player);
                ui.Msg(String.valueOf(dialog2));
                System.out.println("Press enter to continue...");
                input.nextLine();
                fwBarracks(player);
                break;
            case 3:
                Dialog dialog3 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 81, player);
                ui.Msg(String.valueOf(dialog3));
                System.out.println("Press enter to continue...");
                input.nextLine();
                wdShop(player);
                break;
            case 4:
                Dialog dialog4 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 80, player);
                ui.Msg(String.valueOf(dialog4));
                System.out.println("Press enter to continue...");
                input.nextLine();
                sewerGate(player);
                break;
            case 5:
                Dialog dialog5 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 84, player);
                ui.Msg(String.valueOf(dialog5));
                System.out.println("Press enter to continue...");
                input.nextLine();
                roadOut(player);
                break;
            default:
                ui.Msg("Where do you think your going?");
        }
    }

    public void swTavern(Player player) {

        Ascii asciiTavern = Ascii.getAsciiById(207);
        ui.Msg(String.valueOf(asciiTavern));
        ui.Msg("");

        Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 85, player);
        ui.Msg(String.valueOf(dialog));
        System.out.println("Press enter to continue...");
        input.nextLine();

        ArrayList<String> options = new ArrayList<>();
        options.add("HEY! I'm 8 months old - which is 42 in human years ");
        options.add("Im not - but im not here to drink");
        ui.displayList(options, "");
        int choice = ui.promptNumericChoice(options, "Snifflesworth: Aren’t you a little young to be in here?");
        switch (choice) {
            case 1:
                Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 87, player);
                ui.Msg(String.valueOf(dialog1));
                System.out.println("Press enter to continue...");
                input.nextLine();
                break;
            case 2:
                Dialog dialog2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 88, player);
                ui.Msg(String.valueOf(dialog2));
                System.out.println("Press enter to continue...");
                input.nextLine();
                break;
            default:
                ui.Msg("You mumble something incomprehensible");
        }
        ArrayList<String> optionsTwo = new ArrayList<>();
        optionsTwo.add("Tell Snifflesworth everything that happened.");
        optionsTwo.add("Order something from the bar");
        ui.displayList(optionsTwo, "");
        int choice2 = ui.promptNumericChoice(optionsTwo, "Snifflesworth: Aren’t you a little young to be in here?");
        switch (choice2) {
            case 1:
                for (int i = 91; i <= 94; i++) { //Giver map om Fontina sværdet
                    Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                    ui.Msg(String.valueOf(dialog1));
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
                break;
            case 2:
                ui.Msg("Narrator: You really dont have time for that right now...");
                System.out.println("Press enter to continue...");
                input.nextLine();
                for (int i = 91; i <= 94; i++) { //Giver map om Fontina sværdet
                    Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                    ui.Msg(String.valueOf(dialog1));
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
                break;
            default:
                ui.Msg("The cute mouse at the end of the bar  - does not exist");
        }


    }

    public void swTavernFight(Player player) {
        Combat combat = new Combat(bag, inventory);
        DBConnector dbConnector = new DBConnector();
        for (int i = 95; i <= 97; i++) {
            Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog1));
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
        combat.fight(player, dbConnector.getCreatureById(21), bag); //todo Ændre creature til Snifflesworth

        Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 98, player);
        ui.Msg(String.valueOf(dialog1));
        System.out.println("Press enter to continue...");
        input.nextLine();
        cheeseCity(player);
    }


    public void fwBarracks(Player player) {
        //todo: tjek efter quest items
        // hvis ingen Quest items - så intro snak
        // hvis type af Quest Item så give Quest til næste quest Item

        // if (player.QuestItem == OK)
            ArrayList<String> optionsQ1 = new ArrayList<>();
            optionsQ1.add("I've completet the quest!");
            optionsQ1.add("Check the gear for sale.");
            ui.displayList(optionsQ1, "");
            int choiceQ1 = ui.promptNumericChoice(optionsQ1, "What do you say to Fuzzy Wumpus");
            switch (choiceQ1) {
                case 1:
                    for (int i = 108; i <= 109; i++) {
                        Dialog dialogQ1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                        ui.Msg(String.valueOf(dialogQ1));
                        System.out.println("Press enter to continue...");
                        input.nextLine();
                    }
                    break;
                case 2:
                    // todo indsæt shop
                    break;
                default:
                    ui.Msg("He lookes kinda cute though.");
        }

        //else if (player.QuestItem 2 == OK)
        ArrayList<String> optionsQ2 = new ArrayList<>();
        optionsQ2.add("I've completet the quest!");
        optionsQ2.add("Check the gear for sale.");
        ui.displayList(optionsQ2, "");
        int choiceQ2 = ui.promptNumericChoice(optionsQ2, "What do you say to Fuzzy Wumpus");
        switch (choiceQ2) {
            case 1:
                for (int i = 110; i <= 112; i++) {
                    Dialog dialogQ2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
                    ui.Msg(String.valueOf(dialogQ2));
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
                break;
            case 2:
                // todo indsæt shop
                break;
            default:
                ui.Msg("He lookes kinda cute though.");
        }


        //else if (player.QuestItem3 == OK)
        ArrayList<String> optionsQ3 = new ArrayList<>();
        optionsQ3.add("I've completet the quest!");
        optionsQ3.add("Check the gear for sale.");
        ui.displayList(optionsQ3, "");
        int choiceQ3 = ui.promptNumericChoice(optionsQ3, "What do you say to Fuzzy Wumpus");
        switch (choiceQ3) {
            case 1:
                Dialog dialogQ3 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 157, player);
                ui.Msg(String.valueOf(dialogQ3));
                System.out.println("Press enter to continue...");
                input.nextLine();

                break;
            case 2:
                // todo indsæt shop
                break;
            default:
                ui.Msg("He lookes kinda cute though.");
        }

        // else if(playerQuestItem4 == OK)
        ArrayList<String> optionsQ4 = new ArrayList<>();
        optionsQ4.add("I've completet the quest!");
        optionsQ4.add("Check the gear for sale.");
        ui.displayList(optionsQ4, "");
        int choiceQ4 = ui.promptNumericChoice(optionsQ4, "What do you say to Fuzzy Wumpus");
        switch (choiceQ4) {
            case 1:
                Dialog dialogQ4 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 157, player);
                ui.Msg(String.valueOf(dialogQ4));
                System.out.println("Press enter to continue...");
                input.nextLine();

        break;
        case 2:
        // todo indsæt shop
        break;
        default:
        ui.Msg("He lookes kinda cute though.");
    }

    // else

     Ascii asciiBarrack = Ascii.getAsciiById(208);
     ui.Msg(String.valueOf(asciiBarrack));
     ui.Msg("");

  Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 103, player);
  ui.Msg(String.valueOf(dialog1));
  System.out.println("Press enter to continue...");
  input.nextLine();

  ArrayList<String> optionsTwo = new ArrayList<>();
  optionsTwo.add("Tell Fuzzy Wumpus everything that happened.");
  optionsTwo.add("Check the gear for sale.");
     ui.displayList(optionsTwo, "");
  int choice1 = ui.promptNumericChoice(optionsTwo, "Fuzzy Wumpus: Aren’t you a little young to be in here?");
  switch (choice1) {
   case 1:
    for (int i = 106; i <= 107; i++) {
     Dialog dialog2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
     ui.Msg(String.valueOf(dialog2));
     System.out.println("Press enter to continue...");
     input.nextLine();
    }
    break;
   case 2:
    // todo indsæt shop
    break;
   default:
    ui.Msg("The cute mouse at the end of the bar  - does not exist");
  }
 }

 public void sewerGate(Player player) {
  //todo: lav en if statement til at tjekke efter QUEST item - eller fontina

     Ascii asciiSG = Ascii.getAsciiById(209);
     ui.Msg(String.valueOf(asciiSG));
     ui.Msg("");

  Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 150, player);
  ui.Msg(String.valueOf(dialog));
  System.out.println("Press enter to continue...");
  input.nextLine();
//todo If(player.getItemID == FW Potion
  ArrayList<String> optionsTwo = new ArrayList<>();
  optionsTwo.add("Throw Elexir on the gate");
  optionsTwo.add("Go back");
     ui.displayList(optionsTwo, "");
  int choice1 = ui.promptNumericChoice(optionsTwo, "What do you want to do");
  switch (choice1) {
   case 1:
    Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 125, player);
    ui.Msg(String.valueOf(dialog1));
    System.out.println("Press enter to continue...");
    input.nextLine();
    sewerEntrance(player);
    break;
   case 2:
    cheeseCity(player);
    break;
   default:
    ui.Msg("This is not the time to be a silly mouse.");
  } //else if (player.getItemID == Fontina){
  //ArrayList<String> optionsFontina = new ArrayList<>();
  //optionsFontina.add("Strike the gate with Fontina");
  //optionsFontina.add("Go back");
  //int choice2 = ui.promptNumericChoice(optionsFontina, "What do you want to do");
//  switch (choice2) {
//   case 1:
//    Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 126, player);
//    ui.Msg(String.valueOf(dialog1));
//    System.out.println("Press enter to continue...");
//    input.nextLine();
//    sewerEntrance(player);
//    break;
//   case 2:
//    cheeseCity(player);
//    break;
//   default:
//    ui.Msg("This is not the time to be a silly mouse.");
//  }
  // else{cheeseCity(player);}

 }

 public void wdShop(Player player) {

     Ascii asciiShop = Ascii.getAsciiById(216);
     ui.Msg(String.valueOf(asciiShop));
     ui.Msg("");

  Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 99, player);
  ui.Msg(String.valueOf(dialog1));
  System.out.println("Press enter to continue...");
  input.nextLine();
  //Todo: Indsæt Potion shop metode potentiel switch case
  Random random = new Random();
  int randomId = 99 + random.nextInt(4);
  Dialog dialog2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), randomId, player);
  ui.Msg(String.valueOf(dialog2));
  System.out.println("Press enter to continue...");
  input.nextLine();
  cheeseCity(player);
 }

 public void roadOut(Player player) {
  ArrayList<String> optionsTwo = new ArrayList<>();
  optionsTwo.add("Explore the forest");
  optionsTwo.add("Explore the dessert");
  optionsTwo.add("Explore the swamp");
     ui.displayList(optionsTwo, "");
  int choice2 = ui.promptNumericChoice(optionsTwo, "Where do you want to explore?");
  switch (choice2) {
   case 1:
    forrest(player);
    break;
   case 2:
    dessert(player);
    break;
   case 3:
    swamp(player);
   default:
    ui.Msg("This is not the time to be a coward.");
  }
 }

 public void forrest(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);
  Random random = new Random();
  DBConnector dbConnector = new DBConnector();
  Combat combat = new Combat(bag, inventory);

     Ascii asciiBarrack = Ascii.getAsciiById(210);
     ui.Msg(String.valueOf(asciiBarrack));
     ui.Msg("");

  Dialog dialogForest = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 151, player);
  ui.Msg(String.valueOf(dialogForest));
  System.out.println("Press enter to continue...");
  input.nextLine();
  ArrayList<String> optionsTwo = new ArrayList<>();
  optionsTwo.add("Explore the forest");
  optionsTwo.add("Return to Cheese City");
  optionsTwo.add("Check your inventory");
     ui.displayList(optionsTwo, "");
  int choice2 = ui.promptNumericChoice(optionsTwo, "What do you want to do?");
  switch (choice2) {
   case 1:
    int[] creatureID = {5, 9, 10, 11};
    int randomCreatureID = random.nextInt(creatureID.length);
    int forestCreatureID = creatureID[randomCreatureID];
    combat.fight(player, dbConnector.getCreatureById(forestCreatureID), bag);

    break;
   case 2:
    Dialog dialogReturn = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 154, player);
    ui.Msg(String.valueOf(dialogReturn));
    System.out.println("Press enter to continue...");
    input.nextLine();
    cheeseCity(player);
    break;
   case 3:
    //Check your gear
    break;
   default:
    ui.Msg("The forest is too dense - just like your brain.");
  }
 }

 public void dessert(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);
  Random random = new Random();
  Combat combat = new Combat(bag, inventory);
  DBConnector dbConnector = new DBConnector();

     Ascii asciiBarrack = Ascii.getAsciiById(213);
     ui.Msg(String.valueOf(asciiBarrack));
     ui.Msg("");

  Dialog dialogDesert = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 117, player);
  ui.Msg(String.valueOf(dialogDesert));
  System.out.println("Press enter to continue...");
  input.nextLine();
  ArrayList<String> optionsTwo = new ArrayList<>();
  optionsTwo.add("Explore the desert");
  optionsTwo.add("Return to Cheese City");
  optionsTwo.add("Check your inventory");
     ui.displayList(optionsTwo, "");
  int choice2 = ui.promptNumericChoice(optionsTwo, "What do you want to do?");
  switch (choice2) {
   case 1:
    int[] creatureID = {2, 7, 8, 13, 17};
    int randomCreatureID = random.nextInt(creatureID.length);
    int desertCreatureID = creatureID[randomCreatureID];
    combat.fight(player, dbConnector.getCreatureById(desertCreatureID), bag);
    break;
   case 2:
    Dialog dialogReturn = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 154, player);
    ui.Msg(String.valueOf(dialogReturn));
    System.out.println("Press enter to continue...");
    input.nextLine();
    cheeseCity(player);
    break;
   case 3:
    //Check your gear
    break;
   default:
    ui.Msg("If you do that, you might end up in quicksand");
  }
 }

 public void swamp(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);

     Ascii asciiBarrack = Ascii.getAsciiById(211);
     ui.Msg(String.valueOf(asciiBarrack));
     ui.Msg("");

  Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 118, player);
  ui.Msg(String.valueOf(dialog1));
  System.out.println("Press enter to continue...");
  input.nextLine();
  ArrayList<String> optionsTwo = new ArrayList<>();
  optionsTwo.add("Explore the swamp");
  optionsTwo.add("Return to Cheese City");
  optionsTwo.add("Check your inventory");
     ui.displayList(optionsTwo, "");
  int choice2 = ui.promptNumericChoice(optionsTwo, "What do you want to do?");
  switch (choice2) {
   case 1:
    swampExplore(player);
    break;
   case 2:
    Dialog dialogReturn = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 154, player);
    ui.Msg(String.valueOf(dialogReturn));
    System.out.println("Press enter to continue...");
    input.nextLine();
    cheeseCity(player);
    break;
   case 3:
    //Check inventory
    break;
   default:
    ui.Msg("The swamp gasses must have gotten to your mouse brain. You cant do that silly.");
  }
 }

 public void swampExplore(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);
  Random random = new Random();
  Combat combat = new Combat(bag, inventory);
  DBConnector dbConnector = new DBConnector();
  Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 152, player);
  ui.Msg(String.valueOf(dialog1));
  System.out.println("Press enter to continue...");
  input.nextLine();
  int chance = random.nextInt(100);
  int[] creatureID = {12, 4, 18};
  int randomCreatureID = random.nextInt(creatureID.length);
  int swampCreatureID = creatureID[randomCreatureID];
  if (chance < 70) {
   combat.fight(player, dbConnector.getCreatureById(swampCreatureID), bag);
  } else if (chance > 70 && chance < 80) {
   Dialog dialogTroll = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 153, player);
   ui.Msg(String.valueOf(dialogTroll));
   System.out.println("Press enter to continue...");
   input.nextLine();
   combat.fight(player, dbConnector.getCreatureById(3), bag);
  } else {
   ruins(player);
  }
 }

 public void ruins(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);
  Combat combat = new Combat(bag, inventory);
  DBConnector dbConnector = new DBConnector();

     Ascii asciiBarrack = Ascii.getAsciiById(212);
     ui.Msg(String.valueOf(asciiBarrack));
     ui.Msg("");

   Dialog dialogS = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 119, player);
   ui.Msg(String.valueOf(dialogS));
   System.out.println("Press enter to continue...");
   input.nextLine();

     Ascii asciiDragon = Ascii.getAsciiById(23);
     ui.Msg(String.valueOf(asciiDragon));
     ui.Msg("");

     Dialog dialogS2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 120, player);
     ui.Msg(String.valueOf(dialogS2));
     System.out.println("Press enter to continue...");
     input.nextLine();

  ArrayList<String> optionsDragon = new ArrayList<>();
  optionsDragon.add("Fight the Dragon");
  optionsDragon.add("Flee");
  int choice2 = ui.promptNumericChoice(optionsDragon, "What do you want to do?");
  switch (choice2) {
   case 1:
    Dialog dialogDragon1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 121, player);
    ui.Msg(String.valueOf(dialogDragon1));
    System.out.println("Press enter to continue...");
    input.nextLine();
    combat.fight(player, dbConnector.getCreatureById(23), bag);
    for (int i = 122; i <= 123; i++) {
     Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
     ui.Msg(String.valueOf(dialog1));
     System.out.println("Press enter to continue...");
     input.nextLine();
    }
    Dialog dialogReturn = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 154, player);
    ui.Msg(String.valueOf(dialogReturn));
    System.out.println("Press enter to continue...");
    input.nextLine();

       Ascii asciiFontina = Ascii.getAsciiById(23);
       ui.Msg(String.valueOf(asciiFontina));
       ui.Msg("");

    //todo Add Fontina
    cheeseCity(player);
    break;
   case 2:
    Dialog dialogFlee = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 155, player);
    ui.Msg(String.valueOf(dialogFlee));
    System.out.println("Press enter to continue...");
    input.nextLine();
    cheeseCity(player);
    break;
   default:
    ui.Msg("Ancient Dragon: Oh, brilliant. A true master of the art of aimless button pressing.\n Tell me, do you stumble through life with the same grace, or is this incompetence reserved for me?");
  }
 }

 public void sewerEntrance(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);

  for (int i = 127; i <= 128; i++) {
   Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
   ui.Msg(String.valueOf(dialog1));
   System.out.println("Press enter to continue...");
   input.nextLine();
  }
  ArrayList<String> optionsSewerOne = new ArrayList<>();
  optionsSewerOne.add("Enter the Rat Kings domain");
  optionsSewerOne.add("Return to Cheese City");
     ui.displayList(optionsSewerOne, "");
  int choice1 = ui.promptNumericChoice(optionsSewerOne, "What do you want to do?");
  switch (choice1) {
   case 1:
    sewerfights(player);
    break;
   case 2:
    cheeseCity(player);
    break;
   case 3:
    //todo Check inventory
    break;
   default:
    ui.Msg("Are you too scared to make the right decision? ");
  }
 }

 public void sewerfights(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);
  Combat combat = new Combat(bag, inventory);
  DBConnector dbConnector = new DBConnector();
  Random random = new Random();

     Ascii asciiSewer = Ascii.getAsciiById(214);
     ui.Msg(String.valueOf(asciiSewer));
     ui.Msg("");

  Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 129, player);
  ui.Msg(String.valueOf(dialog1));
  System.out.println("Press enter to continue...");
  input.nextLine();

  ArrayList<String> optionsSewerOne = new ArrayList<>();
  optionsSewerOne.add("Push further into the sewers");
  optionsSewerOne.add("Return to Cheese City");
  optionsSewerOne.add("Check your gear");
     ui.displayList(optionsSewerOne, "");
  int choice1 = ui.promptNumericChoice(optionsSewerOne, "What do you want to do?");
  switch (choice1) {
   case 1:
    for (int i = 129; i <= 131; i++) {
     Dialog dialogSewerFight = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
     ui.Msg(String.valueOf(dialogSewerFight));
     System.out.println("Press enter to continue...");
     input.nextLine();
     int[] creatureID = {1,4,6,14,19};
     int randomCreatureID = random.nextInt(creatureID.length);
     int sewerCreatureID = creatureID[randomCreatureID];
        Ascii asciiRC = Ascii.getAsciiById(randomCreatureID);
        ui.Msg(String.valueOf(asciiRC));
        ui.Msg("");

     combat.fight(player, dbConnector.getCreatureById(sewerCreatureID), bag);
    }
    ratKingCity(player);
    break;
   case 2:
    cheeseCity(player);
    break;
   case 3:
    // todo Check inventory
    break;
   default:
    ui.Msg("Are you too scared to make the right decision? ");
  }
 }

 public void ratKingCity(Player player) {
  TextUI ui = new TextUI();
  Scanner input = new Scanner(System.in);
  Combat combat = new Combat(bag, inventory);
  DBConnector dbConnector = new DBConnector();

     Ascii asciiDragon = Ascii.getAsciiById(215);
     ui.Msg(String.valueOf(asciiDragon));
     ui.Msg("");

  Dialog dialogRTCIntro = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 132, player);
  ui.Msg(String.valueOf(dialogRTCIntro));
  System.out.println("Press enter to continue...");
  input.nextLine();
  Dialog dialogRTCGate = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 156, player);
  ui.Msg(String.valueOf(dialogRTCGate));
  System.out.println("Press enter to continue...");
  input.nextLine();

     Ascii asciiRK = Ascii.getAsciiById(20);
     ui.Msg(String.valueOf(asciiRK));
     ui.Msg("");

  Dialog dialogRTCKing = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 133, player);
  ui.Msg(String.valueOf(dialogRTCKing));
  System.out.println("Press enter to continue...");
  input.nextLine();
  ArrayList<String> optionsSewerOne = new ArrayList<>();
  optionsSewerOne.add("Listen to what the Rat King has to say");
  optionsSewerOne.add("Interrupt the Rat King");
     ui.displayList(optionsSewerOne, "");
  int choice1 = ui.promptNumericChoice(optionsSewerOne, "What do you want to do?");
  switch (choice1) {
   case 1:
    for (int i = 134; i <= 137; i++) {
     Dialog dialogSewerFight = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
     ui.Msg(String.valueOf(dialogSewerFight));
     System.out.println("Press enter to continue...");
     input.nextLine();
     combat.fight(player, dbConnector.getCreatureById(20), bag);
    }
    break;
   case 2:
    Dialog dialogSewerFight = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 138, player);
    ui.Msg(String.valueOf(dialogSewerFight));
    System.out.println("Press enter to continue...");
    input.nextLine();
    combat.fight(player, dbConnector.getCreatureById(20), bag);
    break;
   default:
    ui.Msg("Are you too scared to make the right decision? ");
  }
  //Rat King Demon
  Dialog dialogRTD = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 139, player);
  ui.Msg(String.valueOf(dialogRTD));
  System.out.println("Press enter to continue...");
  input.nextLine();

     Ascii asciiRKD = Ascii.getAsciiById(23);
     ui.Msg(String.valueOf(asciiRKD));
     ui.Msg("");

  Dialog dialogRTD2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 141, player);
  ui.Msg(String.valueOf(dialogRTD2));
  System.out.println("Press enter to continue...");
  input.nextLine();
  combat.fight(player, dbConnector.getCreatureById(22), bag);
  Dialog dialogRTD3 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 147, player);
  ui.Msg(String.valueOf(dialogRTD3));
  System.out.println("Press enter to continue...");
  input.nextLine();
 }

}




