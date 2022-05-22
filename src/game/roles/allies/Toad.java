package game.roles.allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.BuyAction;
import game.behaviours.Behaviour;
import game.behaviours.SpeakCapable;
import game.item.PowerStar;
import game.item.Purchasable;
import game.item.SuperMushroom;
import game.item.Wrench;
import game.roles.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Toad class: friendly guy who speaks to Mario and sells items
 *
 * @author Kenda Wan
 * @version 1.0.0
 */

public class Toad extends NPC implements SpeakCapable {

    /**
     * ArrayList to store speakable statements by this actor
     */
    private ArrayList<String> statements = new ArrayList<>();
    /**
     * count to generate return int for speakable statement
     */
    private int count=0;


    /**
     * Constructor.
     * The player's name via the Actor super class.
     */
    public Toad() {
        super("Toad", 'O', 99999999);
        this.statements.add("The Princess is depending on you! You are our only hope.");
        this.statements.add("Being imprisoned in these walls can drive a fungus crazy :( ");

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
        this.count+=1;
        if(this.count%2==0){
            if (this.hasCapability(Status.WRENCH)) {
                this.statements.add("You better get back to finding the Power Stars.");
                this.getStatement(this,this.statements,display);

            }else if (this.hasCapability(Status.INVINCIBLE)) {
                this.statements.add("You might need a wrench to smash Koopa's hard shells.");
                this.getStatement(this,this.statements,display);

            }else {
                this.statements.add("You better get back to finding the Power Stars.");
                this.statements.add("You might need a wrench to smash Koopa's hard shells.");
                this.getStatement(this,this.statements,display);
            }
        }

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
