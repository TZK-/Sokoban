package fr.iutvalence.info.m2103.interfaces;

import fr.iutvalence.info.m2103.sokoban.Level;

/**
 * Manages the display of the game
 */
public interface Display {

	/**
	 * Displays a message
	 * @param msg The message to display
	 */
	public void displayMessage(String msg);
	
	/**
	 * Displays the starting message
	 */
	public void displayStartingMessage();
	
	/**
	 * Displays the level
	 * @param level The level
	 */
	public void displayLevel(Level level);
	
//	/**
//	 * Resets the level display
//	 * @param level The level to reset
//	 */
//	public void resetLevelDisplay(Level level);
	
}
