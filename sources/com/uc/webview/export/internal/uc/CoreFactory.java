package com.uc.webview.export.internal.uc;

import android.content.Context;
import android.util.AttributeSet;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.extension.ARManager;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.ICookieManager;
import com.uc.webview.export.internal.interfaces.IGeolocationPermissions;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IMimeTypeMap;
import com.uc.webview.export.internal.interfaces.IServiceWorkerController;
import com.uc.webview.export.internal.interfaces.IWebStorage;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CoreFactory {
    protected static C7297a a;
    protected static Runnable b;

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.uc.CoreFactory$a */
    /* loaded from: classes11.dex */
    public static class C7297a {
        public final Class<?> a;
        final ReflectionUtil.BindingMethod<IGlobalSettings> b;
        final ReflectionUtil.BindingMethod<ICookieManager> c;
        final ReflectionUtil.BindingMethod<IServiceWorkerController> d;
        final ReflectionUtil.BindingMethod<UCMobileWebKit> e;
        final ReflectionUtil.BindingMethod<IGeolocationPermissions> f;
        final ReflectionUtil.BindingMethod<IWebStorage> g;
        final ReflectionUtil.BindingMethod<IMimeTypeMap> h;
        final ReflectionUtil.BindingMethod<IWebView> i;
        final ReflectionUtil.BindingMethod<IWebView> j;
        final ReflectionUtil.BindingMethod<UCMobileWebKit> k;
        final ReflectionUtil.BindingMethod<Boolean> l;
        final ReflectionUtil.BindingMethod<Integer> m;
        final ReflectionUtil.BindingMethod<Object> n;
        final ReflectionUtil.BindingMethod<Object> o;
        final ReflectionUtil.BindingMethod<WebResourceResponse> p;
        final ReflectionUtil.BindingMethod<ARManager> q;

        public C7297a() {
            ReflectionUtil.BindingMethod<IWebView> bindingMethod;
            Class<?> a = a();
            this.a = a;
            this.b = new ReflectionUtil.BindingMethod<>(a, "getGlobalSettings");
            this.c = new ReflectionUtil.BindingMethod<>(a, "getCookieManager");
            this.d = new ReflectionUtil.BindingMethod<>(a, "getServiceWorkerController");
            this.e = new ReflectionUtil.BindingMethod<>(a, "getUCMobileWebKit");
            this.f = new ReflectionUtil.BindingMethod<>(a, "getGeolocationPermissions");
            this.g = new ReflectionUtil.BindingMethod<>(a, "getWebStorage");
            this.h = new ReflectionUtil.BindingMethod<>(a, "getMimeTypeMap");
            this.i = new ReflectionUtil.BindingMethod<>(a, "createWebView", new Class[]{Context.class});
            ReflectionUtil.BindingMethod<ARManager> bindingMethod2 = null;
            try {
                bindingMethod = new ReflectionUtil.BindingMethod<>(a, "createWebView", new Class[]{Context.class, AttributeSet.class});
            } catch (Throwable unused) {
                bindingMethod = null;
            }
            this.j = bindingMethod;
            Class<?> cls = this.a;
            Class cls2 = Boolean.TYPE;
            this.k = new ReflectionUtil.BindingMethod<>(cls, "initUCMobileWebKit", new Class[]{Context.class, cls2, cls2});
            this.m = new ReflectionUtil.BindingMethod<>(this.a, "getCoreType");
            this.n = new ReflectionUtil.BindingMethod<>(this.a, "initSDK", new Class[]{Context.class});
            this.o = new ReflectionUtil.BindingMethod<>(this.a, "handlePerformanceTests", new Class[]{String.class});
            this.p = new ReflectionUtil.BindingMethod<>(this.a, "getResponseByUrl", new Class[]{String.class});
            try {
                bindingMethod2 = new ReflectionUtil.BindingMethod<>(this.a, "getARManager");
            } catch (Throwable unused2) {
            }
            this.q = bindingMethod2;
            this.l = new ReflectionUtil.BindingMethod<>(this.a, "initUCMobileWebkitCoreSoEnv", new Class[]{Context.class, HashMap.class});
        }

        private static Class<?> a() {
            try {
                return Class.forName("com.uc.webkit.sdk.CoreFactoryImpl", true, SDKFactory.c);
            } catch (ClassNotFoundException e) {
                throw new UCSetupException((int) GlobalErrorCode.ERROR_CTID_APP_ERROR, e);
            }
        }
    }

    public static void a() {
        h();
    }

    public static IGlobalSettings b() {
        return h().b.getInstance();
    }

    public static IGeolocationPermissions c() {
        return h().f.getInstance();
    }

    @Reflection
    public static IWebView createWebView(Context context, AttributeSet attributeSet) {
        return h().j == null ? h().i.invoke(new Object[]{context}) : h().j.invoke(new Object[]{context, attributeSet});
    }

    public static IWebStorage d() {
        return h().g.getInstance();
    }

    public static IMimeTypeMap e() {
        return h().h.getInstance();
    }

    public static boolean f() {
        return h().j != null;
    }

    public static ARManager g() {
        return h().q.invoke();
    }

    @Reflection
    public static ICookieManager getCookieManager() {
        return h().c.getInstance();
    }

    @Reflection
    public static Integer getCoreType() {
        return h().m.invoke();
    }

    @Reflection
    public static IServiceWorkerController getServiceWorkerController() {
        return h().d.getInstance();
    }

    @Reflection
    public static UCMobileWebKit getUCMobileWebKit() {
        return h().e.getInstance();
    }

    private static synchronized C7297a h() {
        C7297a c7297a;
        synchronized (CoreFactory.class) {
            if (a == null) {
                C7302b.a(145);
                a = new C7297a();
                Runnable runnable = b;
                if (runnable != null) {
                    runnable.run();
                }
                C7302b.a(146);
            }
            c7297a = a;
        }
        return c7297a;
    }

    @Reflection
    public static UCMobileWebKit initUCMobileWebKit(Context context, boolean z, boolean z2) {
        return h().k.invoke(new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    @Reflection
    public static boolean initUCMobileWebkitCoreSoEnv(Context context, HashMap<String, String> hashMap) throws RuntimeException {
        return h().l.invoke(new Object[]{context, hashMap}).booleanValue();
    }

    public static void a(Context context) {
        h().n.invoke(new Object[]{context});
    }

    public static WebResourceResponse b(String str) {
        return h().p.invoke(new Object[]{str});
    }

    public static void a(String str) {
        h().o.invoke(new Object[]{str});
    }
}
