package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SimpleViewSwitcher extends ViewGroup {
    public SimpleViewSwitcher(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                childAt.layout(0, 0, i3 - i, i4 - i2);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            childAt.getMeasuredWidth();
            int measuredWidth = childAt.getMeasuredWidth();
            i3++;
            i5 = childAt.getMeasuredHeight();
            i4 = measuredWidth;
        }
        setMeasuredDimension(i4, i5);
    }

    public void setView(View view) {
        if (getChildCount() != 0) {
            removeViewAt(0);
        }
        addView(view, 0);
    }

    public SimpleViewSwitcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleViewSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
