package game;

import java.util.Random;

/**
 * @author Junhao Li
 * Generates Random Values whereever required
 */

public class RandomRange {
    /**
     *  Return random value for coin
     * @return random int value from low to high
     */
    public static int cashValue(){
        Random r = new Random();
        int low = 5;
        int high = 1000;
        return (r.nextInt(high-low)+low);
    }
    /**
     *  Returns random value
     * @return random int value till high
     */
    public static int RandRange (int high){
        Random r = new Random();
        return (r.nextInt(high));
    }
}
