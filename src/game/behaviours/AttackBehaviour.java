package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.behaviours.Behaviour;

import java.util.ArrayList;

public class AttackBehaviour extends Action implements Behaviour  {

    // TODO: develop and use it to attack the player automatically.//incomplete
    private final Actor target;

    public AttackBehaviour(Actor subject) {
        this.target = subject;

    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<Action>();

        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        NumberRange xs, ys;
        if (here.x() == there.x() || here.y() == there.y()) {
            xs = new NumberRange(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
            ys = new NumberRange(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

            for (int x : xs) {
                for (int y : ys) {
                    if(map.at(x, y).getGround().blocksThrownObjects())
                        return null;
                }
            }
            return this;
        }
        return null;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        return menuDescription(actor);
    }


    @Override
    public String menuDescription(Actor actor) {
        return "WaaaPow...";
    }
}
