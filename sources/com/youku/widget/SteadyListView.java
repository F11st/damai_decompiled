package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SteadyListView extends ListView {
    public SteadyListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        super.onMeasure(i, makeMeasureSpec);
    }

    public SteadyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SteadyListView(Context context) {
        super(context);
    }
}
