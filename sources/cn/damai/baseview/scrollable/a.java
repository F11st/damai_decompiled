package cn.damai.baseview.scrollable;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-249932899") ? ((Integer) ipChange.ipc$dispatch("-249932899", new Object[]{context, Integer.valueOf(i)})).intValue() : (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
