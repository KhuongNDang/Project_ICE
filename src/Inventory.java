import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Item> slots;


    public Inventory() {
        this.slots = new HashMap<>();
        slots.put("Head", null);
        slots.put("Top", null);
        slots.put("Bottom", null);
        slots.put("Weapon", null);
        slots.put("Shield", null);
    }


    public Item getItemFromSlot(String slot) {
        return slots.get(slot);
    }


    public void setItemInSlot(String slot, Item item) {
        slots.put(slot, item);
    }


    public void removeItemFromSlot(String slot) {
        slots.put(slot, null);
    }


    public void displayInventory() {
        System.out.println("Inventory Slots:");

        for (Map.Entry<String, Item> entry : slots.entrySet()) {
            String slot = entry.getKey();
            Item item = entry.getValue();

            if (item != null) {
                System.out.println(
                     slot + ": " + item.getName() + ", Attack: " + item.getAttack() + ", Defense: " + item.getDefense() + ", Health: " + item.getHealth()
                );
            } else {
                System.out.println(slot + ": Empty");
            }
        }
    }


    public String[] getSlots() {
        return new String[] { "Head", "Top", "Bottom", "Weapon", "Shield" };
    }
}
