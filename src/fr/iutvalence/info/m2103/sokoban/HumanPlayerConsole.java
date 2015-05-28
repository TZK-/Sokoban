package fr.iutvalence.info.m2103.sokoban;

import java.util.Scanner;

import fr.iutvalence.info.m2103.interfaces.PlayerInteraction;

/**
 * Manages the interactions with a human player.
 */
public class HumanPlayerConsole implements PlayerInteraction{

	/**
	 * Gets input from keyboard
	 */
	private Scanner sc;
	
	/**
	 * The console display
	 */
	private DisplayConsole display;
	
	/**
	 * Creates a new HumanPlayerInteraction
	 */
	public HumanPlayerConsole() {
		this.sc = new Scanner(System.in);
		this.display = new DisplayConsole();
	}

	@Override
	public Direction askDirection() {
		Direction dir = null;
		while(dir == null){
			this.display.displayMessage("Choice (  0:UP  |  1:RIGHT  |  2:DOWN  |  3:LEFT  |  8:RESET  |  9: Exit  ): ");
			int choixDirection = this.sc.nextInt();
		
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
				case 8:
					dir = null;
					this.display.displayMessage("\tThe level has been resetted");
					break;
				case 9:
					this.display.displayMessage("\tThe game has been quit");
					this.askToQuit();
					break;
				default:
					this.display.displayMessage("\tInvalid choice\n");
					break;
			}
		}
		return dir;
	}

	@Override
	public int askLevelToPlay() {
		
		this.display.displayMessage("Level list");
		for (int levelNumber = 0; levelNumber < Level.getLevels().length; levelNumber++) {
			this.display.displayMessage("\t" + levelNumber + " - " + Level.getLevels()[levelNumber]);
		}
		
		int choice = -1;
		do{
			this.display.displayMessage("Choice: ");
			choice = this.sc.nextInt();
		}while(choice < 0 || choice > Level.getLevels().length - 1);
		this.display.displayMessage("\n-----------\n");
		return choice;
	}

	@Override
	public void askToQuit() {
		System.exit(0);
	}

}
