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
import com.uc.webview.export.internal.C7250d;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.uc.startup.C7301a;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.update.C7311a;
import com.uc.webview.export.internal.utility.C7336i;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.Utils;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.j */
/* loaded from: classes11.dex */
public final class C7279j {
    private static AtomicBoolean a = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.j$a */
    /* loaded from: classes11.dex */
    static class C7280a implements ILocationManager {
        private LocationManager a;

        public C7280a(Context context) {
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
        long d = C7302b.d();
        C7301a.a();
        C7302b.a(311, C7302b.d() - d);
        C7257ae a2 = C7257ae.a();
        int i = C7257ae.C7261d.a;
        C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.SETUP_CORE_FACTORY;
        C7257ae a3 = C7257ae.a();
        a3.getClass();
        a2.a(i, enumC7259b, new C7257ae.CallableC7258a(new CallableC7281k(), null), null);
    }

    public static void b() {
        long d = C7302b.d();
        SDKFactory.f(CoreFactory.getCoreType().intValue());
        C7302b.a(308, C7302b.d() - d);
    }

    public static void c() {
        UCMobileWebKit uCMobileWebKit;
        if (!af.b || (uCMobileWebKit = SDKFactory.d) == null) {
            return;
        }
        uCMobileWebKit.setLocationManagerUC(new C7280a(af.a));
    }

    public static void d() {
        Log.i("InitUtil", "initVideoSetting begin");
        Context context = af.a;
        if (af.b) {
            C7302b.a(235);
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
            C7311a.a(af.d);
            C7311a.a(context);
            SDKFactory.o();
            SDKFactory.k();
            C7302b.a(236);
        }
        Log.i("InitUtil", "initVideoSetting end");
    }

    private static int e() {
        Integer num = (Integer) C7336i.a().a(UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED);
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
            C7302b.a(231);
            UCMobileWebKit initUCMobileWebKit = CoreFactory.initUCMobileWebKit(context, af.e, false);
            SDKFactory.d = initUCMobileWebKit;
            C7250d.a(initUCMobileWebKit);
            C7302b.a(232);
            a.set(true);
            return SDKFactory.d;
        }
    }
}
