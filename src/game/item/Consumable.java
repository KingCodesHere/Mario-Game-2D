package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.ConsumeItemAction;

/**
 * Consumable interface
 * @author Junhao Li, Ashston Sequira
 * @version 1.0.0
 */
public interface Consumable {
    /**
     * execute the action from item class
     * @return
     */
    ConsumeItemAction consumeItem();

    /**
     * implement the item function after consuming
     * @param actor
     */
    void checkItem(Actor actor, GameMap map);

    /**
     * remove the action
     * @param action
     */
    void removeConsumableAction(Action action);

    /**
     * a description of the object
     * @return
     */
    String description();

    /**
     * add to the actionlist
     * @param newAction
     */
    void addSampleAction(Action newAction);

    void consumeAffect(Actor actor);
}
