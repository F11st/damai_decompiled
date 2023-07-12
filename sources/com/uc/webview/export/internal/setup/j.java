package com.uc.webview.export.internal.setup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Looper;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.uc.webview.export.extension.ILocationManager;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.Utils;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class j {
    private static AtomicBoolean a = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements ILocationManager {
        private LocationManager a;

        public a(Context context) {
            this.a = (LocationManager) context.getSystemService("location");
        }

        @Override // com.uc.webview.export.extension.ILocationManager
        public final void removeUpdates(LocationListener locationListener) {
            LocationManager locationManager = this.a;
            if (locationManager != null) {
                locationManager.removeUpdates(locationListener);
            }
        }

        @Override // com.uc.webview.export.extension.ILocationManager
        @SuppressLint({"MissingPermission"})
        public final void requestLocationUpdates(String str, long j, float f, LocationListener locationListener) {
            LocationManager locationManager = this.a;
            if (locationManager != null) {
                try {
                    com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(locationManager, str, j, f, locationListener);
                } catch (Throwable unused) {
                    Criteria criteria = new Criteria();
                    if (GeocodeSearch.GPS.equals(str)) {
                        criteria.setAccuracy(1);
                    }
                    com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.a, 0L, 0.0f, criteria, locationListener, Looper.getMainLooper());
                }
            }
        }

        @Override // com.uc.webview.export.extension.ILocationManager
        public final void requestLocationUpdatesWithUrl(String str, long j, float f, LocationListener locationListener, String str2) {
            requestLocationUpdates(str, j, f, locationListener);
        }
    }

    public static void a() {
        SDKFactory.c = af.e();
        long d = com.uc.webview.export.internal.uc.startup.b.d();
        com.uc.webview.export.internal.uc.startup.a.a();
        com.uc.webview.export.internal.uc.startup.b.a(311, com.uc.webview.export.internal.uc.startup.b.d() - d);
        ae a2 = ae.a();
        int i = ae.d.a;
        ae.b bVar = ae.b.SETUP_CORE_FACTORY;
        ae a3 = ae.a();
        a3.getClass();
        a2.a(i, bVar, new ae.a(new k(), null), null);
    }

    public static void b() {
        long d = com.uc.webview.export.internal.uc.startup.b.d();
        SDKFactory.f(CoreFactory.getCoreType().intValue());
        com.uc.webview.export.internal.uc.startup.b.a(308, com.uc.webview.export.internal.uc.startup.b.d() - d);
    }

    public static void c() {
        UCMobileWebKit uCMobileWebKit;
        if (!af.b || (uCMobileWebKit = SDKFactory.d) == null) {
            return;
        }
        uCMobileWebKit.setLocationManagerUC(new a(af.a));
    }

    public static void d() {
        Log.i("InitUtil", "initVideoSetting begin");
        Context context = af.a;
        if (af.b) {
            com.uc.webview.export.internal.uc.startup.b.a(235);
            boolean z = af.e;
            boolean z2 = true;
            z2 = (e() == -1 || e() != 1) ? false : false;
            if (!z && z2) {
                Log.i("InitUtil", "UC Core not support Hardware accelerated.");
                z2 = false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 14) {
                if (z2) {
                    Log.i("InitUtil", "Video Hardware accelerated is supported start at api level 14 and now is " + i);
                }
                CoreFactory.b().setBoolValue(SettingKeys.VideoUseStandardMode, false);
            } else {
                CoreFactory.b().setBoolValue(SettingKeys.VideoUseStandardMode, z2);
                if (z2) {
                    SDKFactory.a((Long) 1048576L);
                }
            }
            SDKFactory.j();
            com.uc.webview.export.internal.update.a.a(af.d);
            com.uc.webview.export.internal.update.a.a(context);
            SDKFactory.o();
            SDKFactory.k();
            com.uc.webview.export.internal.uc.startup.b.a(236);
        }
        Log.i("InitUtil", "initVideoSetting end");
    }

    private static int e() {
        Integer num = (Integer) com.uc.webview.export.internal.utility.i.a().a(UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static boolean a(Boolean bool) {
        if (bool == null) {
            return (Build.VERSION.SDK_INT >= 14) && Utils.checkSupportSamplerExternalOES();
        }
        return bool.booleanValue();
    }

    public static UCMobileWebKit a(Context context) {
        synchronized (a) {
            if (a.get()) {
                return SDKFactory.d;
            }
            com.uc.webview.export.internal.uc.startup.b.a(231);
            UCMobileWebKit initUCMobileWebKit = CoreFactory.initUCMobileWebKit(context, af.e, false);
            SDKFactory.d = initUCMobileWebKit;
            com.uc.webview.export.internal.d.a(initUCMobileWebKit);
            com.uc.webview.export.internal.uc.startup.b.a(232);
            a.set(true);
            return SDKFactory.d;
        }
    }
}
