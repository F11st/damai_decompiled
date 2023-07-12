package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CenterHoleFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private HoleDrawable mHoleBackground;
    private float mMinCircleSize;

    public CenterHoleFrameLayout(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1413323626")) {
            ipChange.ipc$dispatch("-1413323626", new Object[]{this});
            return;
        }
        HoleDrawable holeDrawable = new HoleDrawable(getBackground());
        this.mHoleBackground = holeDrawable;
        setBackground(holeDrawable);
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254166928")) {
            ipChange.ipc$dispatch("-1254166928", new Object[]{this});
            return;
        }
        HoleDrawable holeDrawable = this.mHoleBackground;
        if (holeDrawable != null) {
            holeDrawable.setPath(null);
        }
    }

    public void updateCircleFac(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724679120")) {
            ipChange.ipc$dispatch("1724679120", new Object[]{this, Float.valueOf(f)});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(width, height);
        float f2 = this.mMinCircleSize;
        Path path = new Path();
        path.addCircle(width / 2.0f, height / 2.0f, (((max / 2.0f) - f2) * f) + f2, Path.Direction.CW);
        this.mHoleBackground.setPath(path);
        invalidate();
    }

    public CenterHoleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CenterHoleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMinCircleSize = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CenterHoleFrameLayout);
        this.mMinCircleSize = obtainStyledAttributes.getDimension(R.styleable.CenterHoleFrameLayout_min_circle_size, 0.0f);
        obtainStyledAttributes.recycle();
        initView();
    }
}
