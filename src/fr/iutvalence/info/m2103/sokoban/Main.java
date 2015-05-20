package fr.iutvalence.info.m2103.sokoban;


/**
 * Launcher of the Sokoban application
 */
public class Main {

	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		new Sokoban(new HumanPlayerConsole(), new DisplayConsole()).play();
	}

}
