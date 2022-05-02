package game.roles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.BuyAction;

import game.action.SpeakAction;
import game.item.PowerStar;
import game.item.Purchasable;
import game.item.SuperMushroom;
import game.item.Wrench;

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


        for (Exit exit : map.locationOf(otherActor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                actions.add(new SpeakAction("Toad"));
                items(actions,new Wrench(),new SuperMushroom(),new PowerStar());
                return actions;
            }

        }
        return new ActionList();
    }

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
