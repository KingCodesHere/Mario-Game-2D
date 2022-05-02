package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomRange;
import game.item.SuperMushroom;

public class DestroyShellAction extends Action {
    private Actor target;

    public DestroyShellAction(Actor target) {
        this.target=target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if(RandomRange.RandRange(100)<=80) {
            map.removeActor(target);
            map.locationOf(target).addItem(new SuperMushroom());
            return "Destroyed Koopa's Shell";
        }
        return actor+ " misses and couldn't destroy Koopa's Shell";

    }

    @Override
    public String menuDescription(Actor actor) {
        return "Destroy Koopa's Shell ";
    }
}

