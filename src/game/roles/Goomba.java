package game.roles;

import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * A little fungus guy.
 */
public class Goomba extends Enemy {
	private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

	public Goomba() {
		super("Goomba", 'g', 50);
	}

}