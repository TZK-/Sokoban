package fr.iutvalence.info.m2103.sokoban;

public class Niveau {
	
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
	public Niveau(){
		this.numeroNiveau = Niveau.NIVEAU_PAR_DEFAUT;
	}
	
	/**
	 * Construit un niveau
	 * @param numeroNiveau le numéro de niveau a créer
	 */
	public Niveau(int numeroNiveau){
		this.numeroNiveau = numeroNiveau;
	}
	
}
