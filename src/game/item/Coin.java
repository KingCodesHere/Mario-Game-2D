package game.item;
import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {

    public Coin(String name, char displayChar, boolean portable) {
        super("Coin", '$', true);
    }
}