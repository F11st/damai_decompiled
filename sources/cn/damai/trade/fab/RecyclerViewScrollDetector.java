package cn.damai.trade.fab;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class RecyclerViewScrollDetector extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;

    RecyclerViewScrollDetector() {
    }

    abstract void a();

    abstract void b();

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1533813280")) {
            ipChange.ipc$dispatch("-1533813280", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (Math.abs(i2) > this.a) {
            if (i2 > 0) {
                b();
            } else {
                a();
            }
        }
    }
}
