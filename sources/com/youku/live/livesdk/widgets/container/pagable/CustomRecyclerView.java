package com.youku.live.livesdk.widgets.container.pagable;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CustomRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private float flingScale;

    public CustomRecyclerView(Context context) {
        super(context);
        this.flingScale = 1.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1389519619") ? ((Boolean) ipChange.ipc$dispatch("1389519619", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue() : super.fling((int) (i * this.flingScale), i2);
    }

    public void setFlingScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913168075")) {
            ipChange.ipc$dispatch("-1913168075", new Object[]{this, Float.valueOf(f)});
        } else {
            this.flingScale = f;
        }
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flingScale = 1.0f;
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flingScale = 1.0f;
    }
}
