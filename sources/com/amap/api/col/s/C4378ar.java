package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.ar */
/* loaded from: classes10.dex */
public final class C4378ar extends at<WeatherSearchQuery, LocalWeatherForecast> {
    private LocalWeatherForecast k;

    public C4378ar(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.k = new LocalWeatherForecast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    /* renamed from: c */
    public LocalWeatherForecast a(String str) throws AMapException {
        LocalWeatherForecast f = C4443q.f(str);
        this.k = f;
        return f;
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) ((AbstractC4370a) this).b).getCity();
        if (!C4443q.g(city)) {
            String b = AbstractC4379b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + bk.f(((AbstractC4370a) this).e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.at, com.amap.api.col.s.df
    public final /* bridge */ /* synthetic */ String h() {
        return super.h();
    }
}
