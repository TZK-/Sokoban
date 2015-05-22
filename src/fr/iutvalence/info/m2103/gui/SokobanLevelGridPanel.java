package fr.iutvalence.info.m2103.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

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
	 * The sprite map element dimension
	 */
	private Dimension panelSize;
	
	/**
	 * Creates a new level grid panel.
	 * It generates a graphic display of the given level
	 * @param level The current level
	 */
	public SokobanLevelGridPanel(Level level) {
		super();
		this.setLayout(new GridLayout(level.getMapHeight(), level.getMapWidth()));
		ImageIcon ico = null;
		for (int line = 0; line < level.getMapHeight(); line++) {
			for (int column = 0; column < level.getMapWidth(); column++) {
				Position pos = new Position(line, column);
				switch (level.getFixedMapElement(pos)) {
				case FLOOR:
					ico = new ImageIcon(this.getClass().getResource("/ressources/floor.gif"));
					break;
				case WALL:
					ico = new ImageIcon(this.getClass().getResource("/ressources/wall.jpg"));
					break;
				case TARGET:
					ico = new ImageIcon(this.getClass().getResource("/ressources/target.png"));
					break;
				default:
					break;
				}
				
				if(pos.equals(level.getCharacterPosition()))
					ico = new ImageIcon(this.getClass().getResource("/ressources/character.gif"));
				if(level.isBoxAt(pos))
					ico = new ImageIcon(this.getClass().getResource("/ressources/box.jpg"));
				
				LevelMapElement levelElement = new LevelMapElement(ico, pos);
				this.add(levelElement);
			}
		}
		
		this.panelSize = new Dimension(ico.getIconHeight() * level.getMapHeight(), ico.getIconWidth() * level.getMapWidth());
	}

	/**
	 * @return the panel size
	 */
	public Dimension getPanelSize() {
		return this.panelSize;
	}

}