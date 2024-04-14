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

public class AfficherEspece {
	
    private ArrayList<String> especes;
    private ArrayList<String> id;
    private int id_espece;
    private String nom_espece;
    
    public AfficherEspece() {
    	this.especes = new ArrayList<>();
    	this.id = new ArrayList<>();


        try {
            URL url = new URL("http://172.20.10.2/api_Logiciel/GestionAnimauxEtProprietaires/AfficherEspece.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                
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
                        this.especes.add(jsonObject.getString("libelle"));
                        String id = String.valueOf(jsonObject.getInt("id")); 
                        this.id.add(id);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public AfficherEspece(int id) {
    	try {
            URL url = new URL("http://172.20.10.2/api_Logiciel/GestionAnimauxEtProprietaires/AfficherAnimaux.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            
            String params = "id_animal=" + id;

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
                        
                       id_espece = jsonObject.getInt("id_espece"); 
                       nom_espece = jsonObject.getString("espece");
                        
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNomEspece() {
    	return this.nom_espece;
    }
    public int getIdEspece() {
    	return this.id_espece;
    }

    public ArrayList<String> getEspeces() {
        
        return this.especes;
    }
    public ArrayList<String> getid() {
        
        return this.id;
    }
}
