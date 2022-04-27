package game.roles;

import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Annoying Koopa Troopas
 */
public class Koopa extends Enemy {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    public Koopa() {
        super("Koopa", 'k', 50);

    }

    @Override
    public char getDisplayChar(){
        return this.hasCapability(Status.DORMANT) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
    }

}
