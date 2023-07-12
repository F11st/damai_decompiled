package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baseproject.ui.R$styleable;
import com.youku.utils.YoukuUIUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ChannelCellImageLayout extends RelativeLayout {
    private int ratio_type;

    public ChannelCellImageLayout(Context context) {
        super(context);
    }

    private void initattrs(AttributeSet attributeSet) {
        this.ratio_type = getContext().obtainStyledAttributes(attributeSet, R$styleable.ChannelCellImageLayout).getInt(R$styleable.ChannelCellImageLayout_ratio, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i), RelativeLayout.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        int i4 = this.ratio_type;
        if (i4 == 1) {
            if (YoukuUIUtil.isPad(getContext())) {
                i3 = ((measuredWidth * 9) / 16) / 2;
            } else {
                i3 = (measuredWidth * 1) / 3;
            }
        } else if (i4 == 2) {
            if (YoukuUIUtil.isPad(getContext())) {
                i3 = ((measuredWidth * 9) / 16) / 2;
            } else {
                i3 = (measuredWidth * 7) / 15;
            }
        } else if (i4 == 3) {
            i3 = (measuredWidth * 7) / 15;
        } else if (i4 == 4) {
            i3 = (measuredWidth * 3) / 2;
        } else {
            i3 = (measuredWidth * 9) / 16;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public ChannelCellImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initattrs(attributeSet);
    }
}
