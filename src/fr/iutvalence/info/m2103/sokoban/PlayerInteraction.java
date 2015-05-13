package fr.iutvalence.info.m2103.sokoban;

/**
 * Manages the interactions with the player.
 */
public interface PlayerInteraction {

	/**
	 * Asks to the player a direction to move
	 * @return The direction given by the player
	 */
	public Direction askDirectionToMove();
	
}
