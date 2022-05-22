package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ConsumeItemAction;
import game.roles.Status;
import java.util.List;
/**
 * FireFlower
 * @author Junhao Li
 * @version 1.0.0
 */
public class FireFlower extends Item implements Consumable {
    /**
     * Consumable time
     */
    private int lifetime = 1;

    /**
     * counter
     */
    private int count;

    boolean renewTime;
    /***
     * Constructor.
     */
    public FireFlower() {
        super("Fire Flower", 'f', false);
    }

    @Override
    public ConsumeItemAction consumeItem() {
        return new ConsumeItemAction(this);
    }

    @Override
    public void checkItem(Actor actor, GameMap map, Action action) {
        map.locationOf(actor).removeItem(this);
        this.consumeAffect(actor);
        this.removeConsumableAction(action);
    }

    @Override
    public void removeConsumableAction(Action action) {
        this.removeAction(action);
    }

    @Override
    public String description() {
        return this.toString();
    }

    @Override
    public void addSampleAction(Action newAction) {
        this.addAction(newAction);
    }

    @Override
    public void consumeAffect(Actor actor) {
        actor.addCapability(Status.FIRE);
        actor.addItemToInventory(this);
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

    @Override
    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor) {


        if(lifetime == 1 && renewTime == true ){
            this.count = 0;
            lifetime = 0;
        }

        new Display().println("Mario's FireAttack - " +(20-this.count)+ " turns remaining");
        if (this.count == 20) {
            actor.removeCapability(Status.FIRE);
            actor.removeItemFromInventory(this);
        }

        this.count += 1;
    }
}
