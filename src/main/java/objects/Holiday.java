package objects;

import service.WeatherChecker;

import java.io.IOException;

public class Holiday {
    private String date;
    private String postCode;
    private WeatherData weatherData;

    private WeatherChecker weatherCheckerService;


    /**
     * Constructs a new Holiday instance with the specified holiday date and postal code.
     *
     * <p>This constructor initializes the holiday with the provided date and postal code,
     * and sets the weather checker service used for retrieving corresponding weather data.</p>
     *
     * @param date the holiday date as a string
     * @param postCode the postal code associated with the holiday
     */
    public Holiday(String date, String postCode, WeatherChecker weatherCheckerService){
        this.date = date;
        this.postCode = postCode;
        this.weatherCheckerService = weatherCheckerService;
    }

    /**
     * Retrieves weather data for the holiday's date and postal code.
     *
     * <p>This method calls the weatherCheckerService to obtain weather information corresponding
     * to the holiday's date and postal code.
     *
     * @return the weather data for the specified date and postal code
     * @throws IOException if an I/O error occurs during data retrieval
     * @throws InterruptedException if the operation is interrupted
     */
    public WeatherData getWeatherData() throws IOException, InterruptedException {
        return weatherCheckerService.getWeatherForDate(date, postCode);
    }
}
