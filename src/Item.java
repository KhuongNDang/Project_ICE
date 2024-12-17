import java.sql.Connection;


public class Item {
        private int id;
        private String name;
        private int attack;
        private int defense;
        private int health;
        private String slot;
        private Connection conn;
        private int currency;

        public Item(int id, String name, int attack, int defense, int health, String slot, int currency) {
            this.id = id;
            this.name = name;
            this.slot = slot;
            this.attack = attack;
            this.defense = defense;
            this.health = health;
            this.currency = currency;
            this.conn = conn;

        }

        public Item(String name, int price) {
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

        public int getCurrency() {return currency;}
    }




