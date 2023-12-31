package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.item.Coin;
import game.item.FireFlower;

import java.util.Random;

/**
 * Tree ground of Sprout type
 * @author  Ashton Sequeira
 */
public class Sapling extends Tree{
    private int count=0;
    /**
     * Constructor
     */
    public Sapling() {
        super('t');
        this.addCapability(High.SAPLING);
    }
    /**
     *
     * @return String with Sapling
     */
    @Override
    public String getName() {
        return "Sapling";
    }
    /**
     *
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if(super.getCheckStatus()&& super.getResetTime()==1){
            super.setTreeToDirt(location);
            super.setResetTime(0);
        }
        if (location.containsAnActor()) {
            convertToCoins(location);
        }
        count += 1;
        Random random = new Random();
        if (count == 10) {
            location.setGround(new MatureTree()); //Every 10 turns ,sapling turns to mature
            if ((RandomRange.RandRange(100) < 50)) {

                location.addItem(new FireFlower()); //After every turn, 50% chance for fireFlower to spawn
            }
        }
        if (RandomRange.RandRange(100) <= 10) {
            location.addItem(new Coin(20)); //10% chance to drop coin
        }
    }

}
