package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
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

		Weapon weapon = actor.getWeapon();
		int damage;
		String result = "";


		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}

		if (target.hasCapability(Status.INVINCIBLE)){
			damage=0;
		}
		else{
			damage = weapon.damage();
		}
		if(target.hasCapability(Status.TALL)){
			target.removeCapability(Status.TALL);
		}
		if (target.hasCapability(Status.DORMANT)){
			damage=0;
			if (actor.hasCapability(Status.WRENCH)){
				target.hurt(damage);
			}
		}
		result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		target.hurt(damage);


		if (target.hasCapability(Status.KOOPA)){
			if (!target.isConscious()){
				target.addCapability(Status.DORMANT);
				target.heal(50);
				target.isConscious();
			}
			result += System.lineSeparator() + target+ " is Dormant. " ;
		}


		if (!target.isConscious() && !target.hasCapability(Status.KOOPA)) {
			ActionList dropActions = new ActionList();
			// drop all items
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction(actor));
			for (Action drop : dropActions)
				drop.execute(target, map);
			// remove actor
			map.removeActor(target);
			result += System.lineSeparator() + target + " is killed.";
		}


		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target + " at " + direction;
	}
}
