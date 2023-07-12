package com.uc.webview.export.internal.utility;

import android.content.Context;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.internal.setup.UCSetupException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.h */
/* loaded from: classes11.dex */
public final class C7334h {
    private static ConcurrentHashMap<ClassLoader, C7335a> a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.h$a */
    /* loaded from: classes11.dex */
    public static class C7335a {
        public String a;
        public String b;
        public String c;
        public String[][] d;
        public String[][] e;

        private C7335a() {
        }

        public final String toString() {
            return "coreVersion:" + this.a + ", ucmVersion:" + this.b + ", supportSdkMinVersion:" + this.c;
        }
    }

    public static String a(ClassLoader classLoader) {
        C7335a c7335a = a.get(classLoader);
        if (c7335a != null) {
            return c7335a.a;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build", "CORE_VERSION");
    }

    public static String b(ClassLoader classLoader) {
        C7335a c7335a = a.get(classLoader);
        if (c7335a != null) {
            return c7335a.b;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build$Version", "NAME");
    }

    public static String c(ClassLoader classLoader) {
        C7335a c7335a = a.get(classLoader);
        if (c7335a != null) {
            return c7335a.c;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build$Version", "SUPPORT_SDK_MIN");
    }

    public static String[][] d(ClassLoader classLoader) {
        C7335a c7335a = a.get(classLoader);
        if (c7335a != null) {
            return c7335a.d;
        }
        return (String[][]) a(classLoader, "com.uc.webview.browser.shell.NativeLibraries", "LIBRARIES");
    }

    public static String[][] e(ClassLoader classLoader) {
        C7335a c7335a = a.get(classLoader);
        if (c7335a != null) {
            return c7335a.e;
        }
        return (String[][]) a(classLoader, "com.uc.webview.browser.shell.PakAssets", "ASSETS");
    }

    public static String[] f(ClassLoader classLoader) {
        String[][] d;
        try {
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : d(classLoader)) {
                if (strArr != null && strArr[0] != null) {
                    arrayList.add(strArr[0]);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (Exception e) {
            Log.d("SdkShellUtils", "getCoreSoList failed", e);
            return null;
        }
    }

    public static void a(UCMPackageInfo uCMPackageInfo, Context context, ClassLoader classLoader, ConcurrentHashMap<String, Object> concurrentHashMap) {
        Method method;
        Object[] objArr;
        int indexOf;
        try {
            Class<?> cls = Class.forName("com.uc.webview.browser.shell.SdkAuthentication", true, classLoader);
            int i = 0;
            try {
                try {
                    method = cls.getMethod("tryLoadUCCore", Context.class, UCMPackageInfo.class, HashMap.class);
                    HashMap hashMap = new HashMap(concurrentHashMap.size());
                    hashMap.putAll(concurrentHashMap);
                    objArr = new Object[]{context, uCMPackageInfo, hashMap};
                } catch (NoSuchMethodException unused) {
                    method = cls.getMethod("tryLoadUCCore", Context.class, UCMPackageInfo.class);
                    objArr = new Object[]{context, uCMPackageInfo};
                }
                try {
                    if (!C7349p.b((Boolean) ReflectionUtil.invoke((Object) null, cls, method, objArr))) {
                        return;
                    }
                    throw new UCSetupException(4017, "tryLoadUCCore return false.");
                } catch (UCKnownException e) {
                    throw e;
                } catch (Throwable th) {
                    String message = th.getMessage();
                    if (message != null && (indexOf = message.indexOf("9")) == 0) {
                        try {
                            i = C7349p.c(message.substring(indexOf, indexOf + 4));
                        } catch (Exception unused2) {
                        }
                    }
                    if (i >= 9000) {
                        throw new UCSetupException(i, th);
                    }
                    throw new UCSetupException(4016, th);
                }
            } catch (NoSuchMethodException e2) {
                throw new UCSetupException(4015, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new UCSetupException(4014, e3);
        }
    }

    private static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            Field declaredField = Class.forName(str, true, classLoader).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            Log.d("SdkShellUtils", "getValue failed, loader:" + classLoader, e);
            return null;
        }
    }
}
