
package game.roles;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DestroyShellAction;
import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Koopa Troopa
 * Turtle guy that punches and Hides in shell for protection.
 * @author Kenda Wan
 * @version 1.0.0
 *
 */
public class Koopa extends Enemy{

    /**
     * List of behaviours in hashmap, organising the priority level
     */
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    /**
     * Constructor
     * returning super class: Enemy
     */
    public Koopa() {
        super("Koopa", 'K',100,30,"punches");

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
        ActionList actions=super.allowableActions(otherActor,direction,map);

        if(this.hasCapability(Status.DORMANT)) {
            actions.clear();
        }
        if(otherActor.hasCapability(Status.WRENCH) && this.hasCapability(Status.DORMANT)){
            actions.add(new DestroyShellAction(this));
        }
        return actions;
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
        if(!super.isConscious()){
            this.setDisplayChar('D');
            this.addCapability(Status.DORMANT);

        }
        return super.playTurn(actions,lastAction,map,display);

    }


}