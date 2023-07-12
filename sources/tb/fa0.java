package tb;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@JvmName(name = "DisplayUtil")
/* loaded from: classes8.dex */
public final class fa0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final int a(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "69545005")) {
            return ((Integer) ipChange.ipc$dispatch("69545005", new Object[]{Float.valueOf(f)})).intValue();
        }
        try {
            return (int) TypedValue.applyDimension(1, f, b());
        } catch (Exception e) {
            e.printStackTrace();
            return (int) f;
        }
    }

    @Nullable
    public static final DisplayMetrics b() {
        Resources resources;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913309455")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("1913309455", new Object[0]);
        }
        try {
            Application a = ShareManager.INSTANCE.a();
            if (a == null || (resources = a.getResources()) == null) {
                return null;
            }
            return resources.getDisplayMetrics();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final int c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-637486801")) {
            return ((Integer) ipChange.ipc$dispatch("-637486801", new Object[0])).intValue();
        }
        try {
            Application a = ShareManager.INSTANCE.a();
            Object systemService = a != null ? a.getSystemService(C9796v.ATTACH_MODE_WINDOW) : null;
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                int i = Build.VERSION.SDK_INT;
                if (i < 13) {
                    b41.h(defaultDisplay, "display");
                    return defaultDisplay.getWidth();
                } else if (i < 17) {
                    Point point = new Point();
                    com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
                    return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                } else {
                    Point point2 = new Point();
                    com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point2);
                    return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
