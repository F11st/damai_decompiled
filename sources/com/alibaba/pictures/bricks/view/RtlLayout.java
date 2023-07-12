package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RtlLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int SUPPORT_CHILD_COUNT = 2;

    public RtlLayout(Context context) {
        this(context, null);
    }

    private int getChildUsedHeight(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465261556")) {
            return ((Integer) ipChange.ipc$dispatch("-465261556", new Object[]{this, view})).intValue();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getChildUsedWidth(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643982561")) {
            return ((Integer) ipChange.ipc$dispatch("1643982561", new Object[]{this, view})).intValue();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return view.getMeasuredWidth() + marginLayoutParams.rightMargin + marginLayoutParams.leftMargin;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        int i5 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1221171002")) {
            ipChange.ipc$dispatch("1221171002", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else if (getChildCount() >= 2) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            while (i5 < 2) {
                View childAt = getChildAt(i5);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = paddingLeft + ((ViewGroup.MarginLayoutParams) childAt.getLayoutParams()).leftMargin;
                int i7 = i6 + measuredWidth;
                childAt.layout(i6, paddingTop, i7, measuredHeight + paddingTop);
                i5++;
                paddingLeft = i7;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223509768")) {
            ipChange.ipc$dispatch("1223509768", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (getChildCount() == 2) {
            View childAt = getChildAt(0);
            View childAt2 = getChildAt(1);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
            measureChild(childAt2, i, i2);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(Math.max(0, ((((size - getPaddingLeft()) - getPaddingRight()) - childAt2.getMeasuredWidth()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), Integer.MIN_VALUE), i2);
            if (mode2 != 1073741824) {
                size2 = getPaddingBottom() + getPaddingTop() + Math.max(getChildUsedHeight(childAt), getChildUsedHeight(childAt2));
            }
            if (mode != 1073741824) {
                int childUsedWidth = getChildUsedWidth(childAt) + 0 + getChildUsedWidth(childAt2);
                size = mode == 0 ? childUsedWidth : Math.min(size, childUsedWidth);
            }
            setMeasuredDimension(size, size2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public RtlLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RtlLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
