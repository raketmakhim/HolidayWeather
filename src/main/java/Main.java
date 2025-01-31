import objects.SingleDayWeatherData;
import service.WeatherChecker;
import utils.factory.LocationFinderFactory;

public class Main {

    public static void main(String[] args) throws Exception  {
        WeatherChecker service = new WeatherChecker(new LocationFinderFactory());

        //date format needs to be YYYY-MM-DD
        SingleDayWeatherData data = service.getWeatherForDate("2025-02-01", "DN2 6NJ");
        System.out.println(data.toString());
    }

}