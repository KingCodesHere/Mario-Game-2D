package game.grounds;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.*;
import game.RandomRange;
import game.roles.Goomba;

import java.util.Random;
/**
 * @author  Ashton Sequeira
 * Tree ground of Sprout type
 */
public class Sprout extends Tree{
    private int count=0;

    /**
     * Constructor
     */
    public Sprout() {
        super('+');
        this.addCapability(High.SPROUT);
    }

    /**
     *
     * @return String with Sprout
     */

    @Override
    public String getName() {
        return "Sprout";
    }
    /**
     *
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
     */

    @Override
    public void tick(Location location) {
        this.count += 1;
        if (this.count == 10) {  //After every 10 turns sprout grows to sapling
            location.setGround(new Sapling());
        }
        else if((RandomRange.RandRange(100)<=10) && location.containsAnActor()==false) {
            location.addActor(new Goomba()); //After every turn,10% chance for Goomba to spawn and doesn't spawn if actor stands on it
        }
    }

}
