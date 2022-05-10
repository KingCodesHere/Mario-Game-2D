package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.ResetAction;
import game.balance.ActorWallets;
import game.balance.Wallet;
import game.balance.WalletsManager;
import game.bottles.Bottle;
import game.bottles.BottleManager;
import game.bottles.Drinkable;
import game.reset.Resettable;


/**
 * Class representing the Player.
 * @author Junhao Li, Ashston Sequira
 * @version 1.0.0
 */
public class Player extends Actor implements ActorWallets, Resettable, Drinkable {
    private final Menu menu = new Menu();
    /**
     * Checking if the resetAction has execute yet
     */
    private boolean checkStatus = false;

    /**
     * only can be reset for one time
     */
    private int resetTime = 1;

    private boolean allowReset = true;
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        super.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addToWalletsManager();
        this.registerInstance();
        this.setInstance();
        this.addItemToInventory(BottleManager.getInstance().getDrinkableBottleHashMap().get(this));

    }

    /**
     * String of the HP
     * @return mario Hp
     */
    public String description() {
        return "Mario" + super.printHp();
    }


    /**
     * The player's wallet
     * @return the address of player's wallet
     */
    public Wallet getPlayerWallet() {
        return WalletsManager.getInstance().getWalletHashMap().get(this);
    }

    /**
     * This playturn will be called by engine every turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Only reset for one time
        if(allowReset){
            actions.add(new ResetAction());
        }
        if(this.checkStatus && this.resetTime==1){
            super.resetMaxHp(super.getMaxHp());
//            resetCapability(capabilitiesList());
            this.resetTime = 0;
        }

        display.println(this.description() + " at (" + map.locationOf(this).x() + "," + map.locationOf(this).y() + ")");
        display.println("wallet: $" + getPlayerWallet().getBalance()+ "\n" +"Inventory: " +this.getInventory());
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();
        if (this.hasCapability(Status.INVINCIBLE)) {
            display.println(this + " is invincible!");
        }

        // return/print the console menu
        return menu.showMenu(this, actions, display);
    }

    /**
     * Checking if the player's inventory has mushroom
     * @return either upper case or lower case of getDisplayChar
     */
    @Override
    public char getDisplayChar() {
        return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()) : super.getDisplayChar();
    }

    /**
     * call the resetInstance method the change the current status
     */
    @Override
    public void resetInstance() {
        checkStatus = true;
        allowReset = false;
    }

}