package game.balance;

public interface ActorWallets {
    //public void setWallet(double price);

    default void addToWalletsManager(){
        WalletsManager.getInstance().appendWalletItem(this,new Wallet());}

}
