package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.ai;
import com.amap.api.mapcore.util.ej;
import com.amap.api.mapcore.util.eo;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeSearch;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CoordinateConverter {
    private Context a;
    private CoordType b = null;
    private LatLng c = null;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.maps.CoordinateConverter$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CoordType.values().length];
            a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.a = context;
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return ej.a(d, d2);
    }

    public LatLng convert() {
        CoordType coordType = this.b;
        LatLng latLng = null;
        if (coordType == null || this.c == null) {
            return null;
        }
        try {
            String str = "";
            switch (AnonymousClass1.a[coordType.ordinal()]) {
                case 1:
                    latLng = ai.a(this.c);
                    str = "baidu";
                    break;
                case 2:
                    latLng = ai.b(this.a, this.c);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    latLng = this.c;
                    break;
                case 4:
                    str = "sosomap";
                    latLng = this.c;
                    break;
                case 5:
                    str = "aliyun";
                    latLng = this.c;
                    break;
                case 6:
                    str = "google";
                    latLng = this.c;
                    break;
                case 7:
                    str = GeocodeSearch.GPS;
                    latLng = ai.a(this.a, this.c);
                    break;
            }
            eo.a(this.a, str);
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            hd.c(th, "CoordinateConverter", "convert");
            return this.c;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }
}
