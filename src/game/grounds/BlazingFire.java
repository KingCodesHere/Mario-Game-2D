package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.roles.Status;

/**
 * Blazing Fire class to add 3 x fire on the ground whenever Bowser attacks Player
 * @author JunHao Li
 */
public class BlazingFire extends Ground {
    /**
     * Constructor.
     *
     */
    public BlazingFire() {
        super('L');
    }

    /**
     * public canActorEnter checks the actor if it has the capability.
     * else returns false.
     * @param actor the actor with the capability checked to proceed the using the method.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Retrieves the location for the actor to hurt the actor
     * @param location of the actor to use hurt method
     */
    @Override
    public void tick(Location location) {
        if (location.containsAnActor()){
            location.getActor().hurt(15);
        }
    }
}
