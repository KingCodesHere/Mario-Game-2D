package game.roles;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RandomRange;
import game.action.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * A little fungus guy.

 * @author Kenda Wan
 * @version 1.0.0
 *
 */
public class Goomba extends Enemy {

	/**
	 * List of behaviours in hashmap, organising the priority level
	 */
	private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

	/**
	 * Constructor
	 * returning super class: Enemy
	 */
	public Goomba() {
		super("Goomba", 'g', 20,10,"kicks");
	}


	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		if (!map.contains(otherActor))  {
			if(RandomRange.RandRange(100)<=10){ // if chance hit this actor is less than this,
				map.removeActor(this); // action in playTurn removes the actor
			}
		}

		return super.allowableActions(otherActor, direction, map);
	}
}