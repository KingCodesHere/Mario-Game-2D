package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.balance.Wallet;


/**
 * Class representing the Player.
 */
public class Player extends Actor  {
	private Wallet wallet;
	private final Menu menu = new Menu();
	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints, Wallet wallet) {
		super(name, displayChar, hitPoints);
		this.wallet = wallet;
		this.addCapability(Status.HOSTILE_TO_ENEMY);
	}

	public String Description(){
		return "Mario"+super.printHp();

	}


	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		display.println(this.Description()+" at ("+map.locationOf(this).x()+","+map.locationOf(this).y()+")");
		display.println("wallet: $"+ String.valueOf(wallet.getBalance()));
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		if (this.hasCapability(Status.INVINCIBLE)){
			display.println(this +" is invincible!" );
		}
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

}
