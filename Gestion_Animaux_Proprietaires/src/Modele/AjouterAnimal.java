package Modele;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

public class AjouterAnimal {
	String nom_animal, msg;
	int id_espece, id_prop;
	
	public AjouterAnimal(String nom_animal, int id_espece,int id_prop) {
		this.id_espece = id_espece;
		this.id_prop = id_prop;
		this.nom_animal = nom_animal;
	}
	
	public boolean getVerifAjoutation() {
		boolean result = false;
		try {
            
            URL url = new URL("http://172.20.10.2/api_Logiciel/GestionAnimauxEtProprietaires/AjouterAnimal.php");

            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            
            String params = "espece=" + id_espece + "&prop=" + id_prop + "&nom=" + nom_animal;

            
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
                	msg = jsonResponse.getString("message");
                    result = true;
                } else {
                	msg = jsonResponse.getString("message");
                    result = false;
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
		
		return result;
	}
	public String getMsg() {
		return msg;
	}
}
