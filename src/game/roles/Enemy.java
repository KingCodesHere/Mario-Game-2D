package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.SpeakAction;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.item.PowerStar;
import game.item.SuperMushroom;
import game.item.Wrench;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>();



    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

       return new DoNothingAction();
    }


}
