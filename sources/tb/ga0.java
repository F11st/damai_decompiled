package tb;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.vr.sdk.proto.nano.Phone;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ga0 {
    public static final String EXTERNAL_DISPLAY_RESOURCE_NAME = "display_manager_hdmi_display_name";

    public static float a(Phone.PhoneParams phoneParams) {
        if (phoneParams == null || !phoneParams.hasBottomBezelHeight()) {
            return 0.003f;
        }
        return phoneParams.getBottomBezelHeight();
    }

    public static Display b(Context context) {
        return ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
    }

    public static DisplayMetrics c(Display display) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealMetrics(display, displayMetrics);
        } else {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(display, displayMetrics);
        }
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        if (i < i2) {
            displayMetrics.widthPixels = i2;
            displayMetrics.heightPixels = i;
        }
        float f = displayMetrics.xdpi;
        displayMetrics.xdpi = displayMetrics.ydpi;
        displayMetrics.ydpi = f;
        return displayMetrics;
    }

    public static DisplayMetrics d(Display display, Phone.PhoneParams phoneParams) {
        DisplayMetrics c = c(display);
        if (phoneParams != null) {
            if (phoneParams.hasXPpi()) {
                c.xdpi = phoneParams.getXPpi();
            }
            if (phoneParams.hasYPpi()) {
                c.ydpi = phoneParams.getYPpi();
            }
        }
        return c;
    }

    public static String e(Context context) {
        Resources resources = context.getResources();
        try {
            return resources.getString(resources.getIdentifier(EXTERNAL_DISPLAY_RESOURCE_NAME, "string", "android"));
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static float f(float f) {
        return 0.0254f / f;
    }

    public static boolean g(Display display, Display display2) {
        if (display == display2) {
            return true;
        }
        if (display != null && display2 != null && display.getDisplayId() == display2.getDisplayId() && display.getFlags() == display2.getFlags() && display.isValid() == display2.isValid() && display.getName().equals(display2.getName())) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(display, displayMetrics);
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(display2, displayMetrics2);
            return displayMetrics.equals(displayMetrics2);
        }
        return false;
    }
}
