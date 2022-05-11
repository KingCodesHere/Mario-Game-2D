package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import game.bottles.Drinkable;

public class HealingWater extends Water  {
    /***
     * Constructor.
     */
    public HealingWater() {
        super("Healing Water", '2', false);

    }

    /***
     * implment the function of water
     */
    @Override
    public void waterFunction(Actor actor) {
        actor.heal(50);
    }
}
