package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * Water
 * @author Junhao Li
 * @version 1.0.0
 */
public abstract class Water extends Item{
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Water(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /***
     * implement the function of water
     */
    public abstract void waterFunction(Actor actor);
}
