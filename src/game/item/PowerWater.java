package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import game.roles.Status;

public class PowerWater extends Water{
    /***
     * Constructor.
     */
    public PowerWater() {
        super("Power Water",'1' , false);
    }

    /***
     * implment the function of water
     */
    @Override
    public void waterFunction(Actor actor) {

        actor.addCapability(Status.PowerWater);
    }
}
