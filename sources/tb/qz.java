package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qz {
    public static int a(Activity activity) {
        if (activity == null) {
            return -1;
        }
        WindowManager windowManager = (WindowManager) activity.getSystemService(v.ATTACH_MODE_WINDOW);
        DisplayMetrics displayMetrics = null;
        if (Build.VERSION.SDK_INT >= 17) {
            displayMetrics = new DisplayMetrics();
            Display.getRealMetrics(windowManager.getDefaultDisplay(), displayMetrics);
        }
        if (displayMetrics != null) {
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) - b(activity);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(activity.getResources().getDisplayMetrics());
    }

    public static int b(Activity activity) {
        if (e(activity)) {
            return c(activity);
        }
        return 0;
    }

    public static int c(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("navigation_bar_height", Constants.DIMEN, "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int d(Context context) {
        if (context != null) {
            try {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
            } catch (Exception e) {
                Log.e("CommonUtils", "getStatusBarHeight error", e);
                return 0;
            }
        }
        return 0;
    }

    public static boolean e(Activity activity) {
        int visibility;
        View findViewById = activity.findViewById(16908336);
        return (findViewById == null || (visibility = findViewById.getVisibility()) == 8 || visibility == 4) ? false : true;
    }
}
