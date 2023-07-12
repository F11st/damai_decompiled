package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f83 {
    private static String r = "CoarseLocation";
    private static long s;
    private static boolean t;
    private static boolean u;
    private static boolean v;
    private static boolean w;
    public static volatile AMapLocation x;
    private j73 d;
    private Handler h;
    private Context i;
    private LocationManager l;
    private AMapLocationClientOption m;
    private long a = 0;
    private boolean b = false;
    private int c = 0;
    private int e = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
    private int f = 80;
    private int g = 0;
    private long j = 0;
    private int k = 0;
    private Object n = new Object();
    private boolean o = true;
    private AMapLocationClientOption.GeoLanguage p = AMapLocationClientOption.GeoLanguage.DEFAULT;
    private LocationListener q = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements LocationListener {
        private f83 a;

        a(f83 f83Var) {
            this.a = f83Var;
        }

        final void a() {
            this.a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                f83 f83Var = this.a;
                if (f83Var != null) {
                    f83Var.e(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                f83 f83Var = this.a;
                if (f83Var != null) {
                    f83Var.A();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            GeocodeSearch.GPS.equalsIgnoreCase(str);
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                f83 f83Var = this.a;
                if (f83Var != null) {
                    f83Var.c(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public f83(Context context, Handler handler) {
        this.d = null;
        this.i = context;
        this.h = handler;
        try {
            this.l = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            com.loc.j1.h(th, r, "<init>");
        }
        this.d = new j73();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        try {
            this.g = 0;
        } catch (Throwable unused) {
        }
    }

    private static void B(AMapLocation aMapLocation) {
        if (com.loc.m1.q(aMapLocation) && com.loc.i1.H()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long c = x73.c(time, currentTimeMillis, com.loc.i1.I());
            if (c != time) {
                aMapLocation.setTime(c);
                com.loc.l1.b(time, currentTimeMillis);
            }
        }
    }

    private static com.loc.eo a(int i, String str) {
        com.loc.eo eoVar = new com.loc.eo("");
        eoVar.setErrorCode(i);
        eoVar.setLocationDetail(str);
        return eoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (i == 0) {
            try {
                this.g = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void d(int i, String str, long j) {
        try {
            if (this.h != null) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(20);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                obtain.obj = aMapLocation;
                obtain.what = i;
                this.h.sendMessageDelayed(obtain, j);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(100);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (com.loc.m1.q(aMapLocation)) {
                aMapLocation.setProvider(GeocodeSearch.GPS.equals(location.getProvider()) ? "gps_coarse" : "network_coarse");
                aMapLocation.setLocationType(11);
                if (!this.b && com.loc.m1.q(aMapLocation)) {
                    com.loc.l1.v(this.i, com.loc.m1.B() - this.a, com.loc.j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.b = true;
                }
                Boolean bool = Boolean.FALSE;
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        Boolean bool2 = (Boolean) com.loc.k1.c(location, "isFromMockProvider", new Object[0]);
                        try {
                            "CoarseLocation | isFromMock=".concat(String.valueOf(bool2));
                        } catch (Throwable unused) {
                        }
                        bool = bool2;
                    } catch (Throwable unused2) {
                    }
                }
                if (bool.booleanValue()) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.m.isMockEnable()) {
                        int i = this.k;
                        if (i <= 3) {
                            this.k = i + 1;
                            return;
                        }
                        com.loc.l1.p(null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("CoarseLocation has been mocked!#2007");
                        aMapLocation.setLatitude(0.0d);
                        aMapLocation.setLongitude(0.0d);
                        aMapLocation.setAltitude(0.0d);
                        aMapLocation.setSpeed(0.0f);
                        aMapLocation.setAccuracy(0.0f);
                        aMapLocation.setBearing(0.0f);
                        aMapLocation.setExtras(null);
                        s(aMapLocation);
                        return;
                    }
                } else {
                    this.k = 0;
                }
                int o = o(location);
                this.g = o;
                aMapLocation.setSatellites(o);
                x(aMapLocation);
                B(aMapLocation);
                AMapLocation y = y(aMapLocation);
                g(y);
                p(y);
                synchronized (this.n) {
                    h(y, x);
                }
                s(y);
            }
        } catch (Throwable th) {
            com.loc.j1.h(th, "CoarseLocation", "onLocationChanged");
        }
    }

    private void g(AMapLocation aMapLocation) {
        if (com.loc.m1.q(aMapLocation)) {
            this.c++;
        }
    }

    private void h(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.m.isNeedAddress() || com.loc.m1.c(aMapLocation, aMapLocation2) >= this.e) {
            return;
        }
        com.loc.j1.b(aMapLocation, aMapLocation2);
    }

    private static boolean m(LocationManager locationManager) {
        try {
            if (t) {
                return u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                u = false;
            } else {
                u = allProviders.contains(GeocodeSearch.GPS);
            }
            t = true;
            return u;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            return u;
        }
    }

    private static int o(Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras.getInt("satellites");
        }
        return 0;
    }

    private void p(AMapLocation aMapLocation) {
        Handler handler;
        if (com.loc.m1.q(aMapLocation) && this.h != null) {
            long B = com.loc.m1.B();
            if (this.m.getInterval() <= DanmakuFactory.DEFAULT_DANMAKU_DURATION || B - this.j > this.m.getInterval() - DanmakuFactory.DEFAULT_DANMAKU_DURATION) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat(BQCCameraParam.FOCUS_AREA_RADIUS, aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 102;
                synchronized (this.n) {
                    if (x == null) {
                        handler = this.h;
                    } else if (com.loc.m1.c(aMapLocation, x) > this.f) {
                        handler = this.h;
                    }
                    handler.sendMessage(obtain);
                }
            }
        }
    }

    private static boolean r(LocationManager locationManager) {
        try {
            if (v) {
                return w;
            }
            boolean isProviderEnabled = locationManager.isProviderEnabled("network");
            w = isProviderEnabled;
            v = true;
            return isProviderEnabled;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            return w;
        }
    }

    private void s(AMapLocation aMapLocation) {
        if (this.m.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.m.getDeviceModeDistanceFilter() > 0.0f) {
            v(aMapLocation);
        } else if (com.loc.m1.B() - this.j >= this.m.getInterval() - 200) {
            this.j = com.loc.m1.B();
            v(aMapLocation);
        }
    }

    private boolean t() {
        boolean z = true;
        try {
            if (com.loc.m1.K() >= 28) {
                if (this.l == null) {
                    this.l = (LocationManager) this.i.getApplicationContext().getSystemService("location");
                }
                z = ((Boolean) com.loc.k1.c(this.l, "isLocationEnabled", new Object[0])).booleanValue();
            }
            if (com.loc.m1.K() >= 24 && com.loc.m1.K() < 28) {
                if (Settings.Secure.getInt(this.i.getContentResolver(), "location_mode", 0) == 0) {
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    private void u() {
        s(a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    private void v(AMapLocation aMapLocation) {
        if (this.h != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 101;
            this.h.sendMessage(obtain);
        }
    }

    private void w() {
        s(a(20, "模糊权限下不支持连续定位#2006"));
    }

    private void x(AMapLocation aMapLocation) {
        try {
            if (!com.loc.j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.m.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint d = y73.d(this.i, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(d.getLatitude());
            aMapLocation.setLongitude(d.getLongitude());
            aMapLocation.setOffset(this.m.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
            new StringBuilder("CoarseLocation | offset error: ").append(th.getMessage());
        }
    }

    private AMapLocation y(AMapLocation aMapLocation) {
        if (com.loc.m1.q(aMapLocation) && this.c >= 3) {
            if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                aMapLocation.setAccuracy(0.0f);
            }
            if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                aMapLocation.setSpeed(0.0f);
            }
            return this.d.a(aMapLocation);
        }
        return aMapLocation;
    }

    private void z() {
        if (this.l == null) {
            return;
        }
        try {
            this.o = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.i.getMainLooper();
            }
            this.a = com.loc.m1.B();
            if (r(this.l)) {
                if (this.q == null) {
                    this.q = new a(this);
                }
                com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.l, "network", this.m.getInterval(), this.m.getDeviceModeDistanceFilter(), this.q, myLooper);
            }
            if (m(this.l)) {
                try {
                    if (com.loc.m1.g() - s >= 259200000) {
                        if (com.loc.m1.N(this.i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.l.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                            s = com.loc.m1.g();
                            SharedPreferences.Editor c = a83.c(this.i, "pref");
                            a83.i(c, "lagt", s);
                            a83.f(c);
                        } else {
                            com.loc.j1.h(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("CoarseLocation | sendExtraCommand error: ").append(th.getMessage());
                }
                if (this.q == null) {
                    this.q = new a(this);
                }
                com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.l, GeocodeSearch.GPS, this.m.getInterval(), this.m.getDeviceModeDistanceFilter(), this.q, myLooper);
            }
            if (u || w) {
                d(100, "系统返回定位结果超时#2002", this.m.getHttpTimeOut());
            }
            if (u || w) {
                return;
            }
            d(100, "系统定位当前不可用#2003", 0L);
        } catch (SecurityException e) {
            this.o = false;
            com.loc.l1.p(null, 2121);
            d(101, e.getMessage() + "#2004", 0L);
        } catch (Throwable th2) {
            new StringBuilder("CoarseLocation | requestLocationUpdates error: ").append(th2.getMessage());
            com.loc.j1.h(th2, "CoarseLocation", "requestLocationUpdates part2");
        }
    }

    public final void b() {
        LocationManager locationManager = this.l;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.q;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.q).a();
                this.q = null;
            }
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | removeUpdates error ").append(th.getMessage());
        }
        try {
            Handler handler = this.h;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Throwable unused) {
        }
        this.g = 0;
        this.a = 0L;
        this.j = 0L;
        this.c = 0;
        this.k = 0;
        this.d.c();
    }

    public final void f(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.e = bundle.getInt("I_MAX_GEO_DIS");
                this.f = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.n) {
                    x = aMapLocation;
                }
            } catch (Throwable th) {
                com.loc.j1.h(th, "CoarseLocation", "setLastGeoLocation");
            }
        }
    }

    public final void i(AMapLocationClientOption aMapLocationClientOption) {
        this.m = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.m = new AMapLocationClientOption();
        }
        new StringBuilder("option: ").append(this.m.toString());
        if (!this.m.isOnceLocation()) {
            w();
        } else if (!t()) {
            u();
        } else {
            try {
                s = a83.b(this.i, "pref", "lagt", s);
            } catch (Throwable unused) {
            }
            z();
        }
    }

    @SuppressLint({"NewApi"})
    public final int n() {
        LocationManager locationManager = this.l;
        if (locationManager != null && m(locationManager)) {
            if (Build.VERSION.SDK_INT >= 19) {
                int i = Settings.Secure.getInt(this.i.getContentResolver(), "location_mode", 0);
                if (i == 0) {
                    return 2;
                }
                if (i == 2) {
                    return 3;
                }
            } else if (!this.l.isProviderEnabled(GeocodeSearch.GPS)) {
                return 2;
            }
            return !this.o ? 4 : 0;
        }
        return 1;
    }

    public final void q(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.m = aMapLocationClientOption;
        new StringBuilder("option: ").append(this.m.toString());
        this.h.removeMessages(100);
        if (this.p != this.m.getGeoLanguage()) {
            synchronized (this.n) {
                x = null;
            }
        }
        this.p = this.m.getGeoLanguage();
    }
}
