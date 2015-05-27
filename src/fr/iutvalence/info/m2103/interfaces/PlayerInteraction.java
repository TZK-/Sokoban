package fr.iutvalence.info.m2103.interfaces;

import fr.iutvalence.info.m2103.sokoban.Direction;

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
	 * Leaves the game
	 */
	public void askToQuit();
	
}
