package tb;

import android.app.Application;
import com.taobao.android.dinamic.C6312a;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.dinamic.DinamicAppMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class o80 {
    private static Application a;

    public static synchronized Application a() {
        Application application;
        synchronized (o80.class) {
            if (a == null) {
                a = b();
            }
            application = a;
        }
        return application;
    }

    private static Application b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception unused) {
            DinamicAppMonitor a2 = C6312a.h().a();
            if (a2 != null) {
                a2.counter_commit(C6313b.TAG, "getApplication", 1.0d);
            }
            return null;
        }
    }
}
