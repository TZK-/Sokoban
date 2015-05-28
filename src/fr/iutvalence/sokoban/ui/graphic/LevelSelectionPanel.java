package fr.iutvalence.sokoban.ui.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.iutvalence.sokoban.core.Level;

public class LevelSelectionPanel extends JPanel implements ActionListener{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 4640854857338587932L;

	/**
	 * The level combo list
	 */
	private JComboBox<String> levelList;
	
	/**
	 * The validation button
	 */
	private JButton validationButton;
	
	/**
	 * The selected level
	 */
	private int selectedLevel;
	
	/**
	 * Creates a new level selection panel
	 */
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
