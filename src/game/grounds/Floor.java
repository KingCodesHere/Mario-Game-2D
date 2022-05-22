package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.roles.Status;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {
	public Floor() {
		super('_');

	}
	/**
	 * checks if this actor can enter
	 * @param actor this actor needs to be checked
	 * @return false for actor cant enter
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			return true;
		}
		else {
			return false;
		}
	}
}

