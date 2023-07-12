package cn.damai.search.ui.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DataListener extends RecyclerView.AdapterDataObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean a = false;

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189406728")) {
            ipChange.ipc$dispatch("-189406728", new Object[]{this});
        } else {
            this.a = false;
        }
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1879401412") ? ((Boolean) ipChange.ipc$dispatch("1879401412", new Object[]{this})).booleanValue() : this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571645803")) {
            ipChange.ipc$dispatch("1571645803", new Object[]{this});
            return;
        }
        super.onChanged();
        this.a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401818113")) {
            ipChange.ipc$dispatch("1401818113", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onItemRangeChanged(i, i2);
        this.a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745937699")) {
            ipChange.ipc$dispatch("-745937699", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onItemRangeInserted(i, i2);
        this.a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "627580897")) {
            ipChange.ipc$dispatch("627580897", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        super.onItemRangeMoved(i, i2, i3);
        this.a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640680405")) {
            ipChange.ipc$dispatch("640680405", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onItemRangeRemoved(i, i2);
        this.a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879665763")) {
            ipChange.ipc$dispatch("-879665763", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
            return;
        }
        super.onItemRangeChanged(i, i2, obj);
        this.a = true;
    }
}
