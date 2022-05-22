package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.roles.Status;
/**
 * Fire
 * @author Junhao Li
 * @version 1.0.0
 */
public class Fire extends Item {
    /**
     * counter
     */
    private int count=0;

    /***
     * Constructor.

     */
    public Fire() {
        super("Fire", 'v', false);
    }

    /**
     * setting the fire on ground
     * @param actor actor
     * @param map gamemap
     */
    public void setFire(Actor actor, GameMap map,Actor target) {
        if(actor.hasCapability(Status.FIRE)){
            map.locationOf(target).addItem(new Fire());
        }
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */


    @Override
    public void tick(Location currentLocation){
        new Display().println("Fire - " +(3-this.count)+ " turns remaining");
        if(this.count == 3) {
            currentLocation.removeItem(this);
        }
        if(currentLocation.containsAnActor()){
            currentLocation.getActor().hurt(20);
        }

        this.count +=1;
    }


}
