package tb;

import android.graphics.Color;
import androidx.annotation.FloatRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class qk {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "762881507") ? ((Integer) ipChange.ipc$dispatch("762881507", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : Color.argb(Math.round(f * 255.0f), (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }

    public static int b(float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-714886391") ? ((Integer) ipChange.ipc$dispatch("-714886391", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : Color.argb((int) f, (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }
}
