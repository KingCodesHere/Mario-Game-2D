package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.item.Fire;
import game.roles.Status;
import java.util.Random;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;

	/**
	 * The direction of incoming attack.
	 */
	protected String direction;

	/**
	 * Random number generator
	 */
	protected Random rand = new Random();
	/**
	 * result
	 */
	private String result;
	/**
	 * Constructor.
	 *
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}



	@Override
	public String execute(Actor actor, GameMap map) {
		//set fire checks actor and set fire on the location
		new Fire().setFire(actor,map,target);

		Weapon weapon = actor.getWeapon();

		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}

		int damage = checkIfActorIsInvinsible(weapon);
		checkSuperMushroom();

		result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		target.hurt(damage);

		result = actor.getKilled(map, result);

		return result;
	}



	/**
	 * checking if the actor is invinsible, otherwise actor will get hurt
	 * @param weapon weapon damage
	 * @return damage
	 */
	private int checkIfActorIsInvinsible(Weapon weapon) {
		int damage;
		if (target.hasCapability(Status.INVINCIBLE)){
			damage=0;
		}
		else{
			damage = weapon.damage();
		}
		return damage;
	}

	/**
	 * checking the actor has superMushroom
	 */
	private void checkSuperMushroom() {
		if(target.hasCapability(Status.TALL)){
			target.removeCapability(Status.TALL);
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		String hasFire = checkActorHasFire(actor);
		if (hasFire != null) return hasFire;
		return actor + " attacks " + target + " at " + direction;
	}

	/**
	 * checking if the actor has fire
	 * @param actor
	 * @return
	 */
	private String checkActorHasFire(Actor actor) {
		if(actor.hasCapability(Status.FIRE)){
			return actor + " attacks " + target + " at " + direction + " with fire!";
		}
		return null;
	}
}

