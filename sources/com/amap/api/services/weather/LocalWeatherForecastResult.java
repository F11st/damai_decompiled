package com.amap.api.services.weather;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class LocalWeatherForecastResult {
    private WeatherSearchQuery a;
    private LocalWeatherForecast b;

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.a = weatherSearchQuery;
        this.b = localWeatherForecast;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.a;
    }
}
