package com.autonavi.amap.mapcore;

import com.autonavi.ae.gmap.maploader.Pools;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);
    public double x;
    public double y;

    public DPoint() {
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(0.0d, 0.0d);
        return acquire;
    }

    private void set(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public DPoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public static DPoint obtain(double d, double d2) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d, d2);
        }
        acquire.set(d, d2);
        return acquire;
    }
}
