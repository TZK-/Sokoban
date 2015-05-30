package fr.iutvalence.sokoban.ui.graphic;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.sokoban.core.FixedMapElement;
import fr.iutvalence.sokoban.core.Level;
import fr.iutvalence.sokoban.core.Position;

/**
 * Panel containing the level's map representation
 */
public class LevelGridPanel extends JPanel{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4650266191907566738L;
	
	/**
	 * Creates a new level grid panel.
	 * It generates a graphic display of the given level
	 * @param level The current level
	 */
	public LevelGridPanel(Level level) {
		super();
		
		this.setLayout(new GridLayout(level.getMapHeight(), level.getMapWidth()));
		ImageIcon ico = null;
		for (int line = 0; line < level.getMapHeight(); line++) {
			for (int column = 0; column < level.getMapWidth(); column++) {
				Position pos = new Position(line, column);
				switch (level.getFixedMapElement(pos)) {
					case FLOOR:
						ico = new ImageIcon();
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
				if(level.isBoxAt(pos)){
					if(level.getFixedMapElement(pos) == FixedMapElement.TARGET)
						ico = new ImageIcon(this.getClass().getResource("/ressources/boxOnTarget.jpg"));
					else
						ico = new ImageIcon(this.getClass().getResource("/ressources/box.jpg"));
				}
				
				JLabel levelElement = new JLabel(ico);
				this.add(levelElement);
			}
		}
	}

}