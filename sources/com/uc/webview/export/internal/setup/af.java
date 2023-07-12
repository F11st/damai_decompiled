package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.uc.sandboxExport.PreStartup;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.d;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class af {
    public static Context a = null;
    public static boolean b = true;
    public static bt c;
    public static ConcurrentHashMap<String, Object> d = new ConcurrentHashMap<>();
    public static boolean e = true;
    private static ClassLoader f = af.class.getClassLoader();
    private static int g = 0;
    private static a h = a.NONE;
    private static final AtomicBoolean i = new AtomicBoolean(false);
    private static final AtomicBoolean j = new AtomicBoolean(false);
    private static volatile String k = null;
    private static volatile String l = null;
    private static HashSet<Integer> m = new HashSet<>();
    private static final AtomicBoolean n = new AtomicBoolean(false);
    private static final LinkedList<ValueCallback<String>> o = new LinkedList<>();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum a {
        NONE,
        INIT_START,
        INIT_FINISHED,
        INIT_STOPPED,
        INIT_EXCEPTION,
        INIT_MULTI_CRASHED,
        CORE_DEX_LOADED,
        CORE_DEX_VERIFIED,
        CORE_LIBRARY_LOADED,
        CORE_LIBRARY_VERIFIED,
        CORE_ENGINE_INITED,
        BUSINESS_INIT_START
    }

    public static boolean b() {
        int i2 = g;
        if (i2 != 0) {
            if (!((i2 & 128) != 0)) {
                return true;
            }
        }
        return false;
    }

    public static a c() {
        return h;
    }

    public static void d() {
        h = a.NONE;
    }

    public static ClassLoader e() {
        ClassLoader classLoader;
        synchronized (j) {
            classLoader = f;
        }
        return classLoader;
    }

    public static void f() {
        AtomicBoolean atomicBoolean = n;
        synchronized (atomicBoolean) {
            if (i.get()) {
                com.uc.webview.export.internal.uc.startup.a.a(9010, null);
            } else {
                atomicBoolean.set(true);
            }
        }
    }

    private static void g() {
        LinkedList<ValueCallback<String>> linkedList = o;
        synchronized (linkedList) {
            if (linkedList.isEmpty()) {
                return;
            }
            String str = null;
            if (c != null && SDKFactory.e() != 2 && (str = c.soDirPath) == null) {
                str = a.getApplicationInfo().nativeLibraryDir;
            }
            Iterator<ValueCallback<String>> it = linkedList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveValue(str);
            }
            o.clear();
        }
    }

    public static void a(ConcurrentHashMap<String, Object> concurrentHashMap) {
        long d2 = com.uc.webview.export.internal.uc.startup.b.d();
        d.putAll(concurrentHashMap);
        a = (Context) d.get("CONTEXT");
        b = !com.uc.webview.export.internal.utility.p.b((Boolean) d.get(UCCore.OPTION_USE_SDK_SETUP));
        e = j.a(com.uc.webview.export.internal.utility.p.a(concurrentHashMap, UCCore.OPTION_HARDWARE_ACCELERATED));
        Integer num = (Integer) d.get(UCCore.OPTION_STARTUP_POLICY);
        if (num != null) {
            g = num.intValue();
        }
        com.uc.webview.export.internal.uc.startup.b.a(15, String.valueOf(g));
        com.uc.webview.export.internal.uc.startup.b.a(310, com.uc.webview.export.internal.uc.startup.b.d() - d2);
        Log.i("SetupController", "initSdkSetup sSetupPolicy:" + g + ", sUseSdkSetup:" + b + ", sIsHardwareAccleration:" + e);
    }

    private static void b(Throwable th) {
        Log.d("SetupController", "tryGenerateCrashLog");
        if (th == null) {
            th = new Throwable();
        }
        new Thread(new ah(th)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d.a c(Throwable th) {
        String sb;
        d.a a2 = new d.a("ucbsinit", th).a("ucbsVersion", Build.Version.NAME).a("coreVersion", com.uc.webview.export.internal.utility.b.a()).a("coreTimestamp", com.uc.webview.export.internal.utility.b.b()).a("supportMin", Build.Version.SUPPORT_U4_MIN).a("apiLevel", String.valueOf(Build.Version.API_LEVEL)).a("initStatus", h.toString()).a("errorCode", th instanceof UCKnownException ? String.valueOf(((UCKnownException) th).errCode()) : "0");
        bt btVar = c;
        d.a b2 = a2.b("ucm info", btVar != null ? btVar.toString() : "No UCMPackageInfo!");
        if (k == null && l == null) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            if (k != null) {
                sb2.append("zipLib=");
                sb2.append(k);
                sb2.append(StringUtils.LF);
                sb2.append(UCCyclone.getFileInfo(new File(k)));
                sb2.append("\n\n");
            }
            if (l != null) {
                sb2.append("outDir=");
                sb2.append(l);
                if (!l.contains("ucmsdk")) {
                    UCCyclone.listAllFiles(sb2, new File(l));
                }
            }
            sb = sb2.toString();
        }
        d.a b3 = b2.b("zip info", sb).b("quick path", com.uc.webview.export.internal.utility.m.a(a));
        d.a b4 = b3.b("file info", UCCyclone.listAllDerivedFiles(a, "ucmsdk") + "\n\n" + UCCyclone.listAllDerivedFiles(a, UCCyclone.dataFolder));
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Log.flushCachedLogs(stringBuffer);
        } catch (Throwable th2) {
            stringBuffer.append("flushCachedLogs failed:" + Log.getStackTraceString(th2));
        }
        b4.b("init logs", stringBuffer.toString());
        return b4;
    }

    public static final Object a(String str) {
        return d.get(str);
    }

    public static int a() {
        return g;
    }

    public static void a(a aVar, Object... objArr) {
        Log.i("SetupController", "initStatus: [" + aVar + jn1.ARRAY_END_STR);
        aVar.toString();
        h = aVar;
        int i2 = ai.a[aVar.ordinal()];
        if (i2 == 1) {
            com.uc.webview.export.internal.uc.startup.b.a();
            Context context = (Context) objArr[0];
            try {
                PreStartup.class.getDeclaredMethod(StartupJointPoint.TYPE, Context.class).invoke(null, context);
            } catch (Throwable unused) {
            }
            am.a(context);
        } else if (i2 == 2) {
            com.uc.webview.export.internal.uc.startup.b.b();
        } else if (i2 == 3) {
            ClassLoader classLoader = (ClassLoader) objArr[0];
            if (classLoader != null) {
                a(classLoader);
            }
            j.a();
        } else if (i2 == 6) {
            if (SDKFactory.e() != 2) {
                i.set(true);
                com.uc.webview.export.internal.uc.startup.a.a(9003, null);
                AtomicBoolean atomicBoolean = n;
                synchronized (atomicBoolean) {
                    if (atomicBoolean.get()) {
                        com.uc.webview.export.internal.uc.startup.a.a(9010, null);
                    }
                }
            }
            com.uc.webview.export.internal.uc.startup.b.a(42);
            a(2);
            g();
        } else if (i2 == 7) {
            Throwable th = (Throwable) objArr[0];
            com.uc.webview.export.internal.uc.startup.b.a(196, th != null ? th.toString() : "");
            a(3);
            if ((com.uc.webview.export.internal.utility.i.a().c(UCCore.OPTION_INIT_FAILED_LOG_POLICY) & 1) != 0) {
                b(th);
            }
        } else if (i2 == 8) {
            Throwable th2 = (Throwable) objArr[0];
            com.uc.webview.export.internal.uc.startup.b.a(197, th2 != null ? th2.toString() : "");
            a(4);
            if ((com.uc.webview.export.internal.utility.i.a().c(UCCore.OPTION_INIT_FAILED_LOG_POLICY) & 1) != 0) {
                b(th2);
            }
        }
        aVar.toString();
    }

    public static void a(int i2) {
        synchronized (m) {
            if (m.contains(Integer.valueOf(i2))) {
                return;
            }
            m.add(Integer.valueOf(i2));
            Log.d("SetupController", "doCoreStatusStat status:" + i2);
            com.uc.webview.export.internal.utility.n.a(new ag(i2));
        }
    }

    private static void a(ClassLoader classLoader) {
        if (classLoader == null) {
            Log.rInfo("SetupController", "setClassLoader failed, maybe load jar failed.");
            return;
        }
        synchronized (j) {
            f = classLoader;
            SDKFactory.c = classLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader a(String str, String str2, String str3) {
        com.uc.webview.export.internal.uc.startup.b.a(532);
        AtomicBoolean atomicBoolean = j;
        synchronized (atomicBoolean) {
            if (atomicBoolean.compareAndSet(false, true)) {
                m mVar = new m(str, str2, str3);
                mVar.run();
                a(mVar.c);
            }
        }
        com.uc.webview.export.internal.uc.startup.b.a(533);
        return e();
    }

    public static void a(ValueCallback<String> valueCallback) {
        LinkedList<ValueCallback<String>> linkedList = o;
        synchronized (linkedList) {
            linkedList.add(valueCallback);
        }
        if (SDKFactory.b()) {
            g();
        }
    }

    public static void a(File file, File file2) {
        k = file.getAbsolutePath();
        l = file2.getAbsolutePath();
    }
}
