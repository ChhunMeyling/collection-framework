package service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NotificationService {
    private static final String BOT_TOKEN = "7633140631:AAERcgKtHPVQV0Z8NvfeN_s_BjlxJel9mVY"; // Replace with your Bot Token
    private static final String CHAT_ID = "1229119559"; // Replace with your Chat ID

    public void sendTelegramNotification(String message) {
        try {
            // Encode the message to avoid issues with special characters
            String encodedMessage = URLEncoder.encode(message, "UTF-8");

            // Construct the URL for the API request
            String urlString = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage?chat_id=" + CHAT_ID + "&text=" + encodedMessage;

            // Log the URL for debugging purposes
            System.out.println("Sending request to Telegram API: " + urlString);

            // Make the GET request
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Get the response code from the request
            int responseCode = conn.getResponseCode();

            // Log the response code
            System.out.println("Telegram API response code: " + responseCode);

            // If response is successful (200), log the success
            if (responseCode == 200) {
                System.out.println("Telegram Notification sent: " + message);
            } else {
                System.err.println("Failed to send Telegram notification. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log any exceptions for debugging
        }
    }
}
