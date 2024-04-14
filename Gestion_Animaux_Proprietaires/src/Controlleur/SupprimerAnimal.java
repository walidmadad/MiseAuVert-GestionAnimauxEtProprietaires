package Controlleur;

public class SupprimerAnimal {
	String msg;
	public SupprimerAnimal(int id) {
		
		Modele.SupprimerAnimal SuppAnimal = new Modele.SupprimerAnimal(id);
		if(SuppAnimal.getVerifSupprimer()) {
			msg = SuppAnimal.getMsg();
		}else {
			msg = SuppAnimal.getMsg();
		}
	
	}
	public String getMsg() {
		return msg;
	}
}
