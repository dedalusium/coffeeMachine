package coffeemachine;

public class CustomerDrinkOrder {
    private Drink drink;
    private int sugarNumber;
    private float moneyAmount;

    public CustomerDrinkOrder(Drink drink, int sugarNumber, float moneyAmount) {
        this.drink = drink;
        this.sugarNumber = sugarNumber;
        this.moneyAmount = moneyAmount;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public float getMoneyAmount() {
        return moneyAmount;
    }
}
