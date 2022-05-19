package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.roles.Status;

public class BlazingFire extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public BlazingFire() {
        super('L');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()){
            location.getActor().hurt(15);
        }
    }
}
