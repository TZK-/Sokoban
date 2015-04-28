package fr.iutvalence.info.m2103.sokoban;

/**
 * Represents all the elements constituting the map
 * @author Thibault - Mathie
 *
 */
public enum MapElement {
	
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
	TARGET("."),
	
	/**
	 * Player
	 */
	PLAYER("@"),
	
	/**
	 * Player on target
	 */
	PLAYER_ON_TARGET("+"),
	
	/**
	 * Box
	 */
	BOX("$"),
	
	/**
	 * Box on target
	 */
	BOX_ON_TARGET("*");
	
	
	/**
	 * The string representation of the Element
	 */
	private String name;

	/**
	 * Creates a new Element with a string representation
	 * @param name The string representation
	 */
	MapElement(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return this.name;
	}
	
}
