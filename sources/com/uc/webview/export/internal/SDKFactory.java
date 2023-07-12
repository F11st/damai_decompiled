package com.uc.webview.export.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.AttributeSet;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.taobao.accs.common.Constants;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.Build;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.InitCallback;
import com.uc.webview.export.extension.NotAvailableUCListener;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import com.uc.webview.export.extension.UCSettings;
import com.uc.webview.export.internal.android.C7217b;
import com.uc.webview.export.internal.android.C7221f;
import com.uc.webview.export.internal.android.C7236q;
import com.uc.webview.export.internal.android.C7243v;
import com.uc.webview.export.internal.android.CookieManagerAndroid;
import com.uc.webview.export.internal.android.WebViewAndroid;
import com.uc.webview.export.internal.cd.C7247a;
import com.uc.webview.export.internal.interfaces.CommonDef;
import com.uc.webview.export.internal.interfaces.ICookieManager;
import com.uc.webview.export.internal.interfaces.IGeolocationPermissions;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IMimeTypeMap;
import com.uc.webview.export.internal.interfaces.IPreloadManager;
import com.uc.webview.export.internal.interfaces.IServiceWorkerController;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebStorage;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import com.uc.webview.export.internal.setup.UCMRunningInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.setup.ba;
import com.uc.webview.export.internal.setup.bt;
import com.uc.webview.export.internal.uc.C7299b;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.uc.wa.C7303a;
import com.uc.webview.export.internal.utility.C7345n;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class SDKFactory {
    public static NotAvailableUCListener a = null;
    public static ValueCallback<Pair<String, HashMap<String, String>>> b = null;
    public static String g = null;
    @Reflection
    public static final int getCoreType = 10020;
    @Reflection
    public static final int getGlobalSettings = 10022;
    @Reflection
    public static final int handlePerformanceTests = 10030;
    public static InitCallback i = null;
    @Reflection
    public static final int isInited = 10010;
    @Reflection
    public static final int setBrowserFlag = 10009;
    @Reflection
    public static final int setCoreType = 10021;
    @Reflection
    public static final int setPreloadManager = 10059;
    @Reflection
    public static final int setWebViewFactory = 10008;
    public static SetupTask t;
    public static ClassLoader c = SDKFactory.class.getClassLoader();
    public static UCMobileWebKit d = null;
    public static Context e = null;
    private static int x = 0;
    public static boolean f = false;
    private static IGlobalSettings y = null;
    private static IPreloadManager z = null;
    private static AbstractWebViewFactory A = new C7211a((byte) 0);
    public static int h = 0;
    public static boolean j = false;
    public static boolean k = false;
    public static ValueCallback<String> l = null;
    public static ValueCallback<String> m = null;
    public static ValueCallback<UCSetupException> n = null;
    public static long o = 0;
    public static Map<String, Integer> p = new HashMap();
    public static long q = System.currentTimeMillis();
    public static long r = SystemClock.currentThreadTimeMillis();
    private static boolean B = true;
    private static boolean C = true;
    private static final Object D = new Object();
    public static String s = null;
    private static boolean E = false;
    static boolean u = false;
    static boolean v = false;
    static boolean w = false;
    private static boolean F = false;

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.SDKFactory$a */
    /* loaded from: classes11.dex */
    static class C7211a extends AbstractWebViewFactory {
        private C7211a() {
        }

        @Override // com.uc.webview.export.internal.AbstractWebViewFactory
        public final IWebView createWebView(Context context, AttributeSet attributeSet, WebView webView, boolean z, int[] iArr) {
            int i;
            boolean z2 = z || CommonDef.sOnCreateWindowType == 1;
            SDKFactory.a(context, z2);
            if (z2) {
                i = 2;
            } else if (CommonDef.sOnCreateWindowType != 2) {
                i = SDKFactory.x;
            } else {
                i = CoreFactory.getCoreType().intValue();
            }
            Log.i("SDKFactory", String.format("createWebView(forceUsSystem=%b, sOnCreateWindowType=%d)=>coreType=%d", Boolean.valueOf(z), Integer.valueOf(CommonDef.sOnCreateWindowType), Integer.valueOf(i)));
            iArr[0] = i;
            if (i == 2) {
                return new WebViewAndroid(context, attributeSet, webView);
            }
            return CoreFactory.createWebView(context, attributeSet);
        }

        /* synthetic */ C7211a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.SDKFactory$b */
    /* loaded from: classes11.dex */
    public static class HandlerC7212b extends Handler {
        private static final ConcurrentLinkedQueue<Runnable> a = new ConcurrentLinkedQueue<>();
        private static UCSetupException b = null;
        private static final Runnable c = new RunnableC7246c();

        private HandlerC7212b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            NotAvailableUCListener notAvailableUCListener;
            if (message.what == 0 && (notAvailableUCListener = SDKFactory.a) != null) {
                notAvailableUCListener.onNotAvailableUC(message.arg1);
                SDKFactory.a = null;
            }
        }

        static void a(Runnable runnable) {
            if (runnable != null) {
                a.add(runnable);
                new HandlerC7212b(Looper.getMainLooper()).post(c);
            }
            if (SDKFactory.p()) {
                if (b == null) {
                    c.run();
                }
                UCSetupException uCSetupException = b;
                if (uCSetupException != null) {
                    throw uCSetupException;
                }
            }
        }
    }

    public static void a(Long l2) {
        o |= l2.longValue();
    }

    public static void b(Long l2) {
        o &= ~l2.longValue();
    }

    public static Boolean c(Long l2) {
        return Boolean.valueOf((o & l2.longValue()) != 0);
    }

    public static UCMobileWebKit d() {
        if (e() == 2) {
            return null;
        }
        return CoreFactory.getUCMobileWebKit();
    }

    public static IMimeTypeMap e(int i2) {
        h();
        if (i2 == 2) {
            return new C7221f();
        }
        return CoreFactory.e();
    }

    public static void f(int i2) {
        if (i2 != 0) {
            Throwable th = i2 != 3 ? new Throwable() : null;
            Log.i("SDKFactory", "setCoreType: " + i2, th);
            x = i2;
            g();
        }
    }

    public static void g() {
        Object obj = D;
        synchronized (obj) {
            try {
                obj.notifyAll();
            } catch (Exception e2) {
                Log.i("SDKFactory", "releaseLock", e2);
            }
        }
    }

    public static void h() {
        SetupTask setupTask;
        InitCallback initCallback;
        if (w && Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        if (b() && HandlerC7212b.a.isEmpty()) {
            return;
        }
        if (f && !b() && (initCallback = i) != null) {
            initCallback.notInit();
        }
        if (f && Build.IS_INTERNATIONAL_VERSION) {
            return;
        }
        if (!j && (setupTask = t) != null) {
            setupTask.start();
        }
        r();
    }

    public static Pair<Long, Long> i() {
        if (e() == 2) {
            return null;
        }
        UCMobileWebKit d2 = d();
        try {
            return new Pair<>(Long.valueOf(d2.getClass().getField("sTrafficSent").getLong(d2)), Long.valueOf(d2.getClass().getField("sTrafficReceived").getLong(d2)));
        } catch (Throwable th) {
            Log.d("SDKFactory", "getTraffic", th);
            return null;
        }
    }

    @Reflection
    public static Object invoke(int i2, Object... objArr) {
        if (i2 != 10010) {
            switch (i2) {
                case getCoreType /* 10020 */:
                    return Integer.valueOf(e());
                case setCoreType /* 10021 */:
                    f(((Integer) objArr[0]).intValue());
                    return null;
                case getGlobalSettings /* 10022 */:
                    return f();
                default:
                    return null;
            }
        }
        return Boolean.valueOf(b());
    }

    public static void j() {
        IGlobalSettings f2;
        boolean booleanValue = C7247a.c("apollo").booleanValue();
        Long valueOf = Long.valueOf((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
        if (!booleanValue) {
            a(valueOf);
        } else {
            b(valueOf);
        }
        if (!b() || (f2 = f()) == null) {
            return;
        }
        if (!booleanValue) {
            Log.i("ucmedia.SDKFactory", "sdk cd forbid apollo");
            f2.setStringValue("sdk_apollo_forbid", "1");
            return;
        }
        f2.setStringValue("sdk_apollo_forbid", "0");
    }

    public static void k() {
        bt btVar = af.c;
        if (btVar == null || btVar.coreImplModule == null) {
            return;
        }
        UCSettings.setGlobalStringValue(SettingKeys.CoreDexInfo, "dexPath:" + ((String) btVar.coreImplModule.first) + "&odexPath:" + ((String) btVar.coreImplModule.second) + "&soDirPath:" + btVar.soDirPath);
    }

    public static boolean l() {
        if (e() == 2) {
            return true;
        }
        return CoreFactory.f();
    }

    public static void m() {
        int i2 = x;
        if (i2 == 2) {
            ReflectionUtil.invokeNoThrow("android.webkit.WebView", "enableSlowWholeDocumentDraw");
        } else if (i2 == 3) {
            ReflectionUtil.invokeNoThrow("com.uc.webkit.WebView", "enableSlowWholeDocumentDraw");
        }
    }

    public static IPreloadManager n() {
        Context context;
        IPreloadManager iPreloadManager = z;
        if (iPreloadManager != null && (context = e) != null) {
            iPreloadManager.setContext(context);
        }
        return z;
    }

    public static void o() {
        IGlobalSettings f2 = f();
        if (f2 != null) {
            f2.setStringValue("apollo_str", "ap_cache3=0&ap_cache=0&ap_cache_preload=0&ap_enable_preload2=0&ap_enable_cache2=0");
        }
    }

    static /* synthetic */ boolean p() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private static void r() {
        if (u && Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        Integer num = (Integer) UCCore.getGlobalOption(UCCore.OPTION_WEBVIEW_POLICY);
        int intValue = num == null ? 1 : num.intValue();
        Integer num2 = (Integer) UCCore.getGlobalOption(UCCore.OPTION_WEBVIEW_POLICY_WAIT_MILLIS);
        int intValue2 = num2 == null ? 4000 : num2.intValue();
        UCElapseTime uCElapseTime = new UCElapseTime();
        while (true) {
            if (UCSetupTask.isSetupThread() && !b()) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder();
                for (int i2 = 3; i2 < stackTrace.length && i2 < 8; i2++) {
                    sb.append(stackTrace[i2].toString().replace("com.uc.webview.export.", "").replaceAll("\\(.+\\)", ""));
                    sb.append(",");
                }
                throw new UCSetupException(3013, sb.toString());
            }
            HandlerC7212b.a((Runnable) null);
            if (j) {
                UCSetupTask.resumeAll();
            }
            if (x != 0) {
                break;
            }
            Object obj = D;
            synchronized (obj) {
                try {
                    obj.wait(200L);
                } catch (Exception e2) {
                    Log.i("SDKFactory", "getLock", e2);
                }
            }
            if (uCElapseTime.getMilis() >= intValue2 && intValue != 1) {
                break;
            }
        }
        HandlerC7212b.a((Runnable) null);
        synchronized (SDKFactory.class) {
            if (x == 0) {
                if (intValue == 2) {
                    f(2);
                } else if (intValue == 3) {
                    throw new UCSetupException(4009, String.format("Thread [%s] waitting for init is up to [%s] milis.", Thread.currentThread().getName(), String.valueOf(intValue2)));
                }
            }
            Log.d("SDKFactory", String.format(Locale.CHINA, "waitForInit(sWebViewPolicy=%d, sMaxWaitMillis=%d)=%d", Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(x)));
        }
    }

    public static Boolean a() {
        return Boolean.valueOf(k);
    }

    public static boolean b() {
        return x != 0;
    }

    public static String c() {
        if (b()) {
            return e() == 2 ? "System WebView" : g;
        }
        throw new RuntimeException("UC WebView Sdk not inited.");
    }

    public static IWebView a(Context context, AttributeSet attributeSet, WebView webView, boolean z2, int[] iArr) {
        if (B) {
            B = false;
            C7302b.a(540);
        }
        if (e == null) {
            e = context.getApplicationContext();
        }
        if (f) {
            h();
        }
        ValueCallback<Pair<String, HashMap<String, String>>> valueCallback = b;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(new Pair<>(IWaStat.WV_NEW_BEFORE, null));
        }
        IWebView createWebView = A.createWebView(context, attributeSet, webView, z2, iArr);
        UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
        if (totalLoadedUCM != null) {
            try {
                if (totalLoadedUCM.coreType != 2 && !F) {
                    F = true;
                    C7345n.a(new RunnableC7245b(context));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ValueCallback<Pair<String, HashMap<String, String>>> valueCallback2 = b;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(new Pair<>(IWaStat.WV_NEW_AFTER, null));
        }
        IWaStat.WaStat.upload();
        if (C) {
            C = false;
            C7302b.a(541);
        }
        return createWebView;
    }

    public static void b(Context context) {
        try {
            File a2 = a(context);
            if (a2.exists()) {
                a2.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static IGeolocationPermissions d(int i2) {
        h();
        if (i2 == 2) {
            return new C7217b();
        }
        return CoreFactory.c();
    }

    public static int e() {
        h();
        int i2 = x;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public static IGlobalSettings f() {
        IGlobalSettings iGlobalSettings = y;
        if (iGlobalSettings != null) {
            return iGlobalSettings;
        }
        if (e() == 2) {
            return null;
        }
        IGlobalSettings b2 = CoreFactory.b();
        y = b2;
        return b2;
    }

    public static IServiceWorkerController c(int i2) {
        h();
        if (i2 == 2) {
            return null;
        }
        return CoreFactory.getServiceWorkerController();
    }

    public static String d(Context context) {
        int i2 = x;
        if (i2 == 2) {
            try {
                return (String) ReflectionUtil.invokeNoThrow("android.webkit.WebSettings", "getDefaultUserAgent", new Class[]{Context.class}, new Object[]{context});
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (i2 == 3) {
            try {
                return (String) ReflectionUtil.invokeNoThrow("com.uc.webkit.WebSettings", "getDefaultUserAgent", new Class[]{Context.class}, new Object[]{context});
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            return "";
        }
    }

    public static void e(Context context) {
        if (e == null) {
            e = context.getApplicationContext();
        }
    }

    public static ICookieManager b(int i2) {
        h();
        if (i2 == 2) {
            return new CookieManagerAndroid();
        }
        return CoreFactory.getCookieManager();
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        if (e == null) {
            e = context.getApplicationContext();
        }
        if (E) {
            return;
        }
        C7303a.a(context);
        E = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(Context context) {
        try {
            a(context).createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static WebResourceResponse b(String str) {
        if (e() == 2) {
            return null;
        }
        return CoreFactory.b(str);
    }

    public static void c(String str) {
        Log.d("SDKFactory", "setCoreInfo " + str);
        g = str;
    }

    public static File a(Context context) {
        File a2 = C7349p.a(context, Constants.KEY_FLAGS);
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (C7349p.a(str)) {
            str = "0";
        }
        return new File(a2, UCCyclone.getSourceHash("flag_new_webview") + JSMethod.NOT_SET + str);
    }

    public static UCExtension a(Context context, IWebView iWebView, int i2) {
        if (e == null) {
            e = context.getApplicationContext();
        }
        h();
        if (i2 == 2) {
            return null;
        }
        return new UCExtension(iWebView);
    }

    public static AbstractC7213a a(int i2, Context context) {
        if (e == null) {
            e = context.getApplicationContext();
        }
        h();
        if (i2 == 2) {
            return new C7243v();
        }
        return new C7299b();
    }

    public static IWebStorage a(int i2) {
        h();
        if (i2 == 2) {
            return new C7236q();
        }
        return CoreFactory.d();
    }

    public static void a(Runnable runnable) {
        HandlerC7212b.a(runnable);
    }

    public static void a(String str) {
        if (e() != 2) {
            CoreFactory.a(str);
        }
    }

    public static String a(bt btVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Type:");
        sb.append(str);
        if (btVar.pkgName != null) {
            sb.append("\nPackage Name:");
            sb.append(btVar.pkgName);
        }
        sb.append("\nSo files path:");
        sb.append(btVar.soDirPath);
        sb.append("\nDex files:");
        if (btVar.sdkShellModule != null) {
            sb.append(StringUtils.LF);
            sb.append((String) btVar.sdkShellModule.first);
        }
        if (btVar.coreImplModule != null) {
            sb.append(StringUtils.LF);
            sb.append((String) btVar.coreImplModule.first);
        }
        return sb.toString();
    }

    static /* synthetic */ void a(Context context, boolean z2) {
        if ((v && Looper.myLooper() == Looper.getMainLooper()) || f || b() || z2) {
            return;
        }
        synchronized (SDKFactory.class) {
            if (!j) {
                SetupTask setupTask = t;
                if (setupTask != null) {
                    setupTask.start();
                } else {
                    Log.w("SDKFactory", "initIfNeeded do not setup init");
                    ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) new ba().setup("CONTEXT", (Object) context.getApplicationContext())).setup(UCCore.OPTION_HARDWARE_ACCELERATED, (Object) "true")).setup(UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED, (Object) "false")).start();
                }
            }
        }
        r();
    }
}
