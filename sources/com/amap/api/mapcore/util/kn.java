package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.gm;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kn {
    private static final String[] b = {"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};
    private static final String[] c = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    private static final String[] d = {"com.amap.trace"};
    static gm a = null;

    public static gm a() throws gb {
        Class<?> cls;
        Class<?> cls2;
        gm a2;
        gm gmVar = a;
        if (gmVar != null) {
            return gmVar;
        }
        try {
            cls = MapsInitializer.class;
            String str = MapsInitializer.sdcardDir;
        } catch (Throwable unused) {
            cls = null;
        }
        try {
            if (cls != null) {
                String str2 = (String) ka.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
                a2 = new gm.a("3dmap", str2, "AMAP_SDK_Android_Map_" + str2).a(b).a();
            } else {
                cls = Class.forName("com.amap.api.maps2d.MapsInitializer");
                String str3 = (String) ka.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
                a2 = new gm.a("2dmap", str3, "AMAP_SDK_Android_2DMap_" + str3).a(c).a();
            }
            a = a2;
        } catch (Throwable unused2) {
        }
        if (cls == null) {
            try {
                cls2 = Class.forName("com.amap.trace.AMapTraceClient");
            } catch (Throwable unused3) {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    String str4 = (String) ka.a(cls2, "getVersion", (Object[]) null, (Class<?>[]) null);
                    a = new gm.a(AgooConstants.MESSAGE_TRACE, str4, "AMAP_TRACE_Android_" + str4).a(d).a();
                } catch (Throwable unused4) {
                }
            }
        }
        return a;
    }

    public static boolean a(kj kjVar) {
        if (kjVar == null || kjVar.d().equals("8") || kjVar.d().equals("5") || kjVar.d().equals("6")) {
            return false;
        }
        return a((Inner_3dMap_location) kjVar);
    }

    public static boolean a(Inner_3dMap_location inner_3dMap_location) {
        double longitude = inner_3dMap_location.getLongitude();
        double latitude = inner_3dMap_location.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }
}
