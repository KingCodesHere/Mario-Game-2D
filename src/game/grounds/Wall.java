package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;

public class Wall extends HighGround {
	public Wall() {
		super('#');
		this.addCapability(High.WALL);
	}

	@Override
	public String getName() {
		return "Wall";
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
