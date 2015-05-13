package fr.iutvalence.info.m2103.sokoban;

import java.util.Random;

/**
 *  Represents a direction according to the 4 poles.
 */
public enum Direction {

	/**
	 * The up direction
	 */
	UP(-1,0),
	
	/**
	 * The down direction
	 */
	DOWN(1,0),
	
	/**
	 * The left direction
	 */
	LEFT(0,-1),
	
	/**
	 * The right direction
	 */
	RIGHT(0,1);

	/**
	 * The delta on the X-Axis
	 */
	private final int deltaX;
	
	/**
	 * The delta on the Y-Axis
	 */
	private final int deltaY;

	/**
	 * Creates a new Direction
	 * @param deltaX the delta X
	 * @param deltaY the delta Y
	 */
	private Direction(int deltaX, int deltaY){
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	/**
	 * Gets the delta X
	 * @return the delta X
	 */
	public int getDeltaX() {
		return this.deltaX;
	}

	/**
	 * Gets the delta Y
	 * @return the delta Y
	 */
	public int getDeltaY() {
		return this.deltaY;
	}
	
	/**
	 * Gets the position formed by delta X and delta Y
	 * @return the position formed by delta X and delta Y
	 */
	public Position getDeltaPosition(){
		return new Position(this.deltaX, this.deltaY);
	}

	public static Direction getRandomDirection() {
		Random randomDir = new Random();
		
		return null;
	}
}
