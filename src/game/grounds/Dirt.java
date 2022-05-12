package game.grounds;
import edu.monash.fit2099.engine.positions.Ground;
import game.roles.Status;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	/**
	 * Constructor for Dirt Class
	 */
	public Dirt() {
		super('.');
		addCapability(Status.FERTILE);
	}
}
