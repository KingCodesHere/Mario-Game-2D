package game.bottles;

public interface Drinkable {

    default void setInstance(){
        BottleManager.getInstance().appendResetInstance(this,new Bottle());
    }
}
