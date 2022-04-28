package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.balance.Wallet;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Tree;
import game.grounds.Wall;
import game.item.Coin;
import game.item.PowerStar;
import game.item.SuperMushroom;
import game.roles.Goomba;
import game.roles.Player;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree());

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
		    //Wallet wallet = new Wallet();
			Actor mario = new Player("Player", 'm', 100);
			((Player) mario).addWallet(mario);

			world.addPlayer(mario, gameMap.at(42, 10));
			// FIXME: the Goomba should be generated from the Tree
			gameMap.at(35, 10).addActor(new Goomba());
			SuperMushroom superMushroom = new SuperMushroom();
			superMushroom.addSampleAction(superMushroom.consumeItem(mario));
			gameMap.at(42, 10).addItem(superMushroom);

			PowerStar powerStar = new PowerStar();
			powerStar.addSampleAction(powerStar.consumeItem(mario));
			gameMap.at(43, 10).addItem(powerStar);


			Coin coin = new Coin();
			coin.addSampleAction(coin.getPickUp(coin, (Player) mario));
			gameMap.at(42,11).addItem(coin);

			world.run();



	}
}
