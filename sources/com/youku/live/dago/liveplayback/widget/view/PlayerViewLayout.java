package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerViewLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_ROW_COUNT = 3;
    private int mRowCount;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public LayoutParams(int i) {
            super(-1, -1);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum Mode {
        GRID,
        MASTER_SLAVE
    }

    public PlayerViewLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-385926670")) {
            ipChange.ipc$dispatch("-385926670", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i3 = childCount % this.mRowCount;
        while (childCount > 0) {
            int i4 = this.mRowCount;
            if (childCount < i4) {
                int i5 = size / i3;
            } else {
                int i6 = size / i4;
            }
            childCount -= i4;
        }
    }

    public void setMode(Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19393776")) {
            ipChange.ipc$dispatch("-19393776", new Object[]{this, mode});
        }
    }

    public PlayerViewLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerViewLayout(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRowCount = 3;
    }
}
