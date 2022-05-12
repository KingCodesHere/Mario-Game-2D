package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;

/**
 * Reset Action to control the overall inheritable reset run with its hot key for display
 */
public class ResetAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run();
        return actor + " has reset the game";
    }

    @Override
    public String menuDescription(Actor actor) {

        return actor+ " reset the game ";
    }


    /**
     * Returns the key used in the menu to trigger this Action.
     *
     * There's no central management system for this, so you need to be careful not to use the same one twice.
     * See https://en.wikipedia.org/wiki/Connascence
     *
     * @return The key we use for this Action in the menu, or null to have it assigned for you.
     */
    @Override
    public String hotkey() {
        return "r";
    }
}
