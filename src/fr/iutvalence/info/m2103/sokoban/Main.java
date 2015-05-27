package fr.iutvalence.info.m2103.sokoban;

import javax.swing.SwingUtilities;

import fr.iutvalence.info.m2103.gui.MainWindow;


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
