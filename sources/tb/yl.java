package tb;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class yl {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(View view, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381483716")) {
            ipChange.ipc$dispatch("381483716", new Object[]{view, runnable});
        } else if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292696288")) {
            ipChange.ipc$dispatch("292696288", new Object[]{view, runnable});
        } else {
            view.postOnAnimation(runnable);
        }
    }
}
