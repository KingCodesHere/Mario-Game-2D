package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public interface SpeakCapable {
    Random random=new Random();
    default void getStatement(Actor actor, ArrayList<String> arrayList, Display display){
        display.println(actor+": \""+ arrayList.get(random.nextInt(arrayList.size())) + "\"");
    }
}
