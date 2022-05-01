package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ConsumeItemAction;
import game.roles.Status;

import java.util.List;


public class PowerStar extends Item implements Consumable, Purchasable {
    private int count = 0;
    private int price = 600;
    private int lifetime = 1;
    Display display = new Display();
    /***
     * Constructor.
     */
    public PowerStar() {
        super("Power Star", 'p', false);

    }

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
        this.count += 1;
        display.println("Mario consumes Power Star - " +(10-this.count)+ "turns remaining");
        if (this.count == 10) {
            actor.removeCapability(Status.INVINCIBLE);
            actor.removeItemFromInventory(this);
        }

    }
    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */

    @Override
    public void tick(Location currentLocation){
        this.count +=1;
        display.println("Power Star - " +(10-this.count)+ "turns remaining");
        if(this.count == 10) {
            currentLocation.removeItem(this);
        }
    }

    @Override
    public void itemFunction(Actor actor) {
        actor.heal(200);
        actor.addCapability(Status.INVINCIBLE);
        display.println(actor +" becomes invincible" ); // printout the actor status
    }


    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public List<Action> getAllowableActions() {
        if (lifetime ==1){
            this.addSampleAction(this.consumeItem());
            this.lifetime -= 1;
        }
        return super.getAllowableActions();
    }
}