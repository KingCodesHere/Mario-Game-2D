package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomRange;
import game.item.SuperMushroom;


/**
 * DestroyShellAction class is a allows Actor to have an action to destoy Koopa's shell/ Dormant state
 * in this case, only Koopa will allow actor to have this action
 * @author Kenda Wan
 * @version 1.0.0
 */

public class DestroyShellAction extends Action {

    /**
     * The target that will be attacked/destroyed
     * */
    private Actor target;


    /**
     * Constructor
     *
     * @param target the target to be destroyed.
     * */
    public DestroyShellAction(Actor target) {
        this.target=target;
    }


    /**
     * execute the destroy action when actor press the hotkey
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return display depending on condition
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if(RandomRange.RandRange(100)<=80) {
            map.removeActor(target);
            map.locationOf(target).addItem(new SuperMushroom());
            return "Destroyed Koopa's Shell";
        }
        return actor+ " misses and couldn't destroy Koopa's Shell";

    }

    /**
     * return the actor commit action, to perform
     * @param actor The actor performing the action.
     * @return the actor who will perform this action
     */

    @Override
    public String menuDescription(Actor actor) {
        return "Destroy Koopa's Shell ";
    }
}

