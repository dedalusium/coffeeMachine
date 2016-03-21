package coffeemachine;

import coffeemachine.exception.NotEnoughMoneyException;
import coffeemachine.exception.NotKnownDrinkException;
import coffeemachine.exception.TooManySugarException;

import java.util.ArrayList;
import java.util.List;

public class DrinkMaker {
    private CoffeeMachineOutput output;
    private List<Command> knownDrinks;

    public DrinkMaker() {
        knownDrinks = new ArrayList<>(3);
        knownDrinks.add(Command.COFFEE);
        knownDrinks.add(Command.TEA);
        knownDrinks.add(Command.HOT_CHOCOLATE);
    }

    public void makeDrink(Command command, float inputMoneyAmout) throws NotKnownDrinkException, NotEnoughMoneyException {
        if (!knownDrinks.contains(command)) {
            throw new NotKnownDrinkException();
        } else if(inputMoneyAmout < command.getCost()){
            throw new NotEnoughMoneyException(command.getCost() - inputMoneyAmout);
        }
        else {
            this.output = new CoffeeMachineOutput(command);
        }
    }

    public void sendMessage(String message) {
        this.output.setMessage(message);
    }

    public void addSugar(int sugarNumber) throws TooManySugarException {
        if (sugarNumber > Constants.MIN_SUGAR && sugarNumber <= Constants.MAX_SUGAR) {
            this.output.setSugarNumber(sugarNumber);
            this.addStick();
        } else {
            throw new TooManySugarException();
        }
    }

    private void addStick() {
        this.output.setHasStick(true);
    }

    public CoffeeMachineOutput getOutput() {
        return output;
    }
}
