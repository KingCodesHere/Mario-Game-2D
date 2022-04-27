package game.item;

import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {
    private final int value;
    /***
     * Constructor.
     *  @param value the value of the coin
     */
    public Coin(int value) {
        super("Coin", '$', true);
        this.value = value;
    }
}
