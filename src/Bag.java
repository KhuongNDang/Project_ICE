
import java.util.ArrayList;
import java.util.List;


public class Bag {
    private List<Object> bag;
    private static final int MAX_CAPACITY = 10;
    private DBConnector dbConnector;
    private Inventory inventory;
    private TextUI textUI;
    private Player player;


    public Bag(DBConnector dbConnector, Inventory inventory, TextUI textUI, Player player) {
        this.dbConnector = dbConnector;
        this.bag = new ArrayList<>();
        this.inventory = inventory;
        this.textUI = textUI;
        this.player = player;
    }

    public int getBagSize() {
        return bag.size();
    }



    public boolean addItemFromDB(int itemId) {
        if (getBagSize() >= MAX_CAPACITY) {
            System.out.println("The bag is full. Cannot add item with ID " + itemId);
            return false;
        }

        Item item = dbConnector.getItemById(itemId); // Returns a BagItem
        if (item == null) {
            System.out.println("Item with ID " + itemId + " does not exist in the database.");
            return false;
        }

        bag.add(item);
        System.out.println("Item " + item.getName() + " added to the bag.");
        return true;
    }

    public boolean addPotionFromDB(int potionId) {
        if (getBagSize() >= MAX_CAPACITY) {
            System.out.println("The bag is full. Cannot add potion with ID " + potionId);
            return false;
        }

        Potion potion = dbConnector.getPotionById(potionId); // Returns a BagItem
        if (potion == null) {
            System.out.println("Potion with ID " + potionId + " does not exist in the database.");
            return false;
        }

        bag.add(potion);
        System.out.println("Potion " + potion.getName() + " added to the bag.");
        return true;
    }



    public void displayBag() {
        System.out.println("Items in your bag:");
        System.out.println();

        if (bag.isEmpty()) {
            System.out.println("Your bag is empty.");
            return;
        }

        int index = 1;
        for (Object item : bag) {
            System.out.print(index + ": ");


            if (item instanceof Item) {
                Item i = (Item) item;
                System.out.println(
                        i.getName() + ": Attack: " + i.getAttack() +
                                ": Defense: " + i.getDefense() +
                                ": Health: " + i.getHealth() +
                                ": Slot: " + i.getSlot()
                );
            } else if (item instanceof Potion) {
                Potion p = (Potion) item;
                System.out.println(
                        p.getName() + ": Attack: " + p.getAddAttack() +
                                ": Defense: " + p.getAddDefense() +
                                ": Health: " + p.getAddHealth() +
                                ": Slot: potion"
                );
            }
            index++;
        }
    }



    public void useBag() {
        ArrayList<String> itemNames = new ArrayList<>();
        for (Object obj : bag) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                itemNames.add(item.getName());
            } else if (obj instanceof Potion) {
                Potion potion = (Potion) obj;
                itemNames.add(potion.getName());
            }
        }


        textUI.displayList(itemNames, "Select an item to transfer to your inventory:");
        int selectedItemIndex = textUI.promptNumericChoice(itemNames, "Select an item to transfer to your inventory");


        Object selectedObj = bag.get(selectedItemIndex - 1);

        for (String slot : inventory.getSlots()) {
            if (selectedObj instanceof Item) {
                Item selectedItem = (Item) selectedObj;

                if (selectedItem.getSlot().equals(slot)) {

                    Item itemInSlot = inventory.getItemFromSlot(slot);
                    if (itemInSlot == null) {

                        inventory.setItemInSlot(slot, selectedItem);
                        removeItemById(selectedItem.getId());
                        textUI.Msg("Item " + selectedItem.getName() + " transferred to " + slot + " slot in inventory.");
                        return;
                    } else {

                        textUI.Msg("The " + slot + " slot is already occupied by " + itemInSlot.getName() + ". Replacing it.");
                        inventory.removeItemFromSlot(slot);
                        addItemToBag(itemInSlot);
                        inventory.setItemInSlot(slot, selectedItem);
                        removeItemById(selectedItem.getId());
                        textUI.Msg("Item " + selectedItem.getName() + " transferred to " + slot + " slot in inventory.");
                        return;
                    }
                }
            } else if (selectedObj instanceof Potion) {  // If it's a Potion
                Potion selectedPotion = (Potion) selectedObj;

                // Step 5: Add the potion's stats to the player's attributes
                player.setHealth(player.getHealth() + selectedPotion.getAddHealth());
                player.setAttack(player.getAttack() + selectedPotion.getAddAttack());
                player.setDefense(player.getDefense() + selectedPotion.getAddDefense());


                removeItemById(selectedPotion.getId());

                textUI.Msg("Potion " + selectedPotion.getName() + " used. Stats added to player.");
                return;
            }
        }

        // If no slot matched the item's slot type (shouldn't happen if slots are correctly defined)
        textUI.Msg("No matching slot found for item.");
    }



    public boolean addItemToBag(Item item) {

        if (bag.size() >= MAX_CAPACITY) {
            System.out.println("The bag is full. Cannot add item: " + item.getName());
            return false;
        }


        bag.add(item);
        System.out.println("Item " + item.getName() + " added back to the bag.");
        return true;
    }


    public void removeItemById(int itemId) {
        for (Object obj : bag) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                if (item.getId() == itemId) {
                    bag.remove(obj);
                    System.out.println("Item with ID " + itemId + " removed from the bag.");
                    break;
                }
            } else if (obj instanceof Potion) {
                Potion potion = (Potion) obj;
                if (potion.getId() == itemId) {
                    bag.remove(obj);
                    System.out.println("Potion with ID " + itemId + " removed from the bag.");
                    break;
                }
            }
        }
    }
}
