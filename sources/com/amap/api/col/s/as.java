package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class as extends at<WeatherSearchQuery, LocalWeatherLive> {
    private LocalWeatherLive k;

    public as(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.k = new LocalWeatherLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: c */
    public LocalWeatherLive a(String str) throws AMapException {
        LocalWeatherLive e = q.e(str);
        this.k = e;
        return e;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) ((a) this).b).getCity();
        if (!q.g(city)) {
            String b = b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + bk.f(((a) this).e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.at, com.amap.api.col.s.df
    public final /* bridge */ /* synthetic */ String h() {
        return super.h();
    }
}
