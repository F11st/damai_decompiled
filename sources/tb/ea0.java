package tb;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.taobao.windvane.config.GlobalConfig;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ea0 {
    public static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(float f) {
        try {
            return TypedValue.applyDimension(1, f, e());
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    public static int c(float f) {
        try {
            return (int) TypedValue.applyDimension(1, f, e());
        } catch (Exception e) {
            e.printStackTrace();
            return (int) f;
        }
    }

    public static Application d() {
        return GlobalConfig.context;
    }

    @Nullable
    public static DisplayMetrics e() {
        try {
            return d().getResources().getDisplayMetrics();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int f() {
        try {
            Display defaultDisplay = ((WindowManager) d().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
            int i = Build.VERSION.SDK_INT;
            if (i < 13) {
                return defaultDisplay.getWidth();
            }
            if (i < 17) {
                Point point = new Point();
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
                return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            }
            Point point2 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point2);
            return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int g() {
        Application d = d();
        int identifier = d.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return d.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
