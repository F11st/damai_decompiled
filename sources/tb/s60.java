package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.ViewUtil;
import io.flutter.wpkbridge.WPKFactory;
import java.math.BigDecimal;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class s60 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final s60 INSTANCE = new s60();
    @Nullable
    private static DisplayMetrics a;

    private s60() {
    }

    public final int a(@NotNull Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557277650")) {
            return ((Integer) ipChange.ipc$dispatch("557277650", new Object[]{this, context, Float.valueOf(f)})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (context.getResources() == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int b(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557280533")) {
            return ((Integer) ipChange.ipc$dispatch("557280533", new Object[]{this, context, Integer.valueOf(i)})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (context.getResources() == null) {
            return 0;
        }
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int c(@Nullable Context context, @NotNull Map<String, ? extends Object> map, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922675110")) {
            return ((Integer) ipChange.ipc$dispatch("-1922675110", new Object[]{this, context, map, str})).intValue();
        }
        b41.i(map, "data");
        b41.i(str, "paramName");
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), Constants.DIMEN);
        }
        return 0;
    }

    @Nullable
    public final DisplayMetrics d(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046253554")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-2046253554", new Object[]{this, context});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (a == null) {
            a = context.getResources().getDisplayMetrics();
        }
        return a;
    }

    public final int e(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277589199")) {
            return ((Integer) ipChange.ipc$dispatch("-277589199", new Object[]{this, context})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return (e32.e(context) - a(context, 25.0f)) / ye2.INSTANCE.d(context, 2);
    }

    @NotNull
    public final DisplayMetrics f(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-357217241")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-357217241", new Object[]{this, context});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((Activity) context).getWindowManager().getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }

    public final double g(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896001047")) {
            return ((Double) ipChange.ipc$dispatch("-1896001047", new Object[]{this, context})).doubleValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            if (Build.VERSION.SDK_INT > 16) {
                Object systemService = context.getSystemService(C9796v.ATTACH_MODE_WINDOW);
                b41.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                Point point = new Point();
                Display.getRealSize(((WindowManager) systemService).getDefaultDisplay(), point);
                return new BigDecimal(Math.pow(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) / context.getResources().getDisplayMetrics().ydpi, 2.0d)).setScale(1, 4).doubleValue();
            }
            return 0.0d;
        } catch (Exception e) {
            LogUtil.d("DensityUtil", e.getMessage());
            return 0.0d;
        }
    }

    public final int h(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262603395")) {
            return ((Integer) ipChange.ipc$dispatch("262603395", new Object[]{this, context, Integer.valueOf(i)})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return (int) ((i / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
