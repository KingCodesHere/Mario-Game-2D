package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
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
    void itemFunction(Actor actor);

    /**
     * remove the action
     * @param action
     */
    void removeConsumableAction(Action action);


}
