package fr.iutvalence.info.m2103.interfaces;

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
	 * Displays the win message
	 * @param turn The number of the final winning turn
	 */
	public void displayWinMessage(int turn);
	
}
