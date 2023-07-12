package me.ele.altriax.launcher.biz.workx;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class SystemAlarmSchedulerDelegate implements InvocationHandler {
    private static final String TAG = "SchedulerDelegate";
    private final Object real;

    SystemAlarmSchedulerDelegate(Object obj) {
        this.real = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!"schedule".equals(method.getName()) && !"cancel".equals(method.getName())) {
            return method.invoke(this.real, objArr);
        }
        try {
            method.invoke(this.real, objArr);
            return null;
        } catch (Throwable th) {
            Log.e(TAG, "invoke error: " + method.getName(), th);
            return null;
        }
    }
}
