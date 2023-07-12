package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class es0 {
    private static boolean a;
    private static float b;
    private static float c;
    @NotNull
    public static final es0 INSTANCE = new es0();
    @NotNull
    private static final DisplayMetrics d = new DisplayMetrics();

    private es0() {
    }

    private final void c(Context context) {
        DisplayMetrics displayMetrics;
        if (a) {
            return;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            b = activity.getWindow().getDecorView().getMeasuredWidth();
            float measuredHeight = activity.getWindow().getDecorView().getMeasuredHeight();
            c = measuredHeight;
            if (!(b == 0.0f)) {
                if (!(measuredHeight == 0.0f)) {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode()) {
                b = (float) Math.round((activity.getResources().getConfiguration().screenWidthDp * activity.getResources().getDisplayMetrics().density) + 0.5d);
                float round = (float) Math.round((activity.getResources().getConfiguration().screenHeightDp * activity.getResources().getDisplayMetrics().density) + 0.5d);
                c = round;
                if (!(b == 0.0f)) {
                    if (!(round == 0.0f)) {
                        return;
                    }
                }
            }
            Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), d);
            b = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            c = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            return;
        }
        Object systemService = GXTemplateEngine.Companion.a().g().getSystemService(v.ATTACH_MODE_WINDOW);
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
            if (defaultDisplay != null) {
                Display.getMetrics(defaultDisplay, d);
            }
            DisplayMetrics displayMetrics2 = d;
            b = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2);
            c = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2);
        }
    }

    public final float a(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        c(context);
        return c;
    }

    public final float b(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        c(context);
        return b;
    }
}
