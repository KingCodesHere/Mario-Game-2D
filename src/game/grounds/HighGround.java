package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.JumpAction;
import game.item.Coin;
import game.roles.Status;

/**
 * HighGround class is an abstract class that extend Ground
 * @author Ashton Sequeira,Junhao Li
 * @version 1.0.0
 */
public abstract class HighGround extends Ground {
    private String name;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public HighGround(char displayChar) {
        super(displayChar);
    }

    /**
     * Returns the name of the HighGround
     * @return String of the type of High Ground
     */

    public String getName() {
        return name;
    }
    /**
     * Returns an empty Action list.
     * @author Ashton Sequeira
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()){
            if(actor.hasCapability(Status.INVINCIBLE)){
            convertToCoins(location);}
            return new ActionList();
        }

        else {
            return new ActionList(new JumpAction(direction, location));
        }
    }

    /**
     * Convert the HighGround to coin.
     * @author Junhao Li
     * @param location Location of highground
     */

    public void convertToCoins(Location location) {
        location.setGround(new Dirt());
        location.addItem(new Coin(5));
    }

    /**
     * canActorEnter return true if the actor is invincible
     * @author Junhao Li, Ashton Sequeira
     * @param actor the Actor to check
     * @return true if the Actor can enter this location
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.INVINCIBLE)) { //checks for PowerStar
            return true;
        } else {
            return false;
        }
    }

}
