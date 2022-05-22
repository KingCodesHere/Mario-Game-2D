package game.grounds;


/**
 * A class that represents walls which is within HigGround
 * @author Ashton Sequria
 */
public class Wall extends HighGround {

	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
		this.addCapability(High.WALL);
	}

	/**
	 * getName
	 * @return String of name
	 */
	@Override
	public String getName() {
		return "Wall";
	}



}
