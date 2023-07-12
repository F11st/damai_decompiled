package com.alibaba.pictures.bricks.view.irecycler;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public boolean a(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1321029031") ? ((Boolean) ipChange.ipc$dispatch("-1321029031", new Object[]{this, recyclerView})).booleanValue() : recyclerView.getLayoutManager().getItemCount() - 1 == recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
    }

    public abstract void b(RecyclerView recyclerView);

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "958629506")) {
            ipChange.ipc$dispatch("958629506", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        if ((recyclerView.getLayoutManager().getChildCount() > 0 && i == 0 && a(recyclerView)) ? false : false) {
            b(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498448221")) {
            ipChange.ipc$dispatch("498448221", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }
}
