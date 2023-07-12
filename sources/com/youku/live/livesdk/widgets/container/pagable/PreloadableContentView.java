package com.youku.live.livesdk.widgets.container.pagable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PreloadableContentView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_EXTRA_SPACE = 30;
    private int mBottomExtraSpace;
    private int mTopExtraSpace;

    public PreloadableContentView(Context context) {
        this(context, null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673350070")) {
            ipChange.ipc$dispatch("1673350070", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 + this.mTopExtraSpace + this.mBottomExtraSpace, 1073741824);
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }

    public void setExtraSpace(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200959229")) {
            ipChange.ipc$dispatch("200959229", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mTopExtraSpace = i;
        this.mBottomExtraSpace = i2;
        requestLayout();
    }

    public PreloadableContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreloadableContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTopExtraSpace = 30;
        this.mBottomExtraSpace = 30;
    }
}
