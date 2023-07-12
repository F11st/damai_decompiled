package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kd {
    Context a;
    LocationManager b;
    Object g;
    volatile long c = 0;
    volatile boolean d = false;
    boolean e = false;
    volatile Inner_3dMap_location f = null;
    boolean h = false;
    boolean i = false;
    LocationListener j = new LocationListener() { // from class: com.amap.api.mapcore.util.kd.1
        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            try {
                Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                inner_3dMap_location.setProvider(GeocodeSearch.GPS);
                inner_3dMap_location.setLocationType(1);
                Bundle extras = location.getExtras();
                inner_3dMap_location.setSatellites(extras != null ? extras.getInt("satellites") : 0);
                inner_3dMap_location.setTime(jz.a(inner_3dMap_location.getTime(), System.currentTimeMillis()));
                kd.this.f = inner_3dMap_location;
                kd.this.c = kc.b();
                kd.this.d = true;
            } catch (Throwable th) {
                jy.a(th, "MAPGPSLocation", "onLocationChanged");
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                if (GeocodeSearch.GPS.equals(str)) {
                    kd.this.d = false;
                }
            } catch (Throwable th) {
                jy.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    public kd(Context context) {
        this.g = null;
        if (context == null) {
            return;
        }
        this.a = context;
        e();
        try {
            if (this.g == null && !this.i) {
                this.g = this.h ? CoordinateConverter.class.getConstructor(Context.class).newInstance(context) : Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Throwable unused) {
        }
        if (this.b == null) {
            this.b = (LocationManager) this.a.getSystemService("location");
        }
    }

    private void e() {
        try {
            this.h = true;
        } catch (Throwable unused) {
        }
    }

    private void f() {
        try {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.a.getMainLooper();
            }
            Looper looper = myLooper;
            try {
                this.b.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", new Bundle());
            } catch (Throwable unused) {
            }
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.b, GeocodeSearch.GPS, 800L, 0.0f, this.j, looper);
        } catch (SecurityException unused2) {
        } catch (Throwable th) {
            jy.a(th, "MAPGPSLocation", "requestLocationUpdates");
        }
    }

    private void g() {
        this.d = false;
        this.c = 0L;
        this.f = null;
    }

    public final void a() {
        if (this.e) {
            return;
        }
        f();
        this.e = true;
    }

    public final void b() {
        LocationListener locationListener;
        this.e = false;
        g();
        LocationManager locationManager = this.b;
        if (locationManager == null || (locationListener = this.j) == null) {
            return;
        }
        locationManager.removeUpdates(locationListener);
    }

    public final boolean c() {
        if (this.d) {
            if (kc.b() - this.c <= 10000) {
                return true;
            }
            this.f = null;
            return false;
        }
        return false;
    }

    public final Inner_3dMap_location d() {
        double[] a;
        Object a2;
        Object newInstance;
        if (this.f == null) {
            return null;
        }
        Inner_3dMap_location m240clone = this.f.m240clone();
        if (m240clone != null && m240clone.getErrorCode() == 0) {
            try {
                if (this.g != null) {
                    if (jy.a(m240clone.getLatitude(), m240clone.getLongitude())) {
                        Object[] objArr = {"GPS"};
                        Class[] clsArr = {String.class};
                        if (this.h) {
                            a2 = ka.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr, clsArr);
                            Class<?> cls = Class.forName("com.amap.api.maps.model.LatLng");
                            Class<?> cls2 = Double.TYPE;
                            newInstance = cls.getConstructor(cls2, cls2).newInstance(Double.valueOf(m240clone.getLatitude()), Double.valueOf(m240clone.getLongitude()));
                        } else {
                            a2 = ka.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr, clsArr);
                            Class<?> cls3 = Class.forName("com.amap.api.maps2d.model.LatLng");
                            Class<?> cls4 = Double.TYPE;
                            newInstance = cls3.getConstructor(cls4, cls4).newInstance(Double.valueOf(m240clone.getLatitude()), Double.valueOf(m240clone.getLongitude()));
                        }
                        ka.a(this.g, "coord", newInstance);
                        ka.a(this.g, "from", a2);
                        Object a3 = ka.a(this.g, "convert", new Object[0]);
                        double doubleValue = ((Double) a3.getClass().getDeclaredField("latitude").get(a3)).doubleValue();
                        double doubleValue2 = ((Double) a3.getClass().getDeclaredField("longitude").get(a3)).doubleValue();
                        m240clone.setLatitude(doubleValue);
                        m240clone.setLongitude(doubleValue2);
                    }
                } else if (this.i && jy.a(m240clone.getLatitude(), m240clone.getLongitude()) && (a = jq.a(m240clone.getLongitude(), m240clone.getLatitude())) != null) {
                    m240clone.setLatitude(a[1]);
                    m240clone.setLongitude(a[0]);
                }
            } catch (Throwable unused) {
            }
        }
        return m240clone;
    }
}
