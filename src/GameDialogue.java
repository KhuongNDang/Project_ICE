import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameDialogue {
       TextUI ui = new TextUI();
       Scanner input = new Scanner(System.in);

       public void storyPart1(Player player) {

        for (int i = 1; i <= 6; i++) {
         Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
         ui.Msg(String.valueOf(dialog));
         System.out.println("Press enter to continue...");
         input.nextLine();
        }
       }

        public void storyPart2(Player player){

         for (int i = 7; i <= 13; i++) {
          Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
          ui.Msg(String.valueOf(dialog));
          System.out.println("Press enter to continue...");
          input.nextLine();
         }
         ArrayList<String> options = new ArrayList<>();
         options.add("Yes - I'll go to the market");
         options.add("No - Do it yourself, oldie!");
         int choice = ui.promptNumericChoice(options, "what`s your next Move?");
         switch (choice) {
          case 1:
           for (int i = 14; i <= 17; i++) {
            Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
            ui.Msg(String.valueOf(dialog));
            System.out.println("Press enter to continue...");
            input.nextLine();
           }
           break;
          case 2:
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
         }

        }

        public void storyPart3(Player player){}


  /*
        Dialog dialog1 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 1, player);
        ui.Msg(String.valueOf(dialog1));
        System.out.println("Press enter");
        input.nextLine();
        Dialog dialog2 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 2, player);
        ui.Msg(String.valueOf(dialog2));
        System.out.println("Press enter");
        input.nextLine();
        Dialog dialog3 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 3, player);
        ui.Msg(String.valueOf(dialog3));
        System.out.println("Press enter");
        input.nextLine();
        Dialog dialog4 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 4, player);
        ui.Msg(String.valueOf(dialog4));
        System.out.println("Press enter");
        input.nextLine();
        Dialog dialog5 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 5, player);
        ui.Msg(String.valueOf(dialog5));
        System.out.println("Press enter");
        input.nextLine();
        Dialog dialog6 = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), 6, player);
        ui.Msg(String.valueOf(dialog6));
*/
        }


