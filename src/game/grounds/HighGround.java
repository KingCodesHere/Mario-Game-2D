package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.JumpAction;
import game.item.Coin;
import game.roles.Status;

public abstract class HighGround extends Ground {
    private String name;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public HighGround(char displayChar) {
        super(displayChar);
    }

    public String getName() {
        return name;
    }

    public void tick(Location location) {
        if (location.containsAnActor()) {
            convertToCoins(location);
        }
    }


    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()){
            return new ActionList();
        }
        else {
            return new ActionList(new JumpAction(direction, location));
        }
    }
    public void convertToCoins(Location location) {
        Dirt dirt = new Dirt();
        Coin coin = new Coin(5);
        //coin.addSampleAction(new PickUpCoinAction(coin, new Player("Player", 'm', 100)));
        location.setGround(dirt);
        location.addItem(coin);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.INVINCIBLE)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
