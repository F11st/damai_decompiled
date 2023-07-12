package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BricksHWRatioLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mHwRatio;

    public BricksHWRatioLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627232584")) {
            ipChange.ipc$dispatch("1627232584", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.mHwRatio != -1.0f) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
                i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec((int) (size * this.mHwRatio), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setHwRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "207663415")) {
            ipChange.ipc$dispatch("207663415", new Object[]{this, Float.valueOf(f)});
        } else if (this.mHwRatio != f) {
            this.mHwRatio = f;
            requestLayout();
        }
    }

    public BricksHWRatioLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BricksHWRatioLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BricksHWRatioLayout);
        this.mHwRatio = obtainStyledAttributes.getFloat(R$styleable.BricksHWRatioLayout_bricks_h_w_layout_ratio, -1.0f);
        obtainStyledAttributes.recycle();
    }
}
