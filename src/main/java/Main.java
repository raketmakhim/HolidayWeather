import objects.SingleDayWeatherData;
import service.WeatherChecker;

public class Main {

    public static void main(String[] args) throws Exception  {
        WeatherChecker service = new WeatherChecker("src/main/resources/data/SortedPostCodes.csv", "forecast.url");

        //date format needs to be YYYY-MM-DD
        SingleDayWeatherData data = service.getWeatherForDate("2025-01-26", "DN2 6NJ");
        System.out.println(data.toString());
    }

}