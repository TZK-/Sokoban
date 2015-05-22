package fr.iutvalence.info.m2103.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import fr.iutvalence.info.m2103.sokoban.Sokoban;

/**
 * 
 */
public class MainWindow implements Runnable{

	private static final String SOKOBAN_APP_NAME = "Sokoban";

	private static final int DEFAULT_SIZE_X = 800;

	private static final int DEFAULT_SIZE_Y = 600;

	/**
	 * The main window
	 */
	private JFrame window;

	/**
	 * The vertical pane containing all the panels
	 */
	private JSplitPane verticalSplitPane;
	
	private SokobanLevelGridPanel levelGridPanel;
	
	private Sokoban sokobanGame;
	
	/**
	 * Creates the main window
	 */
	public MainWindow(Sokoban sokobanGame) {
		super();
		this.sokobanGame = sokobanGame;
		this.window = new JFrame();
		this.verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.levelGridPanel = new SokobanLevelGridPanel(this.sokobanGame.getLevel());
	}

	/**
	 * Initializes the window
	 */
	public void initGui(){
		this.window.setTitle(SOKOBAN_APP_NAME);
		this.window.setSize(this.levelGridPanel.getPanelSize());
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.verticalSplitPane.add(this.levelGridPanel);
		this.window.getContentPane().add(this.verticalSplitPane);
		
		this.window.setVisible(true);
	}
	
	@Override
	public void run() {
		this.initGui();
	}

}
