package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class rb1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290369406")) {
            ipChange.ipc$dispatch("-1290369406", new Object[]{str, str2});
        } else {
            Log.d(str, str2);
        }
    }

    public static void b(String str, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460852080")) {
            ipChange.ipc$dispatch("-460852080", new Object[]{str, th});
        } else {
            Log.w(str, th);
        }
    }
}
