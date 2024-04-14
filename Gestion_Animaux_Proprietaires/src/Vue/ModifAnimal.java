package Vue;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlleur.AfficherAnimaux;
import Controlleur.Espece;
import Controlleur.Proprietaires;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModifAnimal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomProp;
	private JTextField txtPrenom;
	private JTextField txtAdresse;
	private JTextField txtTel;
	private JTextField txtDateNaissance;
	private JComboBox<String> lstProprietaires, ChoixAnimalListe, lstProprietaires_1, EspeceBox;
	private ArrayList<String> idProprietaires, idAnimaux, idProprietaires_1, idEspeces;
    private JLabel lbl_msg;
    private JTextField txtNomAnimal;
    private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifAnimal frame = new ModifAnimal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModifAnimal() {
		idEspeces = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Proprietaire :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 114, 162, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Animal a modifier");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 153, 162, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Modifier un animal");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(75, 53, 295, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nom du Proprietaire :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(308, 114, 190, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Prenom du Proprietaire :");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(308, 212, 211, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_3 = new JLabel("Adresse du Proprietaire :");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_3.setBounds(308, 263, 218, 14);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Numero de telephone :");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_4.setBounds(308, 288, 190, 14);
		contentPane.add(lblNewLabel_4_4);
		
		txtNomProp = new JTextField();
		txtNomProp.setBounds(509, 186, 197, 20);
		contentPane.add(txtNomProp);
		txtNomProp.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(509, 211, 197, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(509, 262, 197, 20);
		contentPane.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(509, 287, 197, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblNewLabel_4_5 = new JLabel("Date de Naissance :");
		lblNewLabel_4_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_5.setBounds(308, 239, 190, 14);
		contentPane.add(lblNewLabel_4_5);
		
		JLabel lblAnimalMsg = new JLabel("");
		lblAnimalMsg.setBounds(43, 350, 181, 13);
		contentPane.add(lblAnimalMsg);
		
		JLabel lblProprietaireMsg = new JLabel("");
		lblProprietaireMsg.setBounds(383, 394, 310, 13);
		contentPane.add(lblProprietaireMsg);
		
		txtDateNaissance = new JTextField();
		txtDateNaissance.setBounds(509, 236, 197, 20);
		contentPane.add(txtDateNaissance);
		txtDateNaissance.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndexProp = lstProprietaires_1.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires_1.get(selectedIndexProp));
			    
			    String nom = txtNomProp.getText();
			    String prenom = txtPrenom.getText();
			    String adresse = txtAdresse.getText();
			    String dateNaissance = txtDateNaissance.getText();
			    String tel = txtTel.getText();
			    String email = txtEmail.getText();
			    
			    Controlleur.Proprietaires prop = new Controlleur.Proprietaires(idProprietaire, nom, prenom, adresse, dateNaissance, tel, email);
			    lblProprietaireMsg.setText(prop.getMsg());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(383, 342, 228, 42);
		contentPane.add(btnNewButton_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(509, 312, 197, 20);
		contentPane.add(txtEmail);
		
		lstProprietaires = new JComboBox();
		lstProprietaires.setBounds(162, 113, 114, 21);
		contentPane.add(lstProprietaires);
		lstProprietaires.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	lblAnimalMsg.setText(" ");
            	int selectedIndexProp = lstProprietaires.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires.get(selectedIndexProp));
			    ChoixAnimalListe.removeAllItems();
			    chargerAnimaux(idProprietaire);
            }
		});
		ChoixAnimalListe = new JComboBox<String>();
		ChoixAnimalListe.setBounds(160, 152, 116, 22);
		contentPane.add(ChoixAnimalListe);
		ChoixAnimalListe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	txtNomAnimal.setText((String) ChoixAnimalListe.getSelectedItem());
            	int selectedIndexAnimal = ChoixAnimalListe.getSelectedIndex();
            	int idAnimal = Integer.parseInt(idAnimaux.get(selectedIndexAnimal));
            	chargerEspeces(idAnimal);
            	
            }
		});
		
		txtNomAnimal = new JTextField();
		txtNomAnimal.setBounds(162, 225, 114, 28);
		contentPane.add(txtNomAnimal);
		txtNomAnimal.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nom d'animal :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 229, 162, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnModifierAnimal = new JButton("Modifier");
		btnModifierAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndexEspece = EspeceBox.getSelectedIndex();
			    int idEspece = Integer.parseInt(idEspeces.get(selectedIndexEspece));
			    
			    int selectedIndexAnimal = ChoixAnimalListe.getSelectedIndex();
            	int idAnimal = Integer.parseInt(idAnimaux.get(selectedIndexAnimal));
            	
            	String nomAnimal = txtNomAnimal.getText();
            	
            	Controlleur.ModifierAnimal modifAnimal = new Controlleur.ModifierAnimal(idAnimal, idEspece, nomAnimal);
            	lblAnimalMsg.setText(modifAnimal.getMsg());
			}
		});
		btnModifierAnimal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModifierAnimal.setBounds(71, 274, 171, 42);
		contentPane.add(btnModifierAnimal);
		
		JLabel lblNewLabel_3_1 = new JLabel("Modifier un Proprietaire");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(411, 53, 295, 28);
		contentPane.add(lblNewLabel_3_1);
		
		lstProprietaires_1 = new JComboBox();
		lstProprietaires_1.setBounds(497, 113, 209, 21);
		lstProprietaires_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	int selectedIndexProp = lstProprietaires_1.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires_1.get(selectedIndexProp));
			    Proprietaires pr = new Proprietaires(idProprietaire);
			    txtNomProp.setText(pr.getNom());	
			    txtPrenom.setText(pr.getPrenom());
			    txtAdresse.setText(pr.getAdresse());
			    txtTel.setText(pr.getTel());
			    txtEmail.setText(pr.getEmail());
			    txtDateNaissance.setText(pr.getDateNaissance());
            }
		});
		contentPane.add(lstProprietaires_1);
		
		JLabel lblNewLabel_4_6 = new JLabel("Nom du Proprietaire :");
		lblNewLabel_4_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_6.setBounds(308, 188, 190, 14);
		contentPane.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("Email de proprietaires :");
		lblNewLabel_4_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_4_1.setBounds(308, 313, 190, 14);
		contentPane.add(lblNewLabel_4_4_1);
		
		
		
		EspeceBox = new JComboBox<String>();
		EspeceBox.setBounds(160, 188, 116, 20);
		contentPane.add(EspeceBox);
		
		JLabel lblNewLabel = new JLabel("Especes :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 189, 113, 14);
		contentPane.add(lblNewLabel);
		
		JButton BtnRetour = new JButton("Retour ");
		BtnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BtnRetour.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnRetour.setBounds(10, 10, 162, 23);
		contentPane.add(BtnRetour);
		
		
		chargerProprietaires();	
		chargerProprietaires_1();
		int selectedIndexProp = lstProprietaires.getSelectedIndex();
	    int idProprietaire = Integer.parseInt(idProprietaires.get(selectedIndexProp));
	    
	    
	}
	private void chargerProprietaires() {
	    Proprietaires pr = new Proprietaires();
	    ArrayList<String> props = pr.getProprietaires();
	    idProprietaires = pr.getId();
	    for (String prop : props) {
	    	lstProprietaires.addItem(prop);
	    }
	}
	private void chargerProprietaires_1() {
	    Proprietaires pr = new Proprietaires();
	    ArrayList<String> props = pr.getProprietaires();
	    idProprietaires_1 = pr.getId();
	    for (String prop : props) {
	    	lstProprietaires_1.addItem(prop);
	    }
	}
    
    private void chargerAnimaux(int id) {
    	AfficherAnimaux afficher = new AfficherAnimaux(id);
    	ArrayList<String> animaux = afficher.getNomAnimaux();
    	idAnimaux = afficher.getIdAnimaux();
    	for(String animal : animaux) {
    		ChoixAnimalListe.addItem(animal);
    	}
    	
    }
    private void chargerEspeces(int id) {
        Espece es1 = new Espece(id);
        String id_espece1 = String.valueOf(es1.getIdEspece());
        String espece1 = es1.getNomEspece(); // Supposant qu'il existe une méthode getNomEspece() pour récupérer le nom de l'espèce

        // Vider la liste déroulante avant de remplir à nouveau les éléments
        EspeceBox.removeAllItems();

        // Ajouter l'espèce correspondant à l'ID en premier élément
        EspeceBox.addItem(espece1);
        EspeceBox.setSelectedItem(espece1); // Sélectionner l'espèce correspondant à l'ID

        Espece es = new Espece();
        ArrayList<String> especes = es.getEspeces();
        idEspeces = es.getId();

        // Ajouter le reste des espèces (sans doublon)
        for (String espece : especes) {
            if (!espece.equals(espece1)) { // Vérifier si l'espèce n'est pas déjà la première
                EspeceBox.addItem(espece);
            }
        }
    }
}
