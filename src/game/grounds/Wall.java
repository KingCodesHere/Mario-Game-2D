package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.item.Coin;
import game.roles.Status;

public class Wall extends Ground implements HigherGround{
	public Wall() {
		super('#');
	}

	
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.INVINCIBLE)){
			return true;
		}
		else{
			return false;
		}
	}
	public void tick(Location location){
		if (location.containsAnActor()){
		convertToCoins(location);}
	}
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}




}
