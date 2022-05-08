package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.RandomRange;
import game.action.AttackAction;
import game.item.Coin;
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
     * The Actor that is to be attacked
     */
    private Actor target;

    private String verb = "";

    private int damage = 0;


    public AttackBehaviour( int damage, String verb) {
//        this.target = target;
        this.damage = damage;
        this.verb = verb;
    }


    @Override
    public Action getAction(Actor actor, GameMap map) {
        if(!map.contains(target) || !map.contains(actor))
            return null;

        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        for (Exit exit : here.getExits() ) {
            Location destination = exit.getDestination();
/*            if (destination.canActorEnter(target)) {
                target.hurt(damage);
                return new MoveActorAction(here,exit.getName());*/
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                target.hurt(damage);
                return new AttackBehaviour(damage,verb);
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
        String result=  actor+ " attacks " + target + " for " + damage + " damage.";

        if (RandomRange.RandRange(100) <= 50) {
            result = actor + " misses " + target + ".";
        }

        if (!target.isConscious()) {
            ActionList dropActions = new ActionList();
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            result += System.lineSeparator() + target + " is killed.";
        }
        return result;
    }

    /**
     * return the actor performing
     * @param actor The actor performing the action.
     * @return .
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + verb + target ;
    }
}
