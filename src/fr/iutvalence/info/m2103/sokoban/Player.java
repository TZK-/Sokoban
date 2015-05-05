package fr.iutvalence.info.m2103.sokoban;

/**
 * Sokoban game player
 */
public class Player {
	
	/**
	 * The position of the player
	 */
	private Position position;
	
	/**
	 * The playing level
	 */
	private Level level;
	
	/**
	 * Creates a new player for a given level.
	 * @param level The level to play
	 */
	public Player(Level level){
		this.level = level;
		this.position = level.getStartingPosition();
	}
	
	/**
	 * Moves the player 
	 * @param dir The direction to move
	 */
	public void move(Direction dir){
		Position pos = null;
		switch (dir) {
			case UP:
				pos = new Position(0, 1);
				break;
			case DOWN:
				pos = new Position(0, -1);
				break;
			case RIGHT:
				pos = new Position(1, 0);
				break;
			case LEFT:
				pos = new Position(-1, 0);
				break;
			default:
				break;
		}
		Position finalPosition = pos.addPositions(this.position);
		this.level.moveBox(this.position, finalPosition);
		
	}
	
}
