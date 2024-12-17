import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //Todo: tilføj stien til din .db fil
        String url = "jdbc:sqlite:creature.db";
        Ascii.initialize(url);

        Ascii creature = Ascii.getAsciiById(1);
        if (creature != null) {
            System.out.println(creature);
        }

        Ascii gear = Ascii.getAsciiById(101);
        if (gear != null) {
            System.out.println(gear);
        }





        }
    }



