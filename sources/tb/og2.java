package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes4.dex */
public class og2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Activity activity, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19232271")) {
            ipChange.ipc$dispatch("-19232271", new Object[]{activity, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (activity == null) {
        } else {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            if (z) {
                window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
                window.setStatusBarColor(0);
                window.getDecorView().setSystemUiVisibility(1280);
            } else {
                if (i != 0) {
                    window.setStatusBarColor(i);
                } else {
                    window.setStatusBarColor(Color.parseColor("#ff000000"));
                }
                window.getDecorView().setSystemUiVisibility(0);
            }
            View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
            if (childAt != null) {
                ViewCompat.setFitsSystemWindows(childAt, false);
                ViewCompat.requestApplyInsets(childAt);
            }
        }
    }
}
