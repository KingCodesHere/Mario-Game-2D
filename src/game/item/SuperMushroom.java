package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeItemAction;
import game.roles.Status;

public class SuperMushroom extends Item implements Consumable, Purchasable {
    private int price = 400;
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
    public ConsumeItemAction consumeItem(Actor actor) {
        return new ConsumeItemAction(this);
    }

    @Override
    public void itemFunction(Actor actor){
        actor.increaseMaxHp(50);
        actor.addCapability(Status.TALL); // the capability of the actor

    }

    public void removeConsumeItemAction(ConsumeItemAction action){
        this.removeAction(action);
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
