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

public class FireFlower extends Item implements Consumable {
    /**
     * Consumable time
     */
    private int lifetime = 1;

    /**
     * counter
     */
    private int count;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public FireFlower(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    @Override
    public ConsumeItemAction consumeItem() {
        return new ConsumeItemAction(this);
    }

    @Override
    public void checkItem(Actor actor, GameMap map, Action action) {
        consumeAffect(actor);
    }

    @Override
    public void removeConsumableAction(Action action) {
        this.removeConsumableAction(action);
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
        if(super.isCheckStatus() && super.getResetTime()==1){
            actor.removeItemFromInventory(this);
            actor.removeCapability(Status.INVINCIBLE);
            super.setResetTime(0);
        }
        if(lifetime == 1 && renewTime == true ){
            this.count = 0;
            lifetime = 0;
        }

        new Display().println("Mario's FireAttack - " +(20-this.count)+ " turns remaining");
        if (this.count == 20) {
            actor.removeCapability(Status.FIRE);
        }


    }
}
