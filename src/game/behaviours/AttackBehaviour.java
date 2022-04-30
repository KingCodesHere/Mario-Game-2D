package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.behaviours.Behaviour;
import game.roles.Status;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Random;

public class AttackBehaviour extends Action implements Behaviour  {

    private final Actor target;
    private final Random random = new Random();

    public AttackBehaviour(Actor subject) {
        this.target = subject;

    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Behaviour> behaviours = new ArrayList<Behaviour>();


        return null;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
