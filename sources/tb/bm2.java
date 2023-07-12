package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class bm2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1698394635") ? (String) ipChange.ipc$dispatch("-1698394635", new Object[]{context, Integer.valueOf(i)}) : context.getResources().getString(i);
    }
}
