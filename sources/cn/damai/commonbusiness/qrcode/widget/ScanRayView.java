package cn.damai.commonbusiness.qrcode.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ScanRayView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "ScanRayView";
    private ScaleAnimation animation;
    private ScaleFinderView mFinderView;

    public ScanRayView(Context context) {
        super(context);
        this.mFinderView = null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040595891")) {
            ipChange.ipc$dispatch("-2040595891", new Object[]{this, canvas});
            return;
        }
        Log.d(TAG, "draw()");
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        ScaleFinderView scaleFinderView = this.mFinderView;
        if (scaleFinderView != null) {
            int[] iArr2 = new int[2];
            scaleFinderView.getLocationInWindow(iArr2);
            iArr[1] = iArr[1] - iArr2[1];
            this.mFinderView.setTargetLocation(iArr[0], iArr[1], iArr[0] + getWidth(), iArr[1] + getHeight());
            this.mFinderView.setVisibility(0);
        }
        super.draw(canvas);
    }

    public void setFinderView(ScaleFinderView scaleFinderView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1141091198")) {
            ipChange.ipc$dispatch("1141091198", new Object[]{this, scaleFinderView});
        } else {
            this.mFinderView = scaleFinderView;
        }
    }

    public void startScaleAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930780242")) {
            ipChange.ipc$dispatch("1930780242", new Object[]{this});
            return;
        }
        setVisibility(0);
        if (this.animation == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f);
            this.animation = scaleAnimation;
            scaleAnimation.setDuration(1500L);
            this.animation.setFillAfter(true);
            this.animation.setRepeatCount(-1);
            this.animation.setInterpolator(new AccelerateDecelerateInterpolator());
            startAnimation(this.animation);
        }
    }

    public void stopScaleAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778359264")) {
            ipChange.ipc$dispatch("-778359264", new Object[]{this});
            return;
        }
        setVisibility(4);
        if (this.animation != null) {
            clearAnimation();
            this.animation = null;
        }
    }

    public ScanRayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFinderView = null;
    }
}
