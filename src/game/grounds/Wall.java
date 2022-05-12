package game.grounds;



public class Wall extends HighGround {
	/**
	 * A class that represents walls which is within HigGround
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
