package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.bottles.BottleManager;
import game.item.PowerWater;

public class PowerFountain extends Fountain {
    /**
     * Constructor.
     *
     * "A" character to display for this type of terrain
     */
    public PowerFountain() {
        super('A');
    }

    /**
     * groundAbility, it will add the water into the bottle
     * @param actor
     * @param map
     */
    @Override
    public void groundAbility(Actor actor, GameMap map) {
        BottleManager.getInstance().getDrinkableBottleHashMap().get(actor).filledBottle(new PowerWater());
    }

    @Override
    public String groundDescription() {
        return "Power water";
    }
}
