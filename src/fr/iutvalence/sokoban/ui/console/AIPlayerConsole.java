package fr.iutvalence.sokoban.ui.console;

import java.util.Random;

import fr.iutvalence.sokoban.core.Direction;
import fr.iutvalence.sokoban.core.Level;
import fr.iutvalence.sokoban.interfaces.PlayerInteraction;

/**
 * Manages the interactions with an artificial player.
 */
public class AIPlayerConsole implements PlayerInteraction{

	@Override
	public Direction askDirection() {
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
