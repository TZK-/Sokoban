package fr.iutvalence.info.m2103.sokoban;

/**
 * Manages the interactions with an artificial player.
 */
public class AIPlayerInteraction implements PlayerInteraction{

	@Override
	public Direction askDirectionToMove() {
		return Direction.getRandomDirection();
	}

}
