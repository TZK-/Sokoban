package fr.iutvalence.info.m2103.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.iutvalence.info.m2103.sokoban.Position;

/**
 * Represents a level map element (CHARACTER, BOX, TARGET...).
 * @see fr.iutvalence.info.m2103.sokoban.Level
 */
public class LevelMapElement extends JLabel{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 5601652385915765161L;

	private Position position;

	public LevelMapElement(ImageIcon icon, Position pos) {
		super(icon);
		this.position = pos;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return this.position;
	}
}
