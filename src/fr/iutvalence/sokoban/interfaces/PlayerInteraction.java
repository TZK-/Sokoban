package fr.iutvalence.sokoban.interfaces;

import fr.iutvalence.sokoban.core.Direction;

/**
 * Manages the interactions with the player.
 */
public interface PlayerInteraction{

	/**
	 * Asks to the player a direction to move
	 * @return The direction given by the player
	 */
	public Direction askDirection();
	
	/**
	 * Asks to the player a level to play
	 * @return The selected level number
	 */
	public int askLevelToPlay();
	
	/**
	 * Asks to leave the game
	 */
	public void askToQuit();
	
}
