package game;
import java.util.Random;
public class RandomRange {
    public static int cashValue(){
        Random r = new Random();
        int low = 1000;
        int high = 10000;
        return (r.nextInt(high - low) + low);
    }
    public static int RandRange(int low, int high){
        Random r = new Random();
        return (r.nextInt(high - low) + low);
    }
}
