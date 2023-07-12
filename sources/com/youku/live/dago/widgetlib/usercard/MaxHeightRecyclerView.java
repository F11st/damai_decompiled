package com.youku.live.dago.widgetlib.usercard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MaxHeightRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mMaxHeight;

    public MaxHeightRecyclerView(Context context) {
        super(context);
        this.mMaxHeight = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471083854")) {
            ipChange.ipc$dispatch("-1471083854", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int i3 = this.mMaxHeight;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915696301")) {
            ipChange.ipc$dispatch("-1915696301", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mMaxHeight = i;
        }
    }

    public MaxHeightRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = 0;
    }

    public MaxHeightRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = 0;
    }
}
