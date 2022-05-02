package game.grounds;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.roles.Koopa;
import game.roles.Status;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author  Ashton Sequeira
 * Tree ground of Mature type
 */
public class Mature extends Tree {
    private int count=0;
    /**
     * Constructor
     */
    public Mature() {
        super('T');
        this.addCapability(High.MATURE);
    }

    /**
     *
     * @return String with Mature
     */
    @Override
    public String getName() {
        return "Mature";
    }

    /**
     *
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.count += 1;
        Random random = new Random();
        ArrayList<Location> locationArrayList=new ArrayList<>();
        if (this.count >= 5 && this.count%5==0) { // setGround
            for (Exit exit : location.getExits()) {
                Location destination = exit.getDestination();
                if (destination.getGround().hasCapability(Status.FERTILE)) { //checks if neighbouring ground is fertile
                    locationArrayList.add(destination);
                }
            }
            int index= random.nextInt(locationArrayList.size());
            Location newSproutLocation=locationArrayList.get(index);  //randomly chooses a fertile ground location
            newSproutLocation.setGround(new Sprout());

        } else if ((RandomRange.RandRange(100)) <= 15 && !location.containsAnActor()) {
            location.addActor(new Koopa()); //After every turn,15% chance for Koopa to spawn and doesn't spawn if actor stands on it
        } else if (RandomRange.RandRange(100) <= 20) { //20% chance for Mature to turn to Dirt
            location.setGround(new Dirt());
        }
    }

}
