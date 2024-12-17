import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




    public class Item {
        private int id;
        private String name;
        private int attack;
        private int defense;
        private int health;
        private String slot;
        private Connection conn;


        public Item(int id, String name, int attack, int defense, int health, String slot) {
            this.id = id;
            this.name = name;
            this.slot = slot;
            this.attack = attack;
            this.defense = defense;
            this.health = health;

        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
        public int getAttack(){
            return attack;
        }

        public int getDefense() {
            return defense;
        }

        public int getHealth() {
            return health;
        }

        public String getSlot() {
            return slot;
        }
    }





