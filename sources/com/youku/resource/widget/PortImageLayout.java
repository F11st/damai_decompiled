package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PortImageLayout extends RelativeLayout {
    public PortImageLayout(Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i), RelativeLayout.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((measuredWidth * 3) / 2, 1073741824));
    }

    public PortImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
