package Modele;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class CreerCompteClient {
    private String nom, prenom, email, adresse, mdp, dateNaissance, tel, message;

    public CreerCompteClient(String nom, String prenom, String adresse, String dateNaissance, String tel, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.mdp = mdp;
        this.dateNaissance = dateNaissance;
        this.tel = tel;
    }

    public boolean getCompteCreate() {
        boolean result = false;
        try {
            URL url = new URL("http://172.29.104.4/api_Logiciel/GAP/CreerCompte.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            String params = "nom=" + nom + "&prenom=" + prenom + "&tel=" + tel + "&adresse=" + adresse + "&dateNaissance=" + dateNaissance + "&email=" + email + "&password=" + mdp;

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
                    message = jsonResponse.getString("message");
                    result = true;
                } else {
                    result = false;
                    message = jsonResponse.getString("message");
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
    }

    public String getMessage() {
        return message;
    }
}