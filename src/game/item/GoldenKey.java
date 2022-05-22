package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.roles.Status;

/**
 * Golden Key to unlock Princess Peach's handcuffs
 * Only obtainable by Killing Bowser in LavaZone Map
 * @author Kenda Wan
 * @version 1.01
 */

public class GoldenKey extends Item {

    /***
     * Constructor.
     */
    public GoldenKey() {
        super("GoldenKey", 'k', true);
        this.addCapability(Status.KEY);
    }



}
