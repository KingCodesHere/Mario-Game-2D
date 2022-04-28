package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.balance.Wallet;
import game.item.Coin;


public class PickUpCoinAction extends Action {
    private Coin coin;
    private Wallet wallet;
    public PickUpCoinAction(Coin coin, Wallet wallet){
        this.coin = coin;
        this.wallet = wallet;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        this.wallet.depositBalance(this.coin.getValue());
        map.locationOf(actor).removeItem(coin);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin;
    }
}
