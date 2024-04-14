package Vue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlleur.AfficherAnimaux;
import Controlleur.Proprietaires;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class AfficherDonnee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> lstProprietaires;
    private ArrayList<String> idProprietaires, idAnimaux;
    private JList<String> maListe;
    private DefaultListModel<String> dataModel = new DefaultListModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherDonnee frame = new AfficherDonnee();
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
	public AfficherDonnee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Afficher les Données");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(338, 24, 391, 26);
		contentPane.add(lblNewLabel);
		

		
		JButton btnAfficherDonnees = new JButton("<html>Afficher les<br> données de Proprietaires</html>");
		btnAfficherDonnees.setToolTipText("");
		btnAfficherDonnees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndexProp = lstProprietaires.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires.get(selectedIndexProp));
			    
				AfficherDonneesProprietaire(idProprietaire);
			}
		});
		btnAfficherDonnees.setPreferredSize(btnAfficherDonnees.getPreferredSize());
		btnAfficherDonnees.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAfficherDonnees.setBounds(165, 236, 126, 103);
		contentPane.add(btnAfficherDonnees);
		
		JButton btnAfficherAnimaux = new JButton("<html>Afficher les<br> Animaux</html>");
		btnAfficherAnimaux.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAfficherAnimaux.setPreferredSize(btnAfficherAnimaux.getPreferredSize());
		btnAfficherAnimaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndexProp = lstProprietaires.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires.get(selectedIndexProp));
			    
			    chargerAnimaux(idProprietaire);
		         
			}
			
		});
		btnAfficherAnimaux.setBounds(10, 236, 145, 103);
		contentPane.add(btnAfficherAnimaux);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nom du proprietaire :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 152, 297, 14);
		contentPane.add(lblNewLabel_2_1);
		
		lstProprietaires = new JComboBox();
		lstProprietaires.setBounds(21, 176, 251, 21);
		contentPane.add(lstProprietaires);
        

        maListe = new JList<>(dataModel);
        maListe.setSize(554, 270);
        maListe.setLocation(348, 115);

        contentPane.add(maListe);
        
        JButton BtnRetour = new JButton("Retour ");
        BtnRetour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        BtnRetour.setFont(new Font("Tahoma", Font.BOLD, 15));
        BtnRetour.setBounds(20, 29, 162, 23);
        contentPane.add(BtnRetour);

        chargerProprietaires();
	}
	private void chargerProprietaires() {
	    Proprietaires pr = new Proprietaires();
	    ArrayList<String> props = pr.getProprietaires();
	    idProprietaires = pr.getId();
	    for (String prop : props) {
	    	lstProprietaires.addItem(prop);
	    }
	}
	private void AfficherDonneesProprietaire(int id){
		Proprietaires pr = new Proprietaires(id);
		dataModel.clear();
		dataModel.addElement("Nom :" + pr.getNom());
		dataModel.addElement("prenom :" + pr.getPrenom());
		dataModel.addElement("Adresse :" + pr.getAdresse());
		dataModel.addElement("Date de Naissance :" + pr.getDateNaissance());
		dataModel.addElement("Téléphone :" + pr.getTel());
		dataModel.addElement("Email :" + pr.getEmail());
	}
	private void chargerAnimaux(int id) {
    	AfficherAnimaux afficher = new AfficherAnimaux(id);
    	ArrayList<String> animaux = afficher.getNomAnimaux();
        ArrayList<String> especes = afficher.getEspeces();
        ArrayList<String> idAnimaux = afficher.getIdAnimaux();
    	dataModel.clear();
    	for (int i = 0; i < animaux.size(); i++) {
            String id_animal = idAnimaux.get(i);
            String animal = animaux.get(i);
            String espece = especes.get(i);

    		
    		dataModel.addElement("ID : " + id_animal + " | nom : " + animal + " | esepece : " + espece);
    		
    		
    	}
    	
    }
}
