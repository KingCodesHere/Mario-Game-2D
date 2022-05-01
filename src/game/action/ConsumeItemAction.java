package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.item.Consumable;
import game.roles.Status;


public class ConsumeItemAction extends Action {
    /**
     * Current item
     */
    private final Consumable item;
    private boolean isExist = false;

    /**
     * Constructor.
     *
     * @param item the item to consume
     */
    public ConsumeItemAction(Consumable item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item items : actor.getInventory()) {
            if (items == this.item) {
                isExist = true;
            }
        }
        if (isExist) {
            item.itemFunction(actor);
            actor.removeItemFromInventory((Item) item);
            System.out.println("sb");
            return menuDescription(actor);

        } else {
            map.locationOf(actor).removeItem((Item) item);
            item.itemFunction(actor);

            System.out.println("whyy");
            return menuDescription(actor);
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes the " + item;
    }
}
