package com.uc.sandboxExport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.sandboxExport.InterfaceC7165h;
import com.uc.sandboxExport.helper.C7167a;
import com.uc.sandboxExport.helper.C7169c;
import com.uc.sandboxExport.helper.C7173f;
import java.util.concurrent.Executor;
import tb.jn1;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class PreStartup implements InterfaceC7165h {
    private static C7156c a;
    private static C7155b[] b;
    private static ServiceConnectionC7154a[] c;
    private static boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.sandboxExport.PreStartup$a */
    /* loaded from: classes11.dex */
    public static class ServiceConnectionC7154a implements ServiceConnection {
        private static Handler k;
        Context a;
        C7157d b;
        Handler c;
        boolean d;
        ComponentName f;
        IBinder g;
        ServiceConnection h;
        final String i;
        int e = 0;
        final Executor j = new ExecutorC7158a(this);

        ServiceConnectionC7154a(Context context, C7157d c7157d) {
            this.i = "sandbox.PreStartup." + InterfaceC7165h.C7166a.a(c7157d.a);
            this.a = context;
            this.b = c7157d;
            this.c = PreStartup.a(c7157d.a);
        }

        private static String a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return "UnknownState_" + i;
                                }
                                return "DIS_CONNECTED";
                            }
                            return "CONNECTED";
                        }
                        return "BIND_FAILED";
                    }
                    return "BINDING";
                }
                return "BIND";
            }
            return "IDLE";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (this.d) {
                C7169c.a(this.i, "unbindService %s", this.f);
                this.a.unbindService(this);
                this.d = false;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C7169c.a(4, this.i, "onServiceConnected", null);
            this.c.post(new RunnableC7162e(this, iBinder));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            C7169c.a(4, this.i, "onServiceDisconnected", null);
            this.c.post(new RunnableC7163f(this));
        }

        public final String toString() {
            return jn1.ARRAY_START_STR + this.b + AVFSCacheConstants.COMMA_SEP + a(this.e) + AVFSCacheConstants.COMMA_SEP + a() + jn1.ARRAY_END_STR;
        }

        private void b(int i) {
            C7169c.a(this.i, "state changed: %s -> %s", a(this.e), a(i));
            this.e = i;
        }

        final boolean a() {
            int i = this.e;
            return (i == 3 || i == 5) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(ServiceConnectionC7154a serviceConnectionC7154a) {
            if (serviceConnectionC7154a.e != 0) {
                C7169c.a(5, serviceConnectionC7154a.i, "call ChildServiceConnection.start() again!", null);
                return;
            }
            serviceConnectionC7154a.f = new ComponentName(serviceConnectionC7154a.a.getPackageName(), serviceConnectionC7154a.b.b);
            Intent intent = new Intent();
            intent.setComponent(serviceConnectionC7154a.f);
            serviceConnectionC7154a.b(1);
            C7169c.a(serviceConnectionC7154a.i, "bindService %s...", serviceConnectionC7154a.f);
            Context context = serviceConnectionC7154a.a;
            Handler handler = serviceConnectionC7154a.c;
            if (Build.VERSION.SDK_INT >= 24) {
                if (k == null) {
                    HandlerThread handlerThread = new HandlerThread("U4SvcBindHandler");
                    handlerThread.start();
                    k = new Handler(handlerThread.getLooper());
                }
                handler = k;
            }
            boolean a = C7167a.a(context, intent, serviceConnectionC7154a, handler);
            serviceConnectionC7154a.d = a;
            if (a) {
                serviceConnectionC7154a.b(2);
            } else {
                serviceConnectionC7154a.b(3);
            }
        }

        final void b() {
            if (Looper.myLooper() != this.c.getLooper()) {
                this.c.post(new RunnableC7160c(this));
            } else {
                c();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void c(ServiceConnectionC7154a serviceConnectionC7154a) {
            C7169c.a(4, serviceConnectionC7154a.i, "onServiceDisconnectedOnLauncherThread", null);
            serviceConnectionC7154a.b(5);
            ServiceConnection serviceConnection = serviceConnectionC7154a.h;
            if (serviceConnection != null) {
                serviceConnection.onServiceDisconnected(serviceConnectionC7154a.f);
            }
            serviceConnectionC7154a.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(ServiceConnectionC7154a serviceConnectionC7154a, IBinder iBinder) {
            C7169c.a(4, serviceConnectionC7154a.i, "onServiceConnectedOnLauncherThread", null);
            serviceConnectionC7154a.g = iBinder;
            serviceConnectionC7154a.b(4);
            ServiceConnection serviceConnection = serviceConnectionC7154a.h;
            if (serviceConnection != null) {
                serviceConnection.onServiceConnected(serviceConnectionC7154a.f, serviceConnectionC7154a.g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.sandboxExport.PreStartup$b */
    /* loaded from: classes11.dex */
    public static class C7155b {
        final Object a;
        final HandlerThread b;
        final Handler c;

        C7155b(String str) {
            Object obj = new Object();
            this.a = obj;
            HandlerThreadC7164g handlerThreadC7164g = new HandlerThreadC7164g(this, str);
            this.b = handlerThreadC7164g;
            handlerThreadC7164g.start();
            if (handlerThreadC7164g.getLooper() == null) {
                try {
                    synchronized (obj) {
                        if (handlerThreadC7164g.getLooper() == null) {
                            obj.wait(10000L);
                        }
                    }
                } catch (Throwable th) {
                    C7169c.a("sandbox.PreStartup", "mThread.getLooper() failed", th);
                }
            }
            this.c = new Handler(this.b.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.sandboxExport.PreStartup$c */
    /* loaded from: classes11.dex */
    public static class C7156c {
        boolean a = C7173f.a("ESUDLT");

        C7156c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00c7, code lost:
            com.uc.sandboxExport.helper.C7169c.b("sandbox.PreStartup", "No. %d proc id(%d) is invalid", java.lang.Integer.valueOf(r7), java.lang.Integer.valueOf(r9));
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
            com.uc.sandboxExport.helper.C7169c.b("sandbox.PreStartup", "No. %d proc id is empty", java.lang.Integer.valueOf(r7));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static com.uc.sandboxExport.PreStartup.C7157d[] a() {
            /*
                Method dump skipped, instructions count: 249
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.sandboxExport.PreStartup.C7156c.a():com.uc.sandboxExport.PreStartup$d[]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.sandboxExport.PreStartup$d */
    /* loaded from: classes11.dex */
    public static class C7157d {
        int a;
        String b;

        C7157d(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public final String toString() {
            return jn1.ARRAY_START_STR + InterfaceC7165h.C7166a.a(this.a) + AVFSCacheConstants.COMMA_SEP + this.b + jn1.ARRAY_END_STR;
        }
    }

    static /* synthetic */ Handler a(int i) {
        C7155b b2 = b(i);
        if (b2 == null) {
            return null;
        }
        return b2.c;
    }

    private static C7155b b(int i) {
        C7155b[] c7155bArr = b;
        if (c7155bArr == null) {
            return null;
        }
        boolean z = a.a;
        if (!z) {
            i = 0;
        }
        if (c7155bArr[i] == null) {
            c7155bArr[i] = new C7155b(z ? i == 0 ? "U4_RNProcLauncherThread" : i == 1 ? "U4_RIProcLauncherThread" : "U4_GProcLauncherThread" : "U4_ProLauncherThread");
        }
        return b[i];
    }

    public static int bind(int i, ServiceConnection serviceConnection) {
        ServiceConnectionC7154a serviceConnectionC7154a;
        int i2;
        synchronized (PreStartup.class) {
            ServiceConnectionC7154a[] serviceConnectionC7154aArr = c;
            if (serviceConnectionC7154aArr == null || i < 0 || i >= serviceConnectionC7154aArr.length || (serviceConnectionC7154a = serviceConnectionC7154aArr[i]) == null || !serviceConnectionC7154a.a()) {
                return -1;
            }
            if (Looper.myLooper() == serviceConnectionC7154a.c.getLooper()) {
                String str = serviceConnectionC7154a.i;
                C7169c.a(4, str, "bindService " + serviceConnectionC7154a.f, null);
                serviceConnectionC7154a.h = serviceConnection;
                int i3 = serviceConnectionC7154a.e;
                if (i3 == 3) {
                    i2 = 0;
                } else {
                    if (i3 == 4) {
                        serviceConnectionC7154a.c.post(new RunnableC7161d(serviceConnectionC7154a));
                    }
                    i2 = 1;
                }
                return i2;
            }
            throw new RuntimeException("bindService must be called in the launcher thread");
        }
    }

    public static boolean connectionValid(int i) {
        synchronized (PreStartup.class) {
            d = true;
            ServiceConnectionC7154a[] serviceConnectionC7154aArr = c;
            if (serviceConnectionC7154aArr != null && i >= 0 && i < serviceConnectionC7154aArr.length) {
                ServiceConnectionC7154a serviceConnectionC7154a = serviceConnectionC7154aArr[i];
                if (serviceConnectionC7154a == null) {
                    Object[] objArr = {Integer.valueOf(i)};
                    String a2 = C7169c.a("Can't find connection for proc id %d", objArr);
                    Throwable a3 = C7169c.a(objArr);
                    if (a3 != null) {
                        C7169c.a(5, "sandbox.PreStartup", a2, a3);
                    } else {
                        C7169c.a(5, "sandbox.PreStartup", a2, null);
                    }
                } else {
                    C7169c.a("sandbox.PreStartup", "check connection: %s", serviceConnectionC7154a.toString());
                    return serviceConnectionC7154a.a();
                }
            }
            return false;
        }
    }

    public static HandlerThread getLauncherHandlerThread(int i) {
        HandlerThread handlerThread;
        synchronized (PreStartup.class) {
            d = true;
            C7155b b2 = b(i);
            handlerThread = b2 == null ? null : b2.b;
        }
        return handlerThread;
    }

    public static void setContext(Context context) {
        C7173f.a(context);
    }

    public static void setEnable(boolean z) {
        if (C7173f.a() == null) {
            return;
        }
        C7173f.a("enable", z);
    }

    public static void startup() {
        startup(C7173f.a());
    }

    public static void unbind(int i) {
        ServiceConnectionC7154a serviceConnectionC7154a;
        synchronized (PreStartup.class) {
            ServiceConnectionC7154a[] serviceConnectionC7154aArr = c;
            if (serviceConnectionC7154aArr != null && i >= 0 && i < serviceConnectionC7154aArr.length && (serviceConnectionC7154a = serviceConnectionC7154aArr[i]) != null) {
                serviceConnectionC7154a.b();
                c[i] = null;
            }
        }
    }

    public static void updateSetting(int i, int[] iArr, String[] strArr, boolean z) {
        if (C7173f.a() == null) {
            return;
        }
        setEnable(i > 0);
        synchronized (PreStartup.class) {
            C7173f.a("ESUDLT", z);
            if (i <= 0) {
                C7173f.b("proc_ids", "");
                C7173f.b("svc_names", "");
                C7169c.a(4, "sandbox.PreStartup", "updateSetting: disable", null);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < i; i2++) {
                    sb.append(iArr[i2]);
                    sb.append(',');
                }
                sb.setLength(sb.length() - 1);
                String sb2 = sb.toString();
                C7173f.b("proc_ids", sb2);
                sb.setLength(0);
                for (int i3 = 0; i3 < i; i3++) {
                    sb.append(strArr[i3]);
                    sb.append(',');
                }
                sb.setLength(sb.length() - 1);
                String sb3 = sb.toString();
                C7173f.b("svc_names", sb3);
                C7169c.a("sandbox.PreStartup", "updateSetting: [%s][%s]", sb2, sb3);
            }
        }
    }

    public static void updateSettingAndStopUnwantedService(int i, int[] iArr, String[] strArr, boolean z) {
        boolean z2;
        if (C7173f.a() == null) {
            return;
        }
        updateSetting(i, iArr, strArr, z);
        if (C7173f.a() != null) {
            synchronized (PreStartup.class) {
                int i2 = 0;
                if (i <= 0) {
                    if (c != null) {
                        while (true) {
                            ServiceConnectionC7154a[] serviceConnectionC7154aArr = c;
                            if (i2 >= serviceConnectionC7154aArr.length) {
                                break;
                            }
                            ServiceConnectionC7154a serviceConnectionC7154a = serviceConnectionC7154aArr[i2];
                            if (serviceConnectionC7154a != null) {
                                serviceConnectionC7154a.b();
                                c[i2] = null;
                            }
                            i2++;
                        }
                        c = null;
                    }
                } else if (c != null) {
                    int i3 = 0;
                    while (true) {
                        ServiceConnectionC7154a[] serviceConnectionC7154aArr2 = c;
                        if (i3 >= serviceConnectionC7154aArr2.length) {
                            break;
                        }
                        ServiceConnectionC7154a serviceConnectionC7154a2 = serviceConnectionC7154aArr2[i3];
                        if (serviceConnectionC7154a2 != null) {
                            int length = iArr.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= length) {
                                    z2 = true;
                                    break;
                                } else if (iArr[i4] == serviceConnectionC7154a2.b.a) {
                                    z2 = false;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (z2) {
                                C7169c.a(serviceConnectionC7154a2.i, "no need anymore - %s", serviceConnectionC7154a2.b);
                                serviceConnectionC7154a2.b();
                                c[i3] = null;
                            }
                        }
                        i3++;
                    }
                }
            }
        }
    }

    public static void startup(Context context) {
        String b2;
        if (context == null || (b2 = C7173f.b(context)) == null || b2.length() == 0 || b2.contains(":")) {
            return;
        }
        synchronized (PreStartup.class) {
            Context context2 = null;
            if (d) {
                C7169c.a(5, "sandbox.PreStartup", "U4 core is running, ignore startup", null);
            } else if (a == null) {
                C7173f.a(context);
                try {
                    context2 = context.getApplicationContext();
                } catch (Throwable unused) {
                }
                if (context2 != null) {
                    context = context2;
                }
                a = new C7156c();
                C7157d[] a2 = C7156c.a();
                if (a2 != null) {
                    b = new C7155b[3];
                    c = new ServiceConnectionC7154a[3];
                    for (C7157d c7157d : a2) {
                        if (c7157d != null) {
                            ServiceConnectionC7154a serviceConnectionC7154a = new ServiceConnectionC7154a(context, c7157d);
                            c[c7157d.a] = serviceConnectionC7154a;
                            serviceConnectionC7154a.c.post(new RunnableC7159b(serviceConnectionC7154a));
                        }
                    }
                }
            }
        }
    }
}
