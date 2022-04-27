package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.action.ConsumeItemAction;
import game.grounds.Dirt;
import game.grounds.HigherGround;
import game.roles.Status;


public class PowerStar extends Item implements Consumable {
    private int count = 0;
    private HigherGround higherGround;
    Display display = new Display();
    /***
     * Constructor.
     */
    public PowerStar() {
        super("Power Star", 'p', false);
        this.addCapability(Status.INVINCIBLE);
    }

    public ConsumeItemAction consumeItem(Actor actor){

        return new ConsumeItemAction(this);
    }
    //b public void destoryHighGround()
    // Dunno when to use this method yet or it might be an interface map.locationOf(actor)==map.locationOf(ground) call method
    public void convertToCoins(Ground ground,Location location){
        Dirt dirt = new Dirt();
        Coin coin = new Coin(RandomRange.cashValue());
        location.setGround(dirt);
        location.addItem(coin);
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
        display.println("Mario consumes Power Star -" +(10-this.count)+ "turns remaining");
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
    public void removeConsumeItemAction(ConsumeItemAction action){
        this.removeAction(action);}
}