package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.action.PickUpCoinAction;
import game.reset.Resettable;
import game.roles.Status;

import java.util.List;

/**
 * Coin class extends item
 * @author Junhao Li
 * @version 1.0.0
 */
public class Coin extends Item implements Resettable {
    /**
     * value of the coin
     */
    private final int value;
    /**
     * lifetime of the coin
     */
    private int lifetime =1;

    /**
     * Checking if the resetAction has execute yet
     */
    private boolean checkStatus = false;


    /**
     * only can be reset for one time
     */
    private int resetTime = 1;

    /**
     * Constructor of Coin
     * value of coin will be generated randomly
     */
    public Coin() {
        super("Coin", '$', false);
        this.value = RandomRange.cashValue();
        this.addCapability(Status.COIN);
        this.registerInstance();
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
     * @return Action to actor to pick up coin
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

    @Override
    /**
     * time of the item on ground
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     */
    public void tick(Location currentLocation) {
        if(this.checkStatus && this.resetTime==1){
            currentLocation.removeItem(this);
            this.resetTime = 0;
        }
    }

    /**
     * call the resetInstance method the change the current status
     */
    @Override
    public void resetInstance() {
        this.checkStatus = true;
    }
}

