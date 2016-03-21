package coffeemachine;

public class CustomerDrinkOrder {
    private Command command;
    private int sugarNumber;
    private float moneyAmount;

    public CustomerDrinkOrder(Command command, int sugarNumber, float moneyAmount) {
        this.command = command;
        this.sugarNumber = sugarNumber;
        this.moneyAmount = moneyAmount;
    }

    public Command getCommand() {
        return command;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public float getMoneyAmount() {
        return moneyAmount;
    }
}
