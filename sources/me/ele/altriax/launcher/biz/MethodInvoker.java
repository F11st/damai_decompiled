package me.ele.altriax.launcher.biz;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class MethodInvoker {
    private static final String METHOD_REFLECT_INIT = "init";
    private static final String TAG = "MethodInvoker";

    public static void safeInvoke(String str, Application application, HashMap hashMap) {
        try {
            Object newInstance = Class.forName(str).newInstance();
            Method declaredMethod = newInstance.getClass().getDeclaredMethod("init", Application.class, HashMap.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(newInstance, application, hashMap);
        } catch (Exception e) {
            Log.e(TAG, "failed to invoke: " + str, e);
        }
    }

    public static void startBundleSync(String str) {
        TextUtils.isEmpty(str);
    }

    public static void safeInvoke(String str, Context context) {
        try {
            Object newInstance = Class.forName(str).newInstance();
            Method declaredMethod = newInstance.getClass().getDeclaredMethod("init", Context.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(newInstance, context);
        } catch (Exception e) {
            Log.e(TAG, "failed to invoke: " + str, e);
        }
    }
}
