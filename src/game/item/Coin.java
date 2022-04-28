package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import game.RandomRange;
import game.action.PickUpCoinAction;
import game.roles.Player;
import game.roles.Status;

public class Coin extends Item {
    private final int value;
    /***
     * Constructor.
     *
     */
    public Coin() {
        super("Coin", '$', false);
        this.value = RandomRange.cashValue();
        this.addCapability(Status.COIN);

    }
    public int getValue(){
        return this.value;
    }


    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }
    public PickUpCoinAction getPickUp(Coin coin, Player player){
        return new PickUpCoinAction(coin,player);
    }
}
