package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ew2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105971004")) {
            ipChange.ipc$dispatch("-1105971004", new Object[]{str, str2});
            return;
        }
        Log.w("PullToRefresh", "You're using the deprecated " + str + " attr, please switch over to " + str2);
    }
}
