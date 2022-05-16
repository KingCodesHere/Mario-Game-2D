package game.item;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

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
