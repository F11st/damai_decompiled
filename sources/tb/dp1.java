package tb;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class dp1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final dp1 INSTANCE = new dp1();

    private dp1() {
    }

    private final boolean a(Activity activity) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1384426178")) {
            return ((Boolean) ipChange.ipc$dispatch("-1384426178", new Object[]{this, activity})).booleanValue();
        }
        try {
            Object obj = Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
            if (obj != null) {
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) obj);
                b41.h(obtainStyledAttributes, "activity.obtainStyledAttributes(styleableRes)");
                Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, obtainStyledAttributes);
                if (invoke != null) {
                    boolean booleanValue = ((Boolean) invoke).booleanValue();
                    try {
                        method.setAccessible(false);
                        obtainStyledAttributes.recycle();
                        return booleanValue;
                    } catch (Exception e) {
                        e = e;
                        z = booleanValue;
                        e.printStackTrace();
                        return z;
                    }
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");
        } catch (Exception e2) {
            e = e2;
        }
    }

    public final void b(@NotNull Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2120062677")) {
            ipChange.ipc$dispatch("2120062677", new Object[]{this, activity, Integer.valueOf(i)});
            return;
        }
        b41.i(activity, "activity");
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
