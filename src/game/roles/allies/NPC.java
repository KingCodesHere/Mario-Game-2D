package game.roles.allies;

import edu.monash.fit2099.engine.actors.Actor;
import game.roles.Status;

/**
 * Non Playable Characters, that are friendly toward Player
 * A general abstract class containing the standard capability to be extended by child classes
 * @author Kenda Wan
 */
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
