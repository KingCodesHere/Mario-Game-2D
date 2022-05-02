package game.balance;
/**
 * Interface for ActorWallets
 * @author Junhao Li
 * @version 1.0.0
 */
public interface ActorWallets {

    /**
     * default method to add a new wallet to the actor
     */
    default void addToWalletsManager(){
        WalletsManager.getInstance().appendWalletItem(this,new Wallet());}

}
