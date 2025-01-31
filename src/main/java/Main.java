import objects.WeatherData;
import service.WeatherChecker;
import utils.algorithm.BinarySearch;
import utils.factory.LocationFinderFactory;
import utils.postcode.PostcodeComparator;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception  {
        Comparator<String> postcodeComparator = new PostcodeComparator();
        BinarySearch binarySearch = new BinarySearch(postcodeComparator);
        WeatherChecker service = new WeatherChecker(new LocationFinderFactory(binarySearch));

        //date format needs to be YYYY-MM-DD
        WeatherData data = service.getWeatherForDate("2025-02-01", "DN2 6NJ");
        System.out.println(data.toString());
    }

}