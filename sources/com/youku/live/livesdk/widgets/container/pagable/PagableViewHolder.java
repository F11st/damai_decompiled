package com.youku.live.livesdk.widgets.container.pagable;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PagableViewHolder<Data> extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mPreviousVisibility;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PagableViewHolder(View view) {
        super(view);
        this.mPreviousVisibility = 4;
        if (view != null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        setIsRecyclable(true);
    }

    public int getPreviousVisibility() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1226638149") ? ((Integer) ipChange.ipc$dispatch("1226638149", new Object[]{this})).intValue() : this.mPreviousVisibility;
    }

    public void update(Data data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336318516")) {
            ipChange.ipc$dispatch("-1336318516", new Object[]{this, data});
        }
    }

    public void updateVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1258431739")) {
            ipChange.ipc$dispatch("-1258431739", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mPreviousVisibility = i;
        }
    }
}
