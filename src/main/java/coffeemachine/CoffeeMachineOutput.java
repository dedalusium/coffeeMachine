package coffeemachine;

public class CoffeeMachineOutput {
    private Command command;
    private int sugarNumber;
    private float cost;
    private boolean hasStick;
    private String message;

    public CoffeeMachineOutput(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
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
