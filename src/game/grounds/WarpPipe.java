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
import game.reset.Resettable;
import game.roles.enemies.PiranhaPlant;

import java.util.Arrays;
import java.util.List;

public class WarpPipe extends HighGround implements Resettable {
    /**
     * Checking if the resetAction has execute yet
     */
    private boolean checkStatus = false;

    /**
     * Only for the first round of the game
     */
    private boolean firstRound = true;

    /**
     * only can be reset for one time
     */
    private int resetTime = 1;
    /**
     * Constructor.
     *
     */
    public WarpPipe() {
        super('C');
        this.addCapability(High.WARPPIPE);
        this.registerInstance();
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

    @Override
    public void tick(Location location) {
        //reset
        if(this.checkStatus && this.resetTime==1){
            if(!location.containsAnActor()){
            PiranhaPlant piranhaPlant = new PiranhaPlant("Piranha Plant", 'Y', 200, 90, "chomps");
            location.addActor(piranhaPlant);
            this.resetTime = 0;}
        }
        if(this.firstRound){
            //location.addActor(new PiranhaPlant("Piranha Plant", 'Y', 150, 90, "chomps"));

            setFirstRound();
        };
    }

    /**
     * setting firstround to false
     */
    private void setFirstRound() {
        this.firstRound = false;
    }

    /**
     * call the resetInstance method the change the current status
     */
    @Override
    public void resetInstance() {
        this.checkStatus = true;
    }
}
