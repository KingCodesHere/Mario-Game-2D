package game.roles.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.action.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.reset.Resettable;
import game.roles.Status;

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
     * Getter for returning damage lvl
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
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    /**
     * IntrinsicWeapon to retrieve child class damage level and verb of actions
     * @return attackDamage and verb
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(attackDamage,verb);
    }


    /**
     * call the resetInstance method the change the current status
     */
    @Override
    public void resetInstance() {
        this.checkStatus = true;
    }

}



