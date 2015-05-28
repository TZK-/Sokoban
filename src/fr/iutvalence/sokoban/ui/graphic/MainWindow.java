package fr.iutvalence.sokoban.ui.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import fr.iutvalence.sokoban.core.Direction;
import fr.iutvalence.sokoban.core.Level;
import fr.iutvalence.sokoban.core.MapLoader;
import fr.iutvalence.sokoban.exceptions.PlayerNotPlacedException;
import fr.iutvalence.sokoban.interfaces.Display;
import fr.iutvalence.sokoban.interfaces.PlayerInteraction;

/**
 * Represents the main window of the Sokoban game.
 * It displays the level and the controller buttons.
 */
public class MainWindow implements Runnable, ActionListener, KeyListener, PlayerInteraction, Display{

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
	private JSplitPane secondSplitPane;
	
	/**
	 * The quit button
	 */
	private JButton quitButton;
	
	/**
	 * The reset level button
	 */
	private JButton resetLevelButton;
	
	/**
	 * The level grid panel
	 */
	private LevelGridPanel levelGridPanel;
	
	/**
	 * The controller panel
	 */
	private ControllerPanel controllerPanel;

	/**
	 * The chosen direction
	 */
	private Direction chosenDirection;
	
	/**
	 * <tt>True</tt> if a direction has been choose.
	 */
	private volatile boolean isDirectionChosen;
	
	/**
	 * The copy of the level at its creation
	 */
	@SuppressWarnings("unused")
	private Level beginingLevelCopie;
	
	/**
	 * Creates the main window.
	 */
	public MainWindow() {
		super();
		
		this.chosenDirection = null;
		this.isDirectionChosen = false;
		
		/*
		 * Creating Objects instances
		 */
		this.window = new JFrame();
		this.mainSplitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.secondSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		this.controllerPanel = new ControllerPanel(this);
		
		// TODO Add selection level
		Level levelToPlay = null;
		try {
			levelToPlay = new MapLoader("level0.txt", 0).load();
		} catch (PlayerNotPlacedException e1) {
			e1.printStackTrace();
		}
		this.beginingLevelCopie = null;
		try {
			this.beginingLevelCopie = levelToPlay.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		this.levelGridPanel = new LevelGridPanel(levelToPlay);
		
		this.quitButton = new JButton("Quit");
		this.quitButton.setFocusable(false);
		this.resetLevelButton = new JButton("Reset");
		this.resetLevelButton.setFocusable(false);
		
		/*
		 * Setting Listener
		 */
		this.quitButton.addActionListener(this);
		this.resetLevelButton.addActionListener(this);
		this.window.addKeyListener(this);
	}

	/**
	 * Initializes the window
	 */
	public void initGui(){
		this.window.setTitle(SOKOBAN_APP_NAME);
		this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel quitPanel = new JPanel();
		quitPanel.add(this.resetLevelButton);
		quitPanel.add(this.quitButton);
		
		this.mainSplitPanel.add(this.levelGridPanel);
		this.mainSplitPanel.add(this.secondSplitPane);
		this.secondSplitPane.add(this.controllerPanel);
		this.secondSplitPane.add(quitPanel);
		
		this.mainSplitPanel.setDividerSize(0);
		this.secondSplitPane.setDividerSize(0);
		
		this.window.getContentPane().add(this.mainSplitPanel);
		
		this.window.setResizable(false);
		this.window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JComponent source = (JComponent) event.getSource();
		
		if(source == this.quitButton)
			this.askToQuit();
		if(source == this.resetLevelButton){
			this.chosenDirection = null;
			this.isDirectionChosen = true;
		}
		
		if(source == this.controllerPanel.getDownButton()
				|| source == this.controllerPanel.getUpButton()
				|| source == this.controllerPanel.getLeftButton()
				|| source == this.controllerPanel.getRightButton()){
			JButtonDirection sourceDirection = (JButtonDirection) source;
			this.chosenDirection = sourceDirection.getDirection();
			this.isDirectionChosen = true;
		}
			
	}

	@Override
	public Direction askDirection() {
		
		while (!this.isDirectionChosen) {
			// Nothing to do
		}
	
		this.isDirectionChosen = false;
		return this.chosenDirection;
	}

	@Override
	public void askToQuit() {

		JDialog.setDefaultLookAndFeelDecorated(true);
		int response = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	@Override
	public int askLevelToPlay() {
		/* TODO Adding a new starting window which permits to select the level to play.
		 * For the moment, it will return the level with the index 3
		 */
		return 3;
	}
	
	@Override
	public void displayMessage(String msg) {
		this.levelGridPanel.setMessage(msg);
	}

	@Override
	public void displayLevel(Level level) {
		this.levelGridPanel = new LevelGridPanel(level);
		this.mainSplitPanel.setTopComponent(this.levelGridPanel);
		this.window.pack();
	}
	
	@Override
	public void displayStartingMessage() {
		// TOTO Adding starting message to the level selection window
	}
	
	@Override
	public void run() {
		this.initGui();
	}

	@Override
	public void keyTyped(KeyEvent event) {
		switch(event.getKeyChar()){
			case 'z':
				this.chosenDirection = Direction.UP;
				this.isDirectionChosen = true;
				break;
			case 'q':
				this.chosenDirection = Direction.LEFT;
				this.isDirectionChosen = true;
				break;
			case 's':
				this.chosenDirection = Direction.DOWN;
				this.isDirectionChosen = true;
				break;
			case 'd':
				this.chosenDirection = Direction.RIGHT;
				this.isDirectionChosen = true;
				break;
			default:
				break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		// Nothing to do
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// Nothing to do
	}
}
