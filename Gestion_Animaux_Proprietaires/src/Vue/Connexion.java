package Vue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Connexion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField RecupMail;
	private JPasswordField RecupMDP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONNEXION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(152, 36, 145, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adresse mail : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(38, 123, 127, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(38, 162, 127, 24);
		contentPane.add(lblNewLabel_2);
		
		RecupMail = new JTextField();
		RecupMail.setBounds(129, 126, 96, 20);
		contentPane.add(RecupMail);
		RecupMail.setColumns(10);
		
		RecupMDP = new JPasswordField();
		RecupMDP.setBounds(129, 165, 96, 20);
		contentPane.add(RecupMDP);
		
		JButton BtnEnvoyer = new JButton("Envoyer");
		BtnEnvoyer.setFont(new Font("Tahoma", Font.BOLD, 14));
		BtnEnvoyer.setBounds(292, 123, 105, 82);
		contentPane.add(BtnEnvoyer);
        BtnEnvoyer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = RecupMail.getText();
                String motDePasse = new String(RecupMDP.getPassword());
                Controlleur.VerificationConnexion verif = new Controlleur.VerificationConnexion(email, motDePasse); 
                
            }
        });
        contentPane.add(BtnEnvoyer);
		
	}
}
