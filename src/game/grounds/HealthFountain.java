package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.bottles.BottleManager;
import game.item.HealingWater;


public class HealthFountain extends Fountain {
    /**
     * Constructor.
     *
     * 'H' character to display for this type of terrain
     */
    public HealthFountain() {
        super('H');
    }

    @Override
    public void groundAbility(Actor actor, GameMap map) {
        BottleManager.getInstance().getDrinkableBottleHashMap().get(actor).filledBottle(new HealingWater());
    }
    @Override
    public String groundDescription() {
        return "Healing water";
    }
}
