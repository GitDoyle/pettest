import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class CreatePet {
 public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException {
    URL url = new URL("https://petstore.swagger.io/v2/pet");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    connection.setRequestMethod("POST");
    Map<String, String> params = new HashMap<>();
	params.put("Content-Type", "application/json");

    StringBuilder postData = new StringBuilder();
    for (Map.Entry<String, String> param : params.entrySet()) {
        if (postData.length() != 0) {
            postData.append('&');
        }
        //postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
        //postData.append('=');
        //postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
    }

	String jsonInputString = "{\"id\": 660779600098005,\"category\": {\"id\": 660779600098005,\"name\": \"Labrador\"},\"name\": \"Boogaa\",\"X-photoUrls\": [\"string\"],\"tags\": [{ \"id\": 660779600098005,\"name\": \"Brown\"}],\"status\": \"available\"}";
	
    byte[] postDataBytes = jsonInputString.getBytes("UTF-8");
    connection.setDoOutput(true);
    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
        writer.write(postDataBytes);
        writer.flush();
        writer.close();

        StringBuilder content;

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
        String line;
        content = new StringBuilder();
           while ((line = in.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        }
        System.out.println(content.toString());
		System.out.println(connection.getResponseMessage());
		System.out.println(connection.getResponseCode());
		
    } finally {
        connection.disconnect();
    }
}//End of main
}//End of CreatePet Class
