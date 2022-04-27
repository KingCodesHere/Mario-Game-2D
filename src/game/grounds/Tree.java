package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public abstract class Tree extends Ground implements HigherGround{
    private int age = 0;
    /**
     * Constructor.
     *
     */
    public Tree(char displayChar) {

        super('+');

    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
        if (age == 10)
            setDisplayChar('t');
        if (age == 20)
            setDisplayChar('T');
    }

}
