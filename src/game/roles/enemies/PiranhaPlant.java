package game.roles.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import game.action.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;

import game.behaviours.SpeakCapable;
import game.roles.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Piranha Plant will hurt Mario heavily if near!
 * @author Kenda Wan
 */
public class PiranhaPlant extends Enemy implements SpeakCapable {
    /**
     * List of behaviours in hashmap, organising the priority level
     */
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
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
     *
     *
     * @param name         for this current Enemy name
     * @param displayChar  the display of character on map this enemy carry
     * @param hitPoints    the hit point of this enemy
     * @param attackDamage the damage this enemy carries
     * @param verb         the verb that will display for the enemy when the attack occur
     */
    public PiranhaPlant(String name, char displayChar, int hitPoints, int attackDamage, String verb) {
        super("Piranha Plant", 'Y', 150, 90, "chomps");
        this.statements.add("Slsstssthshs~! (Never gonna say goodbye~)");
        this.statements.add("Ohmnom nom nom nom.");

    }

    /**
     * Allowable Actions for the Player, display hotkeys and has the ability to check map if otherActor is present.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();


        for (Exit exit : map.locationOf(this).getExits()) {

            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    this.behaviours.put(1, new AttackBehaviour(otherActor, direction));
                    actions.add(new AttackAction(this, direction));
                    return actions;
                }
            }

        }

        return actions;
    }
    /**
     * This playTurn override the parent class
     * PiranhaPlant will have playTurn of removing actor by checking its HP level.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the parent class: Enemy playTurn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.count+=1;
        if(this.count%2==0){
            this.getStatement(this,this.statements,display);
        }
        if (!this.isConscious() || this.getMaxHp() <= 0) {
            map.removeActor(this);
            return new DoNothingAction();
        }
        // reset
        if (super.getCheckStatus() && super.getResetTime() == 1) {
            this.increaseMaxHp(50); //  adding 50
            super.setResetTime(0);
        }

        return new DoNothingAction();

    }


}
