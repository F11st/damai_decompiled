package com.youku.arch.v3.adapter;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012B\u001b\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0013J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004H\u0002J&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0013\u0010\u0010\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/youku/arch/v3/adapter/ContentAdapter;", "Lcom/alibaba/android/vlayout/DelegateAdapter;", "", "index", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "adapterList", "Ltb/wt2;", "addAdapterAfter", "removeAdapterAfter", "", "hasConsistItemType", "Z", "Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "getLayoutManager", "()Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "layoutManager", "<init>", "(Lcom/alibaba/android/vlayout/VirtualLayoutManager;)V", "(Lcom/alibaba/android/vlayout/VirtualLayoutManager;Z)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ContentAdapter extends DelegateAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean hasConsistItemType;

    public ContentAdapter(@Nullable VirtualLayoutManager virtualLayoutManager) {
        super(virtualLayoutManager);
    }

    private final void addAdapterAfter(int i, List<? extends VBaseAdapter<?, ?>> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-779282128")) {
            ipChange.ipc$dispatch("-779282128", new Object[]{this, Integer.valueOf(i), list});
            return;
        }
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        int itemCount = getItemCount();
        for (VBaseAdapter<?, ?> vBaseAdapter : list) {
            i2 += vBaseAdapter.dataCount;
        }
        addAdapters(i, list);
        notifyItemRangeInserted(itemCount, i2);
    }

    private final void removeAdapterAfter(int i, List<? extends VBaseAdapter<?, ?>> list) {
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-685040083")) {
            ipChange.ipc$dispatch("-685040083", new Object[]{this, Integer.valueOf(i), list});
            return;
        }
        if (i > 0) {
            int i4 = 0;
            i2 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (findAdapterPositionByIndex(i4) != -1) {
                    i2 += findAdapterByIndex(i4).getItemCount();
                }
                if (i5 >= i) {
                    break;
                }
                i4 = i5;
            }
        } else {
            i2 = 0;
        }
        for (VBaseAdapter<?, ?> vBaseAdapter : list) {
            i3 += vBaseAdapter.dataCount;
        }
        removeAdapters(list);
        notifyItemRangeRemoved(i2, i3);
    }

    @NotNull
    public final VirtualLayoutManager getLayoutManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1521172302")) {
            return (VirtualLayoutManager) ipChange.ipc$dispatch("-1521172302", new Object[]{this});
        }
        VirtualLayoutManager virtualLayoutManager = this.mLayoutManager;
        b41.h(virtualLayoutManager, "mLayoutManager");
        return virtualLayoutManager;
    }

    public final boolean hasConsistItemType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1823967600") ? ((Boolean) ipChange.ipc$dispatch("1823967600", new Object[]{this})).booleanValue() : this.hasConsistItemType;
    }

    public ContentAdapter(@Nullable VirtualLayoutManager virtualLayoutManager, boolean z) {
        super(virtualLayoutManager, z);
        this.hasConsistItemType = z;
    }
}
