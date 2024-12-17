import java.util.HashMap;
import java.util.Map;

public class Ascii {

    private int id;
    private String name;
    private String picture;

    private static final Map<Integer, Ascii> creatures = new HashMap<>();
    private static final Map<Integer, Ascii> gear = new HashMap<>();
    private static final Map<Integer, Ascii> location = new HashMap<>();


    public Ascii( String picture) {

        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return  picture;
    }

    public static Ascii getAsciiById(int id) {
        if (creatures.isEmpty() || gear.isEmpty() || location.isEmpty()) {
            System.err.println("Error: Ascii data has not been initialized. Call Ascii.initialize(url) first.");
            return null;
        }

        if (id <= 24) { // Creature IDs
            return creatures.get(id);
        } else if (id >= 101 && id <= 122) { // Gear IDs
            return gear.get(id);
        } else if (id >= 201 && id <= 217) {
            return location.get(id);
        } else {
            System.err.println("Invalid ID: " + id);
            return null;
        }
    }

    public static void initialize(String url) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect(url);

        for (int i = 1; i <= 24; i++) {
            Ascii ascii = dbConnector.getCreatureAsciiById(i);
            if (ascii != null) {
                creatures.put(i, ascii);
            }
        }
        for (int i = 1; i <= 22; i++) {
            Ascii ascii = dbConnector.getAsciiGearById(i);
            if (ascii != null) {
                gear.put(i + 100, ascii);
            }
        }
        for (int i = 1; i <= 17; i++) {
            Ascii ascii = dbConnector.getAsciiLocationById(i);
            if (ascii != null) {
                location.put(i + 200, ascii);
            }
        }





    }
}

