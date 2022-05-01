package game.balance;
import java.util.HashMap;

public class WalletsManager {
    private HashMap<ActorWallets,Wallet> walletHashMap;

    private static WalletsManager instance;
    public WalletsManager(){walletHashMap = new HashMap<>();}

    public static WalletsManager getInstance(){
        if(instance == null){
            instance = new WalletsManager();
        }
        return instance;
    }

    public void appendWalletItem(ActorWallets actor,Wallet wallet){
        this.walletHashMap.put(actor,wallet);
    }

    public  HashMap<ActorWallets,Wallet> getWalletHashMap(){
        return new  HashMap<ActorWallets,Wallet>(this.walletHashMap);
    }
}
