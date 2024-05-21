package gamelogic.nations;

public final class NotEnoughResourcesException extends Exception {
    public NotEnoughResourcesException(int amount, String type) {
        super(amount + " " + type + " missing!");
    }
}
