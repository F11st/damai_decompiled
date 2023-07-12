package cn.damai.uikit.irecycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RefreshHeaderLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public RefreshHeaderLayout(Context context) {
        this(context, null);
    }

    private void layoutChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918677713")) {
            ipChange.ipc$dispatch("-918677713", new Object[]{this});
            return;
        }
        getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight2 = childAt.getMeasuredHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i = paddingLeft + marginLayoutParams.leftMargin;
            int i2 = (paddingTop + marginLayoutParams.topMargin) - (measuredHeight2 - measuredHeight);
            childAt.layout(i, i2, measuredWidth + i, measuredHeight2 + i2);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-154593981") ? (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-154593981", new Object[]{this}) : new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1532505527") ? (ViewGroup.LayoutParams) ipChange.ipc$dispatch("1532505527", new Object[]{this, layoutParams}) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200074715")) {
            ipChange.ipc$dispatch("-1200074715", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            layoutChildren();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413168819")) {
            ipChange.ipc$dispatch("1413168819", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (getChildCount() > 0) {
            measureChildWithMargins(getChildAt(0), i, 0, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        }
        super.onMeasure(i, i2);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1001336088") ? (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-1001336088", new Object[]{this, attributeSet}) : new LayoutParams(getContext(), attributeSet);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
