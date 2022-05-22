package game.bottles;

import java.util.HashMap;

/**
 * A global Singleton manager that store all the water on the instances.
 * * @author Junhao Li
 *  * @version 1.0.0
 */
public class BottleManager {
    /**
     * A list of resettable instances (any classes that implements drinkable,
     * such as Player fills water will be stored in here)
     */
    private HashMap<Drinkable,Bottle> drinkableBottleHashMap;

    /**
     * A singleton reset manager instance
     */
    private static BottleManager instance;

    /**
     * Get the singleton instance of bottle manager
     * @return bottleManager singleton instance
     */
    public static BottleManager getInstance(){
        if(instance == null){
            instance = new BottleManager();
        }
        return instance;
    }

    /**
     * Constructor
     */
    private BottleManager(){
        drinkableBottleHashMap = new HashMap<>();
    }


    /**
     * Add the Resettable instance to the list
     * FIXME: it does nothing, you need to implement it :)
     */
    public void appendResetInstance(Drinkable actor,Bottle bottle){
        this.drinkableBottleHashMap.put(actor, bottle);
    }

    /**
     * Remove a Drinkable instance from the list
     * @param drink Drinkable object
     * FIXME: it does nothing, you need to implement it :)
     */
    public void cleanUp(Drinkable drink){
        this.drinkableBottleHashMap.remove(drink);

    }
    /**
     * get the hashmap
     * @return hashmap
     */
    public  HashMap<Drinkable, Bottle> getDrinkableBottleHashMap(){
        return new  HashMap<Drinkable,Bottle>(this.drinkableBottleHashMap);
    }
}
