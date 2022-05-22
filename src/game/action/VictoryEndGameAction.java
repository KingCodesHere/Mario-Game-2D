package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class VictoryEndGameAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        return actor+ "rescued Princess Peach and are now heading back to the Mushroom Kingdom !" + "Victory!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor+ " rescue Princess Peach!";

    }
}
