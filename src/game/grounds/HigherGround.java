package game.grounds;
import edu.monash.fit2099.engine.positions.Location;
import game.item.Coin;
import game.roles.Player;

public interface HigherGround {
    default void convertToCoins(Location location) {
        Dirt dirt = new Dirt();
        Coin coin = new Coin();
        location.setGround(dirt);
        location.addItem(coin);
    }

}
