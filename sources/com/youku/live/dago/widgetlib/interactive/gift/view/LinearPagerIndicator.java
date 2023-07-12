package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LinearPagerIndicator extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mIndicatorCount;

    public LinearPagerIndicator(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886835529")) {
            ipChange.ipc$dispatch("-1886835529", new Object[]{this});
            return;
        }
        removeAllViews();
        int dip2px = DensityUtil.dip2px(getContext(), 1.0f);
        for (int i = 0; i < this.mIndicatorCount; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(R.drawable.dago_pgc_ykl_indicator_selector);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            layoutParams.leftMargin = dip2px;
            layoutParams.rightMargin = dip2px;
            addView(imageView, layoutParams);
        }
    }

    public void select(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199707032")) {
            ipChange.ipc$dispatch("1199707032", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (i2 == i) {
                getChildAt(i2).setSelected(true);
            } else {
                getChildAt(i2).setSelected(false);
            }
        }
    }

    public void setIndicatorCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410332482")) {
            ipChange.ipc$dispatch("1410332482", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mIndicatorCount = i;
        init();
    }

    public LinearPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorCount = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearPagerIndicator);
        setIndicatorCount(obtainStyledAttributes.getInteger(R.styleable.LinearPagerIndicator_indicator_count, 0));
        select(obtainStyledAttributes.getInteger(R.styleable.LinearPagerIndicator_default_selection, 0));
        obtainStyledAttributes.recycle();
        init();
    }
}
