package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.roles.Status;

import java.util.ArrayList;
import java.util.Random;

public class SpeakAction extends Action{

    private ArrayList<String> statement = new ArrayList<>();


    @Override
    public String execute(Actor actor, GameMap map) {

        statement.add("The Princess is depending on you! You are our only hope.");
        statement.add("Being imprisoned in these walls can drive a fungus crazy :( ");

        Random random = new Random();
        int index = 0;
            if (actor.hasCapability(Status.WRENCH)) {
                statement.add("You better get back to finding the Power Stars.");
                index = random.nextInt(statement.size());
                return statement.get(index);

            } else if (actor.hasCapability(Status.INVINCIBLE)) {
                statement.add("You might need a wrench to smash Koopa's hard shells.");
                index = random.nextInt(statement.size());
                return statement.get(index);
            }else {
                statement.add("You better get back to finding the Power Stars.");
                statement.add("You might need a wrench to smash Koopa's hard shells.");
                index = random.nextInt(statement.size());
                return statement.get(index);
            }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " speak to Toad" ;
    }

}
