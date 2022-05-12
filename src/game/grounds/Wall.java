package game.grounds;


/**
 * A class that represents walls which is within HigGround
 */
public class Wall extends HighGround {

	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
		this.addCapability(High.WALL);
	}
	@Override
	public String getName() {
		return "Wall";
	}



}
