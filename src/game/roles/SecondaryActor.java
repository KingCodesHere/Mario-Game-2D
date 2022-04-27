package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public abstract class SecondaryActor extends Actor {
//    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
//    private Random random = new Random();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public SecondaryActor(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

}
