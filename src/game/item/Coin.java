package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.RandomRange;
import game.action.PickUpCoinAction;
import game.balance.Wallet;

public class Coin extends Item {
    private final int value;
    /***
     * Constructor.
     *
     */
    public Coin() {
        super("Coin", '$', false);
        this.value = RandomRange.cashValue();
    }
    public int getValue(){
        return this.value;
    }
    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }
    public PickUpCoinAction getPickUp(Coin coin, Wallet wallet){
        return new PickUpCoinAction(coin,wallet);
    }
}
