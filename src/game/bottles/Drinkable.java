package game.bottles;

/**
 * interface for actor to drink water
 * @author Junhao Li
 * @version 1.0.0
 */
public interface Drinkable {

    default void setInstance(){
        BottleManager.getInstance().appendResetInstance(this,new Bottle());
    }
}
