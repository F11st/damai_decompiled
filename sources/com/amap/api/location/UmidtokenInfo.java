package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.loc.C5861o;
import com.loc.j1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class UmidtokenInfo {
    private static AMapLocationClient d;
    static Handler a = new Handler();
    static String b = null;
    private static long e = 30000;
    static boolean c = true;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.location.UmidtokenInfo$a */
    /* loaded from: classes10.dex */
    static class C4466a implements AMapLocationListener {
        C4466a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.d != null) {
                    UmidtokenInfo.a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.d.onDestroy();
                }
            } catch (Throwable th) {
                j1.h(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return b;
    }

    public static void setLocAble(boolean z) {
        c = z;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                b = str;
                C5861o.B(str);
                if (d == null && c) {
                    C4466a c4466a = new C4466a();
                    d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    d.setLocationOption(aMapLocationClientOption);
                    d.setLocationListener(c4466a);
                    d.startLocation();
                    a.postDelayed(new Runnable() { // from class: com.amap.api.location.UmidtokenInfo.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (UmidtokenInfo.d != null) {
                                    UmidtokenInfo.d.onDestroy();
                                }
                            } catch (Throwable th) {
                                j1.h(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, 30000L);
                }
            } catch (Throwable th) {
                j1.h(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
