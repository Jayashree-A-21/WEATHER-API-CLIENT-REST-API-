# Weather API Client in Java

## 📌 Description
This Java application consumes a public REST API to fetch real-time weather data.
It sends an HTTP request, receives a JSON response, parses it, and displays the weather information in a structured format.

## 🛠 Technologies Used
- Java (JDK 8+)
- HTTPURLConnection
- JSON (org.json library)
- REST API

## 📂 Files
- WeatherAPIClient.java

## 📦 External Libraries
- json-20251224.jar

## ▶️ How to Run
1. Compile:
javac -cp .;json-20251224.jar WeatherAPIClient.java
2. Run:
java -cp .;json-20251224.jar WeatherAPIClient

## 📌 Output
- Displays temperature
- Wind speed
- Weather conditions

## 📚 Use Case
Demonstrates API consumption, HTTP requests, and JSON parsing in Java.
