package game.roles.Allies;

import edu.monash.fit2099.engine.actors.Actor;
import game.roles.Status;

public abstract class NPC extends Actor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public NPC(String name, char displayChar, int hitPoints) {
        //hitPoints will not be used for NPC, therefore they are always at 9999999
        super(name, displayChar, hitPoints);
        this.addCapability(Status.NPC);
    }
}
