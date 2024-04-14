package Controlleur;

public class ModifierAnimal {
	String msg;
	public ModifierAnimal(int id_animal, int id_espece, String nom_animal) {
		Modele.ModifierAnimal modifAnimal = new Modele.ModifierAnimal(id_animal, id_espece, nom_animal);
		if(modifAnimal.modification()) {
			msg = modifAnimal.getMsg();
		}else {
			msg = modifAnimal.getMsg();
		}
	}
	public String getMsg(){
		return msg;
	}
}
