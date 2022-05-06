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

public class AttackBehaviour extends Action implements Behaviour  {

    private final Actor target;

    private String direction;
    /**
     * Random generator
     *
     * */
    private final Random random = new Random();

    public AttackBehaviour(Actor target,String direction) {
        this.target = target;
        this.direction = direction;
    }


    @Override
    public Action getAction(Actor actor, GameMap map) {

        ArrayList<Action> actions = new ArrayList<Action>();
        if(!map.contains(target) || !map.contains(actor))
            return null;

        Location x = map.locationOf(target);

        for (Exit exit : x.getExits() ) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                actions.add(new AttackAction(target,direction));

            }

        }
        return null;
    }




    /**
     * execute the hotkey
     * @param actor The actor performing the behaviour.
     * @param map The map the actor is on.
     * @return .
     */


    @Override
    public String execute(Actor actor, GameMap map) {
        return actor + " " + target + " for " + " damage.";
    }

    /**
     * return the actor performing
     * @param actor The actor performing the action.
     * @return .
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction;
    }
}
