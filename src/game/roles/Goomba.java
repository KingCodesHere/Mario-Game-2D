package game.roles;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomRange;
import game.action.AttackAction;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;
/**
 * A little fungus guy.
 */
public class Goomba extends Enemy {
	private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

	/**
	 * Constructor.
	 */
	public Goomba() {
		super("Goomba", 'g', 20,10,"kicks");

	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if(RandomRange.RandRange(100)<=10){
			map.removeActor(this);
		}
		return super.playTurn(actions, lastAction, map, display);
	}



	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();

		if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			actions.add(new AttackAction(this,direction));
		}

		return actions;
	}



}