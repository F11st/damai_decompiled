package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Window;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pg2 {
    public static void a(Activity activity, int i) {
        b(activity, i);
    }

    @TargetApi(21)
    public static void b(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
    }

    public static void c(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }
}
