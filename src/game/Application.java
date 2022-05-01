package game;

import java.util.Arrays;
import java.util.List;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;

import edu.monash.fit2099.engine.positions.World;
import game.balance.Wallet;
import game.balance.WalletsManager;
import game.grounds.*;
import game.item.Coin;
import game.item.PowerStar;
import game.item.SuperMushroom;
import game.roles.Goomba;
import game.roles.Player;
import game.roles.Toad;

/**
 * The main class for the Mario World game.
 *
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
		    //Wallet wallet = new Wallet();
			Actor mario = new Player("Player", 'm', 100);
			//((Player) mario).addWallet(mario);
			WalletsManager.getInstance().appendWalletItem((Player) mario,new Wallet());
			world.addPlayer(mario, gameMap.at(42, 10));
			// FIXME: the Goomba should be generated from the Tree
			//gameMap.at(35, 10).addActor(new Goomba());
			SuperMushroom superMushroom = new SuperMushroom();
			gameMap.at(42, 10).addItem(superMushroom);

			PowerStar powerStar = new PowerStar();
			gameMap.at(43, 10).addItem(powerStar);

			Coin coin = new Coin();
			gameMap.at(42,11).addItem(coin);

			gameMap.addActor(new Toad(),gameMap.at(43,11));

			world.run();



	}
}
