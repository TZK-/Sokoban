package fr.iutvalence.sokoban.core;

import javax.swing.SwingUtilities;

import fr.iutvalence.sokoban.ui.graphic.MainWindow;

/**
 * Launcher of the Sokoban application
 */
public class Main {

	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		//new Sokoban(new HumanPlayerConsole(), new DisplayConsole()).play();
		MainWindow sokobanGUI = new MainWindow();
		SwingUtilities.invokeLater(sokobanGUI);
		new Sokoban(sokobanGUI, sokobanGUI).play();
	}

}
