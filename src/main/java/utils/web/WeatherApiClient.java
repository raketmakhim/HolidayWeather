package utils.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import objects.WeatherData;

import java.io.IOException;
import java.net.http.HttpResponse;

public class WeatherApiClient {

    private final RequestClient client;
    private final ObjectMapper objectMapper;

    public WeatherApiClient(){
        this.client = new RequestClient();
        this.objectMapper = new ObjectMapper();
    }
    public WeatherData getWeather(String longitude, String latitude) throws IOException, InterruptedException {
        HttpResponse<String> response = client.sendGetRequest(UriBuilder.buildUri(longitude, latitude));
        return this.objectMapper.readValue(response.body(), WeatherData.class);
    }
}
