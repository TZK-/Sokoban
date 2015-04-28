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
	 * Create a new Sokoban, using default level
	 *  
	 */
	public Sokoban(){
		this.level = new Level();
	}

	/**
	 * Run the game
	 */
	public void play() {
		System.out.println(this.level);
		this.level.placeElement(new Position(2,2), MapElement.WALL);
		System.out.println(this.level);
	}

}
