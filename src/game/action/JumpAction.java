package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.High;
import game.grounds.HighGround;
import game.roles.Status;
import java.util.Random;

public class JumpAction extends Action {
    protected String direction;
    protected Location jumpToLocation;


    public JumpAction(String direction, Location jumpToLocation) {
        this.direction = direction;
        this.jumpToLocation = jumpToLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String statement = "";
        HighGround highGround= (HighGround) jumpToLocation.getGround();
        Random random=new Random();
        if(actor.hasCapability(Status.TALL)){
            map.moveActor(actor, jumpToLocation);
            statement=actor + " jumped and is standing on top of " + highGround.getName();
        }
        else if(jumpToLocation.getGround().hasCapability(High.SPROUT)) {
            if (random.nextInt(1, 101) <= 90) {
                map.moveActor(actor, jumpToLocation);
                statement= actor + " jumped and is standing on top of " + highGround.getName();
            } else {
                actor.hurt(10);
                statement=actor+ " misses jump and gets hurt";

            }
        }
        else if(jumpToLocation.getGround().hasCapability(High.SAPLING)) {
            if (random.nextInt(1, 101) <= 80) {
                map.moveActor(actor, jumpToLocation);
                statement= actor + " jumped and is standing on top of " + highGround.getName();
            } else {
                actor.hurt(20);
                statement= actor+ " misses jump and gets hurt";
            }
        }
        else if(jumpToLocation.getGround().hasCapability(High.MATURE)) {
            if (random.nextInt(1, 101) <= 70) {
                map.moveActor(actor, jumpToLocation);
                statement= actor + " jumped and is standing on top of " + highGround.getName();
            } else {
                actor.hurt(30);
                statement= actor+ " misses jump and gets hurt";

            }
        }
        else if(jumpToLocation.getGround().hasCapability(High.WALL)) {
            if (random.nextInt(1, 101) <= 80) {
                map.moveActor(actor, jumpToLocation);
                statement= actor + " jumped and is standing on top of " + highGround.getName();
            } else {
                actor.hurt(20);
                statement= actor+ " misses jump and gets hurt";

            }
        }
        return statement;
    }

    @Override
    public String menuDescription(Actor actor) {
        HighGround highGround= (HighGround) jumpToLocation.getGround();
        return actor + " jumps to the " + direction + " " + highGround.getName();
    }

}

