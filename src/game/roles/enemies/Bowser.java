package game.roles.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomRange;
import game.action.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.item.Fire;
import game.item.GoldenKey;
import game.reset.Resettable;
import game.roles.Status;

import java.util.HashMap;
import java.util.Map;

public class Bowser extends Enemy implements Resettable {
    private final Location location;
    /**
     * List of behaviours in hashmap, organising the priority level
     */
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    /**
     * Constructor
     * the general Enemy constructor with set default behaviours
     */
    public Bowser(Location location) {
        super("Bowser", 'B', 1, 8, "punches");
        this.location = location;
    }

    /**
     * Allowable Actions for the Player, display hotkeys and has the ability to check map if otherActor is present.
     * Goomba has to vanish from the map 10% of chance in every turn, this is to clean the map and not over-crowd it
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        //attacks whenever possible, drops fire on ground lasting three turns, dealing 20 damage
        //if killed, a key will drop to unlock handcuffs, use KEY from STATUS ENUM
        ActionList actions = new ActionList();

        for (Exit exit : map.locationOf(this).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    //drops fire at random
                    Fire fire = new Fire();
                    destination.addItem(fire); // actor cannot be hurt by fire, princess peach cannot too
                    this.behaviours.put(1, new AttackBehaviour(otherActor, direction));
                    this.behaviours.put(2, new FollowBehaviour(otherActor));
                    actions.add(new AttackAction(this, direction));
                    return actions;
                }

            }


        }


        return actions;
    }
    /**
     * This playTurn override the parent class
     * Goomba will have playTurn of removing actor by checking its HP level.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the parent class: Enemy playTurn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // reset

        resetMethod(map);

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);

            if(action != null)
                return action;

        }

        if (!this.isConscious()) {
            map.locationOf(this).addItem(new GoldenKey());
            map.removeActor(this);
            System.out.println("something dies");
            return new DoNothingAction();
        }

        return new DoNothingAction();
    }

    /**
     * when user click the reset button
     * @param map map of the game
     */
    private void resetMethod(GameMap map) {
        if (super.getCheckStatus() && super.getResetTime() == 1) {
            if (this.isConscious() || this.getMaxHp() > 0) {
                System.out.println("something");
                super.resetMaxHp(super.getMaxHp());
                map.removeActor(this);
                map.addActor(this, this.location);
                this.resetMaxHp(super.getMaxHp());
                this.behaviours.clear();
                super.setResetTime(0);
            } else {
                map.addActor(this, this.location);
            }

        }
    }

    @Override
    /**\
     * if the actor got killed it will be removed on the map
     * @param map    gamemap
     * @param sentence print sentence
     * @return a sentence that is saying actor has been killed
     */
    public String getKilled(GameMap map, String sentence) {
        if (!this.isConscious()) {
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : this.getInventory())
                dropActions.add(item.getDropAction(this));
            for (Action drop : dropActions)
                drop.execute(this, map);
            // remove actor
            map.locationOf(this).addItem(new GoldenKey());
            map.removeActor(this);
            sentence += System.lineSeparator() + this + " is killed.";
        }
        return sentence;
    }

}
