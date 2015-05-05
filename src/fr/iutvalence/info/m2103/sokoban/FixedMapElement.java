package fr.iutvalence.info.m2103.sokoban;

/**
 * Represents all the elements constituting the map
 * @author Thibault - Mathie
 *
 */
public enum FixedMapElement {
	
	/**
	 * Wall
	 */
	WALL("#"),
	
	/**
	 * Floor
	 */
	FLOOR(" "),
	
	/**
	 * Target where the box should be placed 
	 */
	TARGET(".");
	

	/**
	 * The string representation of the Element
	 */
	private String asciiString;

	/**
	 * Creates a new Element with a string representation
	 * @param asciiString The string representation
	 */
	FixedMapElement(String asciiString){
		this.asciiString = asciiString;
	}

	@Override
	public String toString(){
		return this.asciiString;
	}
	
}
