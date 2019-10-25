import java.io.*;
import java.net.*;

public class getPet {
	public static void main(String args[]) throws MalformedURLException, ProtocolException, IOException {
		URL url = new URL("https://petstore.swagger.io/v2/pet/660779600098004");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");
	
		connection.setRequestProperty("Content-Type", "application/json");
		connection.getResponseCode();
	
		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());
		System.out.println(connection.getContentType());

// To store our response
StringBuilder content;

// Get the input stream of the connection
try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
    String line;
    content = new StringBuilder();
    while ((line = input.readLine()) != null) {
        // Append each line of the response and separate them
        content.append(line);
        content.append(System.lineSeparator());
    }
} finally {
    connection.disconnect();
}

// Output the content to the console
System.out.println(content.toString());
System.out.println(args[0]);

		}//End of main
}//End of getPet Class