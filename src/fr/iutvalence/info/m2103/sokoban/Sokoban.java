package fr.iutvalence.info.m2103.sokoban;

/**
 * Manages game of Sokoban
 * @author Thibault - Mathie
 *
 */
public class Sokoban {
	
	/**
	 * The player
	 */
	private final Player player;
	
	/**
	 * The game level
	 */
	private Level level;
	
	/**
	 * Create a new Sokoban
	 */
	public Sokoban(){
		this.level = new Level();
		this.player = new Player(null);
	}
	
	/**
	 * Run the game
	 */
	public void play() {
		
	}

}
