package com.amap.api.maps.model;

import com.amap.api.mapcore.util.eq;
import com.autonavi.amap.mapcore.DPoint;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng, double d) {
        if (latLng != null) {
            this.latLng = latLng;
            this.mPoint = eq.a(latLng);
            if (d >= 0.0d) {
                this.intensity = d;
                return;
            } else {
                this.intensity = 1.0d;
                return;
            }
        }
        throw new IllegalArgumentException("latLng can not null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DPoint getPoint() {
        return this.mPoint;
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
