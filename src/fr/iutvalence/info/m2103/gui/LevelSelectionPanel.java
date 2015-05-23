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
	
	private Level selectedLevel;
	
	public LevelSelectionPanel(){
		
		this.levelList = new JComboBox<String>(Level.getLevels());
		this.validationButton = new JButton("Validate");
		this.selectedLevel = null;
		
		this.add(this.levelList);
		this.add(this.validationButton);
		
		this.validationButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		
		if(source == this.validationButton){
			try {
				this.selectedLevel = new MapLoader((String) this.levelList.getSelectedItem(), this.levelList.getSelectedIndex()).load();
			} catch (PlayerNotPlacedException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @return the selectedLevel
	 */
	public Level getSelectedLevel() {
		return this.selectedLevel;
	}
	
}
