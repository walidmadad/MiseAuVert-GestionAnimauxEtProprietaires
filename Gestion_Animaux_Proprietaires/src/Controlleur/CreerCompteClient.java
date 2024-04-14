package Controlleur;

public class CreerCompteClient {
	private String message;
	
	
	public CreerCompteClient(String nom, String prenom, String adresse,String dateNaissance,String tel, String email, String mdp) {
		Modele.CreerCompteClient creer = new Modele.CreerCompteClient(nom, prenom, adresse, dateNaissance, tel, email, mdp);
		if(creer.getCompteCreate()) {
			message = creer.getMessage();
		}
		else {
			message = creer.getMessage();
		}
	}
	
	public String getMessage() {
		return message;
	}
}
