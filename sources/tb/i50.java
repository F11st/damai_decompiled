package tb;

import cn.damai.baseview.scrollable.CloseUpAlgorithm;
import cn.damai.baseview.scrollable.ScrollableLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class i50 implements CloseUpAlgorithm {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.baseview.scrollable.CloseUpAlgorithm
    public int getFlingFinalY(ScrollableLayout scrollableLayout, boolean z, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86556887")) {
            return ((Integer) ipChange.ipc$dispatch("-86556887", new Object[]{this, scrollableLayout, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
        }
        if (z) {
            return 0;
        }
        return i3;
    }

    @Override // cn.damai.baseview.scrollable.CloseUpAlgorithm
    public int getIdleFinalY(ScrollableLayout scrollableLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037937060")) {
            return ((Integer) ipChange.ipc$dispatch("1037937060", new Object[]{this, scrollableLayout, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        if (i < i2 / 2) {
            return 0;
        }
        return i2;
    }
}
