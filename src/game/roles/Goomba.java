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
	/**
	 * This playTurn override the parent class
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the parent class: Enemy playTurn
	 */

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if(RandomRange.RandRange(100)<=10){
			map.removeActor(this);
		}

		return super.playTurn(actions, lastAction, map, display);
	}

	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		this.behaviours.put(1, new AttackBehaviour(otherActor,direction));
		this.behaviours.put(2, new FollowBehaviour(otherActor));
		return super.allowableActions(otherActor, direction, map);
	}
}