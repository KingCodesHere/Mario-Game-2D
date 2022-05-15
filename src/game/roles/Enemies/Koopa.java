
package game.roles.Enemies;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DestroyShellAction;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.roles.Enemies.Enemy;
import game.roles.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * Koopa Troopa
 * Turtle guy that punches and Hides in shell for protection.
 * @author Kenda Wan
 * @version 1.0.0
 *
 */
public class Koopa extends Enemy {

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
        this.addCapability(Status.KOOPA);
    }


    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     * Koopa class requires Dormant status and will not display attack action to player when standing next to it
     * Koopa class will only display DestroyShellAction when player acquires WRENCH in its inventory.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor,direction,map);

        if(!this.hasCapability(Status.KOOPA) && this.hasCapability(Status.DORMANT)) {
            this.setDisplayChar('D');
            actions.clear();
            this.increaseMaxHp(50);
            if(otherActor.hasCapability(Status.WRENCH) ){
                actions.add(new DestroyShellAction(this, direction));
            }

            return actions;
        }

        if (!this.hasCapability(Status.DORMANT) && this.getMaxHp() <= 0) {
            this.removeCapability(Status.KOOPA);
            this.addCapability(Status.DORMANT);
            this.setDisplayChar('D');
            this.increaseMaxHp(50);
        }



        return actions;
    }

    /**
     * Koopa Class requires changes to its status when the hp is equal or less than 0
     * for Koopa class, the status will be set to dormant when this happens
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the parent class: Enemy playTurn
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // reset
        if (super.getCheckStatus() && super.getResetTime() == 1) {
            map.removeActor(this);
            this.behaviours.clear();
            super.setResetTime(0);
            return new DoNothingAction();
        }

        else {
            return super.playTurn(actions, lastAction, map, display); // else return to parent class super loop for playTurn
        }
    }


}