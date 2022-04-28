package game.grounds;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.*;
import game.roles.Goomba;

import java.util.Random;
public class Sprout extends Tree{
    private int count=0;

    public Sprout() {
        super('+');
        this.addCapability(High.SPROUT);
    } //Constructor

    @Override
    public String getName() {
        return "Sprout";
    }

    @Override
    public void tick(Location location) {
        this.count += 1;
        Random random= new Random();
        if (this.count == 10) {  //After every 10 turns sprout grows to sapling
            location.setGround(new Sapling());
        }
        else if((random.nextInt(1,101)<=10) && location.containsAnActor()==false) {
            location.addActor(new Goomba()); //After every turn,10% chance for Goomba to spawn and doesn't spawn if actor stands on it
        }
    }
}
