package cn.damai.uikit.irecycler;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public boolean a(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1038437161") ? ((Boolean) ipChange.ipc$dispatch("-1038437161", new Object[]{this, recyclerView})).booleanValue() : recyclerView.getLayoutManager().getItemCount() - 1 == recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
    }

    public abstract void b(RecyclerView recyclerView);

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1517128516")) {
            ipChange.ipc$dispatch("1517128516", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        if ((recyclerView.getLayoutManager().getChildCount() > 0 && i == 0 && a(recyclerView)) ? false : false) {
            b(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486294949")) {
            ipChange.ipc$dispatch("-1486294949", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }
}
