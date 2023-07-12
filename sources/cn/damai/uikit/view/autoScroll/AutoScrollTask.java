package cn.damai.uikit.view.autoScroll;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AutoScrollTask implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    private final WeakReference<AutoScrollRecyclerView> mReference;
    public long TIME_AUTO_POLL = 2000;
    int offset = 0;

    public AutoScrollTask(AutoScrollRecyclerView autoScrollRecyclerView) {
        this.mReference = new WeakReference<>(autoScrollRecyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668162704")) {
            ipChange.ipc$dispatch("-1668162704", new Object[]{this});
            return;
        }
        AutoScrollRecyclerView autoScrollRecyclerView = this.mReference.get();
        if (autoScrollRecyclerView == null || !autoScrollRecyclerView.isRunning()) {
            return;
        }
        if (this.offset == 0 && autoScrollRecyclerView.getChildCount() >= 2 && autoScrollRecyclerView.getChildAt(1) != null) {
            this.offset = autoScrollRecyclerView.getChildAt(1).getTop();
        }
        autoScrollRecyclerView.smoothScrollBy(0, this.offset);
        autoScrollRecyclerView.postDelayed(autoScrollRecyclerView.autoPollTask, this.TIME_AUTO_POLL);
    }
}
