package Modele;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class VerifierIdentifiant {
	private String email, mdp, nom_pension;
	private int id_pension;

	public VerifierIdentifiant(String email, String mdp) {
		this.email = email;
		this.mdp =mdp;
	}
	 public boolean getVerification() {
		 boolean result = false;
	        try {
	            
	            URL url = new URL("http://172.20.10.2/api_Logiciel/GestionAnimauxEtProprietaires/ConnexionPension.php");

	            
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setDoOutput(true);

	            
	            String params = "email=" + email + "&password=" + mdp;

	            
	            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
	                wr.write(params.getBytes(StandardCharsets.UTF_8));
	            }

	            
	            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
	                StringBuilder response = new StringBuilder();
	                String line;
	                while ((line = in.readLine()) != null) {
	                    response.append(line);
	                }
	                JSONObject jsonResponse = new JSONObject(response.toString());

	                
	                if (jsonResponse.getString("status").equals("success")) {
	                    id_pension = jsonResponse.getInt("id");
	                    nom_pension = jsonResponse.getString("nom");
	                    result = true;
	                } else {
	                    result = false;
	                }
	                return result;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return result;
	        }
	    }
	 public String getNom() {
		 return this.nom_pension;
	 }
	 public int getId() {
		 return this.id_pension;
	 }
}
