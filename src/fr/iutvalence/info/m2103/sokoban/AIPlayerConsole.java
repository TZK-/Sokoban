package fr.iutvalence.info.m2103.sokoban;

import java.util.Random;

import fr.iutvalence.info.m2103.interfaces.PlayerInteraction;

/**
 * Manages the interactions with an artificial player.
 */
public class AIPlayerConsole implements PlayerInteraction{

	@Override
	public Direction askAction() {
		return Direction.getRandomDirection();
	}

	@Override
	public int askLevelToPlay() {
		Random rand = new Random();
		return rand.nextInt(Level.getLevels().length);
	}

	@Override
	public void askToQuit() {
		System.exit(0);
	}

}
