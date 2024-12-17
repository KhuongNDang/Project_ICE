
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





    public boolean addItemFromDB(int itemId) {
        if (getBagSize() >= MAX_CAPACITY) {
            System.out.println("The bag is full. Cannot add item with ID " + itemId);
            return false;
        }

        Item item = dbConnector.getItemById(itemId);
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

        Potion potion = dbConnector.getPotionById(potionId);
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
        while (true) {
            ArrayList<String> itemNames = new ArrayList<>();

            // Step 1: Populate itemNames with all items (potions and items) from the bag
            for (Object obj : bag) {
                if (obj instanceof Item) {
                    Item item = (Item) obj;
                    itemNames.add(item.getName());
                } else if (obj instanceof Potion) {
                    Potion potion = (Potion) obj;
                    itemNames.add(potion.getName());
                }
            }

            // Step 2: Add "Exit" option at the end of the list
            itemNames.add("Exit");

            // Step 3: Display the bag's contents and allow player to select an item to use
            textUI.displayList(itemNames, "Select an item to use:");
            int selectedItemIndex = textUI.promptNumericChoice(itemNames, "Select an item to use:");

            // Step 4: Handle "Exit" selection
            if (selectedItemIndex == itemNames.size()) {
                textUI.Msg("Exiting the bag.");
                System.out.println();
                System.out.println();
                return;
            }

            // Step 5: Get the selected item from the bag (adjust for 0-based index)
            Object selectedObj = bag.get(selectedItemIndex - 1);

            // Step 6: Handle Item selection
            if (selectedObj instanceof Item) {
                Item selectedItem = (Item) selectedObj;
                boolean itemEquipped = false;

                for (String slot : inventory.getSlots()) {
                    if (selectedItem.getSlot().equals(slot)) {
                        Item itemInSlot = inventory.getItemFromSlot(slot);
                        if (itemInSlot != null) {
                            // Remove previous item's stats from player
                            updatePlayerStatsOnRemove(itemInSlot);
                            inventory.removeItemFromSlot(slot);
                            addItemToBag(itemInSlot);
                            System.out.println("Item: " + itemInSlot.getName() + " removed from inventory and added back to bag.");
                        }

                        // Equip the new item and update player stats
                        inventory.setItemInSlot(slot, selectedItem);
                        updatePlayerStatsOnEquip(selectedItem);
                        removeItemById(selectedItem.getId());
                        System.out.println("Item: " + selectedItem.getName() + " has been equipped to your inventory.");
                        System.out.println();
                        inventory.displayInventory();
                        System.out.println();
                        player.displayStats();
                        System.out.println();
                        System.out.println();
                        itemEquipped = true;
                        break;
                    }
                }

                if (!itemEquipped) {
                    textUI.Msg("No matching slot found for item: " + selectedItem.getName() + ". Item remains in bag.");
                }
            }
            // Step 7: Handle Potion selection
            else if (selectedObj instanceof Potion) {
                Potion selectedPotion = (Potion) selectedObj;

                // Apply potion effects directly to player stats
                player.setAttack(player.getAttack() + selectedPotion.getAddAttack());
                player.setDefense(player.getDefense() + selectedPotion.getAddDefense());
                player.setHealth(player.getHealth() + selectedPotion.getAddHealth());

                removeItemById(selectedPotion.getId());
                System.out.println();
                player.displayStats();
                System.out.println();
            }
            // Step 8: Handle unknown objects
            else {
                textUI.Msg("Unrecognized item. Unable to use it.");
            }
        }
    }



    public boolean addItemToBag(Item item) {

        if (bag.size() >= MAX_CAPACITY) {
            System.out.println("The bag is full. Cannot add item: " + item.getName());
            return false;
        }


        bag.add(item);
        System.out.println("Item: " + item.getName() + " added back to the bag.");
        return true;
    }


    public void removeItemById(int itemId) {
        for (Object obj : bag) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                if (item.getId() == itemId) {
                    System.out.println("Item: " + item.getName() + " removed from the bag.");
                    bag.remove(obj);
                    break;
                }
            } else if (obj instanceof Potion) {
                Potion potion = (Potion) obj;
                if (potion.getId() == itemId) {
                    System.out.println("Potion: " + potion.getName() + " removed from the bag.");
                    bag.remove(obj);
                    break;
                }
            }
        }
    }


    public int getBagSize() {
        return bag.size();
    }

    private void updatePlayerStatsOnRemove(Item item) {
        player.setAttack(player.getAttack() - item.getAttack());
        player.setDefense(player.getDefense() - item.getDefense());
        player.setHealth(player.getHealth() - item.getHealth());
        System.out.println("Removed stats from " + item.getName() + ":");
        System.out.println("- Attack: -" + item.getAttack());
        System.out.println("- Defense: -" + item.getDefense());
        System.out.println("- Health: -" + item.getHealth());
    }

    private void updatePlayerStatsOnEquip(Item item) {
        player.setAttack(player.getAttack() + item.getAttack());
        player.setDefense(player.getDefense() + item.getDefense());
        player.setHealth(player.getHealth() + item.getHealth());
        System.out.println("Added stats from " + item.getName() + ":");
        System.out.println("+ Attack: +" + item.getAttack());
        System.out.println("+ Defense: +" + item.getDefense());
        System.out.println("+ Health: +" + item.getHealth());
    }


}
