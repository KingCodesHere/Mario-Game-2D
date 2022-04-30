package game.item;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import game.RandomRange;
import game.action.PickUpCoinAction;
import game.roles.Status;
import java.util.List;

public class Coin extends Item {
    private final int value;
    private int lifetime =1;

    /***
     * Constructor.
     *
     */
    public Coin() {
        super("Coin", '$', false);
        this.value = RandomRange.cashValue();
        this.addCapability(Status.COIN);

    }

    public int getValue() {
        return this.value;
    }

    @Override
    public List<Action> getAllowableActions() {
        if (lifetime ==1){
            this.addSampleAction(this.getPickUp(this));
            this.lifetime -= 1;
        }
        return super.getAllowableActions();
    }
    public void addSampleAction(Action newAction) {
        this.addAction(newAction);
    }


    public PickUpCoinAction getPickUp(Coin coin) {
        return new PickUpCoinAction(coin);
    }
}

