package game.roles.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public class Bowser extends Enemy {
    /**
     * Constructor
     * the general Enemy constructor with set default behaviours
     *
     * @param name         for this current Enemy name
     * @param displayChar  the display of character on map this enemy carry
     * @param hitPoints    the hit point of this enemy
     * @param attackDamage the damage this enemy carries
     * @param verb         the verb that will display for the enemy when the attack occur
     */
    public Bowser(String name, char displayChar, int hitPoints, int attackDamage, String verb) {
        super("Bowser", 'B', 500, 80, "punches");
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
        //attacks whenever possible, drops fire on ground lasting three turns, dealing 20 damage
        //if killed, a key will drop to unlock handcuffs, use KEY from STATUS ENUM

    }
}
