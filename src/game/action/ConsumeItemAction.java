package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.item.Consumable;

/**
 * ConsumeItemAction class is a base class that allow the actor to consume item
 * @author Junhao Li
 * @version 1.0.0
 */

public class ConsumeItemAction extends Action {
    /**
     * Consumable item
     */
    private final Consumable item;
    /**
     * Checking if the item checks in actor inventory
     */
    private boolean isExist = false;

    /**
     * Constructor.
     *
     * @param item the item to consume
     */
    public ConsumeItemAction(Consumable item) {
        this.item = item;
    }

    /**
     * Executing the consuming action for the particular item
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item items : actor.getInventory()) {
            if (items == this.item) {
                isExist = true;
            }
        }
        if (isExist) {

            item.itemFunction(actor);
            item.removeConsumableAction(this);
            return menuDescription(actor);

        } else {
            actor.addItemToInventory((Item) this.item);
            map.locationOf(actor).removeItem((Item) item);
            item.itemFunction(actor);
            item.removeConsumableAction(this);
            return menuDescription(actor);
        }
    }
    /**
     * return the actor consumes item sentence
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes the " + item.description();
    }
}
