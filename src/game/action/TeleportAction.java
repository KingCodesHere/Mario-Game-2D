package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.Application;
import game.Maps;
import game.grounds.*;
import game.roles.Player;
import game.roles.Toad;

import java.util.ArrayList;
import java.util.Map;

public class TeleportAction extends Action {
    private WarpPipe warpPipe;
    private Location warpPipeLocation;

    private Location tempWarpPipeLocation;
    public TeleportAction(Location warpPipeLocation) {
        this.warpPipeLocation=warpPipeLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String statement="";
        ArrayList<GameMap> gameMaps=Maps.getMapList();
        GameMap gameMapOriginal= gameMaps.get(0);
        GameMap gameMapLava=gameMaps.get(1);
        if (map==gameMapOriginal){
            map.moveActor(actor,gameMapLava.at(0,0));
            statement="Transporting to Lava Zone!";
            Maps.setPreviousLocation(this.warpPipeLocation);
        }
        else{
            this.tempWarpPipeLocation=Maps.getPreviousLocation();
            map.moveActor(actor,gameMapOriginal.at(tempWarpPipeLocation.x(), tempWarpPipeLocation.y()));
            statement="Going Back!!";
        }
        return statement;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor+" teleports to map.";
    }
}
