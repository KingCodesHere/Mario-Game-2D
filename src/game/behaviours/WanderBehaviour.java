package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;

import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;


import java.util.ArrayList;
import java.util.Random;
/**
 * Wander Behaviour for non-playable Actors to inherit to act by wandering the map
 *
 */
public class WanderBehaviour extends Action implements Behaviour {

	private final Random random = new Random();

	public WanderBehaviour() {	}

	/**
	 * Returns a MoveAction to wander to a random location, if possible.
	 * If no movement is possible, returns null.
	 *
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<Action>();
		for (Exit exit : map.locationOf(actor).getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
			}
		}

		if (actions.size()<=0){
			return new DoNothingAction();
		}
		else{
		return actions.get(random.nextInt(actions.size()));}
	}



	@Override
	public String execute(Actor actor, GameMap map) {
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Raagrh...";
	}
}


