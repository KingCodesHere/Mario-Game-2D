package game.bottles;
import java.util.ArrayList;
import java.util.List;

/**
 * A global Singleton manager that store all the water on the instances.
 */
public class BottleManager {
    /**
     * A list of resettable instances (any classes that implements drinkable,
     * such as Player fills water will be stored in here)
     */
    private List<Drinkable> drinkableList;

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
        drinkableList = new ArrayList<>();
    }

    /**
     * Reset the game by traversing through all the list
     * By doing this way, it will avoid using `instanceof` all over the place.
     */
    public void run(){
        for(Drinkable drink: this.drinkableList){
            drink.executeInstance();
        }
        System.out.println(instance.drinkableList);
    }

    /**
     * Add the Resettable instance to the list
     * FIXME: it does nothing, you need to implement it :)
     */
    public void appendResetInstance(Drinkable drink){
        this.drinkableList.add(drink);
    }

    /**
     * Remove a Drinkable instance from the list
     * @param drink Drinkable object
     * FIXME: it does nothing, you need to implement it :)
     */
    public void cleanUp(Drinkable drink){
        this.drinkableList.remove(drink);
    }
}
