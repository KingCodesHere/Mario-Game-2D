package game.item;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.roles.Status;

/**
 * SuperMushroom item that extends the item class
 * @author Junhao Li, Ashston Sequira
 * @version 1.0.0
 */
public class SuperMushroom extends MagicalItem {
    /**
     * price of the item
     */
    private int price = 400;

    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);

    }


    /**
     * This item's function
     * @param actor
     */
    @Override
    public void itemFunction(Actor actor){
        actor.increaseMaxHp(50);
        actor.addCapability(Status.TALL); // the capability of the actor

    }

    /**
     * Overwrite the method from purchasable method
     * @return
     */
    @Override
    public int getPrice() {
        return this.price;
    }


    @Override
    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor) {
        if(super.isCheckStatus() && super.getResetTime()==1){
            actor.removeItemFromInventory(this);
            actor.removeCapability(Status.TALL);
            super.setResetTime(0);
        }
    }
}
