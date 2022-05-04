package game.item;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.roles.Status;

/**
 * HighGround class is an abstract class that extend Ground
 * @author Junhao Li, Ashston Sequira
 * @version 1.0.0
 */
public class Wrench extends WeaponItem implements Purchasable{
    private int price = 200;
    /**
     * Constructor.
     */
    public Wrench() {
        super("Wrench", 'w', 50, "hits", 80);
        this.addCapability(Status.WRENCH);
    }

    /**
     * Overwrite the method from purchasable method
     * @return
     */
    @Override
    public int getPrice() {
        return this.price;
    }
}
