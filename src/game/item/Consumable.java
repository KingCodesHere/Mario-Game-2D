package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import game.action.ConsumeItemAction;

public interface Consumable {
    ConsumeItemAction consumeItem();
    void itemFunction(Actor actor);


}
