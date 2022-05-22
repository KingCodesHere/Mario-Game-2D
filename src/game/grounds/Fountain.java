package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.JumpAction;
import game.action.RefilledAction;
import game.bottles.BottleManager;
import game.roles.Status;
/**
 * Fountain
 * @author Junhao Li
 * @version 1.0.0
 */
public class Fountain extends Ground implements RefilledAble{
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fountain(char displayChar) {
        super(displayChar);
    }

    @Override
    public RefilledAction refilledGround() {
        return new RefilledAction(this);
    }

    @Override
    public void groundAbility(Actor actor, GameMap map) {
    }


    @Override
    public String groundDescription() {
        return null;
    }
    /**
     * Returns an empty Action list.
     * @author Ashton Sequeira
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()){
            return new ActionList(this.refilledGround());
        }

        else {
            return new ActionList();
        }
    }
}
