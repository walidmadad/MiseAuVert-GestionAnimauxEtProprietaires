package Controlleur;

import Modele.AfficherEspece;
import java.util.ArrayList;

public class Espece {
    private ArrayList<String> especes;
    private ArrayList<String> id;
    private int id_espece;
    private String nom_espece;

    public Espece() {
        this.especes = new ArrayList<>();
        this.id = new ArrayList<>();
        AfficherEspece afficherEspece = new AfficherEspece();
        this.especes.addAll(afficherEspece.getEspeces());
        this.id.addAll(afficherEspece.getid());
    }
    public Espece(int id) {
    	AfficherEspece afficherEspece = new AfficherEspece(id);
    	this.id_espece = afficherEspece.getIdEspece();
    	this.nom_espece = afficherEspece.getNomEspece();
    }

    public ArrayList<String> getEspeces() {
        return this.especes;
    }
    public ArrayList<String> getId() {
        
        return this.id;
    }
    public int getIdEspece() {
    	return this.id_espece;
    }
    public String getNomEspece() {
    	return this.nom_espece;
    }
}
