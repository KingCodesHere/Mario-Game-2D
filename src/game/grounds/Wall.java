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
	Boolean isTrue = false;
	public Wall() {
		super('#');
	}

	
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.INVINCIBLE)){
			isTrue = true;
			return true;
		}
		else{
			return false;
		}
	}
	public void tick(Location location){
		if (isTrue == true){
		convertToCoins(location);}
	}
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	@Override
	public void convertToCoins(Location location) {
		Dirt dirt = new Dirt();
		Coin coin = new Coin(RandomRange.cashValue());
		location.setGround(dirt);
		location.addItem(coin);
	}

}
