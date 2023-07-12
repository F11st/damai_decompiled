package tb;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class wv2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-543475844") ? ((Integer) ipChange.ipc$dispatch("-543475844", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : Color.argb((int) f, (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }
}
