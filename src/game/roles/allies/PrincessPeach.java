package game.roles.allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.SpeakCapable;

import java.util.ArrayList;
import java.util.Random;

public class PrincessPeach extends NPC implements SpeakCapable {
    private ArrayList<String> statements = new ArrayList<>();
    private Random random = new Random();
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
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.count+=1;
        if(this.count%2==0){
            this.getStatement(this,this.statements.get(statements.size()),display);
        }
        return new DoNothingAction();
    }
}
