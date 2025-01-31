package utils.web;

import utils.ConfigReader;

import java.io.IOException;

public class UriBuilder {

    private static final String URL_NAME = "forecast.url";

    public static String buildUri(String lat, String lon) throws IOException {
        String cords = "latitude=" + lat + "&" + "longitude=" + lon;
        String forecastDays = "&forecast_days=16";
        String daily = "&daily=temperature_2m_max,temperature_2m_min,rain_sum,sunshine_duration";

        return ConfigReader.getProperties(URL_NAME) + "?" + cords + forecastDays + daily;
    }
}
