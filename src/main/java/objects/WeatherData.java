package objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    private DailyData daily;

    public DailyData getDaily() {
        return daily;
    }

    public void setDaily(DailyData daily) {
        this.daily = daily;
    }

    public static class DailyData {
        private List<String> time;
        private List<Double> temperature_2m_max;
        private List<Double> temperature_2m_min;
        private List<Double> rain_sum;
        private List<Double> sunshine_duration;

        public List<String> getTime() {
            return time;
        }

        public void setTime(List<String> time) {
            this.time = time;
        }

        public List<Double> getTemperature_2m_max() {
            return temperature_2m_max;
        }

        public void setTemperature_2m_max(List<Double> temperature_2m_max) {
            this.temperature_2m_max = temperature_2m_max;
        }

        public List<Double> getTemperature_2m_min() {
            return temperature_2m_min;
        }

        public void setTemperature_2m_min(List<Double> temperature_2m_min) {
            this.temperature_2m_min = temperature_2m_min;
        }

        public List<Double> getRain_sum() {
            return rain_sum;
        }

        public void setRain_sum(List<Double> rain_sum) {
            this.rain_sum = rain_sum;
        }

        public List<Double> getSunshine_duration() {
            return sunshine_duration;
        }

        public void setSunshine_duration(List<Double> sunshine_duration) {
            this.sunshine_duration = sunshine_duration;
        }
    }
}