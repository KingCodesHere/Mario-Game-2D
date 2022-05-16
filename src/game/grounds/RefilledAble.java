package game.grounds;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.RefilledAction;

public interface RefilledAble {
    /**
     * execute the action from item class
     * @return
     */
    RefilledAction refilledGround();

    /**
     * implement the item function after consuming
     * @param actor
     */
    void groundAbility(Actor actor, GameMap map);


    /**
     * a description of the object
     * @return
     */
    String groundDescription();
}
