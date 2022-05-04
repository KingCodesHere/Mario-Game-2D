package game.balance;
import java.util.HashMap;

/**
 * WalletsManager stores all the actor and
 * @author Junhao Li
 * @version 1.0.0
 */
public class WalletsManager {
    /**
     * Hashmap
     */
    private HashMap<ActorWallets,Wallet> walletHashMap;
    /**
     * a static instance of walletsmanager
     */
    private static WalletsManager instance;

    /**
     * constructor of the wallet
     */
    public WalletsManager(){walletHashMap = new HashMap<>();}

    /**
     * static factory method that generate a new instance if instance = null
     * @return
     */
    public static WalletsManager getInstance(){
        if(instance == null){
            instance = new WalletsManager();
        }
        return instance;
    }

    /**
     * add a new wallet to the hashmap
     * @param actor
     * @param wallet
     */
    public void appendWalletItem(ActorWallets actor,Wallet wallet){
        this.walletHashMap.put(actor,wallet);
    }

    /**
     * get the hashmap
     * @return hashmap
     */
    public  HashMap<ActorWallets,Wallet> getWalletHashMap(){
        return new  HashMap<ActorWallets,Wallet>(this.walletHashMap);
    }
}
