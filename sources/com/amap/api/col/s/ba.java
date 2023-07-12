package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.HandlerC4447t;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ba implements IGeocodeSearch {
    private Context a;
    private GeocodeSearch.OnGeocodeSearchListener b;
    private Handler c;

    public ba(Context context) throws AMapException {
        bu a = bt.a(context, C4434h.a(false));
        if (a.a == bt.EnumC4398c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.c = HandlerC4447t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            C4444r.a(this.a);
            if (a(regeocodeQuery)) {
                return new ai(this.a, regeocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.ba.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 2;
                            obtainMessage.what = 201;
                            HandlerC4447t.C4456i c4456i = new HandlerC4447t.C4456i();
                            c4456i.b = ba.this.b;
                            obtainMessage.obj = c4456i;
                            c4456i.a = new RegeocodeResult(regeocodeQuery, ba.this.getFromLocation(regeocodeQuery));
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        ba.this.c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            C4444r.a(this.a);
            if (geocodeQuery != null) {
                return new C4441o(this.a, geocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.ba.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.what = 200;
                            obtainMessage.arg1 = 2;
                            obtainMessage.arg2 = 1000;
                            HandlerC4447t.C4452e c4452e = new HandlerC4447t.C4452e();
                            c4452e.b = ba.this.b;
                            obtainMessage.obj = c4452e;
                            c4452e.a = new GeocodeResult(geocodeQuery, ba.this.getFromLocationName(geocodeQuery));
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        ba.this.c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }

    private static boolean a(RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }
}
