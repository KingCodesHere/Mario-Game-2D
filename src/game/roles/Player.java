package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.RandomRange;
import game.balance.ActorWallets;
import game.balance.ConvertCoinToWallet;
import game.balance.Wallet;
import game.balance.WalletsManager;
import game.item.Coin;


/**
 * Class representing the Player.
 */
public class Player extends Actor implements ActorWallets {
    private WalletsManager wallets = new WalletsManager();
    private final Menu menu = new Menu();
    private Coin coin;

    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addToWalletsManager();
    }

    public String Description() {
        return "Mario" + super.printHp();

    }

//    public void addWallet(Actor actor) {
//        this.wallets.addWallet(actor);
//    }
//
    public Wallet getPlayerWallet() {
        return WalletsManager.getInstance().getWalletHashMap().get(this);
    }

//    public void addCoinToWallet() {
//        getPlayerWallet().depositBalance(RandomRange.cashValue());
//    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        display.println(this.Description() + " at (" + map.locationOf(this).x() + "," + map.locationOf(this).y() + ")");
        display.println("wallet: $" + getPlayerWallet().getBalance()+ "\n" + this.getInventory());
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();
        if (this.hasCapability(Status.INVINCIBLE)) {
            display.println(this + " is invincible!");
        }

        // return/print the console menu
        return menu.showMenu(this, actions, display);
    }

    @Override
    public char getDisplayChar() {
        return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()) : super.getDisplayChar();
    }

//    @Override
//    public void checkCoin() {
//
//        for (Item item : this.getInventory()) {
//            if (item.toString().equals("Coin")) {
//                addCoinToWallet();
//                item.removeCapability(Status.COIN);
//                //item.togglePortability();
//                //this.removeItemFromInventory(item);
//            }
//        }
//    }

//    @Override
//    public void setWallet(double price) {
//        if (price< 0){
//
//        }
//
//    }
}