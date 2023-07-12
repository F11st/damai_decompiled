package tb;

import android.app.Application;
import androidx.annotation.UiThread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class f0 {
    private static Application a;

    @UiThread
    public static synchronized Application a() {
        Application application;
        synchronized (f0.class) {
            if (a == null) {
                a = b();
            }
            application = a;
        }
        return application;
    }

    @UiThread
    private static Application b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception unused) {
            return null;
        }
    }
}
