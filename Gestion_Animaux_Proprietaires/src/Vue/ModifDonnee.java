package Vue;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ModifDonnee extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

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

    public ModifDonnee(String nom_pension, int id_pension) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton BtnAjouter = new JButton("<html>Ajouter un animal<br>Ajouter Proprietaire</html>");
        BtnAjouter.setFont(new Font("Tahoma", Font.BOLD, 15));
        BtnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 AjouterAnimal ajouterAnimalFrame = new AjouterAnimal(id_pension);
                 ajouterAnimalFrame.setVisible(true);
            }
        });
        BtnAjouter.setBounds(10, 11, 204, 105);
        contentPane.add(BtnAjouter);

        JButton BtnSupprimer = new JButton("Supprimer un animal");
        BtnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 SupprimerAnimal supprimeranimalFrame = new SupprimerAnimal();
            	 supprimeranimalFrame.setVisible(true);
            }
        });
        BtnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 15));
        BtnSupprimer.setBounds(224, 11, 202, 105);
        contentPane.add(BtnSupprimer);

        JButton btnNewButton = new JButton("<html>Modifier un animal<br> Modifier Proprietaire<html>");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           	 ModifAnimal modifanimalFrame = new ModifAnimal();
           	modifanimalFrame.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(10, 128, 204, 105);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("<html>Afficher données des animaux<br> Afficher données des Proprietaires<html>");
        btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
        btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AfficherDonnee afficherDonneeFrame = new AfficherDonnee();
        		afficherDonneeFrame.setVisible(true);
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.setBounds(224, 127, 202, 106);
        contentPane.add(btnNewButton_1);
    }
}
