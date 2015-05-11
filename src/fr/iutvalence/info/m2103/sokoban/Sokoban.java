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
	 * Checks if the game is finished.
	 * A game is finished if all boxes are placed on targets
	 * @return
	 */
	public boolean isGameFinished(){
		for (int line = 0; line < Level.DEFAULT_MAP_SIZE; line++) {
			for (int column = 0; column < Level.DEFAULT_MAP_SIZE; column++) {
				Position pos = new Position(line, column);
				if(this.level.getFixedMapElement(pos) != FixedMapElement.TARGET)
					continue;

				for (Position boxPos : this.level.getBoxPositions()) {
					if(!boxPos.equals(pos))
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * Moves a box from a given position to a given direction.
	 * @param box
	 * @param dir
	 * @return <tt>true</tt> if the box has been moved, 
	 *          <tt>false</tt> if the box could not be moved because 
	 *          there is no FLOOR or TARGET at the given position
	 */
	private boolean moveBox(Position box, Direction dir){

		Position pos = null;

		switch (dir) {
			case UP:
				pos = new Position(-1, 0);
				break;
			case DOWN:
				pos = new Position(1, 0);
				break;
			case LEFT:
				pos = new Position(0, -1);
				break;
			case RIGHT:
				pos = new Position(0, 1);
				break;
			default:
				break;
		}

		Position finalPos = pos.addPositions(box);
		if(!this.canMoveTo(finalPos))
			return false;

		this.level.moveBox(box, finalPos);

		return true;

	}

	/**
	 * @param pos
	 * @return <tt>true</tt> if //TODO complete
	 */
	private boolean canMoveTo(Position pos) {
		if(this.level.getFixedMapElement(pos) != FixedMapElement.FLOOR
				|| this.level.getFixedMapElement(pos) == FixedMapElement.WALL
				|| !this.isTargetAt(pos))
			return false;

		for (Position boxPos : this.level.getBoxPositions()) {
			if(boxPos.equals(pos))
				return false;
		}
		return true;
	}


	/**
	 * Checks if there is a box on a target at a given position
	 * @param pos The position to test
	 * @return 
	 */
	private boolean isTargetAt(Position pos){
		return (this.level.getFixedMapElement(pos) == FixedMapElement.TARGET);
	}


	/**
	 * Run the game
	 */
	public void play() {

		while (true)
		{

			if(this.isGameFinished()){
				System.out.println("Gagné !");
				System.exit(0);	
			}

			// display map
			System.out.println(this.level);
			this.moveBox(new Position(1, 2), Direction.RIGHT);
			System.out.println(this.level);



			break;

		}
	}

}
