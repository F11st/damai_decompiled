package com.amap.api.mapcore.util;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class jr implements AMapLocationListener {
    public Inner_3dMap_locationListener a = null;

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        this.a = inner_3dMap_locationListener;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        try {
            Inner_3dMap_location a = ke.a(aMapLocation);
            if (kn.a(a)) {
                ke.a = a;
            }
            Inner_3dMap_locationListener inner_3dMap_locationListener = this.a;
            if (inner_3dMap_locationListener != null) {
                inner_3dMap_locationListener.onLocationChanged(a);
            }
        } catch (Throwable th) {
            jy.a(th, "LocationListener", "onLocationChanged");
        }
    }
}
