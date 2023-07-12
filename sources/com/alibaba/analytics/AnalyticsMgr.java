package com.alibaba.analytics;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.analytics.IAnalytics;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.os2;
import tb.sj;
import tb.u6;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AnalyticsMgr {
    private static Application a;
    public static IAnalytics b;
    private static HandlerThread c;
    public static HandlerC3105c d;
    public static volatile boolean g;
    private static final Object e = new Object();
    private static final Object f = new Object();
    public static RunMode h = RunMode.Service;
    private static boolean i = false;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static boolean m = false;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    public static boolean r = false;
    private static boolean s = false;
    private static Map<String, String> t = null;
    private static Map<String, String> u = null;
    public static final List<C3104b> mRegisterList = Collections.synchronizedList(new ArrayList());
    private static Map<String, String> v = new ConcurrentHashMap();
    private static boolean w = false;
    private static boolean x = false;
    private static String y = null;
    private static int z = 10;
    private static ServiceConnection A = new ServiceConnectionC3103a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum RunMode {
        Local,
        Service
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class UTInitTimeoutTask implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AnalyticsMgr.w) {
                    Logger.m("AnalyticsMgr", "delay 30 sec to wait the Remote service connected,waiting...");
                    synchronized (AnalyticsMgr.e) {
                        try {
                            AnalyticsMgr.e.wait(30000L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (AnalyticsMgr.b == null) {
                    Logger.m("AnalyticsMgr", "cannot get remote analytics object,new local object");
                    AnalyticsMgr.N();
                }
                AnalyticsMgr.j().run();
            } catch (Throwable th) {
                Logger.i("AnalyticsMgr", "7", th);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class UtDelayInitTask implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Logger.m("AnalyticsMgr", "延时启动任务");
                synchronized (AnalyticsMgr.f) {
                    int f = AnalyticsMgr.f();
                    if (f > 0) {
                        Logger.m("AnalyticsMgr", "delay " + f + " second to start service,waiting...");
                        try {
                            AnalyticsMgr.f.wait(f * 1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                boolean unused = AnalyticsMgr.w = AnalyticsMgr.i();
                Logger.m("AnalyticsMgr", "isBindSuccess", Boolean.valueOf(AnalyticsMgr.w));
                AnalyticsMgr.d.postAtFrontOfQueue(new UTInitTimeoutTask());
            } catch (Throwable th) {
                Logger.i("AnalyticsMgr", "6", th);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.AnalyticsMgr$a */
    /* loaded from: classes15.dex */
    static class ServiceConnectionC3103a implements ServiceConnection {
        ServiceConnectionC3103a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.f("AnalyticsMgr", "onServiceConnected mConnection", AnalyticsMgr.A);
            if (RunMode.Service == AnalyticsMgr.h) {
                IAnalytics asInterface = IAnalytics.Stub.asInterface(iBinder);
                AnalyticsMgr.b = asInterface;
                Logger.m("AnalyticsMgr", "onServiceConnected iAnalytics", asInterface);
            }
            synchronized (AnalyticsMgr.e) {
                AnalyticsMgr.e.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.f("AnalyticsMgr", "[onServiceDisconnected]");
            synchronized (AnalyticsMgr.e) {
                AnalyticsMgr.e.notifyAll();
            }
            boolean unused = AnalyticsMgr.i = true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.AnalyticsMgr$b */
    /* loaded from: classes15.dex */
    public static class C3104b {
        public String a;
        public String b;
        public MeasureSet c;
        public DimensionSet d;
        public boolean e;
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.AnalyticsMgr$c */
    /* loaded from: classes15.dex */
    public static class HandlerC3105c extends Handler {
        public HandlerC3105c(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            try {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = runnable;
                sendMessage(obtain);
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    ((Runnable) obj).run();
                }
            } catch (Throwable th) {
                Logger.h("AnalyticsMgr", th, new Object[0]);
            }
            super.handleMessage(message);
        }
    }

    private static Runnable A() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.turnOffRealTimeDebug();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable B() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.turnOnDebug();
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable C(final Map<String, String> map) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.turnOnRealTimeDebug(map);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable D(final Map<String, String> map) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.updateSessionProperties(map);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable E(final String str, final String str2, final String str3, final String str4) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.updateUserAccount(str, str2, str3, str4);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public static void F() {
        if (l()) {
            d.a(m());
        }
    }

    public static void G() {
        if (l()) {
            d.a(s());
        }
    }

    private static int H() {
        String f2 = u6.f(a.getApplicationContext(), "UTANALYTICS_REMOTE_SERVICE_DELAY_SECOND");
        int i2 = z;
        i2 = (i2 < 0 || i2 > 30) ? 10 : 10;
        if (TextUtils.isEmpty(f2)) {
            return i2;
        }
        try {
            int intValue = Integer.valueOf(f2).intValue();
            return (intValue < 0 || intValue > 30) ? i2 : intValue;
        } catch (Throwable unused) {
            return i2;
        }
    }

    public static String I(String str) {
        if (l() && str != null) {
            return v.get(str);
        }
        return null;
    }

    public static String J() {
        return p;
    }

    public static String K(String str) {
        IAnalytics iAnalytics = b;
        if (iAnalytics == null) {
            return null;
        }
        try {
            return iAnalytics.getValue(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void L(Exception exc) {
        Logger.u("AnalyticsMgr", exc, new Object[0]);
        if (exc instanceof DeadObjectException) {
            R();
        }
    }

    public static synchronized void M(Application application) {
        synchronized (AnalyticsMgr.class) {
            try {
                if (!g) {
                    Logger.m("AnalyticsMgr", "[init] start sdk_version", os2.a().getFullSDKVersion());
                    a = application;
                    HandlerThread handlerThread = new HandlerThread("Analytics_Client");
                    c = handlerThread;
                    Looper looper = null;
                    handlerThread.start();
                    for (int i2 = 0; i2 < 3; i2++) {
                        looper = c.getLooper();
                        if (looper != null) {
                            break;
                        }
                        Thread.sleep(10L);
                    }
                    HandlerC3105c handlerC3105c = new HandlerC3105c(looper);
                    d = handlerC3105c;
                    handlerC3105c.postAtFrontOfQueue(new UtDelayInitTask());
                    g = true;
                    Logger.f("AnalyticsMgr", "外面init完成");
                }
                Logger.v("AnalyticsMgr", "isInit", Boolean.valueOf(g), "sdk_version", os2.a().getFullSDKVersion());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N() {
        h = RunMode.Local;
        b = new AnalyticsImp(a);
        Logger.v("AnalyticsMgr", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    public static void O() {
        if (l()) {
            d.a(o());
        }
    }

    public static void P() {
        if (l()) {
            d.a(p());
        }
    }

    public static void Q(String str) {
        if (l() && !yh2.f(str) && v.containsKey(str)) {
            v.remove(str);
            d.a(r(str));
        }
    }

    public static void R() {
        Map<String, String> map;
        Logger.f("AnalyticsMgr", "[restart]");
        try {
            if (i) {
                i = false;
                N();
                n().run();
                x(m, x, j, l).run();
                v(k).run();
                u(n).run();
                E(o, p, y, q).run();
                D(t).run();
                if (r) {
                    B().run();
                }
                boolean z2 = s;
                if (z2 && (map = u) != null) {
                    y(map).run();
                } else if (z2) {
                    A().run();
                }
                synchronized (mRegisterList) {
                    int i2 = 0;
                    while (true) {
                        List<C3104b> list = mRegisterList;
                        if (i2 >= list.size()) {
                            break;
                        }
                        C3104b c3104b = list.get(i2);
                        if (c3104b != null) {
                            q(c3104b.a, c3104b.b, c3104b.c, c3104b.d, c3104b.e).run();
                        }
                        i2++;
                    }
                }
                for (Map.Entry<String, String> entry : v.entrySet()) {
                    W(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            Logger.i("AnalyticsMgr", "[restart]", th);
        }
    }

    public static void S() {
        if (l()) {
            d.a(t());
        }
    }

    public static void T(String str) {
        Logger.m("AnalyticsMgr", "aAppVersion", str);
        if (l()) {
            d.a(u(str));
            n = str;
        }
    }

    public static void U(String str) {
        if (l()) {
            d.a(v(str));
            k = str;
        }
    }

    public static void V(int i2) {
        if (i2 < 0 || i2 > 30) {
            return;
        }
        z = i2;
    }

    public static void W(String str, String str2) {
        if (l()) {
            if (!yh2.f(str) && str2 != null) {
                v.put(str, str2);
                d.a(w(str, str2));
                return;
            }
            Logger.i("AnalyticsMgr", "setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        }
    }

    public static void X(boolean z2, boolean z3, String str, String str2) {
        if (l()) {
            d.a(x(z2, z3, str, str2));
            m = z2;
            j = str;
            l = str2;
            x = z3;
        }
    }

    public static void Y(Map<String, String> map) {
        if (l()) {
            d.a(y(map));
        }
    }

    public static void Z() {
        if (l()) {
            d.a(z(sj.c().f()));
        }
    }

    public static void a0() {
        if (l()) {
            d.a(A());
            s = false;
        }
    }

    public static void b0() {
        Logger.m("AnalyticsMgr", "turnOnDebug");
        if (l()) {
            d.a(B());
            r = true;
            Logger.s(true);
        }
    }

    public static void c0(Map<String, String> map) {
        if (l()) {
            d.a(C(map));
            u = map;
            s = true;
        }
    }

    public static void d0(Map<String, String> map) {
        if (l()) {
            d.a(D(map));
            t = map;
        }
    }

    @Deprecated
    public static void e0(String str, String str2, String str3) {
        f0(str, str2, str3, null);
    }

    static /* synthetic */ int f() {
        return H();
    }

    public static void f0(String str, String str2, String str3, String str4) {
        Logger.m("AnalyticsMgr", "userNick", str, "userId", str2, "openId", str3, "userSite", str4);
        if (l()) {
            d.a(E(str, str2, str3, str4));
            g0(str, str2, str3, str4);
        }
    }

    private static void g0(String str, String str2, String str3, String str4) {
        o = str;
        if (TextUtils.isEmpty(str2)) {
            p = null;
            y = null;
        } else if (!TextUtils.isEmpty(str3) || !str2.equals(p)) {
            p = str2;
            y = str3;
        }
        q = str4;
    }

    static /* synthetic */ boolean i() {
        return k();
    }

    static /* synthetic */ Runnable j() {
        return n();
    }

    private static boolean k() {
        boolean z2;
        if (a == null) {
            return false;
        }
        if (h == RunMode.Service) {
            z2 = a.getApplicationContext().bindService(new Intent(a.getApplicationContext(), AnalyticsService.class), A, 1);
            if (!z2) {
                N();
            }
        } else {
            N();
            z2 = false;
        }
        Logger.m("AnalyticsMgr", "bindsuccess", Boolean.valueOf(z2));
        return z2;
    }

    public static boolean l() {
        if (!g) {
            Logger.f("AnalyticsMgr", "Please call init() before call other method");
        }
        return g;
    }

    private static Runnable m() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.dispatchLocalHits();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable n() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.m("AnalyticsMgr", "call Remote init start...");
                try {
                    AnalyticsMgr.b.initUT();
                } catch (Throwable th) {
                    Logger.i("AnalyticsMgr", "initut error", th);
                    AnalyticsMgr.N();
                    try {
                        AnalyticsMgr.b.initUT();
                    } catch (Throwable th2) {
                        Logger.i("AnalyticsMgr", "initut error", th2);
                    }
                }
                try {
                    sj.c().m();
                } catch (Exception unused) {
                }
                Logger.m("AnalyticsMgr", "call Remote init end");
            }
        };
    }

    private static Runnable o() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.f("AnalyticsMgr", "onBackground");
                    AnalyticsMgr.b.onBackground();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable p() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.f("AnalyticsMgr", "onForeground");
                    AnalyticsMgr.b.onForeground();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable q(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z2) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.f("register stat event", "module", str, " monitorPoint: ", str2);
                    AnalyticsMgr.b.register4(str, str2, measureSet, dimensionSet, z2);
                } catch (RemoteException e2) {
                    AnalyticsMgr.L(e2);
                }
            }
        };
    }

    private static Runnable r(final String str) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.removeGlobalProperty(str);
                } catch (RemoteException e2) {
                    AnalyticsMgr.L(e2);
                }
            }
        };
    }

    static Runnable s() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.saveCacheDataToLocal();
                } catch (RemoteException e2) {
                    Logger.u("AnalyticsMgr", e2, new Object[0]);
                }
            }
        };
    }

    private static Runnable t() {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.sessionTimeout();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable u(final String str) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.setAppVersion(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable v(final String str) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.setChannel(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable w(final String str, final String str2) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.setGlobalProperty(str, str2);
                } catch (RemoteException e2) {
                    AnalyticsMgr.L(e2);
                }
            }
        };
    }

    private static Runnable x(final boolean z2, final boolean z3, final String str, final String str2) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.setRequestAuthInfo(z2, z3, str, str2);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable y(final Map<String, String> map) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.setSessionProperties(map);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private static Runnable z(final long j2) {
        return new Runnable() { // from class: com.alibaba.analytics.AnalyticsMgr.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.f("AnalyticsMgr", "startMainProcess");
                    AnalyticsMgr.b.startMainProcess(j2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }
}
