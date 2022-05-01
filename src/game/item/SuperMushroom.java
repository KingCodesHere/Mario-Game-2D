package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeItemAction;
import game.roles.Status;

import java.util.List;

public class SuperMushroom extends Item implements Consumable, Purchasable {
    private int price = 400;
    private boolean consumeable = true;
    private int consumeTime = 1;
    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', false);

    }

    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }

    public void consumeTime(){
        this.consumeable = false;
    }

    @Override
    public ConsumeItemAction consumeItem() {
        return new ConsumeItemAction(this);
    }

    @Override
    public void itemFunction(Actor actor){
        actor.increaseMaxHp(50);
        actor.addCapability(Status.TALL); // the capability of the actor
        this.addCapability(Status.TALL);

    }
    @Override
    public List<Action> getAllowableActions() {
        if (this.consumeable && this.consumeTime ==1 ){
            this.addSampleAction(this.consumeItem());
            this.consumeTime -=1;
            System.out.println("FUCK");

        }
        else{
            System.out.println("why");
            this.removeAction(this.consumeItem());

        }
        return super.getAllowableActions();
    }


    @Override
    public int getPrice() {
        return this.price;
    }
}
