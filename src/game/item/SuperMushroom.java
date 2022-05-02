package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeItemAction;
import game.roles.Status;

import java.util.List;
/**
 * SuperMushroom item that extends the item class
 * @author Junhao Li, Ashston Sequira
 * @version 1.0.0
 */
public class SuperMushroom extends Item implements Consumable, Purchasable {
    /**
     * price of the item
     */
    private int price = 400;
    /**
     * Consumable time
     */
    private int lifetime = 1;
    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);

    }

    /**
     * add the action
     * @param newAction action
     */
    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }

    /**
     * method from the interface to be overwritten
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
    public void itemFunction(Actor actor){
        actor.increaseMaxHp(50);
        actor.addCapability(Status.TALL); // the capability of the actor
        this.addCapability(Status.TALL);

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
            this.addSampleAction(this.consumeItem());
            this.lifetime -= 1;
        }
        return super.getAllowableActions();
    }

    /**
     * Overwrite the method from purchasable method
     * @return
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * Adding the consumeAction if actor press the consume hotkey
     * @return
     */
    @Override
    public void removeConsumableAction(Action action) {
        this.removeAction(action);
    }
}
