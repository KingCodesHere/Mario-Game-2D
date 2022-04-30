package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.balance.WalletsManager;
import game.item.Coin;



public class PickUpCoinAction extends Action {
    private Coin coin;



    public PickUpCoinAction(Coin coin){
        this.coin = coin;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        WalletsManager.getInstance().getWalletHashMap().get(actor).depositBalance(this.coin.getValue());
        map.locationOf(actor).removeItem(coin);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin +" ($"+this.coin.getValue() +")";
    }
}
