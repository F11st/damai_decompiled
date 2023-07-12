package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class jg2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524245543")) {
            return ((Integer) ipChange.ipc$dispatch("1524245543", new Object[]{activity})).intValue();
        }
        int identifier = activity.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    private static boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086627672")) {
            return ((Boolean) ipChange.ipc$dispatch("-1086627672", new Object[0])).booleanValue();
        }
        if ("Xiaomi".equals(Build.getMANUFACTURER())) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "ro.miui.ui.version.name");
                if (str.contains("V")) {
                    return Integer.parseInt(str.substring(str.indexOf("V") + 1)) >= 6;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static void c(boolean z, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989164358")) {
            ipChange.ipc$dispatch("-1989164358", new Object[]{Boolean.valueOf(z), activity});
            return;
        }
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(21)
    public static void d(boolean z, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52452982")) {
            ipChange.ipc$dispatch("-52452982", new Object[]{Boolean.valueOf(z), activity});
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            View decorView = activity.getWindow().getDecorView();
            if (decorView != null) {
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            activity.getWindow().setStatusBarColor(0);
        }
        if (b()) {
            c(z, activity);
        }
    }

    @TargetApi(21)
    public static void e(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254496405")) {
            ipChange.ipc$dispatch("1254496405", new Object[]{activity});
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            View decorView = activity.getWindow().getDecorView();
            if (decorView != null) {
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
            }
            activity.getWindow().setStatusBarColor(0);
        }
        if (b()) {
            c(false, activity);
        }
    }

    public static void f(@NonNull Activity activity, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334606835")) {
            ipChange.ipc$dispatch("-334606835", new Object[]{activity, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            ng2.a(activity, z, i);
        } else if (i2 >= 19) {
            lg2.h(activity, z, i);
        }
    }
}
