package com.taobao.android.sopatch;

import androidx.annotation.Keep;
import com.taobao.android.sopatch.common.Constants;
import com.taobao.android.sopatch.exception.VerifyErrorException;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.util.HashMap;
import java.util.Map;
import tb.ee2;
import tb.ie2;
import tb.je2;
import tb.jj2;
import tb.le2;
import tb.ob1;
import tb.oe2;

/* compiled from: Taobao */
@Keep
/* loaded from: classes12.dex */
public final class SoLoader {
    private static final String TAG = "SoLoader";
    private static final Map<String, C6632a> loadedObjectMap = new HashMap();
    private static final Object DEFAULT_LOADED_OBJECT = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sopatch.SoLoader$a */
    /* loaded from: classes12.dex */
    public static class C6632a {
        private volatile Object a;

        private C6632a() {
        }
    }

    private static String getFullLibName(String str) {
        int i;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1 && str.length() > (i = lastIndexOf + 1)) {
            return str.substring(i);
        }
        if (str.endsWith(".so")) {
            return str;
        }
        return SolidMonitor.CHECK_TYPE_LIB + str + ".so";
    }

    private static C6632a getLoadedObject(String str) {
        C6632a c6632a;
        Map<String, C6632a> map = loadedObjectMap;
        synchronized (map) {
            c6632a = map.get(str);
            if (c6632a == null) {
                c6632a = new C6632a();
                map.put(str, c6632a);
            }
        }
        return c6632a;
    }

    private static void innerLoad(String str, Runnable runnable) {
        String fullLibName = getFullLibName(str);
        C6632a loadedObject = getLoadedObject(str);
        ie2 ie2Var = null;
        if (loadedObject.a == null) {
            synchronized (loadedObjectMap) {
                if (loadedObject.a == null) {
                    ie2Var = je2.c().b(fullLibName);
                    loadedObject.a = matchBrothersPatchMode(ie2Var, fullLibName);
                }
            }
        }
        if (ie2Var != null) {
            Object obj = loadedObject.a;
            Object obj2 = DEFAULT_LOADED_OBJECT;
            if (obj != obj2) {
                ee2 b = ie2Var.b(fullLibName);
                if (b != null) {
                    try {
                        loadSoPatch(b);
                        le2.a(true, ie2Var.d(), Constants.Stage.EFFECTIVE, 0L, 0, ie2Var.toString(), ie2Var.e());
                        ob1.b(TAG, "patch load success", b.toString());
                        return;
                    } catch (Throwable th) {
                        le2.a(false, ie2Var.d(), Constants.Stage.EFFECTIVE, 0L, -1, ie2Var.toString(), ie2Var.e());
                        ob1.b(TAG, "patch load fail", th.getMessage());
                        runnable.run();
                        loadedObject.a = DEFAULT_LOADED_OBJECT;
                        return;
                    }
                }
                runnable.run();
                loadedObject.a = obj2;
                return;
            }
        }
        runnable.run();
    }

    @Keep
    public static void load(final String str) {
        if (!jj2.a(Constants.NEED_SO_PATCH, false)) {
            System.load(str);
            ob1.b(TAG, "before so patch start", str);
            return;
        }
        innerLoad(str, new Runnable() { // from class: com.taobao.android.sopatch.SoLoader.1
            @Override // java.lang.Runnable
            public void run() {
                System.load(str);
                ob1.a(SoLoader.TAG, "system load success", str);
            }
        });
    }

    @Keep
    public static void loadLibrary(final String str) {
        if (!jj2.a(Constants.NEED_SO_PATCH, false)) {
            System.loadLibrary(str);
            ob1.b(TAG, "before so patch start", str);
            return;
        }
        innerLoad(str, new Runnable() { // from class: com.taobao.android.sopatch.SoLoader.2
            @Override // java.lang.Runnable
            public void run() {
                System.loadLibrary(str);
                ob1.a(SoLoader.TAG, "system load success", str);
            }
        });
    }

    private static void loadSoPatch(ee2 ee2Var) throws VerifyErrorException, UnsatisfiedLinkError {
        if (jj2.a("forceVerify", false) && !oe2.d(ee2Var)) {
            throw new VerifyErrorException();
        }
        System.load(ee2Var.c());
    }

    private static Object matchBrothersPatchMode(ie2 ie2Var, String str) {
        C6632a c6632a;
        if (ie2Var == null) {
            return DEFAULT_LOADED_OBJECT;
        }
        for (String str2 : ie2Var.c().keySet()) {
            if (!str.equals(str2) && (c6632a = loadedObjectMap.get(str2)) != null && c6632a.a != ie2Var) {
                return ((c6632a.a instanceof ie2) && ((ie2) c6632a.a).b(str) == null) ? ie2Var : c6632a.a;
            }
        }
        return ie2Var;
    }
}
