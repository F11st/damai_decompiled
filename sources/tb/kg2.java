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
/* loaded from: classes4.dex */
public class kg2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170877216")) {
            return ((Integer) ipChange.ipc$dispatch("1170877216", new Object[]{activity})).intValue();
        }
        int identifier = activity.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    private static boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967358625")) {
            return ((Boolean) ipChange.ipc$dispatch("1967358625", new Object[0])).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1047420511")) {
            ipChange.ipc$dispatch("-1047420511", new Object[]{Boolean.valueOf(z), activity});
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
        if (AndroidInstantRuntime.support(ipChange, "-283440143")) {
            ipChange.ipc$dispatch("-283440143", new Object[]{Boolean.valueOf(z), activity});
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
        if (AndroidInstantRuntime.support(ipChange, "-1680833220")) {
            ipChange.ipc$dispatch("-1680833220", new Object[]{activity});
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
        if (AndroidInstantRuntime.support(ipChange, "1094725766")) {
            ipChange.ipc$dispatch("1094725766", new Object[]{activity, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            og2.a(activity, z, i);
        } else if (i2 >= 19) {
            mg2.h(activity, z, i);
        }
    }
}
