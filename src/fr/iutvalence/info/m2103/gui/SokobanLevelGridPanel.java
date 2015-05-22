package fr.iutvalence.info.m2103.gui;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.iutvalence.info.m2103.sokoban.Level;
import fr.iutvalence.info.m2103.sokoban.Position;

/**
 * Panel containing the level's map representation
 */
public class SokobanLevelGridPanel extends JPanel{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4650266191907566738L;
	
	/**
	 * A grid layout
	 */
	private GridLayout gridLayout;
	
	/**
	 * 
	 */
	public SokobanLevelGridPanel(Level level) {
		super();
		this.setLayout(new GridLayout(level.getMapHeight(), level.getMapWidth()));
		for (int line = 0; line < this.gridLayout.getRows(); line++) {
			for (int column = 0; column < this.gridLayout.getColumns(); column++) {
				ImageIcon ico = null;
				Position pos = new Position(line, column);
				switch (level.getFixedMapElement(pos)) {
				case FLOOR:
					ico = new ImageIcon(this.getClass().getResource("ressources/floor.gif"));
					break;
				case WALL:
					ico = new ImageIcon(this.getClass().getResource("ressources/wall.jpg"));
					break;
				case TARGET:
					ico = new ImageIcon(this.getClass().getResource("ressources/target.png"));
					break;
				default:
					if(pos.equals(level.getCharacterPosition()))
						ico = new ImageIcon(this.getClass().getResource("ressources/character.gif"));
					else
						ico = new ImageIcon(this.getClass().getResource("ressources/box.gif"));
					break;
				}
				//TODO check box pos
				this.add(new LevelMapElement(ico, new Position(line, column)));
			}
		}
	}

	
}
