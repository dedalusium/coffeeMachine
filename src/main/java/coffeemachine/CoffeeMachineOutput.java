package coffeemachine;

public class CoffeeMachineOutput {
    private Drink drink;
    private int sugarNumber;
    private float cost;
    private boolean hasStick;
    private String message;

    public CoffeeMachineOutput(Drink drink) {
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public float getCost() {
        return cost;
    }

    public boolean isHasStick() {
        return hasStick;
    }

    public String getMessage() {
        return message;
    }

    public void setSugarNumber(int sugarNumber) {
        this.sugarNumber = sugarNumber;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setHasStick(boolean hasStick) {
        this.hasStick = hasStick;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
