package com.mycompany.assignment;

public class climatedate {
    private int DateId;
    private String Temp;
    private String WeatherConditions;
    private String Datedata;

    public climatedate() {
    }

    public climatedate(int DateId, String Temp, String WeatherConditions, String Datedata) {
        this.DateId = DateId;
        this.Temp = Temp;
        this.WeatherConditions = WeatherConditions;
        this.Datedata = Datedata;
    }

    public int getDateId() {
        return DateId;
    }

    public void setDateId(int DateId) {
        this.DateId = DateId;
    }

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String Temp) {
        this.Temp = Temp;
    }

    public String getWeatherConditions() {
        return WeatherConditions;
    }

    public void setWeatherConditions(String WeatherConditions) {
        this.WeatherConditions = WeatherConditions;
    }

    public String getDatedata() {
        return Datedata;
    }

    public void setDatedata(String Datedata) {
        this.Datedata = Datedata;
    }

    @Override
    public String toString() {
        return "No.: " + DateId + "\n"
                + "Temperature: " + Temp + " C\n"
                + "Weather Condition: " + WeatherConditions + "\n"
                + "Date: " + Datedata + "\n";
    }
}
