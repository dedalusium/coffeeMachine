import coffeemachine.Drink;
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
        drinkMaker.computeInput("C:0:0.6");
        Assert.assertTrue(Drink.C.equals(drinkMaker.getOutput().getDrink()));
        Assert.assertFalse(drinkMaker.getOutput().isHasStick());
    }

    @Test
    public void testMakeTea() throws NotKnownDrinkException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        drinkMaker.computeInput("T:0:0.4");
        Assert.assertTrue(Drink.T.equals(drinkMaker.getOutput().getDrink()));
        Assert.assertFalse(drinkMaker.getOutput().isHasStick());
    }

    @Test
    public void testMakeHotChocolate() throws NotKnownDrinkException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        drinkMaker.computeInput("H:0:0.5");
        Assert.assertTrue(Drink.H.equals(drinkMaker.getOutput().getDrink()));
        Assert.assertFalse(drinkMaker.getOutput().isHasStick());
    }

    @Test(expected = NotKnownDrinkException.class)
    public void testMakeUnknownDrink() throws NotKnownDrinkException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        drinkMaker.computeInput("A:0:0.5");
        Assert.fail();
    }

    @Test
    public void testAddOneSugarAndStick() throws NotKnownDrinkException, TooManySugarException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        drinkMaker.computeInput("C:0:0.6");
        drinkMaker.addSugar(1);
        Assert.assertTrue(drinkMaker.getOutput().isHasStick());
    }

    @Test
    public void testAddTwoSugarAndStick() throws NotKnownDrinkException, TooManySugarException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        drinkMaker.computeInput("C:0:0.6");
        drinkMaker.addSugar(2);
        Assert.assertTrue(drinkMaker.getOutput().isHasStick());
    }

    @Test(expected = TooManySugarException.class)
    public void testAddTenSugarAndStick() throws NotKnownDrinkException, TooManySugarException, NotEnoughMoneyException {
        drinkMaker = new DrinkMaker();
        drinkMaker.computeInput("C:0:0.6");
        drinkMaker.addSugar(10);
        Assert.assertTrue(drinkMaker.getOutput().isHasStick());
    }

    @Test
    public void testWrongAmountOfMoney() throws NotKnownDrinkException, TooManySugarException {
        drinkMaker = new DrinkMaker();
        try {
            drinkMaker.computeInput("C:0:0.2");
            Assert.fail();
        } catch (NotEnoughMoneyException e) {
            String expected = "Il manque 0,40 euros";
            Assert.assertTrue(expected.equals(e.getMessage()));
        }
    }
}