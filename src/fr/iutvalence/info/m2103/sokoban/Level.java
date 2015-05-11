package fr.iutvalence.info.m2103.sokoban;

import java.util.Iterator;


// TODO detail comment
/**
 * Represents a level of Sokoban
 * @author Thibault - Mathie
 *
 */
public class Level {
	
	/**
	 * The default level number
	 */
	private static final int DEFAULT_LEVEL_NUMBER = 1;
	
	/**
	 * The first line grid of walls
	 */
	private static final int WALL_FIRST_LINE = 0;

	/**
	 * The last line grid of walls
	 */
	private static final int WALL_LAST_LINE = 4;
	
	/**
	 * The first column grid of walls
	 */
	private static final int WALL_FIRST_COLUMN = 0;
	
	/**
	 * The last column grid of walls
	 */
	private static final int WALL_LAST_COLUMN = 4;
	
	/**
	 * The starting default position of the player
	 */
	private static final Position STARTING_POSITION = new Position(1,1);
	
	/**
	 * Default map size
	 */
	public static final int DEFAULT_MAP_SIZE = 5;

	/**
	 * The string representation of box which is not placed on a target
	 */
	private static final char BOX_REPRESENTATION = '$';

	/**
	 * 
	 */
	private static final char BOX_REPRESENTATION_ON_TARGET = '*';

	/**
	 * The starting position of the player
	 */
	private Position startingPosition;
	
	/**
	 * 2D grid of fixedElements
	 * @see fr.iutvalence.info.m2103.sokoban.FixedMapElement
	 */ 
	private FixedMapElement[][] fixedElements;
	
	/**
	 * The boxes positions on the map
	 */
	private Position[] boxPositions;

	/**
	 * Level number
	 */
	private int levelNumber;

	/**
	 * Creates a new default level without the character.
	 * At the end, it looks like this:</br>
	 *  #####
	 *  # $.#
	 *  #   #
	 *  #   #
	 *  #####
	 */
	public Level(){
		this.levelNumber = DEFAULT_LEVEL_NUMBER;
		this.boxPositions = new Position[1];
		
		this.fixedElements = new FixedMapElement[DEFAULT_MAP_SIZE][DEFAULT_MAP_SIZE];

		for (int line = 0; line < DEFAULT_MAP_SIZE; line++) {
			for (int column = 0; column < DEFAULT_MAP_SIZE; column++) {
				if(line == WALL_FIRST_LINE || line == WALL_LAST_LINE)
					this.placeElement(new Position(line, column), FixedMapElement.WALL);
				else
					this.placeElement(new Position(line, column), FixedMapElement.FLOOR);
			}
			this.placeElement(new Position(line, WALL_FIRST_COLUMN), FixedMapElement.WALL);
			this.placeElement(new Position(line, WALL_LAST_COLUMN), FixedMapElement.WALL);
		}

		this.placeElement(new Position(1, 3), FixedMapElement.TARGET);
		
		// Place the box
		this.boxPositions[0] = new Position(1, 2);
		
		this.startingPosition = STARTING_POSITION;
	}

	/**
	 * Places a specified element at a given position.
	 * @param pos The position
	 * @param elem The element
	 * @return <tt>true</tt> if the element has been placed.
	 *         <tt>false</tt> if the element is out of bound of the map
	 */
	public boolean placeElement(Position pos, FixedMapElement elem){
		if(!isValidPosition(pos))
			return false;
		this.fixedElements[pos.getPosX()][pos.getPosY()] = elem;
		return true;
	}
	
	/**
	 * Moves a box to a given position
	 *  from a given valid position to an other valid position.
	 * @param startPos The starting position
	 * @param finalPos The final position
	 */
	public void moveBox(Position startPos, Position finalPos){
		for (int boxPos = 0; boxPos < this.boxPositions.length; boxPos++) {
			if (this.boxPositions[boxPos].equals(startPos)){
				this.boxPositions[boxPos] = finalPos;
				return;
			}
		}
	}

	
	/**
	 * Returns the boxes positions
	 * @return The boxes positions
	 */
	public Position[] getBoxPositions() {
		return this.boxPositions;
	}

	/**
	 * Returns the map element at the given position
	 * @param pos The given position
	 * @return true if the map element if the position is valid
	 *         else return null
	 */
	public FixedMapElement getMapElement(Position pos){
		if(!isValidPosition(pos))
			return null;
		return this.fixedElements[pos.getPosX()][pos.getPosY()];
	}

	/**
	 * Checks if the position is valid
	 * @param pos The position to check
	 * @return <tt>true</tt> if the position is valid, <tt>else</tt> false
	 */
	private boolean isValidPosition(Position pos){
		if((pos.getPosX() < 0 || pos.getPosX() > this.fixedElements.length)
				|| (pos.getPosY() < 0 || pos.getPosY() > this.fixedElements.length)
				|| pos == null)
			return false;
		// TODO Check the collisions with walls ?
		return true;
	}

	/**
	 * Returns the starting position where the player will begin
	 * @return The starting position
	 */
	public Position getStartingPosition() {
		return this.startingPosition;
	}

	/**
	 * Returns an ASCII representation of the map
	 */
	@Override
	public String toString() {
		String str = "";
		boolean boxHasBeenPlaced = false;
		for (int line = 0; line < DEFAULT_MAP_SIZE; line++) {
			for (int column = 0; column < DEFAULT_MAP_SIZE; column++) {
				Position pos = new Position(line, column);
				for (Position boxPosition : boxPositions) {
					if(boxPosition.equals(pos)){
						if(this.getMapElement(pos) == FixedMapElement.TARGET)
							str += BOX_REPRESENTATION_ON_TARGET;
						else
							str += BOX_REPRESENTATION;
						boxHasBeenPlaced = true;
					}
					break;
				}
				if(boxHasBeenPlaced){
					boxHasBeenPlaced = false;
					continue;
				}
				str += this.fixedElements[line][column];
				
			}
			str += "\n";
		}
		return str;
	}

}