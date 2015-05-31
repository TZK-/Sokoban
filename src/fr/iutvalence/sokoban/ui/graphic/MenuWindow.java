package fr.iutvalence.sokoban.ui.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import fr.iutvalence.sokoban.core.Sokoban;

/**
 * The main menu of the SOkoban
 */
public class MenuWindow extends JFrame implements ActionListener, Runnable{
	
	/**
	 * The level selection panel
	 */
	private LevelSelectionPanel levelSelectionPanel;
	
	private volatile boolean isLevelSelected;
	
	private GameWindow gameWindow;
	
	public MenuWindow() {
		super(Sokoban.APP_NAME);
		this.gameWindow = null;
		this.isLevelSelected = false;
		this.levelSelectionPanel = new LevelSelectionPanel(this);
		this.getContentPane().add(this.levelSelectionPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JComponent source = (JComponent) event.getSource();
		
		if(source == this.levelSelectionPanel.getValidationButton()){
			this.gameWindow = new GameWindow(this.levelSelectionPanel.getLevelList().getSelectedIndex());
			this.isLevelSelected = true;
			
			this.gameWindow.initGui();
			
			this.dispose();
		}
	}

	@Override
	public void run() {
		this.setVisible(true);
	}

	/**
	 * @return the isLevelSelected
	 */
	public boolean isLevelSelected() {
		return this.isLevelSelected;
	}

	/**
	 * @return the gameWindow
	 */
	public GameWindow getGameWindow() {
		return this.gameWindow;
	}
	
}
