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
/* loaded from: classes11.dex */
public final class h {
    private static ConcurrentHashMap<ClassLoader, a> a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String[][] d;
        public String[][] e;

        private a() {
        }

        public final String toString() {
            return "coreVersion:" + this.a + ", ucmVersion:" + this.b + ", supportSdkMinVersion:" + this.c;
        }
    }

    public static String a(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.a;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build", "CORE_VERSION");
    }

    public static String b(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.b;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build$Version", "NAME");
    }

    public static String c(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.c;
        }
        return (String) a(classLoader, "com.uc.webview.browser.shell.Build$Version", "SUPPORT_SDK_MIN");
    }

    public static String[][] d(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.d;
        }
        return (String[][]) a(classLoader, "com.uc.webview.browser.shell.NativeLibraries", "LIBRARIES");
    }

    public static String[][] e(ClassLoader classLoader) {
        a aVar = a.get(classLoader);
        if (aVar != null) {
            return aVar.e;
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
                    if (!p.b((Boolean) ReflectionUtil.invoke((Object) null, cls, method, objArr))) {
                        return;
                    }
                    throw new UCSetupException(4017, "tryLoadUCCore return false.");
                } catch (UCKnownException e) {
                    throw e;
                } catch (Throwable th) {
                    String message = th.getMessage();
                    if (message != null && (indexOf = message.indexOf("9")) == 0) {
                        try {
                            i = p.c(message.substring(indexOf, indexOf + 4));
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
