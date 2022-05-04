package game.roles;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RandomRange;
import game.action.AttackAction;
import game.behaviours.Behaviour;

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


	/**
	 * Returns a new collection of the Actions that the otherActor can do to the current Actor.
	 *
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return A collection of Actions.
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();

		if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			actions.add(new AttackAction(this,direction));
		}

		return actions;
	}



}