package fr.iutvalence.info.m2103.sokoban;

import fr.iutvalence.info.m2103.interfaces.Display;

/**
 * Manages the console display
 */
public class DisplayConsole implements Display{

	@Override
	public void displayMessage(String msg) {
		System.out.println(msg);
	}

	@Override
	public void displayStartingMessage() {
		this.displayMessage("Sokoban Game\n");
		this.displayMessage("\t '@': CHARACTER     - '$': BOX");
		this.displayMessage("\t '*': BOX on TARGET - '+': CHARACTER on TARGET");
		this.displayMessage("\t '#': WALL          - '.': TARGET\n");
		this.displayMessage("------------");
	}

	@Override
	public void displayLevel(Level level) {
		System.out.println(level.toString());
	}

}
