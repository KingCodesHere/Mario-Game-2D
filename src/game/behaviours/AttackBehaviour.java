package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.action.AttackAction;
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

public class AttackBehaviour implements Behaviour  {
    /**
     * the actor being targeted
     *
     * */
    private final Actor target;
    /**
     * String of direction the actor will attack on
     *
     * */
    private String direction;
    /**
     * Random generator
     *
     * */
    private final Random random = new Random();

    /**
     * Attack Behaviour constructor
     *
     * @param target the Actor to attack
     * @param direction the direction to attack at
     * */
    public AttackBehaviour(Actor target,String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Returns a action for player to return in display, if possible.
     * If no action is possible, returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no action is possible
     */

    @Override
    public Action getAction(Actor actor, GameMap map) {

        ArrayList<Action> actions = new ArrayList<Action>();
        if(!map.contains(target) || !map.contains(actor))
            return null;

        Location x = map.locationOf(target);

        for (Exit exit : x.getExits() ) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                actions.add(new AttackAction(target,direction));

            }

        }
        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        return null;
    }




}