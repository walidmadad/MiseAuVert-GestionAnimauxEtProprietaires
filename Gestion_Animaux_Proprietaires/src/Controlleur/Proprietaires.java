package Controlleur;

import java.util.ArrayList;

public class Proprietaires {
	private ArrayList<String> info; 
	private ArrayList<String> id_prop;
	private String nom, prenom, adresse, dateNaissance, tel, email, msg;

	
	public Proprietaires() {
		this.info = new ArrayList<>();
		this.id_prop = new ArrayList<>();
		Modele.Proprietaires prop = new Modele.Proprietaires();
		this.info.addAll(prop.getProprietaires());
		this.id_prop.addAll(prop.getId());
	}
	public Proprietaires(int id) {
		Modele.Proprietaires prop = new Modele.Proprietaires(id);
		this.nom = prop.getNom();
		this.prenom = prop.getPrenom();
		this.adresse = prop.getAdresse();
		this.dateNaissance = prop.getDateNaissance();
		this.tel = prop.getTel();
		this.email = prop.getEmail();
	}
	public Proprietaires(int id, String nom,String prenom, String adresse, String dateNaissance, String tel, String email) {
		Modele.Proprietaires prop = new Modele.Proprietaires(id, nom, prenom, adresse, dateNaissance, tel, email);
		if(prop.modifierDonneesProp()) {
			this.msg= prop.getMsg();
		}
		else {
			this.msg = prop.getMsg();
		}
	}
	public String getMsg() {
		return msg;
	}
	
	public ArrayList<String> getProprietaires(){
		return info;
	}
	public ArrayList<String> getId(){
		return id_prop;
	}
	public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }
}
