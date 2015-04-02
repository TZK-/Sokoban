package fr.iutvalence.info.m2103.sokoban;

public class Position {
	
	/**
	 * Position en abscisse 
	 */
	private final int posX;
	
	/**
	 * Postion en ordonnee
	 */
	private final int posY;
	
	
	public Position(){
		this.posX = 0;
		this.posY = 0;
	}
	
	public Position(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
}
