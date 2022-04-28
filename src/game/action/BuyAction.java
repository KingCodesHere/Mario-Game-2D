package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.item.Purchasable;

public class BuyAction extends Action {
    private final Purchasable item;

    /**
     * Constructor.
     *
     * @param item the item to purchase
     */
    public BuyAction(Purchasable item) {
        this.item = item;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        // if item.getPrice >=
        // check balance if true add to inventory
        actor.addItemToInventory((Item) item);
        return menuDescription(actor);
        // else print You don't have enough coins!" and so you cannot get the item.


    }

    @Override
    public String menuDescription(Actor actor) {
        return actor +" buys "+"item";
    }
}
