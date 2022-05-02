package game;

import java.util.Random;

public class RandomRange {
    public static int cashValue(){
        Random r = new Random();
        int low = 1000;
        int high = 20000;
        return (r.nextInt(high-low)+low);
    }

    public static int RandRange (int high){
        Random r = new Random();
        return (r.nextInt(high+1));
    }
}
