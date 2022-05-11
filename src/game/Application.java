package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Sprout;
import game.grounds.Wall;
import game.item.Coin;
import game.roles.Enemy;
import game.roles.Player;
import game.roles.Toad;

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

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Sprout());

			List<String> map = Arrays.asList(
				"..........................................##..........+.........................",
				"............+............+..................#...................................",
				"............................................#...................................",
				".............................................##......................+..........",
				"...............................................#................................",
				"................................................#...............................",
				".................+................................#.............................",
				".................................................##.............................",
				"................................................##..............................",
				".........+..............................+#____####.................+............",
				".......................................+#_____###++.............................",
				".......................................+#______###..............................",
				"........................................+#_____###..............................",
				"........................+........................##.............+...............",
				"...................................................#............................",
				"....................................................#...........................",
				"...................+.................................#..........................",
				"......................................................#.........................",
				".......................................................##.......................");

			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);
			Actor mario = new Player("Mario", 'm', 100);
			world.addPlayer(mario, gameMap.at(42, 10));
			gameMap.addActor(new Toad(),gameMap.at(43,11));

			Coin coin = new Coin(400);
			gameMap.at(41,11).addItem(coin);

			world.run();



	}
}
