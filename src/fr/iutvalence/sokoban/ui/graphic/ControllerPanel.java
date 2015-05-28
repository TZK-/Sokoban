package fr.iutvalence.sokoban.ui.graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import fr.iutvalence.sokoban.core.Direction;

/**
 * Represents the controller panel.
 * It includes buttons to choose the direction to move
 */
public class ControllerPanel extends JPanel{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 2276797078024689626L;

	/**
	 * The up button
	 */
	private JButtonDirection upButton;
	
	/**
	 * The down button
	 */
	private JButtonDirection downButton;
	
	/**
	 * The left button
	 */
	private JButtonDirection leftButton;
	
	/**
	 * The right button
	 */
	private JButtonDirection rightButton;
	
	
	/**
	 * Creates the controller panel
	 * @param event The event manager
	 */
	public ControllerPanel(ActionListener event){
		this.upButton = new JButtonDirection("U", Direction.UP);
		this.downButton = new JButtonDirection("D", Direction.DOWN);
		this.rightButton = new JButtonDirection("R", Direction.RIGHT);
		this.leftButton = new JButtonDirection("L", Direction.LEFT);
		
		this.upButton.addActionListener(event);
		this.downButton.addActionListener(event);
		this.leftButton.addActionListener(event);
		this.rightButton.addActionListener(event);
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(this.upButton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(this.downButton, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(this.rightButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.leftButton, gbc);
		
	}

	/**
	 * @return The up button
	 */
	public JButtonDirection getUpButton() {
		return this.upButton;
	}

	/**
	 * @return The down button
	 */
	public JButtonDirection getDownButton() {
		return this.downButton;
	}

	/**
	 * @return The left button
	 */
	public JButtonDirection getLeftButton() {
		return this.leftButton;
	}

	/**
	 * @return The right button
	 */
	public JButtonDirection getRightButton() {
		return this.rightButton;
	}
	
}
