package game.roles.Allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.BuyAction;
import game.action.SpeakAction;
import game.item.PowerStar;
import game.item.Purchasable;
import game.item.SuperMushroom;
import game.item.Wrench;
import game.roles.Status;

/**
 * Toad class: friendly guy who speaks to Mario and sells items
 *
 * @author Kenda Wan
 * @version 1.0.0
 */

public class Toad extends NPC{


    /**
     * The player's name via the Actor super class.
     */
    public Toad() {
        super("Toad", 'O', 99999999);
    }

    /**
     * This playturn overrites the parent class
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the do nothing as a result of not gaining interaction with other player
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return new DoNothingAction();
    }



    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

        ActionList actions = new ActionList();


        for (Exit exit : map.locationOf(otherActor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                actions.add(new SpeakAction("Toad"));
                items(actions,new Wrench(),new SuperMushroom(),new PowerStar());

                return actions;
            }

        }
        return new ActionList();
    }

    /**
     * For loop to loop through all the items that have been added into the action
     * @param actions   action
     * @param itemTypes Purchasable
     */
    public void items(ActionList actions, Purchasable... itemTypes) {
        for (Purchasable item : itemTypes) {
            try {
                actions.add(new BuyAction(item));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
