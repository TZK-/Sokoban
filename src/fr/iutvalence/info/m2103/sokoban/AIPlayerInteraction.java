package fr.iutvalence.info.m2103.sokoban;

import java.util.Random;

import fr.iutvalence.info.m2103.interfaces.PlayerInteraction;

/**
 * Manages the interactions with an artificial player.
 */
public class AIPlayerInteraction implements PlayerInteraction{

	@Override
	public Direction askDirectionToMove() {
		return Direction.getRandomDirection();
	}

	@Override
	public int askLevelToPlay() {
		Random rand = new Random();
		return rand.nextInt(Level.getLevels().length);
	}

}
