package fr.iutvalence.sokoban.launcher;

import javax.swing.SwingUtilities;

import fr.iutvalence.sokoban.core.Sokoban;
import fr.iutvalence.sokoban.ui.graphic.MenuWindow;

/**
 * Launcher of the Sokoban application
 */
public class Main {

	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		MenuWindow sokobanMenu = new MenuWindow();
		SwingUtilities.invokeLater(sokobanMenu);
		while(!sokobanMenu.isLevelSelected()){
			// wait
		}
		new Sokoban(sokobanMenu.getGameWindow(), sokobanMenu.getGameWindow()).play();
	}

}
