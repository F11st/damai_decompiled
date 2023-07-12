package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class h83 {
    static AMapLocation D;
    static long E;
    static Object F = new Object();
    static long G;
    static boolean H;
    static boolean I;
    public static volatile AMapLocation J;
    Handler a;
    private Context b;
    LocationManager c;
    AMapLocationClientOption d;
    j73 i;
    private GnssStatus.Callback t;
    private long e = 0;
    long f = 0;
    boolean g = false;
    private int h = 0;
    int j = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
    int k = 80;
    AMapLocation l = null;
    long m = 0;
    float n = 0.0f;
    Object o = new Object();
    Object p = new Object();
    private int q = 0;
    private GpsStatus r = null;
    private GpsStatus.Listener s = null;
    AMapLocationClientOption.GeoLanguage u = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean v = true;
    long w = 0;
    int x = 0;
    LocationListener y = null;
    private String z = null;
    private boolean A = false;
    private int B = 0;
    private boolean C = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class a extends GnssStatus.Callback {
        a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i) {
            h83.N();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            h83.this.f(gnssStatus);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            h83.L();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            h83.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class b implements GpsStatus.Listener {
        b() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            try {
                h83 h83Var = h83.this;
                LocationManager locationManager = h83Var.c;
                if (locationManager == null) {
                    return;
                }
                h83Var.r = locationManager.getGpsStatus(h83Var.r);
                if (i == 1) {
                    h83.L();
                } else if (i == 2) {
                    h83.this.M();
                } else if (i == 3) {
                    h83.N();
                } else if (i != 4) {
                } else {
                    h83.this.O();
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                com.loc.j1.h(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c implements LocationListener {
        private h83 a;

        c(h83 h83Var) {
            this.a = h83Var;
        }

        final void a() {
            this.a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                h83 h83Var = this.a;
                if (h83Var != null) {
                    h83Var.g(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                h83 h83Var = this.a;
                if (h83Var != null) {
                    h83Var.l(str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                h83 h83Var = this.a;
                if (h83Var != null) {
                    h83Var.d(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public h83(Context context, Handler handler) {
        this.i = null;
        this.b = context;
        this.a = handler;
        try {
            this.c = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            com.loc.j1.h(th, "GpsLocation", "<init>");
        }
        this.i = new j73();
    }

    private void B(AMapLocation aMapLocation) {
        if (this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.a.sendMessage(obtain);
        }
    }

    private void D(AMapLocation aMapLocation) {
        try {
            if (!com.loc.j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.d.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint d = y73.d(this.b, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(d.getLatitude());
            aMapLocation.setLongitude(d.getLongitude());
            aMapLocation.setOffset(this.d.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    private void E(AMapLocation aMapLocation) {
        try {
            int i = this.q;
            if (i >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    private AMapLocation G(AMapLocation aMapLocation) {
        if (com.loc.m1.q(aMapLocation) && this.h >= 3) {
            if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                aMapLocation.setAccuracy(0.0f);
            }
            if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                aMapLocation.setSpeed(0.0f);
            }
            return this.i.a(aMapLocation);
        }
        return aMapLocation;
    }

    private static void J(AMapLocation aMapLocation) {
        if (com.loc.m1.q(aMapLocation) && com.loc.i1.H()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long c2 = x73.c(time, currentTimeMillis, com.loc.i1.I());
            if (c2 != time) {
                aMapLocation.setTime(c2);
                com.loc.l1.b(time, currentTimeMillis);
            }
        }
    }

    private void K() {
        if (this.c == null) {
            return;
        }
        try {
            P();
            this.v = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.b.getMainLooper();
            }
            Looper looper = myLooper;
            this.e = com.loc.m1.B();
            if (!r(this.c)) {
                e(8, 14, "no gps provider#1402", 0L);
                return;
            }
            try {
                if (com.loc.m1.g() - G >= 259200000) {
                    if (com.loc.m1.N(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                        this.c.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                        G = com.loc.m1.g();
                        SharedPreferences.Editor c2 = a83.c(this.b, "pref");
                        a83.i(c2, "lagt", G);
                        a83.f(c2);
                    } else {
                        com.loc.j1.h(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                    }
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
            }
            if (this.y == null) {
                this.y = new c(this);
            }
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.c, GeocodeSearch.GPS, this.d.getInterval(), this.d.getDeviceModeDistanceFilter(), this.y, looper);
            if (Build.VERSION.SDK_INT >= 24) {
                a aVar = new a();
                this.t = aVar;
                this.c.registerGnssStatusCallback(aVar);
            } else {
                b bVar = new b();
                this.s = bVar;
                this.c.addGpsStatusListener(bVar);
            }
            e(8, 14, "no enough satellites#1401", this.d.getHttpTimeOut());
        } catch (SecurityException e) {
            this.v = false;
            com.loc.l1.p(null, 2121);
            e(2, 12, e.getMessage() + "#1201", 0L);
        } catch (Throwable th2) {
            new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th2.getMessage());
            com.loc.j1.h(th2, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.q = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Iterable<GpsSatellite> satellites;
        int i = 0;
        try {
            GpsStatus gpsStatus = this.r;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                Iterator<GpsSatellite> it = satellites.iterator();
                int maxSatellites = this.r.getMaxSatellites();
                while (it.hasNext() && i < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i++;
                    }
                }
            }
        } catch (Throwable th) {
            com.loc.j1.h(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.q = i;
    }

    private void P() {
        if (com.loc.m1.B() - E > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V || !com.loc.m1.q(D)) {
            return;
        }
        if (this.d.isMockEnable() || !D.isMock()) {
            this.f = com.loc.m1.B();
            y(D);
        }
    }

    private static boolean Q() {
        try {
            return ((Boolean) com.loc.k1.e(com.loc.v1.v("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), com.loc.v1.v("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private AMapLocation R() {
        float f;
        float f2;
        try {
            if (com.loc.m1.q(this.l) && com.loc.i1.z() && Q()) {
                JSONObject jSONObject = new JSONObject((String) com.loc.k1.e(com.loc.v1.v("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), com.loc.v1.v("UZ2V0TmF2aUxvY2F0aW9u"), null, null));
                long optLong = jSONObject.optLong("time");
                if (!this.C) {
                    this.C = true;
                    com.loc.l1.q("useNaviLoc", "use NaviLoc");
                }
                if (com.loc.m1.g() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f3 = 0.0f;
                    try {
                        f = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f2 = 0.0f;
                    }
                    try {
                        f3 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f2);
                    aMapLocation.setSpeed(f3);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (com.loc.m1.c(aMapLocation, this.l) <= 300.0f) {
                        synchronized (this.p) {
                            this.l.setLongitude(optDouble2);
                            this.l.setLatitude(optDouble);
                            this.l.setAccuracy(f);
                            this.l.setBearing(f2);
                            this.l.setSpeed(f3);
                            this.l.setTime(optLong);
                            this.l.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 0) {
            try {
                this.f = 0L;
                this.q = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void e(int i, int i2, String str, long j) {
        try {
            if (this.a == null || this.d.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(GeocodeSearch.GPS);
            aMapLocation.setErrorCode(i2);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i;
            this.a.sendMessageDelayed(obtain, j);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(GnssStatus gnssStatus) {
        int i = 0;
        if (gnssStatus != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    int i2 = 0;
                    while (i < satelliteCount) {
                        try {
                            if (gnssStatus.usedInFix(i)) {
                                i2++;
                            }
                            i++;
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            com.loc.j1.h(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.q = i;
                        }
                    }
                    i = i2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.q = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Location location) {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (com.loc.m1.q(aMapLocation)) {
                aMapLocation.setProvider(GeocodeSearch.GPS);
                aMapLocation.setLocationType(1);
                if (!this.g && com.loc.m1.q(aMapLocation)) {
                    com.loc.l1.f(this.b, com.loc.m1.B() - this.e, com.loc.j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.g = true;
                }
                if (com.loc.m1.p(aMapLocation, this.q)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.d.isMockEnable()) {
                        int i = this.x;
                        if (i <= 3) {
                            this.x = i + 1;
                            return;
                        }
                        com.loc.l1.p(null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                        aMapLocation.setLatitude(0.0d);
                        aMapLocation.setLongitude(0.0d);
                        aMapLocation.setAltitude(0.0d);
                        aMapLocation.setSpeed(0.0f);
                        aMapLocation.setAccuracy(0.0f);
                        aMapLocation.setBearing(0.0f);
                        aMapLocation.setExtras(null);
                        y(aMapLocation);
                        return;
                    }
                } else {
                    this.x = 0;
                }
                aMapLocation.setSatellites(this.q);
                D(aMapLocation);
                E(aMapLocation);
                J(aMapLocation);
                AMapLocation G2 = G(aMapLocation);
                i(G2);
                t(G2);
                synchronized (this.o) {
                    j(G2, J);
                }
                if (com.loc.m1.q(G2)) {
                    if (this.l != null) {
                        this.m = location.getTime() - this.l.getTime();
                        this.n = com.loc.m1.c(this.l, G2);
                    }
                    synchronized (this.p) {
                        this.l = G2.m216clone();
                    }
                    this.z = null;
                    this.A = false;
                    this.B = 0;
                }
                y(G2);
            }
        } catch (Throwable th) {
            com.loc.j1.h(th, "GpsLocation", "onLocationChanged");
        }
    }

    private void i(AMapLocation aMapLocation) {
        if (com.loc.m1.q(aMapLocation)) {
            this.f = com.loc.m1.B();
            synchronized (F) {
                E = com.loc.m1.B();
                D = aMapLocation.m216clone();
            }
            this.h++;
        }
    }

    private void j(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.d.isNeedAddress() || com.loc.m1.c(aMapLocation, aMapLocation2) >= this.j) {
            return;
        }
        com.loc.j1.b(aMapLocation, aMapLocation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        try {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                this.f = 0L;
                this.q = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean r(LocationManager locationManager) {
        try {
            if (H) {
                return I;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                I = false;
            } else {
                I = allProviders.contains(GeocodeSearch.GPS);
            }
            H = true;
            return I;
        } catch (Throwable th) {
            new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            return I;
        }
    }

    private void t(AMapLocation aMapLocation) {
        Handler handler;
        if (com.loc.m1.q(aMapLocation) && this.a != null) {
            long B = com.loc.m1.B();
            if (this.d.getInterval() <= DanmakuFactory.DEFAULT_DANMAKU_DURATION || B - this.w > this.d.getInterval() - DanmakuFactory.DEFAULT_DANMAKU_DURATION) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat(BQCCameraParam.FOCUS_AREA_RADIUS, aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.o) {
                    if (J == null) {
                        handler = this.a;
                    } else if (com.loc.m1.c(aMapLocation, J) > this.k) {
                        handler = this.a;
                    }
                    handler.sendMessage(obtain);
                }
            }
        }
    }

    private boolean w(String str) {
        try {
            ArrayList<String> E2 = com.loc.m1.E(str);
            ArrayList<String> E3 = com.loc.m1.E(this.z);
            if (E2.size() < 8 || E3.size() < 8) {
                return false;
            }
            return com.loc.m1.t(this.z, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private void y(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.d.getLocationMode())) {
            if (this.d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.d.getDeviceModeDistanceFilter() > 0.0f) {
                B(aMapLocation);
            } else if (com.loc.m1.B() - this.w >= this.d.getInterval() - 200) {
                this.w = com.loc.m1.B();
                B(aMapLocation);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final int A() {
        LocationManager locationManager = this.c;
        if (locationManager != null && r(locationManager)) {
            if (Build.VERSION.SDK_INT >= 19) {
                int i = Settings.Secure.getInt(this.b.getContentResolver(), "location_mode", 0);
                if (i == 0) {
                    return 2;
                }
                if (i == 2) {
                    return 3;
                }
            } else if (!this.c.isProviderEnabled(GeocodeSearch.GPS)) {
                return 2;
            }
            return !this.v ? 4 : 0;
        }
        return 1;
    }

    public final int C() {
        return this.q;
    }

    public final boolean F() {
        AMapLocationClientOption aMapLocationClientOption = this.d;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || com.loc.m1.B() - this.f <= 300000) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amap.api.location.AMapLocation b(com.amap.api.location.AMapLocation r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.h83.b(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    public final void c() {
        LocationManager locationManager = this.c;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.y;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((c) this.y).a();
                this.y = null;
            }
        } catch (Throwable unused) {
        }
        try {
            GpsStatus.Listener listener = this.s;
            if (listener != null) {
                this.c.removeGpsStatusListener(listener);
            }
        } catch (Throwable unused2) {
        }
        try {
            GnssStatus.Callback callback = this.t;
            if (callback != null) {
                this.c.unregisterGnssStatusCallback(callback);
            }
        } catch (Throwable unused3) {
        }
        try {
            Handler handler = this.a;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (Throwable unused4) {
        }
        this.q = 0;
        this.e = 0L;
        this.w = 0L;
        this.f = 0L;
        this.h = 0;
        this.x = 0;
        this.i.c();
        this.l = null;
        this.m = 0L;
        this.n = 0.0f;
        this.z = null;
        this.C = false;
    }

    public final void h(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.j = bundle.getInt("I_MAX_GEO_DIS");
                this.k = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.o) {
                    J = aMapLocation;
                }
            } catch (Throwable th) {
                com.loc.j1.h(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    public final void k(AMapLocationClientOption aMapLocationClientOption) {
        this.d = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.d = new AMapLocationClientOption();
        }
        try {
            G = a83.b(this.b, "pref", "lagt", G);
        } catch (Throwable unused) {
        }
        K();
    }

    public final void u(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.d = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.a) != null) {
            handler.removeMessages(8);
        }
        if (this.u != this.d.getGeoLanguage()) {
            synchronized (this.o) {
                J = null;
            }
        }
        this.u = this.d.getGeoLanguage();
    }

    public final boolean v() {
        return com.loc.m1.B() - this.f <= 2800;
    }

    public final void x() {
        this.x = 0;
    }
}
