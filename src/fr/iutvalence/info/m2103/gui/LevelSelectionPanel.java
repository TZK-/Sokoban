package fr.iutvalence.info.m2103.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.iutvalence.info.m2103.exceptions.PlayerNotPlacedException;
import fr.iutvalence.info.m2103.sokoban.Level;
import fr.iutvalence.info.m2103.sokoban.MapLoader;

public class LevelSelectionPanel extends JPanel implements ActionListener{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 4640854857338587932L;

	private JComboBox<String> levelList;
	
	private JButton validationButton;
	
	private int selectedLevel;
	
	public LevelSelectionPanel(){
		
		this.levelList = new JComboBox<String>(Level.getLevels());
		this.validationButton = new JButton("Validate");
		
		this.add(this.levelList);
		this.add(this.validationButton);
		
		this.validationButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		
		if(source == this.validationButton){
			this.selectedLevel = this.levelList.getSelectedIndex();
		}
	}

	/**
	 * @return the selectedLevel
	 */
	public int getSelectedLevel() {
		return this.selectedLevel;
	}
	
}
