package fr.iutvalence.info.m2103.gui;

import javax.swing.JButton;

import fr.iutvalence.info.m2103.sokoban.Direction;

public class JButtonDirection extends JButton{

	private Direction direction;

	public JButtonDirection(String name, Direction direction) {
		super(name);
		this.direction = direction;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return this.direction;
	}

}
