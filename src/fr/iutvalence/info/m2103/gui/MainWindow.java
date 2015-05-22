package fr.iutvalence.info.m2103.gui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

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
	
	
	/**
	 * Creates the main window
	 */
	public MainWindow() {
		super();
		this.window = new JFrame();
		this.verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.levelGridPanel = new SokobanLevelGridPanel();
	}

	/**
	 * Initializes the window
	 */
	public void initGui(){
		this.window.setTitle(SOKOBAN_APP_NAME);
		this.window.setSize(DEFAULT_SIZE_X, DEFAULT_SIZE_Y);
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
