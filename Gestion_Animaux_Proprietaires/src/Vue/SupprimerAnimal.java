package Vue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlleur.AfficherAnimaux;
import Controlleur.Proprietaires;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class SupprimerAnimal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> ChoixAnimalListe;
    private JButton BtnSupprimer;
    private JButton BtnRetour;
    private JComboBox<String> lstProprietaires;
    private JLabel lblProprietaire;
    private JButton btnAfficherAnimaux;
    private ArrayList<String> idProprietaires, idAnimaux;
    private JLabel lbl_msg;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SupprimerAnimal frame = new SupprimerAnimal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SupprimerAnimal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 655, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Supprimer l'animal de votre choix");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(150, 174, 344, 33);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nom de l'animal :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(10, 237, 173, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Nom du proprietaire :");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2.setBounds(10, 75, 173, 14);
        contentPane.add(lblNewLabel_2);
        
        lbl_msg = new JLabel("");
        lbl_msg.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_msg.setBounds(240, 385, 186, 32);
        contentPane.add(lbl_msg);

        ChoixAnimalListe = new JComboBox<>();
        ChoixAnimalListe.setBounds(193, 235, 327, 22);
        contentPane.add(ChoixAnimalListe);

        BtnSupprimer = new JButton("Supprimer");
        BtnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	int selectedIndexAnimal = ChoixAnimalListe.getSelectedIndex();
            	int idAnimal = Integer.parseInt(idAnimaux.get(selectedIndexAnimal));
            	
            	Controlleur.SupprimerAnimal suppAnimal = new Controlleur.SupprimerAnimal(idAnimal);
            	
            	int selectedIndexProp = lstProprietaires.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires.get(selectedIndexProp));
			    ChoixAnimalListe.removeAllItems();
			    chargerAnimaux(idProprietaire);
            	
            	lbl_msg.setText(suppAnimal.getMsg());
                
            }
        });
        BtnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 15));
        BtnSupprimer.setBounds(240, 308, 162, 67);
        BtnSupprimer.setVisible(false); // Démarre masqué
        contentPane.add(BtnSupprimer);
        
        BtnRetour = new JButton("Retour ");
        BtnRetour.setFont(new Font("Tahoma", Font.BOLD, 15));
        BtnRetour.setBounds(10, 16, 162, 23);
        contentPane.add(BtnRetour);
        
        lstProprietaires = new JComboBox();
        lstProprietaires.setBounds(193, 74, 327, 21);
        contentPane.add(lstProprietaires);
        
        lblProprietaire = new JLabel("Proprietaire");
        lblProprietaire.setHorizontalAlignment(SwingConstants.CENTER);
        lblProprietaire.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblProprietaire.setBounds(150, 10, 344, 33);
        contentPane.add(lblProprietaire);
        
        btnAfficherAnimaux = new JButton("Afficher les Animaux");
        btnAfficherAnimaux.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedIndexProp = lstProprietaires.getSelectedIndex();
			    int idProprietaire = Integer.parseInt(idProprietaires.get(selectedIndexProp));
			    
			    chargerAnimaux(idProprietaire);
			    
			    BtnSupprimer.setVisible(true);
        	}
        });
        btnAfficherAnimaux.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAfficherAnimaux.setBounds(222, 118, 204, 46);
        contentPane.add(btnAfficherAnimaux);
        
        
        BtnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
			    
            }
        });
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
    
    private void chargerAnimaux(int id) {
    	AfficherAnimaux afficher = new AfficherAnimaux(id);
    	ArrayList<String> animaux = afficher.getNomAnimaux();
    	idAnimaux = afficher.getIdAnimaux();
    	for(String animal : animaux) {
    		ChoixAnimalListe.addItem(animal);
    	}
    	
    }


}

