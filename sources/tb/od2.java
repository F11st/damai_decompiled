package tb;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jy2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class od2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static jy2.b a(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "871117871") ? (jy2.b) ipChange.ipc$dispatch("871117871", new Object[]{view}) : new jy2.b(view);
    }
}
