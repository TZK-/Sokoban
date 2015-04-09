package fr.iutvalence.info.m2103.sokoban;

/**
 * Represents a player of Sokoban
 * @author Thibault
 *
 */
public class Player {

	/**
	 * The player position
	 */
	private Position position;
	
	
	/**
	 * Creates a new player at a given position
	 * @param pos The start position
	 */
	public Player(Position pos){
		this.position = pos;
	}
	
	/**
	 * Move the player on the board
	 * @param displacement The displacement to perform
	 * @param level The level where the player is
	 */
	public void deplacer(Position displacement, Level level){
		this.position = new Position(this.position.getPosX() + displacement.getPosX(), this.position.getPosY() + displacement.getPosY());
		// TODO Check the rules of travel (collision, outside board etc.)
	}
	
}
