package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.roles.Status;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}

	
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.TALL) || (actor.hasCapability(Status.INVINCIBLE))){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
