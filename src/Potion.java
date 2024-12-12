public class Potion {


    private String name;
    private int addAttack;
    private int addDefense;
    private int addHealth;
    private int addXP;
    private int addCurrency;



    public Potion(String name, int addAttack, int addDefense, int addHealth) {
        this.name = name;
        this.addAttack = addAttack;
        this.addDefense = addDefense;
        this.addHealth = addHealth;
    }




    public String getName() {
        return name;
    }

    public int getAddAttack() {
        return addAttack;
    }

    public int getAddDefense() {
        return addDefense;
    }

    public int getAddHealth() {
        return addHealth;
    }

    public int getAddXp() {
        return addXP;
    }

    public int getAddCurrency(){return addCurrency;}

}