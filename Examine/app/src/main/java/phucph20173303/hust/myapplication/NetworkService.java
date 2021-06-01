package phucph20173303.hust.myapplication;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkService {
    private static final String ROOT_URL = "https://www.googleapis.com/books/v1/volumes?";

    public static String SEND_POST(String studentId, String macId) throws IOException {
        Uri builtURI = Uri.parse(ROOT_URL).buildUpon().build();
        URL url = new URL(builtURI.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.accumulate("studentId", studentId);
            jsonObj.accumulate("macAddress", macId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        writer.write(jsonObj.toString());
        writer.flush();
        writer.close();
        os.close();
        conn.connect();
        StringBuffer sb = new StringBuffer();
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream in = conn.getInputStream();
            int chr;
            while ((chr = in.read()) != -1) {
                sb.append((char) chr);
            }
            in.close();
        } else {
            sb.append(conn.getResponseCode());
        }
        String result = sb.toString();
        conn.disconnect();
        return result;
    }
}
