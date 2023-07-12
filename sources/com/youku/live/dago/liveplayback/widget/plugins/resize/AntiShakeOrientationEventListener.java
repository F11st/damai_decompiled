package com.youku.live.dago.liveplayback.widget.plugins.resize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.OrientationEventListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public abstract class AntiShakeOrientationEventListener extends OrientationEventListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 270;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 0;
    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 90;
    public static final int SCREEN_ORIENTATION_UNKNOWN = -1;
    private float alpha;
    private float rotateThreshold;
    float smoothedRotate;

    public AntiShakeOrientationEventListener(Context context) {
        super(context, 1);
        this.alpha = 0.2f;
        this.rotateThreshold = 6.0f;
        this.smoothedRotate = 0.0f;
    }

    public abstract void onAntiShakeOrientationChanged(float f);

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        float f;
        float f2;
        float f3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "645514973")) {
            ipChange.ipc$dispatch("645514973", new Object[]{this, Integer.valueOf(i)});
        } else if (i == -1) {
            onAntiShakeOrientationChanged(i);
        } else {
            float f4 = i;
            if (Math.abs(f4 - this.smoothedRotate) > 225.0f) {
                int i2 = f4 > this.smoothedRotate ? 360 : 0;
                float f5 = this.alpha;
                f = f4 * f5;
                f2 = 1.0f - f5;
                f3 = i2;
            } else {
                float f6 = this.alpha;
                f = f4 * f6;
                f2 = 1.0f - f6;
                f3 = this.smoothedRotate;
            }
            float f7 = f + (f2 * f3);
            if (this.smoothedRotate != f7) {
                this.smoothedRotate = f7;
                float f8 = this.rotateThreshold;
                if (f7 < f8 || f7 > 360.0f - f8) {
                    this.smoothedRotate = 0.0f;
                }
                float f9 = this.smoothedRotate;
                if (f9 > 90.0f - f8 && f9 < f8 + 90.0f) {
                    this.smoothedRotate = 90.0f;
                }
                float f10 = this.smoothedRotate;
                if (f10 > 270.0f - f8 && f10 < f8 + 270.0f) {
                    this.smoothedRotate = 270.0f;
                }
                onAntiShakeOrientationChanged(this.smoothedRotate);
            }
        }
    }

    public AntiShakeOrientationEventListener setAlpha(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600408318")) {
            return (AntiShakeOrientationEventListener) ipChange.ipc$dispatch("1600408318", new Object[]{this, Float.valueOf(f)});
        }
        this.alpha = f;
        return this;
    }

    public AntiShakeOrientationEventListener setRotateThreshold(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-82876695")) {
            return (AntiShakeOrientationEventListener) ipChange.ipc$dispatch("-82876695", new Object[]{this, Integer.valueOf(i)});
        }
        this.rotateThreshold = i;
        return this;
    }
}
