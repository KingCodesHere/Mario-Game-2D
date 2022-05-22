package game.roles.allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.AttackAction;
import game.action.VictoryEndGameAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.SpeakCapable;
import game.roles.Status;

import java.util.ArrayList;
import java.util.Random;

/**
 * Princess Peach : handcuffed and held captive in Bowser's castle in the Lava Zone waiting to be saved.
 * Player will need to defeat Bowser to obtain a Golden Key which unlocks the handcuffs that will free Princess Peach.
 * @author Kenda Wan
 */
public class PrincessPeach extends NPC implements SpeakCapable {
    /**
     * An instance of ArrayList for statements from the SpeakCapable interface
     */
    private ArrayList<String> statements = new ArrayList<>();
    /**
     * count method to execute playTurn check
     */
    private int count=0;
    /**
     * The player's name via the Actor super class.
     */
    public PrincessPeach() {
        super("Princess Peach", 'P', 9999999);
        this.statements.add("Dear Mario, I'll be waiting for you...");
        this.statements.add("Never gonna give you up!");
        this.statements.add("Release me, or I will kick you!");
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        System.out.println("something");
        for (Exit exit : map.locationOf(otherActor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                if (otherActor.hasCapability(Status.KEY)) {
                        actions.add(new VictoryEndGameAction());

                        return actions;

                }
            }

        }

        return new ActionList();
    }

    /**
     * Princess Peach's playTurn to use the count to generate next Statement in even number.
     * @param actions required returnable actions for this actor
     * @param display the statement or action display
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.count+=1;
        if(this.count%2==0){
            this.getStatement(this,this.statements,display);
        }

        return new DoNothingAction();
    }
}
