package fr.iutvalence.info.m2103.sokoban;

import java.util.Scanner;

import fr.iutvalence.info.m2103.interfaces.PlayerInteraction;

/**
 * Manages the interactions with a human player.
 *
 */
public class HumanPlayerInteraction implements PlayerInteraction{

	/**
	 * Gets input from keyboard
	 */
	private Scanner sc;
	
	/**
	 * Creates a new HumanPlayerInteraction
	 */
	public HumanPlayerInteraction() {
		this.sc = new Scanner(System.in);
	}

	@Override
	public Direction askDirectionToMove() {
		Direction dir = null;
		while(dir == null){
			System.out.print("Choice (  0:UP  |  1:RIGHT  |  2:DOWN  |  3:LEFT  |  9: Exit  ): ");
			int choixDirection = this.sc.nextInt();
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

	@Override
	public int askLevelToPlay() {
		
		System.out.println("Level list");
		for (int levelNumber = 0; levelNumber < Level.getLevels().length; levelNumber++) {
			System.out.println("\t" + levelNumber + " - " + Level.getLevels()[levelNumber]);
		}
		
		int choice = -1;
		do{
			System.out.print("Choice: ");
			choice = this.sc.nextInt();
		}while(choice < 0 || choice > Level.getLevels().length - 1);
		System.out.println("\n-----------\n");
		return choice;
	}

}
