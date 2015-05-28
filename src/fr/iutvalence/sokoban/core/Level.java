package fr.iutvalence.sokoban.core;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Represents a level of Sokoban.
 * It is composed with WALLS, TARGETS and a CHARACTER.
 */
public class Level implements Cloneable{
	
	/**
	 * The folder containing all the levels file
	 */
	public static final String LEVELS_FOLDER = "/levels";
	
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
	public static final char BOX_REPRESENTATION = '$';

	/**
	 * The string representation of box which is placed on a target
	 */
	public static final char BOX_REPRESENTATION_ON_TARGET = '*';
	
	/**
	 * The string representation of character who is not placed on a target
	 */
	public static final char CHARACTER_REPRESENTATION = '@';
	
	/**
	 * The string representation of the character who is placed on a target
	 */
	public static final char CHARACTER_REPRESENTATION_ON_TARGET = '+';
	
	/**
	 * 2D grid of fixedElements
	 * @see fr.iutvalence.sokoban.core.FixedMapElement
	 */ 
	private FixedMapElement[][] fixedElements;
	
	/**
	 * The boxes positions on the map
	 */
	private Position[] boxPositions;

	/**
	 * The position of the character
	 */
	private Position characterPosition;

	/**
	 * Level number
	 */
	private final int levelNumber;
	
	/**
	 * The map height
	 */
	private final int mapHeight;
	
	/**
	 * The map width
	 */
	private final int mapWidth;

	/**
	 * Creates a new default level. 
	 * It places the character(@), 2 boxes($) and 2 targets(.)
	 * It will looks like this:</br>
	 * <p>
	 *  #####</br>
	 *  #@$.#</br>
	 *  # $ #</br>
	 *  #  .#</br>
	 *  #####</br>
	 *  </p>
	 */
	public Level(){
		this.levelNumber = DEFAULT_LEVEL_NUMBER;
		this.boxPositions = new Position[2];
		this.characterPosition = STARTING_POSITION;
		this.fixedElements = new FixedMapElement[DEFAULT_MAP_SIZE][DEFAULT_MAP_SIZE];

		for (int line = 0; line < DEFAULT_MAP_SIZE; line++) {
			for (int column = 0; column < DEFAULT_MAP_SIZE; column++) {
				if(line == WALL_FIRST_LINE || line == WALL_LAST_LINE)
					this.placeFixedElement(new Position(line, column), FixedMapElement.WALL);
				else
					this.placeFixedElement(new Position(line, column), FixedMapElement.FLOOR);
			}
			this.placeFixedElement(new Position(line, WALL_FIRST_COLUMN), FixedMapElement.WALL);
			this.placeFixedElement(new Position(line, WALL_LAST_COLUMN), FixedMapElement.WALL);
		}

		this.placeFixedElement(new Position(1, 3), FixedMapElement.TARGET);
		this.placeFixedElement(new Position(3, 3), FixedMapElement.TARGET);
		
		this.boxPositions[0] = new Position(1, 2);
		this.boxPositions[1] = new Position(2, 2);
		this.mapWidth = DEFAULT_MAP_SIZE;
		this.mapHeight = DEFAULT_MAP_SIZE;
	}

	
	/**
	 * Creates a new level with given datas
	 * @param fixedElements The fixed map elements
	 * @param boxPositions The position of the boxes
	 * @param characterPosition The character's position
	 * @param levelNumber The number of the level
	 */
	public Level(FixedMapElement[][] fixedElements, Position[] boxPositions, Position characterPosition, int levelNumber) {
		this.fixedElements = fixedElements;
		this.boxPositions = boxPositions;
		this.characterPosition = characterPosition;
		this.levelNumber = levelNumber;
		this.mapWidth = this.fixedElements[0].length;
		this.mapHeight = this.fixedElements.length;
	}
	
	/**
	 * Places a specified element at a given position.
	 * @param pos The position
	 * @param elem The element
	 * @return <tt>true</tt> if the element has been placed.
	 *         <tt>false</tt> if the element is out of bound of the map
	 */
	public boolean placeFixedElement(Position pos, FixedMapElement elem){
		if(!isValidPosition(pos))
			return false;
		this.fixedElements[pos.getPosX()][pos.getPosY()] = elem;
		return true;
	}
	
	/**
	 * Checks if there is a box at the given position
	 * @param pos The position to check
	 * @return <tt>true</tt> if there is a box at the position,
	 *         <tt>false</tt> if not.
	 */
	public boolean isBoxAt(Position pos){
		for (Position boxPos : this.boxPositions) {
			if(pos.equals(boxPos))
				return true;
		}
		return false;
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
	 * Returns the character's position
	 * @return the character's position
	 */
	public Position getCharacterPosition() {
		return this.characterPosition;
	}

	/**
	 * Moves the character to a given position
	 * @param pos The position to move
	 */
	public void moveCharacter(Position pos) {
		this.characterPosition = pos;
	}
	
	/**
	 * Returns the map element at the given position
	 * @param pos The given position
	 * @return true if the map element if the position is valid
	 *         else return null
	 */
	public FixedMapElement getFixedMapElement(Position pos){
		if(!isValidPosition(pos))
			return null;
		return this.fixedElements[pos.getPosX()][pos.getPosY()];
	}

	/**
	 * Checks if the position is valid
	 * @param pos The position to check
	 * @return <tt>true</tt> if the position is valid, else it returns <tt>false</tt>
	 */
	private boolean isValidPosition(Position pos){
		if((pos.getPosX() < 0 || pos.getPosX() > this.fixedElements.length)
				|| (pos.getPosY() < 0 || pos.getPosY() > this.fixedElements[0].length)
				|| pos == null)
			return false;
		return true;
	}
	
	/**
	 * @return The levelNumber
	 */
	public int getLevelNumber() {
		return this.levelNumber;
	}

	
	/**
	 * Returns the name of the existing levels into the Levels folder.
	 * @return The name of the existing levels into the Levels folder.
	 */
	public static String[] getLevels(){
		
		URL levelsUrl = MapLoader.class.getResource(Level.LEVELS_FOLDER);
		File levelsPath = null;
		try {
			levelsPath = new File(levelsUrl.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return levelsPath.list();
	}
	

	/**
	 * @return the mapHeight
	 */
	public int getMapHeight() {
		return this.mapHeight;
	}


	/**
	 * @return the mapWidth
	 */
	public int getMapWidth() {
		return this.mapWidth;
	}


	/**
	 * Returns an ASCII representation of the map
	 */
	@Override
	public String toString() {
		String str = "";
		boolean boxHasBeenPlaced = false;
		for (int line = 0; line < this.fixedElements.length; line++) {
			for (int column = 0; column < this.fixedElements[0].length; column++) {
				Position pos = new Position(line, column);
				if(pos.equals(this.characterPosition)){
					if(this.getFixedMapElement(pos) == FixedMapElement.TARGET)
						str += CHARACTER_REPRESENTATION_ON_TARGET;
					else
						str += CHARACTER_REPRESENTATION;
					continue;
				}
				for (Position boxPosition : this.boxPositions) {
					if(boxPosition.equals(pos)){
						if(this.getFixedMapElement(pos) == FixedMapElement.TARGET)
							str += BOX_REPRESENTATION_ON_TARGET;
						else
							str += BOX_REPRESENTATION;
						boxHasBeenPlaced = true;
					}
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

	@Override
	public Level clone() throws CloneNotSupportedException {   
		Level copiedLevel =  (Level) super.clone();
		
		copiedLevel.boxPositions = this.boxPositions.clone();
		copiedLevel.fixedElements = this.fixedElements.clone();
		
		return copiedLevel;
	}
  
}
