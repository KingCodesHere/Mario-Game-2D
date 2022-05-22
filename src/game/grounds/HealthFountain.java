package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.bottles.BottleManager;
import game.item.HealingWater;

/**
 * Healing Fountain
 * @author Junhao Li
 * @version 1.0.0
 */
public class HealthFountain extends Fountain {
    /**
     * Constructor.
     *
     * 'H' character to display for this type of terrain
     */
    public HealthFountain() {
        super('H');
    }

    /**
     * Ground Ability for an instance of a bottle for the actor
     * @param actor the actor acting
     * @param map the map actor is on
     */
    @Override
    public void groundAbility(Actor actor, GameMap map) {
        BottleManager.getInstance().getDrinkableBottleHashMap().get(actor).filledBottle(new HealingWater());
    }
    /**
     * ground description
     * @return String of description
     */
    @Override
    public String groundDescription() {
        return "Healing water";
    }
}
