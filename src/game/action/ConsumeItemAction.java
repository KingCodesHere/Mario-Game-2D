package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.item.Consumable;
import game.item.MagicalItem;

import java.util.function.Consumer;

public class ConsumeItemAction extends Action {
    /**
     * Current item
     */
    private final Consumable item;

    /**
     * Constructor.
     *
     * @param item the item to drop
     */
    public ConsumeItemAction(Consumable item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addItemToInventory((Item) item);
        map.locationOf(actor).removeItem((Item) item);
        item.itemFunction(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return  actor + " consumes the " + item;
    }
}
