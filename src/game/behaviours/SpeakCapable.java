package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;

public interface SpeakCapable {
    default void getStatement(Actor actor,String statement,Display display){
        display.println(actor+": \""+ statement + "\"");
    }
}
