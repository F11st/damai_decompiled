package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bi implements IWeatherSearch {
    private Context a;
    private WeatherSearchQuery b;
    private WeatherSearch.OnWeatherSearchListener c;
    private LocalWeatherLiveResult d;
    private LocalWeatherForecastResult e;
    private Handler f;

    public bi(Context context) throws AMapException {
        this.f = null;
        bu a = bt.a(context, h.a(false));
        if (a.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.f = t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bi.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (bi.this.b != null) {
                        if (bi.this.b.getType() != 1) {
                            if (bi.this.b.getType() == 2) {
                                try {
                                    try {
                                        bi biVar = bi.this;
                                        biVar.e = biVar.b();
                                        bundle.putInt("errorCode", 1000);
                                        return;
                                    } catch (AMapException e) {
                                        bundle.putInt("errorCode", e.getErrorCode());
                                        i.a(e, "WeatherSearch", "searchWeatherAsyn");
                                        return;
                                    } catch (Throwable th) {
                                        i.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                                        return;
                                    }
                                } finally {
                                    t.k kVar = new t.k();
                                    obtainMessage.what = 1302;
                                    kVar.b = bi.this.c;
                                    kVar.a = bi.this.e;
                                    obtainMessage.obj = kVar;
                                    obtainMessage.setData(bundle);
                                    bi.this.f.sendMessage(obtainMessage);
                                }
                            }
                            return;
                        }
                        try {
                            try {
                                bi biVar2 = bi.this;
                                biVar2.d = biVar2.a();
                                bundle.putInt("errorCode", 1000);
                                return;
                            } catch (AMapException e2) {
                                bundle.putInt("errorCode", e2.getErrorCode());
                                i.a(e2, "WeatherSearch", "searchWeatherAsyn");
                                return;
                            } catch (Throwable th2) {
                                i.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                                return;
                            }
                        } finally {
                            t.l lVar = new t.l();
                            obtainMessage.what = 1301;
                            lVar.b = bi.this.c;
                            lVar.a = bi.this.d;
                            obtainMessage.obj = lVar;
                            obtainMessage.setData(bundle);
                            bi.this.f.sendMessage(obtainMessage);
                        }
                    }
                    try {
                        throw new AMapException("无效的参数 - IllegalArgumentException");
                    } catch (AMapException e3) {
                        i.a(e3, "WeatherSearch", "searchWeatherAsyn");
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherForecastResult b() throws AMapException {
        r.a(this.a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            ar arVar = new ar(this.a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult(arVar.c_(), arVar.b());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherLiveResult a() throws AMapException {
        r.a(this.a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            as asVar = new as(this.a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult(asVar.c_(), asVar.b());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
