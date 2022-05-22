package game.roles.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.action.AttackAction;
import game.behaviours.*;
import game.roles.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A little fungus guy.

 * @author Kenda Wan
 * @version 1.0.0
 *
 */
public class Goomba extends Enemy implements SpeakCapable {

	/**
	 * List of behaviours in hashmap, organising the priority level
	 */
	private final Map<Integer, Behaviour> behaviours = new HashMap<>();
	// priority, behaviour
	private ArrayList<String> statements = new ArrayList<>();

	private int count=0;
	/**
	 * Constructor
	 * returning super class: Enemy
	 */
	public Goomba() {
		super("Goomba", 'g', 20,10,"kicks");
		this.behaviours.put(10,new WanderBehaviour());
		this.statements.add("Mugga mugga!");
		this.statements.add("Ugha ugha... (Never gonna run around and desert you...)");
		this.statements.add("Ooga-Chaka Ooga-Ooga!");
	}

	/**
	 * Allowable Actions for the Player, display hotkeys and has the ability to check map if otherActor is present.
	 * Goomba has to vanish from the map 10% of chance in every turn, this is to clean the map and not over-crowd it
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();


		if (!map.contains(otherActor))  {
			if(RandomRange.RandRange(100)<=10){ // if chance hit this actor is less than this,
				map.removeActor(this); // action in playTurn removes the actor
			}
		}

		for (Exit exit : map.locationOf(this).getExits()) {

			Location destination = exit.getDestination();
			if (destination.containsAnActor()) {
				if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
					this.behaviours.put(1, new AttackBehaviour(otherActor, direction));
					this.behaviours.put(2, new FollowBehaviour(otherActor));
					actions.add(new AttackAction(this, direction));
					return actions;
				}

			}



		}

		return actions;
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
		this.count+=1;
		if(this.count%2==0){
			this.getStatement(this,this.statements,display);
		}
		// reset
		if (super.getCheckStatus() && super.getResetTime() == 1) {
			map.removeActor(this);
			this.behaviours.clear();
			super.setResetTime(0);
		}

		for (Behaviour behaviour : behaviours.values()) {
			Action action = behaviour.getAction(this, map);
			if(action != null)
				return action;

		}

		if (!this.isConscious() || this.getMaxHp() <= 0) {
			map.removeActor(this);
			return new DoNothingAction();
		}


		return new DoNothingAction();
	}



}
