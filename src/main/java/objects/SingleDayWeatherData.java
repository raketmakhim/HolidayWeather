package objects;

public class SingleDayWeatherData {
    String date;
    String maxTemp;
    String minTemp;
    String rain;
    String sunshine;

    public SingleDayWeatherData(String date, String maxTemp, String minTemp, String rain , String sunshine){
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.rain = rain;
        this.sunshine = sunshine;
    }

    public SingleDayWeatherData(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getSunshine() {
        return sunshine;
    }

    public void setSunshine(String sunshine) {
        this.sunshine = sunshine;
    }

    @Override
    public String toString() {
        return "SingleDayWeatherData{" +
                "date='" + date + '\'' +
                ", maxTemp='" + maxTemp + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", rain='" + rain + '\'' +
                ", sunshine='" + sunshine + '\'' +
                '}';
    }
}
