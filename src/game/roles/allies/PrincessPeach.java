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

public class PrincessPeach extends NPC implements SpeakCapable {
    private ArrayList<String> statements = new ArrayList<>();
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

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.count+=1;
        if(this.count%2==0){
            this.getStatement(this,this.statements,display);
        }

        return new DoNothingAction();
    }
}
