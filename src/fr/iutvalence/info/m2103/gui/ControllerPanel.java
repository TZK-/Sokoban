package fr.iutvalence.info.m2103.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.iutvalence.info.m2103.sokoban.Direction;

public class ControllerPanel extends JPanel{

	private JButtonDirection upButton;
	
	private JButtonDirection downButton;
	
	private JButtonDirection leftButton;
	
	private JButtonDirection rightButton;
	
	
	public ControllerPanel(ActionListener event){
		this.upButton = new JButtonDirection("U", Direction.UP);
		this.downButton = new JButtonDirection("D", Direction.DOWN);
		this.rightButton = new JButtonDirection("R", Direction.RIGHT);
		this.leftButton = new JButtonDirection("L", Direction.LEFT);
		
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
	
}
