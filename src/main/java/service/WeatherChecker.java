package service;

import objects.WeatherData;
import objects.WeatherDataLists;
import utils.factory.LocationFinderFactory;
import utils.postcode.LocationFinder;
import utils.web.WeatherApiClient;

import java.io.IOException;
import java.util.List;

public class WeatherChecker {

    private final WeatherApiClient apiClient;
    private final LocationFinderFactory locationFinderFactory;

    // Constructor to inject dependencies, useful for testing.
    public WeatherChecker(LocationFinderFactory locationFinderFactory) throws IOException {
        this.apiClient = new WeatherApiClient();
        this.locationFinderFactory = locationFinderFactory;
    }

    public WeatherData getWeatherForDate(String date, String postcode) throws IOException, InterruptedException {
        LocationFinder locationFinder = locationFinderFactory.create(postcode);
        WeatherDataLists weatherDataLists = apiClient.getWeather(locationFinder.getLongitude(), locationFinder.getLatitude());
        return getSingleDayWeatherData(weatherDataLists, date);
    }

    private WeatherData getSingleDayWeatherData(WeatherDataLists weatherDataLists, String date){
        List<String> dates = weatherDataLists.getDaily().getTime();

        WeatherData data = new WeatherData();

        for (int i = 0; i < dates.size(); i++) {
            if (date.equals(dates.get(i))){
                return new WeatherData(
                        date,
                        weatherDataLists.getDaily().getTemperature_2m_max().get(i).toString(),
                        weatherDataLists.getDaily().getTemperature_2m_min().get(i).toString(),
                        weatherDataLists.getDaily().getRain_sum().get(i).toString(),
                        weatherDataLists.getDaily().getSunshine_duration().get(i).toString()
                );
            }
        }

        return new WeatherData("0", "0", "0", "0", "0");
    }
}
