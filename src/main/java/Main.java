import objects.Holiday;
import objects.WeatherData;
import service.WeatherChecker;
import utils.algorithm.BinarySearch;
import utils.factory.LocationFinderFactory;
import utils.postcode.PostcodeComparator;

import java.util.Comparator;

public class Main {

    /**
     * Application entry point that retrieves and prints weather data for a specific holiday.
     *
     * <p>This method sets up the necessary components including a postcode comparator, a binary search utility, and a weather checking service configured
     * through a location finder factory. It then creates a holiday instance for a predefined date and postcode, retrieves the associated weather data,
     * and prints the result to the console.
     *
     * @param args command line arguments (unused)
     * @throws Exception if an error occurs during initialization or weather data retrieval.
     */
    public static void main(String[] args) throws Exception  {
        Comparator<String> postcodeComparator = new PostcodeComparator();
        BinarySearch binarySearch = new BinarySearch(postcodeComparator);
        WeatherChecker service = new WeatherChecker(new LocationFinderFactory(binarySearch));
        Holiday holiday = new Holiday("2025-02-01", "DN2 6NJ", service);
        WeatherData data = holiday.getWeatherData();
        System.out.println(data.toString());
    }

}