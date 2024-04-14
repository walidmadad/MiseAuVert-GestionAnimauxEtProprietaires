package Controlleur;

public class AjouterAnimal {
	
	private String msg;
	public AjouterAnimal(String nom_animal, int id_espece, int id_prop) {
		Modele.AjouterAnimal ajAn = new Modele.AjouterAnimal(nom_animal, id_espece, id_prop);
		if(ajAn.getVerifAjoutation()) {
			msg = ajAn.getMsg();
		}else {
			msg =ajAn.getMsg();
		}
	}
	
	public String getMsg() {
		return msg;
	}
}
