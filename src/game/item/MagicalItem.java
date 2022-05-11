package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ConsumeItemAction;
import game.reset.Resettable;

import java.util.List;

public class MagicalItem extends Item implements Consumable, Purchasable, Resettable {

    /**
     * Consumable time
     */
    private int lifetime = 1;

    /**
     * Checking if the resetAction has execute yet
     */
    private boolean checkStatus = false;


    /**
     * only can be reset for one time
     */
    private int resetTime = 1;

    /**
     * Checking if the item checks in actor inventory
     */
    private boolean isExist = false;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public MagicalItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        this.registerInstance();
    }

    /**
     * getter for checkStatus
     *
     * @return
     */
    public boolean isCheckStatus() {
        return checkStatus;
    }

    public int getResetTime() {
        return resetTime;
    }

    /**
     * setter for resetTime
     *
     * @param resetTime
     */
    public void setResetTime(int resetTime) {
        this.resetTime = resetTime;
    }


    /**
     * add the action
     *
     * @param newAction action
     */
    public void addSampleAction(Action newAction) {
        this.addAction(newAction);
    }

    @Override
    public void consumeAffect(Actor actor) {

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
     * This check if the item is in the actor inventory
     * @param actor
     */
    @Override
    public void checkItem(Actor actor, GameMap map,Action action) {
        for (Item items : actor.getInventory()) {
            if (items == this) {
                isExist = true;
            }
        }
        if (isExist) {
            this.consumeAffect(actor);
        } else {
            actor.addItemToInventory(this);
            map.locationOf(actor).removeItem(this);
            this.consumeAffect(actor);
        }
        this.removeConsumableAction(action);
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
     * @return name of the item
     */
    @Override
    public String description() {

        return this.toString();
    }

    /**
     * get price
     *
     * @return 0 nothing for the abstruct class
     */
    @Override
    public int getPrice() {
        return 0;
    }

    /**
     * call the resetInstance method the change the current status
     */
    @Override
    public void resetInstance() {
        this.checkStatus = true;
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
        if (this.checkStatus && this.resetTime == 1) {
            actor.removeItemFromInventory(this);
            this.resetTime = 0;
        }
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
