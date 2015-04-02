package fr.iutvalence.info.m2103.sokoban;

public class Joueur {

	/**
	 * Position du joueur
	 */
	private Position position;
	
	
	/**
	 * Construit un joueur a une position donnée
	 * @param pos La position de départ
	 */
	public Joueur(Position pos){
		this.position = pos;
	}
	
	/**
	 * Deplace le joueur 
	 * @param deplacement Le déplacement relatif au joueur
	 * @param niveau Le niveau où le joueur se déplace
	 */
	public void deplacer(Position deplacement, Niveau niveau){
		this.position = new Position(this.position.getPosX() + deplacement.getPosX(), this.position.getPosY() + deplacement.getPosY());
		// TODO Verifier les règles de déplacements (sortie de terrain, collision)
	}
	
}
