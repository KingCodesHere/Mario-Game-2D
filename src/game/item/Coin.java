package game.item;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import game.RandomRange;
import game.action.PickUpCoinAction;
import game.roles.Status;
import java.util.List;
/**
 * Coin class extends item
 * @author Junhao Li, Ashston Sequira
 * @version 1.0.0
 */
public class Coin extends Item {
    private final int value;
    private int lifetime =1;

    /**
     * Constructor of Coin
     * value of coin will be generated randomly
     */
    public Coin() {
        super("Coin", '$', false);
        this.value = RandomRange.cashValue();
        this.addCapability(Status.COIN);

    }

    /**
     * Constructor of Coin
     * @param price input price for the Coin
     */
    public Coin(int price) {
        super("Coin", '$', false);
        this.value = price;
        this.addCapability(Status.COIN);

    }

    /**
     * Get coin value
     * @return  Coin Value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * add action method
     * @param newAction
     */
    public void addSampleAction(Action newAction) {
        this.addAction(newAction);
    }

    /**
     * call the pickupcoinaction method
     * @param coin
     * @return
     */
    public PickUpCoinAction getPickUp(Coin coin) {
        return new PickUpCoinAction(coin);
    }

    /**
     * Getter.
     *
     * Returns an unmodifiable copy of the actions list so that calling methods won't
     * be able to change what this Item can do without the Item checking.
     * @return an unmodifiable list of Actions
     */
    @Override
    public List<Action> getAllowableActions() {
        if (lifetime ==1){
            this.addSampleAction(this.getPickUp(this));
            this.lifetime -= 1;
        }
        return super.getAllowableActions();
    }

}

