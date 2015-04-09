package fr.iutvalence.info.m2103.sokoban;

/**
 * Represents a level of Sokoban
 * @author Thibault
 *
 */
public class Level {
	
	/**
	 * Default level number
	 */
	public static final int DEFAULT_LEVEL = 1;
	
	/**
	 * Level number
	 */
	private int levelNumber;
	
	/**
	 * Creates the default level
	 */
	public Level(){
		this.levelNumber = Level.DEFAULT_LEVEL;
	}
	
	/**
	 * Creates a new level
	 * @param levelNumber The level number to create
	 */
	public Level(int levelNumber){
		this.levelNumber = levelNumber;
	}
	
}
