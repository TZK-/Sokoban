package fr.iutvalence.info.m2103.sokoban;

public class Level {
	
	/**
	 * Numéro du niveau par défaut
	 */
	public static final int NIVEAU_PAR_DEFAUT = 1;
	
	/**
	 * Numéro du niveau
	 */
	private int numeroNiveau;
	
	/**
	 * Construit le niveau par défaut
	 */
	public Level(){
		this.numeroNiveau = Level.NIVEAU_PAR_DEFAUT;
	}
	
	/**
	 * Construit un niveau
	 * @param numeroNiveau le numéro de niveau a créer
	 */
	public Level(int numeroNiveau){
		this.numeroNiveau = numeroNiveau;
	}
	
}
