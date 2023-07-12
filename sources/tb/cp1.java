package tb;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class cp1 {
    public static boolean a(Activity activity) {
        Exception e;
        boolean z;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        return z;
    }

    public static void b(Activity activity, int i) {
        if (i != -1 && Build.VERSION.SDK_INT == 26 && a(activity)) {
            activity.setRequestedOrientation(-1);
            return;
        }
        try {
            activity.setRequestedOrientation(i);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            if (Build.VERSION.SDK_INT == 26) {
                activity.setRequestedOrientation(-1);
            }
        }
    }
}
