package Vue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import Controlleur.Espece;
import Controlleur.Proprietaires;

public class AjouterAnimal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField TextNomAnimal;
	private JTextField txtAdresse;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtDateNaissance;
	private JComboBox<String> EspeceBox, proprietairesBox;
	private ArrayList<String> idProprietaires, idEspeces;
	
	private JPasswordField txtMdp;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AjouterAnimal(int id_pension) {
		idProprietaires = new ArrayList<>();
		idEspeces = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPrenom = new JTextField();
		txtPrenom.setBounds(157, 27, 140, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Prenom :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 21, 152, 25);
		contentPane.add(lblNewLabel_1);

		txtNom = new JTextField();
		txtNom.setBounds(157, 58, 140, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lbl_msg_ajouterAnimal = new JLabel("");
		lbl_msg_ajouterAnimal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_msg_ajouterAnimal.setBounds(341, 280, 208, 20);
		contentPane.add(lbl_msg_ajouterAnimal);

		JButton BtnEnregistrer = new JButton("Enregistrer");
		BtnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndexProp = proprietairesBox.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires.get(selectedIndexProp));
			    
			    int selectedIndexEspece = EspeceBox.getSelectedIndex();
			    int idEspece = Integer.parseInt(idEspeces.get(selectedIndexEspece));
			    
			    String nom_animal = TextNomAnimal.getText();
			    Controlleur.AjouterAnimal ajAn = new Controlleur.AjouterAnimal(nom_animal, idEspece, idProprietaire);
			    lbl_msg_ajouterAnimal.setText(ajAn.getMsg());
			    
			    
			}
		});
		BtnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 14));
		BtnEnregistrer.setBounds(341, 161, 208, 109);
		contentPane.add(BtnEnregistrer);

		JLabel lblNewLabel_2 = new JLabel("Nom_Animal :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(337, 18, 113, 33);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nom:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(13, 56, 149, 25);
		contentPane.add(lblNewLabel_3);

		TextNomAnimal = new JTextField();
		TextNomAnimal.setBounds(453, 26, 96, 20);
		contentPane.add(TextNomAnimal);
		TextNomAnimal.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Adresse :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(13, 98, 149, 14);
		contentPane.add(lblNewLabel_4);

		txtAdresse = new JTextField();
		txtAdresse.setBounds(157, 99, 140, 20);
		contentPane.add(txtAdresse);
		txtAdresse.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Telephone:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(13, 136, 149, 14);
		contentPane.add(lblNewLabel_5);

		txtTel = new JTextField();
		txtTel.setBounds(157, 137, 140, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		JLabel lblNewLabel = new JLabel("Especes :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(337, 68, 113, 14);
		contentPane.add(lblNewLabel);

		txtEmail = new JTextField();
		txtEmail.setBounds(157, 208, 140, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtDateNaissance = new JTextField();
		txtDateNaissance.setText("AAAA/MM/JJ");
		txtDateNaissance.setBounds(157, 171, 140, 20);
		contentPane.add(txtDateNaissance);
		txtDateNaissance.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Email :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 207, 152, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Date De Naissance :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 170, 152, 14);
		contentPane.add(lblNewLabel_7);

		EspeceBox = new JComboBox<>();
		EspeceBox.setBounds(452, 67, 97, 20);
		contentPane.add(EspeceBox);

		txtMdp = new JPasswordField();
		txtMdp.setBounds(157, 253, 140, 20);
		contentPane.add(txtMdp);

		JLabel lblNewLabel_8 = new JLabel("Password :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 259, 152, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lbl_msg = new JLabel("");
		lbl_msg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_msg.setBounds(41, 402, 190, 20);
		contentPane.add(lbl_msg);
		
		JButton btn_CreerCompte = new JButton("Créer un Compte");
		btn_CreerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String adresse = txtAdresse.getText();
				String tel = txtTel.getText();
				String dateNaissance = txtDateNaissance.getText();
				String email = txtEmail.getText();
				String mdp = new String(txtMdp.getPassword());
				
				Controlleur.CreerCompteClient client = new Controlleur.CreerCompteClient(nom, prenom, adresse, dateNaissance, tel, email, mdp);
				lbl_msg.setText(client.getMessage());   
			    
			}
		});
		btn_CreerCompte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_CreerCompte.setBounds(41, 305, 218, 79);
		contentPane.add(btn_CreerCompte);
		
		JLabel lblProprietaires = new JLabel("Proprietaires :");
		lblProprietaires.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProprietaires.setBounds(337, 101, 113, 18);
		contentPane.add(lblProprietaires);
		
		proprietairesBox = new JComboBox();
		proprietairesBox.setBounds(453, 102, 96, 21);
		contentPane.add(proprietairesBox);
		
		JButton BtnRetour = new JButton("Retour ");
		BtnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BtnRetour.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnRetour.setBounds(543, 336, 162, 23);
		contentPane.add(BtnRetour);
		
		
		chargerEspeces();
		chargerProprietaires();
		

	}
	
	private void chargerEspeces() {
		
	    Espece es = new Espece();
	    ArrayList<String> especes = es.getEspeces();
	    idEspeces = es.getId();
	    for (String espece : especes) {
	        EspeceBox.addItem(espece);
	    }
	   
	}
	
	private void chargerProprietaires() {
	    Proprietaires pr = new Proprietaires();
	    ArrayList<String> props = pr.getProprietaires();
	    idProprietaires = pr.getId();
	    for (String prop : props) {
	        proprietairesBox.addItem(prop);
	    }
	}
	

	
	
}