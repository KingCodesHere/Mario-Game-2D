package game.bottles;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeItemAction;
import game.bottles.BottleManager;
import game.bottles.Drinkable;
import game.item.Consumable;
import game.item.Water;
import java.util.List;

public class Bottle extends Item implements Consumable, Drinkable {
    /**
     * An array list to store the water
     */
    private List<Water> waterList;

    /**
     * Consumable time
     */
    private int lifetime = 1;

    /***
     * Constructor.
     *
     */
    public Bottle() {
        super("Bottle", 'b', false);
        this.setInstance();
    }


    /**
     * method from the interface to be overwritten
     *
     * @return
     */
    @Override
    public ConsumeItemAction consumeItem() {
        return new ConsumeItemAction(this);
    }

    /**
     * This item's function
     * @param actor
     */
    @Override
    public void itemFunction(Actor actor) {
        BottleManager.getInstance().run();
    }

    /**
     * Removing the action after executing
     *
     * @param action
     */
    @Override
    public void removeConsumableAction(Action action) {
        this.removeAction(action);
    }

    /**
     * name of this
     * @return name of the item and arraylist
     */
    @Override
    public String description() {
        return this.toString()+waterList;
    }


    @Override
    public void executeInstance() {

    }

    /**
     * add the action
     *
     * @param newAction action
     */
    @Override
    public void addSampleAction(Action newAction) {
        this.addAction(newAction);
    }

    /**
     * Getter.
     * <p>
     * Returns an unmodifiable copy of the actions list so that calling methods won't
     * be able to change what this Item can do without the Item checking.
     *
     * @return an unmodifiable list of Actions
     */
    @Override
    public List<Action> getAllowableActions() {

        if (lifetime == 1) {
            this.addSampleAction(this.consumeItem());
            this.lifetime -= 1;
        }
        return super.getAllowableActions();
    }
}
