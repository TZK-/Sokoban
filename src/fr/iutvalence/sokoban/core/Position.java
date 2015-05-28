package fr.iutvalence.sokoban.core;

/**
 * Represents a position
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
		return this.posX;
	}
	
	/**
	 * Returns the value of the Y-axis
	 * @return the value of the Y-axis
	 */
	public int getPosY() {
		return this.posY;
	}
	
	/**
	 * Adds the current position with an other position 
	 * @param pos the position to add
	 * @return a new position resulting from the addition of two positions.
	 */
	public Position addTo(Position pos){
		return new Position(this.posX + pos.posX, this.posY + pos.posY);
	}
	
	/**
	 * Returns the position matches with the direction
	 * @param dir The direction
	 * @return the position matches with the direction
	 */
	public Position nextPosition(Direction dir){
		return this.addTo(dir.getDeltaPosition()); 
	}
	
	/**
	 * Returns position as a string format
	 */
	@Override
	public String toString() {
		return "(" + this.posX + ", " + this.posY + ")";
	}

	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.posX;
		result = prime * result + this.posY;
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (this.posX != other.posX)
			return false;
		if (this.posY != other.posY)
			return false;
		return true;
	}
	
}
