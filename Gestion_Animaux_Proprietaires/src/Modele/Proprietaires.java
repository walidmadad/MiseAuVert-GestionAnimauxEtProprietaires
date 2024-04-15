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
import org.json.JSONException;
import org.json.JSONObject;
public class Proprietaires {
	private ArrayList<String> info;
	private ArrayList<String> id_prop;
	private String nom, prenom, adresse, dateNaissance, tel, email, msg;
	private int id;
	
	public Proprietaires(int id) {
		this.id = id;
		getDonneesProprietairesFromBDD();
	}
	
	public Proprietaires(int id, String nom,String prenom, String adresse, String dateNaissance, String tel, String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance =dateNaissance;
		this.tel = tel;
		this.email = email;
	}
	
	public void getDonneesProprietairesFromBDD() {
		try {
            URL url = new URL("http://172.29.104.4/api_Logiciel/GAP/AfficherDonneesProprietaires.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            String params = "id=" + id;
            
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
                    	this.nom = jsonObject.getString("nom");
                    	this.prenom = jsonObject.getString("prenom");
                    	this.adresse = jsonObject.getString("adresse");
                        this.tel = jsonObject.getString("tel");
                        this.dateNaissance = jsonObject.getString("dateNaissance");
                        this.email =jsonObject.getString("email");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public Proprietaires() {
		this.info = new ArrayList<>();
		this.id_prop = new ArrayList<>();
        try {
            URL url = new URL("http://172.29.104.4/api_Logiciel/GAP/AfficherProprietaires.php");
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
                        this.info.add(jsonObject.getString("nom") + " " + jsonObject.getString("prenom"));
                        String id = String.valueOf(jsonObject.getInt("id")); 
                        this.id_prop.add(id);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	
	public boolean modifierDonneesProp() {
	    boolean result = false;
	    try {
	        URL url = new URL("http://172.29.104.4/api_Logiciel/GAP/ModifierProprietaire.php");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setDoOutput(true);

	        String params = "id=" + id + "&nom=" + nom + "&prenom=" + prenom + "&adresse=" + adresse + "&dateNaissance=" + dateNaissance + "&tel=" + tel + "&email=" + email;

	        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
	            wr.writeBytes(params);
	            wr.flush();
	        }

	        int responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) { // success
	            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
	                StringBuilder response = new StringBuilder();
	                String line;
	                while ((line = in.readLine()) != null) {
	                    response.append(line);
	                }
	                System.out.println("Response: " + response.toString());

	                JSONObject jsonObject = new JSONObject(response.toString());
	                if (jsonObject.getString("status").equals("success")) {
	                    result = true;
	                    msg = jsonObject.getString("message");
	                } else {
	                    result = false;
	                    msg = jsonObject.getString("message");
	                }
	            }
	        } else {
	            result = false;
	            msg = "Request failed with response code: " + responseCode;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        result = false;
	        msg = "An error occurred while sending the request.";
	    } catch (JSONException e) {
	        e.printStackTrace();
	        result = false;
	        msg = "An error occurred while parsing the JSON response.";
	    }

	    return result;
	}





	
	public String getMsg() {
		return msg;
	}
	
	public ArrayList<String> getProprietaires(){
		return info;
	}
	public ArrayList<String> getId(){
		return id_prop;
	}
	
	public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }
	
	
}
