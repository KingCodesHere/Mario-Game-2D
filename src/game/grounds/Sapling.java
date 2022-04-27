package game.grounds;

import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class
Sapling extends Tree{
    private int count=0;
    public Sapling() {
        super('t');
    } //Constructor
    @Override
    public void tick(Location location) {
        count += 1;
        Random random = new Random();
        if (count == 10) {
            location.setGround(new Mature()); //Every 10 turns ,sapling turns to mature
        }
//        else if (random.nextInt(1, 101) <= 10) {
//            location.addItem(new Coin("Coin", '$', true)); //10% chance to drop coin
//        }
    }
}