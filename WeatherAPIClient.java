import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

/*
 * Program Name : WeatherAPIClient
 * Description  : Java application to consume REST API and parse JSON response
 * Author       : Jayashree A
 */

public class WeatherAPIClient {

    public static void main(String[] args) {

        try {
            // API URL (Bengaluru weather)
            String apiUrl = "http://api.open-meteo.com/v1/forecast?latitude=12.97&longitude=77.59&current_weather=true";


            // Create URL object
            URL url = new URL(apiUrl);

            // Open HTTP connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Parse JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject currentWeather = jsonResponse.getJSONObject("current_weather");

            // Extract values
            double temperature = currentWeather.getDouble("temperature");
            double windSpeed = currentWeather.getDouble("windspeed");
            int weatherCode = currentWeather.getInt("weathercode");

            // Display structured output
            System.out.println("===== CURRENT WEATHER REPORT =====");
            System.out.println("Location      : Bengaluru");
            System.out.println("Temperature   : " + temperature + " °C");
            System.out.println("Wind Speed    : " + windSpeed + " km/h");
            System.out.println("Weather Code  : " + weatherCode);
            System.out.println("=================================");

        } catch (Exception e) {
            System.out.println("Error while fetching weather data");
            e.printStackTrace();
        }
    }
}
