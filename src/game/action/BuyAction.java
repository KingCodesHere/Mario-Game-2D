package game.action;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.balance.WalletsManager;
import game.item.Purchasable;

/**
 * BuyAction class is a base class that allow the actor to purchase item
 * @author Junhao Li
 * @version 1.0.0
 */
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

    /**
     * execute the buy action when actor press the hotkey
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int valueOfWallet =  WalletsManager.getInstance().getWalletHashMap().get(actor).getBalance();
        int purchasedItemPrice = item.getPrice();
        if(purchasedItemPrice <= valueOfWallet){
            actor.addItemToInventory((Item) item);
            WalletsManager.getInstance().getWalletHashMap().get(actor).withdrawBalance(purchasedItemPrice);
            return actor +" purchased "+item;}
        else{
            return  "You don't have enough coins! and so you cannot get the " + item+".";
        }
    }

    /**
     * return the actor buys item sentence
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor +" buys "+item +" $"+item.getPrice();
    }
}
