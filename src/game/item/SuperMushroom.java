package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeItemAction;
import game.roles.Status;

public class SuperMushroom extends Item implements Consumable {

    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);
        this.addCapability(Status.TALL);
    }

    @Override
    public ConsumeItemAction consumeItem(Actor actor) {
        return new ConsumeItemAction(this);
    }
    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }
    @Override
    public void itemFunction(Actor actor){
        actor.increaseMaxHp(50);
        actor.addCapability(Status.TALL);
    }
}
