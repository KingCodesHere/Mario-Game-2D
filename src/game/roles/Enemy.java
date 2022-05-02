package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.action.AttackAction;
import game.action.SpeakAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.item.PowerStar;
import game.item.SuperMushroom;
import game.item.Wrench;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Enemy extends Actor {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>();
    private String verb;
    private int attackDamage;


    public String getVerb() {
        return verb;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public Enemy(String name, char displayChar, int hitPoints, int attackDamage, String verb) {
        super(name, displayChar, hitPoints);
        this.attackDamage=attackDamage;
        this.verb=verb;
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.behaviours.put(3, new WanderBehaviour());
        this.behaviours.put(1, new AttackBehaviour());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious() || this.getMaxHp() <= 0) {
            map.removeActor(this);
        } else {
            for (Behaviour behaviour : behaviours.values()) {
                Action action = behaviour.getAction(this, map);
                return action;
            }
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions=new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && this.isConscious()){
            actions.add(new AttackAction(this,direction));
            this.behaviours.put(3,new FollowBehaviour(otherActor));

        }
        return actions;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(attackDamage,verb);
    }
}

