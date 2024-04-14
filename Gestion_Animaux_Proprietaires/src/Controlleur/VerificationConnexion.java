package Controlleur;

import Modele.*;

public class VerificationConnexion {
	public VerificationConnexion(String email, String mdp) {
		VerifierIdentifiant verif = new VerifierIdentifiant(email,mdp);
		if(verif.getVerification()) {
			goToAccueil(verif.getNom(), verif.getId());
		}
	}
	public void goToAccueil(String nom, int id){
		Vue.ModifDonnee modifDonneeFrame = new Vue.ModifDonnee(nom, id);
        modifDonneeFrame.setVisible(true);
        
	}
}
