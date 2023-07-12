package com.amap.api.mapcore.util;

import com.amap.api.maps.model.LatLng;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class el {
    private static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.latitude;
        double d2 = d - latLng3.latitude;
        double d3 = latLng.longitude;
        double d4 = latLng2.longitude;
        return ((d3 - d4) * (d - latLng2.latitude)) - ((d3 - d4) * d2);
    }

    private static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.longitude;
        double d2 = latLng2.longitude;
        double d3 = d - d2 > 0.0d ? d : d2;
        if (d - d2 >= 0.0d) {
            d = d2;
        }
        double d4 = latLng.latitude;
        double d5 = latLng2.latitude;
        double d6 = d4 - d5 > 0.0d ? d4 : d5;
        if (d4 - d5 >= 0.0d) {
            d4 = d5;
        }
        double d7 = latLng3.longitude;
        if (d > d7 || d7 > d3) {
            return false;
        }
        double d8 = latLng3.latitude;
        return d4 <= d8 && d8 <= d6;
    }

    public static boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double a = a(latLng3, latLng4, latLng);
        double a2 = a(latLng3, latLng4, latLng2);
        double a3 = a(latLng, latLng2, latLng3);
        double a4 = a(latLng, latLng2, latLng4);
        int i = (a > 0.0d ? 1 : (a == 0.0d ? 0 : -1));
        if (((i > 0 && a2 < 0.0d) || (a < 0.0d && a2 > 0.0d)) && ((a3 > 0.0d && a4 < 0.0d) || (a3 < 0.0d && a4 > 0.0d))) {
            return true;
        }
        if (i == 0 && b(latLng3, latLng4, latLng)) {
            return true;
        }
        if (a2 == 0.0d && b(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (a3 == 0.0d && b(latLng, latLng2, latLng3)) {
            return true;
        }
        return a4 == 0.0d && b(latLng, latLng2, latLng4);
    }
}
