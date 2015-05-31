package fr.iutvalence.sokoban.ui.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import fr.iutvalence.sokoban.core.Direction;
import fr.iutvalence.sokoban.core.Level;
import fr.iutvalence.sokoban.core.Sokoban;
import fr.iutvalence.sokoban.interfaces.Display;
import fr.iutvalence.sokoban.interfaces.PlayerInteraction;

/**
 * Represents the main window of the Sokoban game.
 * It displays the level and the controller buttons.
 */
public class GameWindow extends JFrame implements ActionListener, KeyListener, PlayerInteraction, Display{

	/**
	 * The vertical pane containing all the split panel
	 */
	private JSplitPane mainSplitPanel;

	/**
	 * The vertical pane containing the message label
	 */
	private JSplitPane secondSplitPane;
	
	/**
	 * The vertical pane containing the level grid panel
	 */
	private JSplitPane thirdSplitPane;

	/**
	 * The quit button
	 */
	private JButton quitButton;

	/**
	 * The reset level button
	 */
	private JButton resetLevelButton;

	/**
	 * Label used to display message to the screen
	 */
	private JLabel labelMessage;
	
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
	 * The selected level
	 */
	private int selectedLevel;
	
	/**
	 * Creates the main window.
	 */
	public GameWindow(int selectedLevel) {
		super();

		this.chosenDirection = null;
		this.isDirectionChosen = false;
		this.selectedLevel = selectedLevel;

		/*
		 * Creating Objects instances
		 */
		this.mainSplitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.secondSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.thirdSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		this.thirdSplitPane.setDividerSize(0);
		
		this.controllerPanel = new ControllerPanel(this);

		// TODO Add selection level
		this.levelGridPanel = null;

		this.quitButton = new JButton("Quit");
		this.quitButton.setFocusable(false);
		this.resetLevelButton = new JButton("Reset");
		this.resetLevelButton.setFocusable(false);
		
		this.labelMessage = new JLabel("ttt");
		
		/*
		 * Setting Listener
		 */
		this.quitButton.addActionListener(this);
		this.resetLevelButton.addActionListener(this);
		this.addKeyListener(this);
	}

	/**
	 * Initializes the window
	 */
	public void initGui(){
		this.setTitle(Sokoban.APP_NAME);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel quitPanel = new JPanel();
		quitPanel.add(this.resetLevelButton);
		quitPanel.add(this.quitButton);

		this.mainSplitPanel.add(this.labelMessage);
		this.mainSplitPanel.add(this.secondSplitPane);
		
		this.secondSplitPane.setBottomComponent(this.thirdSplitPane);
		
		this.thirdSplitPane.add(this.controllerPanel);
		this.thirdSplitPane.add(quitPanel);
		
		this.getContentPane().add(this.mainSplitPanel);

		//this.window.setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JComponent source = (JComponent) event.getSource();

		if(source == this.quitButton)
			this.askToQuit();
		if(source == this.resetLevelButton){
			this.labelMessage.setText("Level resetted");
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
		return this.selectedLevel;
	}

	@Override
	public void displayMessage(String msg) {
		this.labelMessage.setText(msg);
	}

	@Override
	public void displayLevel(Level level) {
		this.levelGridPanel = new LevelGridPanel(level);
		this.secondSplitPane.setTopComponent(this.levelGridPanel);
		this.pack();
	}

	@Override
	public void displayStartingMessage() {
		// Nothing to do
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
