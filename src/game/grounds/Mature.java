package game.grounds;

import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.roles.Status;

import java.util.ArrayList;
import java.util.Random;

public class Mature extends Tree {
    private int count=0;
    public Mature() {
        super('T');
    }
    public void tick(Location location) {
        this.count += 1;
        ActorLocationsIterator actorLocationsIterator = new ActorLocationsIterator();
        Random random = new Random();
        ArrayList<Location> locationArrayList=new ArrayList<>();
        if (this.count == 5) { // setGround
            for (Exit exit : location.getExits()) {
                Location destination = exit.getDestination();
                if (destination.getGround().hasCapability(Status.FERTILE)) { //checks if neighbouring ground is fertile
                    locationArrayList.add(destination);
                }
            }
            int index= random.nextInt(locationArrayList.size());
            Location newSproutLocation=locationArrayList.get(index);  //randomly chooses a fertile ground location
            newSproutLocation.setGround(new Sprout());
        }
//        else if (random.nextInt(1, 101) <= 15 && actorLocationsIterator.isAnActorAt(location)==false) {
//            actorLocationsIterator.add(new Koopa(), location); //After every turn,15% chance for Koopa to spawn and doesn't spawn if actor stands on it
//        } else if (random.nextInt(1, 101) <= 20) { //20% chance for Mature to turn to Dirt
//            location.setGround(new Dirt());
//        }
    }
}