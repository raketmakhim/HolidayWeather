package service;

import objects.SingleDayWeatherData;
import objects.WeatherData;
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

    public SingleDayWeatherData getWeatherForDate(String date, String postcode) throws IOException, InterruptedException {
        LocationFinder locationFinder = locationFinderFactory.create(postcode);
        WeatherData weatherData = apiClient.getWeather(locationFinder.getLongitude(), locationFinder.getLatitude());
        return getSingleDayWeatherData(weatherData, date);
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
