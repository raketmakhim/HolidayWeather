package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import objects.SingleDayWeatherData;
import objects.WeatherData;
import utils.ConfigReader;
import utils.CsvSearch;
import utils.RequestClient;
import utils.UriBuilder;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class WeatherChecker {

    ObjectMapper mapper = new ObjectMapper();
    RequestClient client = new RequestClient();

    private final String POSTCODE_DATA_FILE_URI;
    private final String URL_NAME;

    // Constructor to inject dependencies, useful for testing.
    public WeatherChecker(String uri, String UrlName) {
        this.POSTCODE_DATA_FILE_URI = uri;
        this.URL_NAME = UrlName;
    }

    public SingleDayWeatherData getWeatherForDate(String date, String postcode) throws IOException, InterruptedException {
        List<String[]> records = CsvSearch.readCsv(POSTCODE_DATA_FILE_URI);
        String[] record = CsvSearch.binarySearch(records, postcode);

        String longitude = record[2];
        String latitude = record[3];

        WeatherData weatherData = getWeatherData(longitude, latitude);
        return getSingleDayWeatherData(weatherData, date);
    }

    private WeatherData getWeatherData(String longitude, String latitude) throws IOException, InterruptedException {
        String baseUrl = ConfigReader.getProperties(URL_NAME);
        String uri = UriBuilder.buildUri(baseUrl, longitude, latitude);
        HttpResponse<String> response = client.sendGetRequest(uri);
        return mapper.readValue(response.body(), WeatherData.class);
    }

    private SingleDayWeatherData getSingleDayWeatherData(WeatherData weatherData, String date){
        List<String> dates = weatherData.getDaily().getTime();

        SingleDayWeatherData data = new SingleDayWeatherData();

        for (int i = 0; i < dates.size(); i++) {
            if (date.equals(dates.get(i))){
                return new SingleDayWeatherData(
                        date,
                        weatherData.getDaily().getTemperature_2m_max().get(i).toString(),
                        weatherData.getDaily().getTemperature_2m_min().get(i).toString(),
                        weatherData.getDaily().getRain_sum().get(i).toString(),
                        weatherData.getDaily().getSunshine_duration().get(i).toString()
                );
            }
        }

        return new SingleDayWeatherData("0", "0", "0", "0", "0");
    }
}
