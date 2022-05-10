package game.bottles;

public interface Drinkable {
    void executeInstance();
    default void setInstance(){
        BottleManager.getInstance().appendResetInstance(this);
    }
}
