package fr.iutvalence.info.m2103.sokoban;

import java.util.Random;


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

	/**
	 * Create a new Sokoban, using default level
	 *  
	 */
	public Sokoban(){
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
	 * @param boxPosition The position of the box to moved
	 * @param dir The direction to moved
	 * @return <tt>true</tt> if the box has been moved, 
	 *          <tt>false</tt> if the box could not be moved because 
	 *          there is a blocking WALL or BOX.
	 */
	private boolean moveBox(Position boxPosition, Direction dir){

		Position finalPos = boxPosition.nextPosition(dir);
		if(!this.canMoveTheBoxTo(finalPos))
			return false;

		this.level.moveBox(boxPosition, finalPos);

		return true;
	}

	/**
	 * Checks if the BOX can move to a given position.
	 * @param pos The position check the move
	 * @return <tt>true</tt> if the movable element can move to the given position,
	 *         <tt>false</tt> if the movable element is blocked by WALL or BOX
	 */
	private boolean canMoveTheBoxTo(Position pos) {
		if(this.isThisElementAt(FixedMapElement.WALL, pos))
			return false;
		
		for (Position boxPos : this.level.getBoxPositions()) {
			if(boxPos.equals(pos))
				return false;
		}
		return true;
	}

	/**
	 * Moves the character to a given direction
	 * @param dir The direction to move
	 * @return <tt>true</tt> if the character has been moved,
	 *         <tt>false</tt> if not.
	 */
	private boolean moveCharacter(Direction dir){
		
		Position finalCharacterPos = this.level.getCharacterPosition().nextPosition(dir);
		
		for (Position boxPos : this.level.getBoxPositions()) {
			// There is a box at the next position of the character
			if(boxPos.equals(finalCharacterPos)){
				if(!this.moveBox(boxPos, dir))
					return false;
			}
			else{
				if(this.isThisElementAt(FixedMapElement.WALL, finalCharacterPos))
					return false;
			}
		}
		this.level.moveCharacter(finalCharacterPos);
		return true;
	}

	/**
	 * Checks if an element is at the given position
	 * @param elem The element to test
	 * @param pos The position to test
	 * @return <tt>true</tt> if there is the element at the given position,
	 *         <tt>false</tt> if not.
	 */
	private boolean isThisElementAt(FixedMapElement elem, Position pos){
		return (this.level.getFixedMapElement(pos) == elem);
	}


	/**
	 * Run the game
	 */
	public void play() {
		Random randomDir = new Random();
		while (true)
		{
			
			if(this.isGameFinished()){
				System.out.println("Gagné !");
				System.out.println(this.level);
				System.exit(0);
			}
			
			System.out.println(this.level);
			this.moveCharacter(Direction.RIGHT);
			System.out.println(this.level);
			
			break;
			/*Direction dir = null;
			switch (randomDir.nextInt(4)) {
			case 0:
				dir = Direction.UP;
				break;
			case 1:
				dir = Direction.RIGHT;
				break;
			case 2:
				dir = Direction.DOWN;
				break;
			case 3:
				dir = Direction.LEFT;
				break;
			default:
				break;
			}
			
			System.out.println(dir.name());
			this.moveBox(this.level.getBoxPositions()[0], dir);*/
			
			
		}
	}

}
