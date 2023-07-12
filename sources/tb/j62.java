package tb;

import android.app.Activity;
import android.provider.Settings;
import android.view.WindowManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class j62 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static float a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041932579")) {
            return ((Float) ipChange.ipc$dispatch("1041932579", new Object[]{activity})).floatValue();
        }
        float f = 0.0f;
        try {
            f = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException unused) {
        }
        return f / 255.0f;
    }

    public static void b(Activity activity, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-993850631")) {
            ipChange.ipc$dispatch("-993850631", new Object[]{activity, Float.valueOf(f)});
            return;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = f;
        activity.getWindow().setAttributes(attributes);
    }
}
