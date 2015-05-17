package fr.iutvalence.info.m2103.sokoban;

import java.util.Scanner;

import fr.uitvalence.info.m2103.interfaces.PlayerInteraction;

/**
 * Manages the interactions with a human player.
 *
 */
public class HumanPlayerInteraction implements PlayerInteraction{

	@Override
	public Direction askDirectionToMove() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		Direction dir = null;
		while(dir == null){
			System.out.print("Choice (  0:UP  |  1:RIGHT  |  2:DOWN  |  3:LEFT  |  9: Exit  ): ");
			int choixDirection = sc.nextInt();
			System.out.print("\n");
			switch (choixDirection) {
				case 0:
					dir = Direction.UP;
					break;
				case 1:
					dir = Direction.RIGHT;
					break;
				case 2:
					dir = Direction.DOWN;
					break;
				case 3:
					dir = Direction.LEFT;
					break;
				case 9:
					System.out.println("\tThe game has been quit");
					System.exit(0);
					break;
				default:
					System.out.println("\tInvalid choice\n");
					break;
			}
		}
		return dir;
	}

}
