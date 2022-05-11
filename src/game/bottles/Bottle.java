package game.bottles;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.ConsumeItemAction;
import game.bottles.BottleManager;
import game.bottles.Drinkable;
import game.item.Consumable;
import game.item.Water;

import java.util.ArrayList;
import java.util.List;

public class Bottle extends Item implements Consumable{
    /**
     * An array list to store the water
     */
    private ArrayList<Water> waterList= new ArrayList<Water>();

    /**
     * Consumable time
     */

    private boolean isEmpty = true;

    /***
     * Constructor.
     *
     */
    public Bottle() {
        super("Bottle", 'b', false);

    }

    /**
     * get rip of the water
     */
    private void drinkBottle(){
        waterList.remove(0);
    }

    /**
     * refilling the water bottle
     * @param water water from founatin
     */
    public void filledBottle(Water water){
        waterList.add(water);
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
    public void checkItem(Actor actor, GameMap map) {
        drinkBottle();
        consumeAffect(actor);
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
        return this.toString()+ waterList;
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

    @Override
    public void consumeAffect(Actor actor) {
        this.toString();
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
        System.out.println(waterList);
        if (!waterList.isEmpty()) {
            this.addSampleAction(this.consumeItem());
        }
        return super.getAllowableActions();
    }
}
