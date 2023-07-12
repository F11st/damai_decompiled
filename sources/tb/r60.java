package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class r60 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static float a(@NonNull Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1646747011") ? ((Float) ipChange.ipc$dispatch("-1646747011", new Object[]{context, Float.valueOf(f)})).floatValue() : f * context.getResources().getDisplayMetrics().density;
    }
}
