package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.reset.Resettable;

/**
  Tree ground of generic tree
 */
public abstract class Tree extends HighGround implements Resettable {
    /**
     * Checking if the resetAction has execute yet
     */
    private boolean checkStatus = false;

    /**
     * only can be reset for one time
     */
    private int resetTime = 1;

    /**
     * Constructor.
     * @return displayChar
     */
    public Tree(char displayChar) {
        super(displayChar);
        this.registerInstance();
    }

    /**
     * Setting the tree type to ground
     *
     * @param location tree's current location
     */
    public void setTreeToDirt(Location location) {
        if (RandomRange.RandRange(100) >= 50) {
            location.setGround(new Dirt());
        }
    }

    /**
     * getter for checkStatus
     *
     * @return true or false when checking status according to its constraints
     */
    public boolean getCheckStatus() {
        return this.checkStatus;
    }

    /**
     * getter for resetTime
     *
     * @return Reset times for resetting map
     */
    public int getResetTime() {
        return resetTime;
    }

    /**
     * setter for resetTime
     *
     * @param resetTime for time when resetting the map
     */
    public void setResetTime(int resetTime) {
        this.resetTime = resetTime;
    }

    /**
     * call the resetInstance method the change the current status
     */
    @Override
    public void resetInstance() {
        this.checkStatus = true;
    }


}
