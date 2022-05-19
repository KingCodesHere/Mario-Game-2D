package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;

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


