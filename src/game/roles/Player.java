package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.action.ResetAction;
import game.balance.ActorWallets;
import game.balance.Wallet;
import game.balance.WalletsManager;
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

    private int damage = 50000;
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
     * increasing the damage of actor after consuming powerwater
     * @param playerdamage
     */
    private void increaseDamageOfPowerWater(int playerdamage){
        if(this.hasCapability(Status.PowerWater)) {
            damage += playerdamage;
            this.removeCapability(Status.PowerWater);
        }
    }

    /**
     * String of the HP
     * @return mario Hp
     */
    public String description() {
        return "Mario" + this.printHp();
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
        resettingGame();
        // checking if player consumes power star
        isInvincible(display);
        // coordinate
        playerCoordinate(map, display);
        // wallet
        walletDetail(display);
        // IntrinsicDamage
        getIntrinsicDamage(display);

        // check if the player's hp is smaller than 0
        if(!this.isConscious()){
            map.removeActor(this);
        }

        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();


        // return/print the console menu
        return menu.showMenu(this, actions, display);
    }

    /**
     * reset the game
     */
    private void resettingGame() {
        if(this.checkStatus && this.resetTime==1){
            super.resetMaxHp(super.getMaxHp());
            this.resetTime = 0;
        }
    }

    /**
     * printing the damage to intrinsic
     * @param display
     */
    private void getIntrinsicDamage(Display display) {
        display.println("intrinsic attack damage: " +String.valueOf(getIntrinsicWeapon().damage()));
    }

    /**
     * printing the value of the wallet
     * @param display
     */
    private void walletDetail(Display display) {
        display.println("wallet: $" + getPlayerWallet().getBalance()+ "\n" +"Inventory: " +this.getInventory());
    }

    /**
     * player's coordinate
     * @param map map from game
     * @param display print
     */
    private void playerCoordinate(GameMap map, Display display) {
        display.println(this.description() + " at (" + map.locationOf(this).x() + "," + map.locationOf(this).y() + ")");
    }

    /**
     * checking if player is invincible
     * @param display
     */
    private void isInvincible(Display display) {
        if (this.hasCapability(Status.INVINCIBLE)) {
            display.println(this + " is invincible!");
        }
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

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
            this.increaseDamageOfPowerWater(15);
        return new IntrinsicWeapon(damage, "punches");
    }



}