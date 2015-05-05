package fr.iutvalence.info.m2103.sokoban;

/**
 * Launcher of the Sokoban application
 * @author Thibault - Mathie
 *
 */
public class Main {

	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		new Sokoban(new Level()).play();
	}

}
