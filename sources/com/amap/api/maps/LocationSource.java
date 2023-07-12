package com.amap.api.maps;

import android.location.Location;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface LocationSource {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
