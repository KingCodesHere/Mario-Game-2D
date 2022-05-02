package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.balance.WalletsManager;
import game.item.Coin;
/**
 * PickUpCoinAction class is a base class that allow the actor to pick up the coin
 * @author Junhao Li
 * @version 1.0.0
 */

public class PickUpCoinAction extends Action {
    /**
     * coin item
     */
    private Coin coin;


    /**
     * A constuctor for the PickUpCoinAction
     * @param coin
     */
    public PickUpCoinAction(Coin coin){
        this.coin = coin;

    }

    /**
     * Executing to pick up the coin
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        WalletsManager.getInstance().getWalletHashMap().get(actor).depositBalance(this.coin.getValue());
        map.locationOf(actor).removeItem(coin);
        return menuDescription(actor);
    }

    /**
     * return the actor pick up coin item
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin +" ($"+this.coin.getValue() +")";
    }
}
