package game.grounds;



public class Wall extends HighGround {
	public Wall() {
		super('#');
		this.addCapability(High.WALL);
	}
	@Override
	public String getName() {
		return "Wall";
	}



}
