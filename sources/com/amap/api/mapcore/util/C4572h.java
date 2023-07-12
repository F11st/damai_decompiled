package com.amap.api.mapcore.util;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.h */
/* loaded from: classes10.dex */
class C4572h implements LocationSource.OnLocationChangedListener {
    Location a;
    private IAMapDelegate b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4572h(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        this.a = location;
        try {
            if (this.b.isMyLocationEnabled()) {
                this.b.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            hd.c(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
