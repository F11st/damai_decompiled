package com.alient.onearch.adapter.widget.banner;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Px;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface Indicator {
    RelativeLayout.LayoutParams getParams();

    View getView();

    void initIndicatorCount(int i, int i2);

    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, @Px int i2);

    void onPageSelected(int i);
}
