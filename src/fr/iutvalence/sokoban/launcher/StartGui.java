package fr.iutvalence.sokoban.launcher;

import javax.swing.SwingUtilities;

import fr.iutvalence.sokoban.core.Sokoban;
import fr.iutvalence.sokoban.ui.graphic.GameWindow;
import fr.iutvalence.sokoban.ui.graphic.MenuWindow;

public class StartGui {

	public StartGui(){
		MenuWindow sokobanMenu = new MenuWindow();
		SwingUtilities.invokeLater(sokobanMenu);
		
		while(true){
			if(sokobanMenu.isLevelSelected())
				break;
		}

		GameWindow game = sokobanMenu.getGameWindow();
		new Sokoban(game, game).play();
	}
	
}
