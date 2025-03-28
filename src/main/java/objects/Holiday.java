package objects;

import service.WeatherChecker;

import java.io.IOException;

public class Holiday {
    private String date;
    private String postCode;
    private WeatherData weatherData;

    private WeatherChecker weatherCheckerService;


    public Holiday(String date, String postCode, WeatherChecker weatherCheckerService){
        this.date = date;
        this.postCode = postCode;
        this.weatherCheckerService = weatherCheckerService;
    }

    public WeatherData getWeatherData() throws IOException, InterruptedException {
        return weatherCheckerService.getWeatherForDate(date, postCode);
    }
}
