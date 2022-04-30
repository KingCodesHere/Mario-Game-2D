package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.action.ConsumeItemAction;
import game.action.PickUpCoinAction;
import game.roles.Status;

import java.util.List;

public class SuperMushroom extends Item implements Consumable, Purchasable {
    private int price = 400;
    private int lifetime = 1;
    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);
        this.addCapability(Status.TALL);
    }

    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }

    @Override
    public ConsumeItemAction consumeItem() {
        return new ConsumeItemAction(this);
    }

    @Override
    public void itemFunction(Actor actor){
        actor.increaseMaxHp(50);
        actor.addCapability(Status.TALL); // the capability of the actor

    }
    @Override
    public List<Action> getAllowableActions() {
        if (lifetime ==1){
            this.addSampleAction(this.consumeItem());
            this.lifetime -= 1;
        }
        return super.getAllowableActions();
    }

    public void removeConsumeItemAction(ConsumeItemAction action){
        this.removeAction(action);
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
