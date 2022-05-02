package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.roles.Status;

import java.util.ArrayList;
import java.util.Random;

public class SpeakAction extends Action{

    private ArrayList<String> statement = new ArrayList<>();
    private final String friend;

    public SpeakAction(String friend) {
        this.friend = friend;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String speaks = friend+": ";

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " speak to " +friend;
    }

}
