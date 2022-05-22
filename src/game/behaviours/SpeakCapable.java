package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;

import java.util.ArrayList;
import java.util.Random;
/**
 * Speak Capable Interface for actor classes to implement for ability to speak statements
 * @author Ashton Sequira & Kenda Wan
 */

/**
 * public method SpeakCapable
 *
 */
public interface SpeakCapable {
    Random random=new Random();
    /**
     * void getStatement that returns random int to print one statement within the size of the arrayList
     * @param actor the actor using this method
     * @param arrayList to store the statements the actor will have
     * @param display to display the return statement
     */
    default void getStatement(Actor actor, ArrayList<String> arrayList, Display display){
        display.println(actor+": \""+ arrayList.get(random.nextInt(arrayList.size())) + "\"");
    }
}
