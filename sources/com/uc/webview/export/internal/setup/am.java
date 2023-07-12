package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.huawei.hms.api.ConnectionResult;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.ui.component.AbstractEditComponent;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.uc.CoreClassPreLoader;
import com.uc.webview.export.internal.uc.startup.C7301a;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.uc.wa.C7303a;
import com.uc.webview.export.internal.utility.C7327d;
import com.uc.webview.export.internal.utility.C7336i;
import com.uc.webview.export.internal.utility.C7343m;
import com.uc.webview.export.internal.utility.C7345n;
import com.uc.webview.export.internal.utility.C7349p;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.usercenter.passport.result.VerifyCookieResult;
import com.youku.vpm.track.OnePlayTrack;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class am {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static final AtomicBoolean d = new AtomicBoolean(false);
    private static final AtomicBoolean e = new AtomicBoolean(false);
    private static final AtomicBoolean f = new AtomicBoolean(false);
    private static final AtomicBoolean g = new AtomicBoolean(false);
    private static final AtomicBoolean h = new AtomicBoolean(false);
    private static final AtomicBoolean i = new AtomicBoolean(false);
    private static final AtomicBoolean j = new AtomicBoolean(false);
    private static final AtomicBoolean k = new AtomicBoolean(false);
    private static final AtomicBoolean l = new AtomicBoolean(false);
    private static String m = null;

    private am() {
    }

    private static void a() {
        C7345n.a(new an());
        C7257ae.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        Log.e("SetupPreprocess", "commonInitPreprocess " + context);
        C7302b.a(VerifyCookieResult.USER_ALREADY_LOGOUT);
        d(context);
        b();
        a(context, (String) null);
        a();
        C7285o.a().b();
        C7302b.a(517);
    }

    private static void d(Context context) {
        if (a.compareAndSet(false, true)) {
            a("preInitCore.preloadStart", OnePlayTrack.PlayType.BEGIN);
            Log.e("SetupPreprocess", "preloadStart " + context);
        }
    }

    private static void b() {
        Log.e("SetupPreprocess", "preloadSdkClass ");
        if (c.compareAndSet(false, true)) {
            C7302b.a(520);
            try {
                ClassLoader classLoader = am.class.getClassLoader();
                a(C7285o.class, classLoader);
                a(SDKFactory.class, classLoader);
                a(UCCyclone.class, classLoader);
                a(bt.class, classLoader);
                a(C7303a.class, classLoader);
                a(IWaStat.class, classLoader);
                a(C7349p.class, classLoader);
                C7336i.a().a("gk_preload_cl", Boolean.TRUE);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    C7302b.a(521);
                }
            }
        }
    }

    public static void a(Context context) {
        Log.e("SetupPreprocess", "asyncInitPreprocess " + context);
        if (b.compareAndSet(false, true)) {
            C7345n.a(new ao(context));
        }
    }

    private static void a(Class cls, ClassLoader classLoader) {
        try {
            Class.forName(cls.getName(), true, classLoader);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Context context, String str) {
        Log.e("SetupPreprocess", "preloadIo " + context + AVFSCacheConstants.COMMA_SEP + str);
        if (context == null) {
            return;
        }
        int i2 = 0;
        if (e.compareAndSet(false, true)) {
            C7302b.a(522);
            try {
                C7336i.a().a("gk_preload_io", Boolean.TRUE);
                C7343m.c(context);
                SDKFactory.c(context);
                IWaStat.WaStat.stat("pre_head");
                if (C7349p.f()) {
                    String[] strArr = new String[2];
                    if (!C7349p.a(str)) {
                        strArr[0] = aj.a(UCCore.getExtractDirPath(context, new File(str, "libkernelu4_7z_uc.so").getAbsolutePath()));
                        i2 = 1;
                    }
                    if (C7343m.a() != null) {
                        strArr[i2] = aj.a(C7343m.a().soDirPath);
                        i2++;
                    }
                    if (i2 > 0) {
                        aj.a(context, strArr);
                    }
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    C7302b.a(523);
                }
            }
        }
    }

    private static boolean a(ClassLoader classLoader) {
        AtomicBoolean atomicBoolean = l;
        if (atomicBoolean.get()) {
            return true;
        }
        try {
            if (classLoader != null) {
                Class.forName("com.uc.webkit.sdk.CoreFactoryImpl", true, classLoader);
            } else {
                Class.forName("com.uc.webkit.sdk.CoreFactoryImpl");
            }
            atomicBoolean.set(true);
            return true;
        } catch (ClassNotFoundException unused) {
            com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "shouldPreLaunchCoreSetupTask failed.");
            return false;
        }
    }

    private static void a(int i2, Object[] objArr) {
        String.valueOf(i2);
        C7301a.a(i2, objArr);
        String.valueOf(i2);
    }

    private static void a(String str, String str2) {
        C7327d.a(str, String.format(Locale.US, "%s at timestamp %d", str2, Long.valueOf(SystemClock.uptimeMillis())));
    }

    public static Object a(int i2, Context context, Object[] objArr) {
        try {
            d(context);
            switch (i2) {
                case 0:
                    a("preInitCore.decompress.start", AbstractEditComponent.ReturnTypes.DONE);
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    String str3 = (String) objArr[2];
                    boolean booleanValue = ((Boolean) objArr[3]).booleanValue();
                    Log.e("SetupPreprocess", "preDecompress " + context + AVFSCacheConstants.COMMA_SEP + str + AVFSCacheConstants.COMMA_SEP + str2 + AVFSCacheConstants.COMMA_SEP + str3 + AVFSCacheConstants.COMMA_SEP + booleanValue);
                    if (context != null && !C7349p.a(str) && !C7349p.a(str3) && g.compareAndSet(false, true)) {
                        C7302b.a(528);
                        new File(str3).mkdirs();
                        boolean extractWebCoreLibraryIfNeeded = UCCore.extractWebCoreLibraryIfNeeded(context, str, str2, str3, false);
                        com.uc.webview.export.internal.utility.Log.d("SetupPreprocess", "preDecompress extract: " + extractWebCoreLibraryIfNeeded);
                        C7302b.a(529);
                    }
                    a("preInitCore.decompress.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 1:
                    a(context, (String) objArr[0]);
                    a("preInitCore.loadIO", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 2:
                    b();
                    a();
                    C7285o.a().b();
                    a("preInitCore.loadSdkClass", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 3:
                    Log.e("SetupPreprocess", "preloadCoreClass");
                    if (d.compareAndSet(false, true)) {
                        if (C7349p.f()) {
                            CoreClassPreLoader.a(am.class.getClassLoader());
                        } else if (C7301a.b()) {
                            C7301a.a(9001, null);
                        }
                    }
                    a("preInitCore.loadCoreClass", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 4:
                    a("preInitCore.loadJar.start", AbstractEditComponent.ReturnTypes.DONE);
                    String str4 = (String) objArr[0];
                    Log.e("SetupPreprocess", "preloadJar " + context + ", decompressRootDir:" + str4);
                    C7302b.a(530);
                    String absolutePath = new File(str4, "core.jar").getAbsolutePath();
                    if (new File(absolutePath).exists()) {
                        File b2 = C7349p.b(C7349p.a(context, "odexs"), C7349p.e(C7349p.b(context, absolutePath)));
                        if (b2.exists()) {
                            af.a(absolutePath, b2.getAbsolutePath(), null);
                            C7301a.a();
                        }
                    }
                    C7302b.a(530);
                    a("preInitCore.loadJar.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 5:
                    a("preInitCore.loadSo.start", AbstractEditComponent.ReturnTypes.DONE);
                    String str5 = (String) objArr[0];
                    Log.e("SetupPreprocess", "preloadSo " + context + ", decompressRootDir");
                    C7301a.a();
                    ClassLoader e2 = af.e();
                    if (context != null && !C7349p.a(str5) && !f.getAndSet(true) && a(e2)) {
                        C7302b.a(524);
                        String canonicalPath = C7349p.a(new File(str5, SolidMonitor.CHECK_TYPE_LIB)).getCanonicalPath();
                        if (new File(canonicalPath, "libwebviewuc.so").exists()) {
                            boolean booleanValue2 = ((Boolean) C7301a.a(9004, new Object[]{context, canonicalPath})).booleanValue();
                            if (booleanValue2) {
                                m = str5;
                                C7336i.a().a("gk_preload_so", Boolean.TRUE);
                            }
                            com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "preloadSoInternal  libwebviewuc res:" + booleanValue2);
                        } else {
                            com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "preloadSoInternal failed libwebviewuc not exist. libDir:" + canonicalPath);
                        }
                        C7302b.a(525);
                    }
                    a("preInitCore.loadSo.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 6:
                    Log.e("SetupPreprocess", "prePartialInitWebView " + context);
                    if (h.compareAndSet(false, true) && a(af.e())) {
                        C7302b.a(535);
                        C7301a.a();
                        Log.e("SetupPreprocess", "preInitWebviewProvider " + context);
                        a((int) ConnectionResult.SIGN_IN_FAILED, new Object[]{context});
                        C7279j.a(context);
                        a(9006, (Object[]) null);
                        C7302b.a(536);
                    } else {
                        com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "prePartialInitWebView failed");
                    }
                    a("preInitCore.initWebViewProvider", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 7:
                    a("preInitCore.startCoreEngine.start", AbstractEditComponent.ReturnTypes.DONE);
                    Log.e("SetupPreprocess", "preStartCoreEngine " + context);
                    a(9009, new Object[]{context});
                    a("preInitCore.startCoreEngine.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 8:
                    Log.e("SetupPreprocess", "preInitPak " + context);
                    com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "preInitPak sDecompressRootDir:" + m);
                    if (i.compareAndSet(false, true) && a((ClassLoader) null) && m != null) {
                        C7301a.a();
                        a(9008, new Object[]{new File(m, "assets").getAbsolutePath()});
                    } else {
                        com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "preInitPak failed, sDecompressRootDir:" + m);
                    }
                    a("preInitCore.initPAK", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 9:
                    Log.e("SetupPreprocess", "preInitIcu " + context);
                    com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "preInitIcu sDecompressRootDir:" + m);
                    if (j.compareAndSet(false, true) && a((ClassLoader) null) && m != null) {
                        C7301a.a();
                        a(9007, (Object[]) null);
                    } else {
                        com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "preInitIcu failed, sDecompressRootDir:" + m);
                    }
                    a("preInitCore.initICU", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 10:
                    Log.e("SetupPreprocess", "initPreprocess " + context);
                    if (b.compareAndSet(false, true)) {
                        C7302b.a(518);
                        c(context);
                        C7336i.a().a("gk_init_pre", Boolean.TRUE);
                        C7302b.a(519);
                    }
                    a("preInitCore.initPreprocess", AbstractEditComponent.ReturnTypes.DONE);
                    break;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
