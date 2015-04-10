package fr.iutvalence.info.m2103.sokoban;

/**
 * Represents a level of Sokoban
 * @author Thibault - Mathie
 *
 */
public class Level {
	
	/**
	 * Default level number
	 */
	public static final int DEFAULT_MAP_SIZE = 5;
	
	/**
	 * Array of map elements
	 * Represents the map of the level
	 */
	private MapElement[][] map;
	
	/**
	 * Level number
	 */
	private int levelNumber;
	
	/**
	 * Creates a new level
	 * @param levelNumber The level number to create
	 */
	public Level(int levelNumber){
		this.levelNumber = levelNumber;
		this.map = new MapElement[DEFAULT_MAP_SIZE][DEFAULT_MAP_SIZE];
		
		for (int line = 0; line < DEFAULT_MAP_SIZE; line++) {
			for (int column = 0; column < DEFAULT_MAP_SIZE; column++) {
				if(line == 0 || line == 4)
					this.placeElement(new Position(line, column), MapElement.WALL);
				else
					this.placeElement(new Position(line, column), MapElement.FLOOR);
			}
			this.placeElement(new Position(line, 0), MapElement.WALL);
			this.placeElement(new Position(line, 4), MapElement.WALL);
		}
		this.placeElement(new Position(1, 1), MapElement.PLAYER);
		this.placeElement(new Position(1, 2), MapElement.BOX);
		this.placeElement(new Position(1, 3), MapElement.TARGET);
	}
	
	/**
	 * Place a specified element at a given position
	 * @param pos The position
	 * @param elem The element
	 */
	public void placeElement(Position pos, MapElement elem){
		this.map[pos.getPosX()][pos.getPosY()] = elem;
	}

	/**
	 * Returns the starting position where the player will begin
	 * @return The starting position
	 */
	public Position getStartingPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}