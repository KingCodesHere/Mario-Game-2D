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
	 * Allowable Actions for the Player, display hotkeys and has the ability to check map if otherActor is present.
	 * Goomba has to vanish from the map 10% of chance in every turn, this is to clean the map and not over-crowd it
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

		if (!map.contains(otherActor))  {
			if(RandomRange.RandRange(100)<=10){ // if chance hit this actor is less than this,
				map.removeActor(this); // action in playTurn removes the actor
			}
		}

		return super.allowableActions(otherActor, direction, map);
	}
	/**
	 * This playTurn override the parent class
	 * Goomba will have playTurn of removing actor by checking its HP level.
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the parent class: Enemy playTurn
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if (!this.isConscious() || this.getMaxHp() <= 0) {
			map.removeActor(this);
		}

		// reset
		if (super.getCheckStatus() && super.getResetTime() == 1) {
			map.removeActor(this);
			super.setResetTime(0);
		}

		return super.playTurn(actions, lastAction, map, display); // else return to parent class super loop for playTurn
	}



}