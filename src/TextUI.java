import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
private Scanner scan = new Scanner(System.in);
    public TextUI() {
        this.scan = new Scanner(System.in);
    }

    public void Msg(String msg) {
        System.out.println(msg);
    }

    public int promptNumeric(String msg) {
        System.out.println(msg);
        String input = this.scan.nextLine();

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            this.Msg("Please type a number");
            number = this.promptNumeric(msg);
        }

        return number;
    }

    public String promptText(String msg) {
        System.out.println(msg);
        return this.scan.nextLine();
    }

    public int promptNumericChoice(ArrayList<String> options, String msg) {
        System.out.println(); //h
        int choice = this.promptNumeric("Choose an option (1-" + options.size() + "):");
        System.out.println();
        if (choice >= 1 && choice <= options.size()) {
            return choice;
        } else {
            this.Msg("Invalid choice. Please try again.");
            return this.promptNumericChoice(options, msg);
        }
    }

    public void displayList(ArrayList<String> options, String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
        int i = 1;

        for(String option : options) {
            Msg(i + ":" + option);
            i++;
        }

    }

}
