//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("David", 10,100,30, 10);

        Creature creature1 = new Creature("Ayman", 20, 10,10,100);

        Combat combat = new Combat();
        combat.fight(player1, creature1);


    }
}