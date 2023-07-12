package com.uc.webview.export.internal.uc;

import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CoreClassPreLoader {
    @Reflection
    protected static LazyClass Lazy;
    @Reflection
    protected static Runnable sLazyUpdateCallback;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class LazyClass {
        final ReflectionUtil.BindingMethod<Boolean> a;
        ReflectionUtil.BindingMethod<Boolean> b;
        @Reflection
        public final Class<?> sCoreClassLoaderImpl;

        public LazyClass(ClassLoader classLoader) {
            this.b = null;
            Class<?> a = a(classLoader);
            this.sCoreClassLoaderImpl = a;
            this.a = new ReflectionUtil.BindingMethod<>(a, "loadCoreClass", new Class[]{ClassLoader.class});
            try {
                this.b = new ReflectionUtil.BindingMethod<>(a, "loadCoreClassLevel", new Class[]{ClassLoader.class, Integer.class});
            } catch (Throwable unused) {
            }
        }

        private static Class<?> a(ClassLoader classLoader) {
            try {
                return Class.forName("com.uc.webkit.sdk.CoreClassPreLoaderImpl", true, classLoader);
            } catch (ClassNotFoundException e) {
                throw new UCSetupException(4028, e);
            }
        }
    }

    public static boolean a(ClassLoader classLoader) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class.forName("com.uc.webkit.sdk.CoreFactoryImpl", true, classLoader);
            Class.forName("com.uc.webkit.sdk.CoreClassPreLoaderImpl", true, classLoader);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        Log.i("CoreClassPreLoader", "loadCoreClassUrgent result:" + z + ", cost:" + (System.currentTimeMillis() - currentTimeMillis));
        updateLazy(classLoader);
        ReflectionUtil.BindingMethod<Boolean> bindingMethod = Lazy.b;
        return bindingMethod != null ? z & bindingMethod.invoke(new Object[]{classLoader, 3}).booleanValue() : z;
    }

    @Reflection
    public static boolean loadCoreClass(ClassLoader classLoader) {
        return Lazy.a.invoke(new Object[]{classLoader}).booleanValue();
    }

    @Reflection
    public static synchronized void updateLazy(ClassLoader classLoader) {
        synchronized (CoreClassPreLoader.class) {
            if (Lazy == null) {
                Lazy = new LazyClass(classLoader);
                Runnable runnable = sLazyUpdateCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
}
