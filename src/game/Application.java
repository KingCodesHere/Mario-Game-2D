package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;

import game.roles.allies.Toad;
import game.roles.Player;


import java.util.Arrays;
import java.util.List;

/**
 * <h1>The Mario World game</h1>
 * The main class for the Mario World game.
 * <p>
 *     Giving detailed comments, it is high quality code
 * </p>
 *
 * @author Junhao Li, Kenda Wan, Ashton Sequeira
 * @version 1.0
 * @since 2022-05-02
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());
		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Sprout(),new WarpPipe(),new BlazingFire());

		List<String> map = Arrays.asList(
				"..........................................##..........+.........................",
				"............+............+..........C.......#...................................",
				"............................................#...................................",
				"......C......................................##......................+..........",
				"...............................................#........C.......................",
				"................................................#...............................",
				".................+.........................C......#.............................",
				".................................................##.............................",
				"................................................##..............................",
				".........+..................C...........+#____####.................+............",
				".......................................+#_____###++.............................",
				".......................................+#______###............C.................",
				"........................................+#_____###..............................",
				"........................+........................##.............+...............",
				"...................................................#............................",
				".........C..........................................#...........................",
				"...................+.................................#..........................",
				"......................................C...............#.........................",
				".......................................................##.......................");

		List<String> mapLava = Arrays.asList(
				"C..L.................#..................+...................",
				"L......L.L.....+.....#..........................L...........",
				".......L..L..........#.........#..............L.+.L.........",
				".........L...........#.........#...............L.L..........",
				".....................#.........#......+...............+.....",
				"...............#...............#.......+....................",
				"...............#..............................L.............",
				".........+.....#....+..........+...........L....L...........",
				"...............#............+..............L..+..L..........",
				".....L.........#...........................L..+..L..........",
				"....L.L....................................L....L...........",
				".....L................#.......+..............L.L............",
				"...........+..........#.....................................",
				"......................#................................+....",
				"..................+...#.................+...................");

		GameMap gameMap = new GameMap(groundFactory, map);
		GameMap gameMapLava=new GameMap(groundFactory,mapLava);
		world.addGameMap(gameMap);
		world.addGameMap(gameMapLava);
		Maps.setMapList(gameMap,gameMapLava);
		Actor mario = new Player("Player", 'm', 100);
		world.addPlayer(mario, gameMap.at(42, 10));
		gameMap.addActor(new Toad(),gameMap.at(43,11));

		world.run();



	}
}
