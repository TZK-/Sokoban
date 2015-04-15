package fr.iutvalence.info.m2103.sokoban;

/**
 * Manages game of Sokoban. 
 * @author Thibault - Mathie
 *
 */
// TODO Complete javadoc with Sokoban's rules + link
public class Sokoban {

	/**
	 * The game level
	 */
	private Level level;

	/**
	 * Create a new Sokoban
	 * Initializing the level 1
	 * Print the board to the screen
	 */
	public Sokoban(){
		// TODO Complete javadoc
		this.level = new Level();
	}

	/**
	 * Run the game
	 */
	public void play() {
		System.out.print(this.level);
	}

}
