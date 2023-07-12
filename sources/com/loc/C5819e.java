package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.xu1;

/* compiled from: Taobao */
/* renamed from: com.loc.e */
/* loaded from: classes10.dex */
public final class C5819e {
    static boolean v;
    Context i;
    private List<Messenger> p;
    private boolean a = false;
    private boolean b = false;
    String c = null;
    HandlerThreadC5821b d = null;
    private long e = 0;
    private eo f = null;
    AMapLocation g = null;
    HandlerC5820a h = null;
    private n1 j = null;
    ej k = null;
    HashMap<Messenger, Long> l = new HashMap<>();
    l1 m = null;
    long n = 0;
    long o = 0;
    String q = null;
    private boolean r = true;
    private String s = "";
    AMapLocationClientOption t = null;
    AMapLocationClientOption u = new AMapLocationClientOption();

    /* compiled from: Taobao */
    /* renamed from: com.loc.e$a */
    /* loaded from: classes10.dex */
    public class HandlerC5820a extends Handler {
        public HandlerC5820a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x010e A[Catch: all -> 0x011c, TryCatch #2 {all -> 0x011c, blocks: (B:21:0x0058, B:24:0x005e, B:55:0x0118, B:26:0x0063, B:27:0x006c, B:28:0x0071, B:30:0x0075, B:32:0x007d, B:34:0x0089, B:35:0x0092, B:37:0x009a, B:39:0x00a6, B:40:0x00ae, B:42:0x00b2, B:44:0x00ba, B:46:0x00c6, B:48:0x00db, B:49:0x00e1, B:50:0x00e7, B:51:0x00ed, B:52:0x00f8, B:53:0x0103, B:54:0x010e, B:20:0x0051), top: B:64:0x0051 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r9) {
            /*
                Method dump skipped, instructions count: 312
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.C5819e.HandlerC5820a.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.e$b */
    /* loaded from: classes10.dex */
    public class HandlerThreadC5821b extends HandlerThread {
        public HandlerThreadC5821b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                C5819e.this.j = new n1(C5819e.this.i);
                i1.j(C5819e.this.i);
                i1.a(C5819e.this.i);
                C5819e.this.k = new ej(false);
                super.onLooperPrepared();
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                j1.h(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public C5819e(Context context) {
        this.i = null;
        this.i = context;
    }

    public static void C() {
        v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (m1.f0(this.i)) {
            return;
        }
        try {
            ej ejVar = this.k;
            if (ejVar == null || ejVar == null) {
                return;
            }
            ejVar.k(this.h);
            this.k.B();
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        try {
            i1.m(this.i);
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    private static eo a(int i, String str) {
        try {
            eo eoVar = new eo("");
            eoVar.setErrorCode(i);
            eoVar.setLocationDetail(str);
            return eoVar;
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Bundle bundle) {
        try {
            if (this.a) {
                ej ejVar = this.k;
                if (ejVar != null) {
                    ejVar.i();
                    return;
                }
                return;
            }
            j1.e(this.i);
            if (bundle != null) {
                this.u = j1.c(bundle.getBundle("optBundle"));
            }
            this.k.j(this.i);
            this.k.q();
            l(this.u);
            this.k.v();
            this.a = true;
            this.r = true;
            this.s = "";
            List<Messenger> list = this.p;
            if (list == null || list.size() <= 0) {
                return;
            }
            D();
        } catch (Throwable th) {
            this.r = false;
            th.printStackTrace();
            this.s = th.getMessage();
            j1.h(th, "ApsServiceCore", UCCore.LEGACY_EVENT_INIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Messenger messenger) {
        this.l.remove(messenger);
    }

    private static void g(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i;
                messenger.send(obtain);
            } catch (Throwable th) {
                j1.h(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.b) {
                    return;
                }
                this.b = true;
                x(messenger);
            } catch (Throwable th) {
                j1.h(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Messenger messenger, AMapLocation aMapLocation, String str, ei eiVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", eiVar);
        this.l.put(messenger, Long.valueOf(m1.B()));
        g(messenger, 1, bundle);
    }

    private void k(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", i1.y() * 3);
        bundle.putInt("I_MIN_GEO_DIS", i1.y());
        bundle.putParcelable("loc", this.g);
        g(messenger, "COARSE_LOC".equals(str) ? 103 : 6, bundle);
    }

    private void l(AMapLocationClientOption aMapLocationClientOption) {
        try {
            ej ejVar = this.k;
            if (ejVar != null) {
                ejVar.m(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                v = aMapLocationClientOption.isKillProcess();
                if (this.t != null) {
                    if (aMapLocationClientOption.isOffset() != this.t.isOffset() || aMapLocationClientOption.isNeedAddress() != this.t.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.t.isLocationCacheEnable() || this.t.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.e = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.t.isOffset() || this.t.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.g = null;
                    }
                }
                this.t = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "setExtra");
        }
    }

    private static AMapLocationClientOption t(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = j1.c(bundle.getBundle("optBundle"));
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                C5861o.B(string);
            }
        } catch (Throwable th) {
            j1.h(th, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    static /* synthetic */ eo u(String str) {
        return a(10, str);
    }

    private void x(Messenger messenger) {
        try {
            this.k.A();
            if (i1.A()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                g(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "initAuth");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0140 A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(android.os.Messenger r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C5819e.y(android.os.Messenger, android.os.Bundle):void");
    }

    public final void A() {
        try {
            HashMap<Messenger, Long> hashMap = this.l;
            if (hashMap != null) {
                hashMap.clear();
                this.l = null;
            }
            List<Messenger> list = this.p;
            if (list != null) {
                list.clear();
            }
            n1 n1Var = this.j;
            if (n1Var != null) {
                n1Var.e();
                this.j = null;
            }
            this.a = false;
            this.b = false;
            this.k.z();
            HandlerC5820a handlerC5820a = this.h;
            if (handlerC5820a != null) {
                handlerC5820a.removeCallbacksAndMessages(null);
            }
            this.h = null;
            HandlerThreadC5821b handlerThreadC5821b = this.d;
            if (handlerThreadC5821b != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    k1.b(handlerThreadC5821b, HandlerThread.class, "quitSafely", new Object[0]);
                } else {
                    handlerThreadC5821b.quit();
                }
            }
            this.d = null;
            if (this.m != null && this.n != 0 && this.o != 0) {
                long B = m1.B() - this.n;
                l1.e(this.i, this.m.w(this.i), this.m.x(this.i), this.o, B);
                this.m.y(this.i);
            }
            l1.c(this.i);
            an.k();
            if (v) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th) {
            j1.h(th, xu1.DEFAULT_SAVE_DIR, "tdest");
        }
    }

    public final void c() {
        try {
            this.m = new l1();
            HandlerThreadC5821b handlerThreadC5821b = new HandlerThreadC5821b("amapLocCoreThread");
            this.d = handlerThreadC5821b;
            handlerThreadC5821b.setPriority(5);
            this.d.start();
            this.h = new HandlerC5820a(this.d.getLooper());
            this.p = new ArrayList();
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void d(Intent intent) {
        HandlerC5820a handlerC5820a;
        if (!"true".equals(intent.getStringExtra("as")) || (handlerC5820a = this.h) == null) {
            return;
        }
        handlerC5820a.sendEmptyMessageDelayed(9, 100L);
    }

    final void i(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption t;
        float f;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d = bundle.getDouble("lat");
                double d2 = bundle.getDouble("lon");
                float f2 = bundle.getFloat(BQCCameraParam.FOCUS_AREA_RADIUS);
                long j = bundle.getLong("time");
                if ("FINE_LOC".equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation(GeocodeSearch.GPS);
                    aMapLocation.setLatitude(d);
                    aMapLocation.setLocationType(1);
                    aMapLocation.setLongitude(d2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setTime(j);
                    this.k.l(aMapLocation);
                }
                if (i1.x() && (t = t(bundle)) != null && t.isNeedAddress()) {
                    l(t);
                    AMapLocation aMapLocation2 = this.g;
                    if (aMapLocation2 != null) {
                        f = m1.e(new double[]{d, d2, aMapLocation2.getLatitude(), this.g.getLongitude()});
                        if (f < i1.y() * 3) {
                            k(messenger, str);
                        }
                    } else {
                        f = -1.0f;
                    }
                    if (f == -1.0f || f > i1.y()) {
                        e(bundle);
                        eo a = this.k.a(d, d2);
                        this.g = a;
                        if (a == null || TextUtils.isEmpty(a.getAdCode())) {
                            return;
                        }
                        k(messenger, str);
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean r(String str) {
        if (TextUtils.isEmpty(this.q)) {
            this.q = j1.o(this.i);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.q);
    }

    public final Handler s() {
        return this.h;
    }

    public final void w(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            C5849m.h(this.i, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.c = stringExtra2;
        C5846l.c(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        C5861o.B(stringExtra3);
    }
}
