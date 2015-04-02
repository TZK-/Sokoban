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
	
	/**
	 * Construit une position par defaut: (0, 0)
	 */
	public Position(){
		this.posX = 0;
		this.posY = 0;
	}
	
	/**
	 * Construit une position
	 * @param posX La position en abscisse
	 * @param posY La position en ordonnée
	 */
	public Position(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Retourne la valeur de l'abscisse
	 * @return La valeur de l'abscisse
	 */
	public int getPosX() {
		return posX;
	}

	
	/**
	 * Retourne la valeur de l'ordonnée
	 * @return La valeur de l'ordonnée
	 */
	public int getPosY() {
		return posY;
	}
	
}
