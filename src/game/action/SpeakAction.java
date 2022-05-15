package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.roles.Status;

import java.util.ArrayList;
import java.util.Random;

/**
 * SpeakAction class is a allows actor to return random (with conditions) statements as outputs
 * in this case, Toad uses SpeakAction
 * @author Kenda Wan
 * @version 1.0.0
 */
public class SpeakAction extends Action{

    /**
     * List of statement to output
     * */
    private ArrayList<String> statement = new ArrayList<>();

    /**
     * The friend that will use this method.
     * */
    private final String friend;


    /**
     * Constructor.
     *
     * @param friend the friend that is talking.
     */
    public SpeakAction(String friend) {
        this.friend = friend;
    }


    /**
     * execute the speak action when actor press the hotkey
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return statement of the friend in random
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String speaks = friend+ ": ";

        statement.add(speaks+"The Princess is depending on you! You are our only hope.");
        statement.add(speaks+"Being imprisoned in these walls can drive a fungus crazy :( ");

        Random random = new Random();

            if (actor.hasCapability(Status.WRENCH)) {
                statement.add(speaks+"You better get back to finding the Power Stars.");
                return statement.get(random.nextInt(statement.size()));

            }else if (actor.hasCapability(Status.INVINCIBLE)) {
                statement.add(speaks+"You might need a wrench to smash Koopa's hard shells.");
                return statement.get(random.nextInt(statement.size()));

            }else {
                statement.add(speaks+"You better get back to finding the Power Stars.");
                statement.add(speaks+"You might need a wrench to smash Koopa's hard shells.");
                return statement.get(random.nextInt(statement.size()));
            }
    }

    /**
     * return the actor speak sentence
     * @param actor The actor performing the action.

     * @return the actor who will speak to the friend
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " speak to " + friend;
    }

}
