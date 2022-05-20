package game.roles;

import edu.monash.fit2099.engine.actors.Actor;

public abstract class NPC extends Actor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public NPC(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
}
