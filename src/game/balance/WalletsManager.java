package game.balance;

import edu.monash.fit2099.engine.actors.Actor;
import java.util.HashMap;

public class WalletsManager {
    private HashMap<Actor, Wallet> wallets = new HashMap<>();

    public WalletsManager(){}

    public void addWallet(Actor actor){
        wallets.put(actor,new Wallet());
    }
    public Wallet getValue(Actor actor){
        return wallets.get(actor);
    }
}
