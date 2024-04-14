package Modele;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class AfficherAnimaux {
	private ArrayList<String> nom_animaux, especes;
	private ArrayList<String> id_animaux, id_especes;
	private int id_prop;
	
	public AfficherAnimaux(int id_prop) {
		this.nom_animaux = new ArrayList<>();
		this.id_animaux = new ArrayList<>();
		this.especes = new ArrayList<>();
		this.id_especes = new ArrayList<>();
		this.id_prop = id_prop;
        try {
            URL url = new URL("http://172.20.10.2/api_Logiciel/GestionAnimauxEtProprietaires/AfficherAnimaux.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            
            String params = "id=" + id_prop;

            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            	wr.write(params.getBytes(StandardCharsets.UTF_8));
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                JSONArray jsonArray = new JSONArray(response.toString());

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject.getString("status").equals("success")) {
                        this.nom_animaux.add(jsonObject.getString("nom_animal"));
                        String id_animal = String.valueOf(jsonObject.getInt("id_Animal")); 
                        this.id_animaux.add(id_animal);
                        this.especes.add(jsonObject.getString("espece"));
                        String id_espece = String.valueOf(jsonObject.getInt("id_espece"));
                        this.id_especes.add(id_espece);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	public ArrayList<String> getNomAnimaux(){
		return nom_animaux;
	}
	public ArrayList<String> getIdAnimaux(){
		return id_animaux;
	}
	public ArrayList<String> getIdEspeces(){
		return id_especes;
	}
	public ArrayList<String> getEspeces(){
		return especes;
	}
	

}
