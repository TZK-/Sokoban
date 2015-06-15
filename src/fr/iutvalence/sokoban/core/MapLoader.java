package fr.iutvalence.sokoban.core;

import fr.iutvalence.sokoban.exceptions.PlayerNotPlacedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is used to load levels from files.
 * Levels are specified by symbols.
 * @see "http://sokobano.de/wiki/index.php?title=Level_format"
 *
 */
public class MapLoader{
	
	/**
	 * The level file
	 */
	private File levelFile;

	/**
	 * The height of the map
	 */
	private int mapHeight;
	
	/**
	 * The width of the map
	 */
	private int mapWidth;
	
	/**
	 * 2D grid of fixedElements
	 * @see fr.iutvalence.sokoban.core.FixedMapElement
	 */ 
	private FixedMapElement[][] fixedElements;
	
	/**
	 * The boxes positions on the map
	 */
	private List<Position> boxPositions;

	/**
	 * The position of the character
	 */
	private Position characterPosition;
	
	/**
	 * The level number
	 */
	private int levelNumber;
	
	/**
	 * Initializes the MapLoader.
	 * @param levelName The level name
	 * @param levelNumber The level number
	 */
	public MapLoader(String levelName, int levelNumber) {
		this.fixedElements = null;
		this.boxPositions = new ArrayList<Position>();
		this.characterPosition = null;
		this.mapHeight = 0;
		this.mapWidth = 0;
		this.levelNumber = levelNumber;
		
		this.levelFile = new File(Level.LEVELS_FOLDER + File.separator + levelName);

	}
	
	/**
	 * Load the level from the file
	 * @return A new Level object
	 * @throws PlayerNotPlacedException if the player has not been placed on the map
	 */
	public Level load() throws PlayerNotPlacedException{
		BufferedReader buffer = null;
		try {
			
			buffer = new BufferedReader(new FileReader(this.levelFile));
			buffer.mark(512);
			String currentLine;

			StringBuilder allLines = new StringBuilder();
			
			/*
			 * Gets the height and width of the level
			 */
			while((currentLine = buffer.readLine()) != null){
				this.mapHeight++;
				if(this.mapWidth < currentLine.length())
					this.mapWidth = currentLine.length();
			}

			buffer.reset();
			
			while((currentLine = buffer.readLine()) != null){
				while(currentLine.length() % this.mapWidth != 0){
					currentLine += " ";
				}
				allLines.append(currentLine);
			}
			
			buffer.close();
			
			this.fixedElements = new FixedMapElement[this.mapHeight][this.mapWidth];
			boolean isCharacterPlaced = false;
			
			for (int line = 0; line < this.mapHeight; line++) {
				for (int column = 0; column < this.mapWidth; column++) {
					
					Position pos = new Position(line, column);
					char currentChar = allLines.charAt(line * this.mapWidth + column);
					switch (currentChar) {
						case Level.BOX_REPRESENTATION:
							this.boxPositions.add(pos);
							this.fixedElements[pos.getPosX()][pos.getPosY()] = FixedMapElement.FLOOR;
							break;
						case Level.CHARACTER_REPRESENTATION:
							this.characterPosition = pos;
							this.fixedElements[pos.getPosX()][pos.getPosY()] = FixedMapElement.FLOOR;
							isCharacterPlaced = true;
							break;
						case Level.BOX_REPRESENTATION_ON_TARGET:
							this.boxPositions.add(pos);
							this.fixedElements[pos.getPosX()][pos.getPosY()] = FixedMapElement.TARGET;
							break;
						case Level.CHARACTER_REPRESENTATION_ON_TARGET:
							this.characterPosition = pos;
							this.fixedElements[pos.getPosX()][pos.getPosY()] = FixedMapElement.TARGET;
							isCharacterPlaced = true;
							break;
						default:
							try{
								this.fixedElements[pos.getPosX()][pos.getPosY()] = FixedMapElement.fromString(Character.toString(currentChar));
							}catch(IllegalArgumentException e){
								System.out.println(e.getMessage());
							}
							break;
					}
				}
			}
			
			if(!isCharacterPlaced)
				throw new PlayerNotPlacedException();
			
			return new Level(this.fixedElements, (Position[]) this.boxPositions.toArray(new Position[this.boxPositions.size()]), this.characterPosition, this.levelNumber);
			
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
}
