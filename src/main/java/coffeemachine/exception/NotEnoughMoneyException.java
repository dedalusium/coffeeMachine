package coffeemachine.exception;

public class NotEnoughMoneyException extends Exception {
    public final static String NOT_ENOUGH_MONEY = "Il manque AMOUNT euros";

    public NotEnoughMoneyException(float differential) {
        super(NOT_ENOUGH_MONEY.replaceFirst("AMOUNT", String.format("%.2f", differential)));
    }
}
