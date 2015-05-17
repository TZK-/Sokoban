package fr.iutvalence.info.m2103.sokoban;

import fr.iutvalence.info.m2103.interfaces.PlayerInteraction;

/**
 * Manages the interactions with an artificial player.
 */
public class AIPlayerInteraction implements PlayerInteraction{

	@Override
	public Direction askDirectionToMove() {
		return Direction.getRandomDirection();
	}

}
