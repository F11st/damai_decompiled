package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.location.DPoint;
import com.loc.a;
import com.loc.j1;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;
    Context a;
    a b;

    public GeoFenceClient(Context context) {
        this.a = null;
        this.b = null;
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            this.b = a(applicationContext);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "<init>");
        }
    }

    private static a a(Context context) {
        return new a(context);
    }

    public void addGeoFence(DPoint dPoint, float f, String str) {
        try {
            this.b.n(dPoint, f, str);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.b.p(str, str2);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "addGeoFence district");
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            this.b.q(str, str2, dPoint, f, i, str3);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            this.b.r(str, str2, str3, i, str4);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.b.t(list, str);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.b.d(str);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.b.B();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.b.Z();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.b.S();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.b.g();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.b.v(geoFence);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void resumeGeoFence() {
        try {
            this.b.W();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i) {
        try {
            this.b.h(i);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z) {
        try {
            this.b.s(str, z);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.b.l(geoFenceListener);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }
}
