package utils;

public class UriBuilder {

    public static String buildUri(String baseUrl, String lat, String lon){
        String cords = "latitude=" + lat + "&" + "longitude=" + lon;
        String forecastDays = "&forecast_days=16";
        String daily = "&daily=temperature_2m_max,temperature_2m_min,rain_sum,sunshine_duration";

        return baseUrl + "?" + cords + forecastDays + daily;
    }
}
