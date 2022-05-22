package game.roles.enemies;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.AttackAction;
import game.action.DestroyShellAction;
import game.behaviours.*;
import game.roles.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Koopa Troopa
 * Turtle guy that punches and Hides in shell for protection.
 * @author Kenda Wan
 * @version 1.0.0
 *
 */
public class Koopa extends Enemy implements SpeakCapable {

    /**
     * List of behaviours in hashmap, organising the priority level
     */
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    private ArrayList<String> statements = new ArrayList<>();
    private Random random = new Random();
    private int count=0;
    /**
     * Constructor
     * returning super class: Enemy
     */
    public Koopa() {
        super("Koopa", 'K',100,30,"punches");
        this.behaviours.put(10,new WanderBehaviour());
        this.statements.add("Never gonna make you cry!");
        this.statements.add("Koopi koopi koopii~!");
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
        ActionList actions = new ActionList();

        if(this.hasCapability(Status.DORMANT)) {
            actions.clear();

            if(otherActor.hasCapability(Status.WRENCH) ){
                actions.add(new DestroyShellAction(this,direction));
            }

            return actions;
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
     * Koopa Class requires changes to its status when the hp is <=0
     * for Koopa class, the status will be set to dormant when this happens
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
            this.getStatement(this,this.statements.get(statements.size()),display);
        }
        if (!this.isConscious() || this.getMaxHp() <= 0) {
            map.removeActor(this);
            return new DoNothingAction();
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

        if (this.getMaxHp() <= 0) {
            this.setDisplayChar('D');
            this.addCapability(Status.DORMANT);
            this.isConscious();
        }


        return new DoNothingAction();

    }
}
