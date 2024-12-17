import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dialog {
    private int id;
    private String text;
    private String role;

    public Dialog(int id, String text, String role) {
        this.id = id;
        this.text = text;
        this.role = role;
    }

    public String formatText(Player player) {
        return text.replace("(PLAYER NAME)", player.getName());
    }
    @Override
    public String toString() {
        return role + ": " + text;
    }

    public static List<Dialog> loadDialog(String filePath) {
        List<Dialog> dialogList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String text = parts[1];
                    String role = parts[2];
                    dialogList.add(new Dialog(id, text, role));
                }
            }
        } catch (IOException e) {
            System.err.println("Fejl ved læsning af filen: " + e.getMessage());
        }
        return dialogList;
    }


    // Metode til at hente en specifik dialog baseret på ID
    public static Dialog getDialogById(List<Dialog> dialogList, int id, Player player) {
        for (Dialog dialog : dialogList) {
            if (dialog.id == id) {
                dialog.text = dialog.formatText(player);
                return dialog;
            }
        }
        return null;
    }

}
