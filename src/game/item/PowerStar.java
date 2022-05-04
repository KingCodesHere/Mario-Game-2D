package game.item;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ConsumeItemAction;
import game.roles.Status;

/**
 * Power star one of the item
 * @author Junhao Li, Ashston Sequira
 * @version 1.0.0
 */
public class PowerStar extends MagicalItem {
    private int count = 0;
    private int price = 600;
    private int lifetime = 1;
    private boolean renewTime = true;
    Display display = new Display();
    /***
     * Constructor.
     */
    public PowerStar() {
        super("Power Star", '*', false);

    }

    /**
     * Call the consumeItemAction
     * @return the consumeItemAction
     */
    public ConsumeItemAction consumeItem(){

        return new ConsumeItemAction(this);
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
            actor.removeCapability(Status.INVINCIBLE);
            super.setResetTime(0);
        }
        if(lifetime != 1 && renewTime == true ){
            this.count = 0;
        }

        display.println("Mario consumes Power Star - " +(10-this.count)+ " turns remaining");
        if (this.count == 10) {
            actor.removeCapability(Status.INVINCIBLE);
        }
        this.count += 1;
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */

    @Override
    public void tick(Location currentLocation){
        if(super.isCheckStatus() && super.getResetTime()==1){
            currentLocation.removeItem(this);
            super.setResetTime(0);
        }
        this.count +=1;
        display.println("Power Star - " +(10-this.count)+ " turns remaining");
        if(this.count == 10) {
            currentLocation.removeItem(this);
        }
    }

    /**
     * Overwrite the method from consumable interface
     * @param actor
     */
    @Override
    public void itemFunction(Actor actor) {
        actor.heal(200);
        actor.addCapability(Status.INVINCIBLE);
        display.println(actor +" becomes invincible" ); // printout the actor status
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