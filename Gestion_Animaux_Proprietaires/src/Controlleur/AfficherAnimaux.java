package Controlleur;

import java.util.ArrayList;

public class AfficherAnimaux {
	private ArrayList<String> nom_animaux, especes;
	private ArrayList<String> id_animaux, id_especes;
	public AfficherAnimaux(int id_prop) {
		this.nom_animaux = new ArrayList<>();
		this.id_animaux = new ArrayList<>();
		this.especes = new ArrayList<>();
		this.id_especes = new ArrayList<>();
		Modele.AfficherAnimaux afficher = new Modele.AfficherAnimaux(id_prop);
		this.nom_animaux.addAll(afficher.getNomAnimaux());
		this.id_animaux.addAll(afficher.getIdAnimaux());
		this.especes.addAll(afficher.getEspeces());
		this.id_especes.addAll(afficher.getIdEspeces());
	}
	public ArrayList<String> getNomAnimaux(){
		return nom_animaux;
	}
	public ArrayList<String> getIdAnimaux(){
		return id_animaux;
	}
	public ArrayList<String> getIdEspeces(){
		return id_especes;
	}
	public ArrayList<String> getEspeces(){
		return especes;
	}
	
}
