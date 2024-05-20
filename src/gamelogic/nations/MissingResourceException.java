package gamelogic.nations;

public final class MissingResourceException extends Exception {
    public MissingResourceException(int amount, String type) {
        super(amount + " " + type + " missing!");
    }
}
