package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.action.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic Enemy class with default behaviours.
 *
 * @author Kenda Wan
 * @version 1.0.0
 */
public abstract class Enemy extends Actor implements Resettable {
    /**
     * List of behaviours in hashmap, organising the priority level
     */
    private final Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * String of verb as the action verb
     */
    private String verb;

    /**
     * Int damage for attack as the attackDamage towards player
     */
    private int attackDamage;

    /**
     * Checking if the resetAction has execute yet
     */
    private boolean checkStatus = false;

    /**
     * only can be reset for one time
     */
    private int resetTime = 1;

    /**
     *  Getter for returning verb
     * @return verb of verb of the action
     */
    public String getVerb() {
        return verb;
    }

    /**
     * Getter for returnign damage lvl
     * @return attackDamage int
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * Getter for checkStatus
     * @return checkStatus boolean
     */
    public boolean getCheckStatus(){
        return this.checkStatus;
    }
    /**
     * Getter for Resettime
     * @return Resettime int
     */
    public int getResetTime() {
        return resetTime;
    }
    /**
     * Setter for Resettime
     */
    public void setResetTime(int resetTime) {
        this.resetTime = resetTime;
    }


    /**
     * Constructor
     * the general Enemy constructor with set default behaviours
     */
    public Enemy(String name, char displayChar, int hitPoints, int attackDamage, String verb) {
        super(name, displayChar, hitPoints);
        this.attackDamage=attackDamage;
        this.verb=verb;
        this.registerInstance();

        super.addCapability(Status.HOSTILE_TO_PLAYER);
        this.behaviours.put(3, new WanderBehaviour());
        this.behaviours.put(1, new AttackBehaviour());
    }

    /**
     * This playTurn is default for Enemies and can be overridden
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the parent class: Enemy playTurn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // reset
        if(this.checkStatus && this.resetTime==1){
            map.removeActor(this);
            this.resetTime = 0;
        }

        if (!this.isConscious() || this.getMaxHp() <= 0) {
            map.removeActor(this);
        } else {
            for (Behaviour behaviour : behaviours.values()) {
                Action action = behaviour.getAction(this, map);
                return action;
            }
        }
        return new WanderBehaviour();
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
        ActionList actions=new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && this.isConscious()){
            actions.add(new AttackAction(this,direction));
            this.behaviours.put(3,new FollowBehaviour(otherActor));
        }
        return actions;
    }

    /**
     * IntrinsicWeapon to retrieve child class damage level and verb of actions
     * @return attackDamage and verb
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(attackDamage,verb);
    }

    @Override
    public void resetInstance() {
        this.checkStatus = true;
    }
}


