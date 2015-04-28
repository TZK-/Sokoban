package fr.iutvalence.info.m2103.sokoban;


// TODO detail comment
/**
 * Represents a level of Sokoban
 * @author Thibault - Mathie
 *
 */
public class Level {
	
	/**
	 * 
	 */
	private static final int DEFAULT_LEVEL_NUMBER = 1;
	
	/**
	 * 
	 */
	private static final int WALL_FIRST_LINE = 0;

	/**
	 * 
	 */
	private static final int WALL_LAST_LINE = 4;
	
	/**
	 * 
	 */
	private static final int WALL_FIRST_COLUMN = 0;
	
	/**
	 * 
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
	 * The starting position of the player
	 */
	private Position startingPosition;
	
	// TODO finish writing comment
	/**
	 * 2D grid of elements (...)
	 */
	private MapElement[][] map;

	/**
	 * Level number
	 */
	private int levelNumber;

	// TODO detail comment (how is the level once created)
	/**
	 * Creates a new level
	 */
	public Level(){
		// TODO 1 should be declared as a constant
		this.levelNumber = DEFAULT_LEVEL_NUMBER;
		
		this.map = new MapElement[DEFAULT_MAP_SIZE][DEFAULT_MAP_SIZE];

		for (int line = 0; line < DEFAULT_MAP_SIZE; line++) {
			for (int column = 0; column < DEFAULT_MAP_SIZE; column++) {
				// TODO if 0 and 4 have a special meaning, they should be declared as constants
				if(line == WALL_FIRST_LINE || line == WALL_LAST_LINE)
					this.placeElement(new Position(line, column), MapElement.WALL);
				else
					this.placeElement(new Position(line, column), MapElement.FLOOR);
			}
			this.placeElement(new Position(line, WALL_FIRST_COLUMN), MapElement.WALL);
			this.placeElement(new Position(line, WALL_LAST_COLUMN), MapElement.WALL);
		}
		this.placeElement(new Position(1, 1), MapElement.PLAYER);
		this.placeElement(new Position(1, 2), MapElement.BOX);
		this.placeElement(new Position(1, 3), MapElement.TARGET);
		
		// TODOD default starting position should be declared as a constant
		this.startingPosition = STARTING_POSITION;
	}

	/**
	 * Places a specified element at a given position.
	 * @param pos The position
	 * @param elem The element
	 * @return <tt>true</tt> if the element has been placed.
	 *         <tt>false</tt> if the element is out of bound of the map
	 */
	public boolean placeElement(Position pos, MapElement elem){
		if(!isValidPosition(pos))
			return false;
		this.map[pos.getPosX()][pos.getPosY()] = elem;
		return true;
	}
	
	/**
	 * Moves a movable map element (PLAYER, BOX, PLAYER_ON_TARGET, BOX_ON_TARGET)
	 *  from a given position to an other position.</br>
	 * If the it moves PLAYER or BOX on a TARGET,
	 *  it will place PLAYER_ON_TARGET or BOX_ON_TARGET.
	 * @param startPos The starting position
	 * @param finalPos The final position
	 * @return <tt>true</tt> if the element has been moved, <tt>false</tt> if not.
	 */
	public boolean moveElement(Position startPos, Position finalPos){
		if(!isValidPosition(startPos) || !isValidPosition(finalPos))
			return false;
		
		/*
		 * If element to move is a TARGET,
		 * it places the element to the final position by
		 * PLAYER_ON_TARGET or BOX_ON_TARGET.
		 */
		if(this.getMapElement(finalPos) == MapElement.TARGET){
			if(this.getMapElement(startPos) == MapElement.PLAYER)
				this.placeElement(finalPos, MapElement.PLAYER_ON_TARGET);
			else
				this.placeElement(finalPos, MapElement.BOX_ON_TARGET);
		}
		
		/*
		 * If the starting element is a PLAYER_ON_TARGET
		 * it places on the final position the PLAYER and it update
		 * the starting element with TARGET
		 */
		// TODO CHECK IF PLAYER IS PUSHING BOX
		else if (this.getMapElement(startPos) == MapElement.PLAYER_ON_TARGET) {
			if(this.getMapElement(finalPos) == MapElement.FLOOR){
				this.placeElement(finalPos, MapElement.PLAYER);
			}
			this.placeElement(startPos, MapElement.TARGET);
		}
		
		else{
			this.placeElement(finalPos, this.getMapElement(startPos));
		}
		
		//TODO remove starting elem
		return true;
	}

	/**
	 * Returns the map element at the given position
	 * @param pos The given position
	 * @return true if the map element if the position is valid
	 *         else return null
	 */
	public MapElement getMapElement(Position pos){
		if(!isValidPosition(pos))
			return null;
		return this.map[pos.getPosX()][pos.getPosY()];
	}

	/**
	 * Checks if the position is valid
	 * @param pos The position to check
	 * @return true if the position is valid, else false
	 */
	private boolean isValidPosition(Position pos){
		if((pos.getPosX() < 0 || pos.getPosX() > this.map.length)
				|| (pos.getPosY() < 0 || pos.getPosY() > this.map.length)
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
		for (int line = 0; line < DEFAULT_MAP_SIZE; line++) {
			for (int column = 0; column < DEFAULT_MAP_SIZE; column++) {
				str += this.map[line][column];
			}
			str += "\n";
		}
		return str;
	}

}