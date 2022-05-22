package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
/**
 * Class representing second map: Lava Zone
 *
 * @author Ashton S.
 * The system can have multiple maps, and Actors can move between them. Only the
 * map that the player is currently on will be displayed, but Actors on all maps
 * will be queried on each turn for their moves -- that is, time does not stop
 * when the player leaves a map.
 *
 * It's important to put the GameMap in the World before using it.
 */
public class Maps {
    private static ArrayList<GameMap> gameMaps;
    private static Location previousLocation;
    public Maps() {
    }

    public static void setMapList(GameMap... gameMapss){
        ArrayList<GameMap> maps= new ArrayList<>();
        for(GameMap gameMap : gameMapss){
            maps.add(gameMap);
        }
        gameMaps=maps;
    }
    public static ArrayList<GameMap> getMapList(){
        return gameMaps;
    }
    public static void setPreviousLocation(Location location){
        previousLocation=location;
    }
    public static Location getPreviousLocation(){
        return previousLocation;
    }
}


