package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.roles.Status;

import java.util.ArrayList;
import java.util.Random;

/**
 * AttackBehaviour class implemeting Behaviour class which allows actor to Attack by default
 * in this case, the Behaviour class is for non-players, where behaviours are naturally inherited
 * Actor inheriting this method Attacks player (with conditions), and Wander's by default
 * @author Kenda Wan
 * @version 1.0.0
 */

public class AttackBehaviour extends Action implements Behaviour  {


    /**
     * Random generator
     *
     * */
    private final Random random = new Random();

    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<Action>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor())
                actions.
        }

        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }

    }




    /**
     * execute the hotkey
     * @param actor The actor performing the behaviour.
     * @param map The map the actor is on.
     * @return .
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    /**
     * return the actor performing
     * @param actor The actor performing the action.
     * @return .
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
