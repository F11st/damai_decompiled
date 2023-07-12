package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class sa1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683418569")) {
            ipChange.ipc$dispatch("683418569", new Object[]{str, th});
        } else {
            Log.e("android-crop", str, th);
        }
    }
}
