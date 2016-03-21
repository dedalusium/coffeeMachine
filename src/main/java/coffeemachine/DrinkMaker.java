package coffeemachine;

import coffeemachine.exception.NotEnoughMoneyException;
import coffeemachine.exception.NotKnownDrinkException;
import coffeemachine.exception.TooManySugarException;

public class DrinkMaker {
    private CoffeeMachineOutput output;

    public void computeInput(String input) throws NotKnownDrinkException, NotEnoughMoneyException {
        String[] splitedInput = input.split(":");
        if (splitedInput.length == 2) {
            sendMessage(splitedInput[1]);
        } else {
            try {
                makeDrink(new CustomerDrinkOrder(Drink.valueOf(splitedInput[0]), Integer.valueOf(splitedInput[1]), Float.valueOf(splitedInput[2])));
            } catch (IllegalArgumentException e) {
                throw new NotKnownDrinkException();
            }
        }
    }

    public void makeDrink(CustomerDrinkOrder order) throws NotKnownDrinkException, NotEnoughMoneyException {
        Drink drink = order.getDrink();
        float money = order.getMoneyAmount();
        if (money < drink.getCost()) {
            throw new NotEnoughMoneyException(drink.getCost() - money);
        } else {
            this.output = new CoffeeMachineOutput(drink);
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
