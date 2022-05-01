package game.item;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.roles.Status;

public class Wrench extends WeaponItem implements Purchasable{
    private int price = 200;
    /**
     * Constructor.
     */
    public Wrench() {
        super("Wrench", 'w', 50, "hits", 80);
        this.addCapability(Status.WRENCH);
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
