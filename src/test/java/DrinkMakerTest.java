import coffeemachine.Command;
import coffeemachine.CustomerDrinkOrder;
import coffeemachine.DrinkMaker;
import coffeemachine.exception.NotEnoughMoneyException;
import coffeemachine.exception.NotKnownDrinkException;
import coffeemachine.exception.TooManySugarException;
import org.junit.Assert;
import org.junit.Test;

public class DrinkMakerTest {

    private static DrinkMaker drinkMaker;

    @Test
    public void testMakeCoffee() throws NotKnownDrinkException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        CustomerDrinkOrder order = new CustomerDrinkOrder(Command.COFFEE, 0, 0);
        drinkMaker.makeDrink(order.getCommand(), order.getMoneyAmount());
        Assert.assertTrue(Command.COFFEE.equals(drinkMaker.getOutput().getCommand()));
        Assert.assertFalse(drinkMaker.getOutput().isHasStick());
    }

    @Test
    public void testMakeTea() throws NotKnownDrinkException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        CustomerDrinkOrder order = new CustomerDrinkOrder(Command.TEA, 0, 0);
        drinkMaker.makeDrink(order.getCommand(), order.getMoneyAmount());
        Assert.assertTrue(Command.TEA.equals(drinkMaker.getOutput().getCommand()));
        Assert.assertFalse(drinkMaker.getOutput().isHasStick());
    }

    @Test
    public void testMakeHotChocolate() throws NotKnownDrinkException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        CustomerDrinkOrder order = new CustomerDrinkOrder(Command.HOT_CHOCOLATE, 0, 0);
        drinkMaker.makeDrink(order.getCommand(), order.getMoneyAmount());
        Assert.assertTrue(Command.HOT_CHOCOLATE.equals(drinkMaker.getOutput().getCommand()));
        Assert.assertFalse(drinkMaker.getOutput().isHasStick());
    }

    @Test(expected = NotKnownDrinkException.class)
    public void testMakeUnknownDrink() throws NotKnownDrinkException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        CustomerDrinkOrder order = new CustomerDrinkOrder(Command.MESSAGE, 0, 0);
        drinkMaker.makeDrink(order.getCommand(), order.getMoneyAmount());
        Assert.fail();
    }

    @Test
    public void testAddOneSugarAndStick() throws NotKnownDrinkException, TooManySugarException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        CustomerDrinkOrder order = new CustomerDrinkOrder(Command.COFFEE, 0, 0);
        drinkMaker.makeDrink(order.getCommand(), order.getMoneyAmount());
        drinkMaker.addSugar(1);
        Assert.assertTrue(drinkMaker.getOutput().isHasStick());
    }

    @Test
    public void testAddTwoSugarAndStick() throws NotKnownDrinkException, TooManySugarException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        CustomerDrinkOrder order = new CustomerDrinkOrder(Command.COFFEE, 0, 0);
        drinkMaker.makeDrink(order.getCommand(), order.getMoneyAmount());
        drinkMaker.addSugar(2);
        Assert.assertTrue(drinkMaker.getOutput().isHasStick());
    }

    @Test(expected = TooManySugarException.class)
    public void testAddTenSugarAndStick() throws NotKnownDrinkException, TooManySugarException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        CustomerDrinkOrder order = new CustomerDrinkOrder(Command.COFFEE, 0, 0);
        drinkMaker.makeDrink(order.getCommand(), order.getMoneyAmount());
        drinkMaker.addSugar(10);
        Assert.assertTrue(drinkMaker.getOutput().isHasStick());
    }
}