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
	 *
	 */
	public Sokoban(){
		// TODO Complete javadoc
		this.level = new Level(0);
	}
	
	/**
	 * Run the game
	 */
	public void play() {
		System.out.print(this.level);
	}

}
