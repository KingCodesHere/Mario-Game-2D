package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.action.TeleportAction;

import java.util.Arrays;
import java.util.List;

public class WarpPipe extends HighGround {

    /**
     * Constructor.
     *
     */
    public WarpPipe() {
        super('C');
        this.addCapability(High.WARPPIPE);
    }
    @Override
    public String getName() {
        return "Warp Pipe";
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        //gameMap.at(42,10).setGround(this);
        ActionList actionList=super.allowableActions(actor,location,direction);
        if(location.containsAnActor()){
            actionList.add(new TeleportAction(location));
        }
        return actionList;
    }

}
