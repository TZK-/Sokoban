package fr.iutvalence.info.m2103.sokoban;

/**
 * Represents a position
 * @author Thibault - Mathie
 *
 */
public class Position {
	
	/**
	 * The value of default axis
	 */
	public final static int DEFAULT_POSITION = 0;
	
	/**
	 * X-axis position 
	 */
	private final int posX;
	
	/**
	 * Y-axis position
	 */
	private final int posY;
	
	/**
	 * Creates a new position with coordinates (0, 0)
	 */
	public Position(){
		this.posX = Position.DEFAULT_POSITION;
		this.posY = Position.DEFAULT_POSITION;
	}
	
	/**
	 * Create a new position with the values passed as parameters
	 * @param posX the X-axis position
	 * @param posY the Y-axis position
	 */
	public Position(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Returns the value of the X-axis
	 * @return the value of the X-axis
	 */
	public int getPosX() {
		return posX;
	}

	
	/**
	 * Returns the value of the Y-axis
	 * @return the value of the Y-axis
	 */
	public int getPosY() {
		return posY;
	}
	
}
