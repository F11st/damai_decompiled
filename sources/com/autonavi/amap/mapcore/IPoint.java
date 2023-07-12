package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class IPoint extends Point implements Cloneable {
    private static final Pools.SynchronizedPool<IPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public IPoint() {
    }

    public static IPoint obtain() {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint();
        }
        acquire.set(0, 0);
        return acquire;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public IPoint(int i, int i2) {
        ((Point) this).x = i;
        ((Point) this).y = i2;
    }

    public static IPoint obtain(int i, int i2) {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint(i, i2);
        }
        acquire.set(i, i2);
        return acquire;
    }
}
