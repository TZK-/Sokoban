package fr.iutvalence.info.m2103.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import fr.iutvalence.info.m2103.interfaces.Display;
import fr.iutvalence.info.m2103.interfaces.PlayerInteraction;
import fr.iutvalence.info.m2103.sokoban.Direction;
import fr.iutvalence.info.m2103.sokoban.Level;
import fr.iutvalence.info.m2103.sokoban.Sokoban;

/**
 * 
 */
public class MainWindow implements Runnable, ActionListener, PlayerInteraction, Display{

	/**
	 * The application's name
	 */
	private static final String SOKOBAN_APP_NAME = "Sokoban";


	/**
	 * The main window
	 */
	private JFrame window;

	/**
	 * The vertical pane containing all the split panel
	 */
	private JSplitPane mainSplitPanel;
	
	/**
	 * The vertical pane containing the level grid panel
	 */
	private JSplitPane splitPaneLevelGrid;
	
	/**
	 * The vertical pane containing the controller panel
	 */
	private JSplitPane splitPaneController;
	
	/**
	 * The quit button
	 */
	private JButton quitButton;
	
	/**
	 * The reset level button
	 */
	private JButton resetLevelButton;
	
	/**
	 * The level selection panel
	 */
	private LevelSelectionPanel levelSelectionPanel;
	
	/**
	 * The level grid panel
	 */
	private LevelGridPanel levelGridPanel;
	
	/**
	 * The controller panel
	 */
	private ControllerPanel controllerPanel;
	


	private Direction chosenDirection;
	
	private boolean isDirectionChoose;
	
	/**
	 * Creates the main window
	 * @param sokobanGame The sokoban game
	 */
	public MainWindow() {
		super();
		this.window = new JFrame();
		
		this.mainSplitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.splitPaneLevelGrid = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.splitPaneController = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		this.quitButton = new JButton("Quit");
		this.resetLevelButton = new JButton("Reset");
		
		this.quitButton.addActionListener(this);
		this.resetLevelButton.addActionListener(this);
		
		this.levelSelectionPanel = new LevelSelectionPanel();

		this.controllerPanel = new ControllerPanel(this);

		this.isDirectionChoose = false;
	}

	/**
	 * Initializes the window
	 */
	public void initGui(){
		this.window.setTitle(SOKOBAN_APP_NAME);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JPanel quitPanel = new JPanel();
		quitPanel.add(this.resetLevelButton);
		quitPanel.add(this.quitButton);
		
		this.mainSplitPanel.add(this.levelSelectionPanel);
		this.mainSplitPanel.add(this.splitPaneLevelGrid);
		this.splitPaneLevelGrid.add(this.splitPaneController);
		this.splitPaneController.add(this.controllerPanel);
		this.splitPaneController.add(quitPanel);
		
		this.window.getContentPane().add(this.mainSplitPanel);
		
		this.window.pack();
		this.window.setResizable(false);
		this.window.setVisible(true);
	}
	
	@Override
	public void run() {
		this.initGui();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JComponent source = (JComponent) event.getSource();
		
		if(source == this.quitButton)
			this.askToQuit();
		if(source == this.resetLevelButton){
			//TODO
		}
		
		if(source == this.controllerPanel){
			JButtonDirection sourceDirection = (JButtonDirection) source;
			this.isDirectionChoose = true;
			this.chosenDirection = sourceDirection.getDirection();
		}
			
	}

	@Override
	public Direction askDirection() {
		while(true){
			if(this.isDirectionChoose)
				break;
		}
		this.isDirectionChoose = false;
		return this.chosenDirection;
	}

	@Override
	public int askLevelToPlay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void askToQuit() {
		System.exit(0);
	}

	@Override
	public void displayMessage(String msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayStartingMessage() {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayWinMessage(int turn) {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayLevel(Level level) {
		this.levelGridPanel = new LevelGridPanel(level);
		this.splitPaneLevelGrid.add(this.levelGridPanel);
	}

}
