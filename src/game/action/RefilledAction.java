package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.RefilledAble;


public class RefilledAction extends Action {
    /**
     * refilled ground
     */
    private final RefilledAble ground;


    /**
     * Constructor.
     *
     * @param ground the ground to refilled
     */
    public RefilledAction(RefilledAble ground) {
        this.ground = ground;
    }

    /**
     * Executing the consuming action for the particular item
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ground.groundAbility(actor,map);
        return menuDescription(actor);
    }
    /**
     * return the actor consumes item sentence
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " refill the " + ground.groundDescription();
    }
}
