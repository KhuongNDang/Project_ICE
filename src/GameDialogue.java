import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameDialogue {

       public void storyPart1(Player player) {
        TextUI ui = new TextUI();
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 6; i++) {
         Dialog dialog = Dialog.getDialogById(Dialog.loadDialog("files/Dialog.txt"), i, player);
         ui.Msg(String.valueOf(dialog));
         System.out.println("Press enter to continue...");
         input.nextLine(); // Vent på brugerens input for at fortsætte til næste dialog
        }

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
        public void storyPart2(){
        }
        public void storyPart3(){
        }

}
