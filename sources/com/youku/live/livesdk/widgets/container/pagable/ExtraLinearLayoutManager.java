package com.youku.live.livesdk.widgets.container.pagable;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ExtraLinearLayoutManager extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_ITEM_EXTRA_SPACE = 100;
    private int mExtraLayoutSpace;

    public ExtraLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.mExtraLayoutSpace = 100;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int getExtraLayoutSpace(RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2077910947")) {
            return ((Integer) ipChange.ipc$dispatch("-2077910947", new Object[]{this, state})).intValue();
        }
        super.getExtraLayoutSpace(state);
        return this.mExtraLayoutSpace;
    }

    public void setExtraLayoutSpace(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927164113")) {
            ipChange.ipc$dispatch("-1927164113", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mExtraLayoutSpace = i;
        }
    }
}
