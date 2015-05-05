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
	
	private Position characterPosition;

	/**
	 * Create a new Sokoban, using default level
	 *  
	 */
	public Sokoban(Level level){
		this.level = new Level();
	}

	
	
	/**
	 * Run the game
	 */
	public void play() {
		
		while (true)
		{
			// if won, exit telling it is won
			// if lost, exit telling it is won
			
			// (else)
			
			// display map
			System.out.println(this.level);
		
			// ask player for move
			
			// process move
			
		}
	}

}
