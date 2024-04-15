package Modele;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

public class SupprimerAnimal {
    private String msg;
    private int id;

    public SupprimerAnimal(int id) {
        this.id = id;
    }

    public boolean getVerifSupprimer() {
        boolean result = false;
        try {
            URL url = new URL("http://172.29.104.4/api_Logiciel/GAP/SupprimerAnimal.php");
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
                        result = true;
                        msg = jsonObject.getString("message");
                    } else {
                        result = false;
                        msg = jsonObject.getString("message");
                    }
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
