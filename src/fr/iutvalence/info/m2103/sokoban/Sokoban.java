package fr.iutvalence.info.m2103.sokoban;

import fr.iutvalence.info.m2103.exceptions.PlayerNotPlacedException;
import fr.iutvalence.info.m2103.interfaces.PlayerInteraction;


/**
 * Manages game of Sokoban. 
 * @author Thibault - Mathie
 *
 *
 * The game is played on a board of squares, where each square is a floor or a wall. 
 * Some floor squares contain boxes, and some floor squares are marked as storage locations (TARGET).
 * The player is confined to the board, and may move horizontally or vertically onto empty squares 
 * (never through walls or boxes). The player can also move into a box, 
 * which pushes it into the square beyond. Boxes may not be pushed into other boxes or walls,
 * and they cannot be pulled. 
 * The puzzle is solved when all boxes are at storage locations.
 * 
 * @see http://en.wikipedia.org/wiki/Sokoban
 */
public class Sokoban {

	/**
	 * The game level
	 */
	private Level level;

	/**
	 * Create a new Sokoban
	 */
	public Sokoban(){
		this.level = null;
	}

	/**
	 * Checks if the game is finished.
	 * A game is finished if all boxes are placed on targets
	 * @return <tt>true</tt> if the game is finished, i.e. all the boxes are on targets,
	 *         <tt>false</tt> if not.
	 */
	public boolean isGameFinished(){
		
		for (Position boxPos : this.level.getBoxPositions()) {
			if(!this.isThisElementAt(FixedMapElement.TARGET, boxPos))
				return false;
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
	 * Moves the character to a given direction.
	 * @param dir The direction to move
	 * @return <tt>true</tt> if the character can move to the given direction,
	 *         <tt>false</tt> if the character is blocked by WALL or BOX
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
	 * Run the game.
	 * Displays the board level and asks the player to move.
	 * If the game is won, it exits the Sokoban game.
	 */
	public void play() {
		PlayerInteraction playerInteraction = new HumanPlayerInteraction();
		
		System.out.println("Sokoban Game");
		System.out.println("-------------\n");
		
		int levelNumber = playerInteraction.askLevelToPlay();
		
		try {
			this.setLevel(new MapLoader(Level.getLevels()[levelNumber], levelNumber).load());
		} catch (PlayerNotPlacedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Level " + this.level.getLevelNumber());
		System.out.println("\t '@': CHARACTER     - '$': BOX");
		System.out.println("\t '*': BOX on TARGET - '+': CHARACTER on TARGET");
		System.out.println("\t '#': WALL          - '.': TARGET\n");
		System.out.println(this.level);

		while (true)
		{
			
			if(this.isGameFinished()){
				System.out.println(this.level);
				System.out.println("\nGagné !");
				System.exit(0);
			}
			
			this.moveCharacter(playerInteraction.askDirectionToMove());
			
			System.out.println("------------------");
			System.out.println(this.level);
		}
	}

	/**
	 * @param level The level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}
	
}
