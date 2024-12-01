package data_access;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGPTAPI {

    private static final String API_KEY = "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"; // Replace with your actual OpenAI API key
    private static final String API_URL = "https://api.openai.com/v1/completions";

//    public static void main(String[] args) throws IOException {
//        String prompt = "Tell me a joke about Java programming.";
//
//        // Make the API call to ChatGPT
//        String response = getChatGPTResponse(prompt);
//        System.out.println("ChatGPT Response: " + response);
//    }

    private static String getChatGPTResponse(String prompt) throws IOException {
        // Construct the request body
        String requestBody = "{\n" +
                "  \"model\": \"text-davinci-003\",  // Or another model like gpt-3.5-turbo\n" +
                "  \"prompt\": \"" + prompt + "\",\n" +
                "  \"max_tokens\": 100\n" +
                "}";

        // Create URL object for the API endpoint
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method and headers
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setDoOutput(true);

        // Send the request
        try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
            writer.writeBytes(requestBody);
            writer.flush();
        }

        // Get the response code and input stream
        int responseCode = connection.getResponseCode();
        InputStream inputStream = responseCode == HttpURLConnection.HTTP_OK ? connection.getInputStream() : connection.getErrorStream();

        // Read the response from the API
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // Convert the response JSON into a string using org.json
        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONArray choices = jsonResponse.getJSONArray("choices");
        return choices.getJSONObject(0).getString("text");
    }
}