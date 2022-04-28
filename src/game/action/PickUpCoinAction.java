package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.balance.Wallet;
import game.item.Coin;
import game.roles.Player;


public class PickUpCoinAction extends Action {
    private Coin coin;
    private Player player;


    public PickUpCoinAction(Coin coin,Player player){
        this.coin = coin;
        this.player = player;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        player.getPlayerWallet().depositBalance(this.coin.getValue());
        map.locationOf(actor).removeItem(coin);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin +" ($"+this.coin.getValue() +")";
    }
}
