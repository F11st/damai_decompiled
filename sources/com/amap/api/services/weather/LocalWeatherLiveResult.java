package com.amap.api.services.weather;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class LocalWeatherLiveResult {
    private WeatherSearchQuery a;
    private LocalWeatherLive b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.a = weatherSearchQuery;
        this.b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.a;
    }
}
