package game.roles;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.AttackAction;
import game.action.SpeakAction;

public class Toad extends Actor {


    public Toad() {
        super("Toad", 'O', 99999999);
        this.addCapability(Status.NPC);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {


        return new DoNothingAction();

    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        actions.add(new SpeakAction());

        return actions;
    }




}
