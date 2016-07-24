package webapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Adeola.Ojo on 7/23/2016.
 */
public class RestApiHelper {


    static final String DEFAULT_RESP_CODE = "200";

    public static <T> T fromJSON(final TypeReference<T> type,
                                 final String jsonPacket) {
        T data = null;

        try {
            data = new ObjectMapper().readValue(jsonPacket, type);
        } catch (Exception e) {
            // Handle the problem
        }
        return data;
    }

    public static String call(String urlEndpoint, Map<String, String> headers, String body, String httpMethod) throws IOException {
        URL url = new URL(urlEndpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        switch (httpMethod) {
            case "GET":
                conn.setRequestMethod("GET");
                break;
            case "POST":
                conn.setRequestMethod("POST");
                break;
        }

        conn.setRequestProperty("Accept", "application/json");
        int respCode = conn.getResponseCode();
        if (respCode != 200 || respCode != 301) {

        }

        if (headers != null && headers.size() != 0)
            for (String key : headers.keySet()) {
                String data = headers.get(key);
            }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        StringBuilder jsonBuilder = new StringBuilder();
        while ((output = br.readLine()) != null) {
            jsonBuilder.append(output);
        }

        String finalData = jsonBuilder.toString();
        finalData = finalData.replace("'", "\"");
        return finalData;
    }
}
