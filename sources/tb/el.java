package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class el {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "120026081") ? (String) ipChange.ipc$dispatch("120026081", new Object[]{Float.valueOf(f)}) : f == 0.0f ? "" : f <= 2.0f ? "不推荐" : f <= 4.0f ? "较差" : f <= 6.0f ? "一般" : f <= 8.0f ? "推荐" : "极好";
    }
}
