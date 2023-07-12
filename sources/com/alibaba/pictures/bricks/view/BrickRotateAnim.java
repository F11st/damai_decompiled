package com.alibaba.pictures.bricks.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BrickRotateAnim extends Animation {
    private static transient /* synthetic */ IpChange $ipChange;
    private float degrees;
    private int mHeight;
    private int mWidth;

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, @NotNull Transformation transformation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328015642")) {
            ipChange.ipc$dispatch("328015642", new Object[]{this, Float.valueOf(f), transformation});
            return;
        }
        b41.i(transformation, "t");
        transformation.getMatrix().setRotate(-((float) (Math.sin(f * 3.141592653589793d) * this.degrees)), 0.0f, this.mHeight);
        super.applyTransformation(f, transformation);
    }

    public final float getDegrees() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "969951611") ? ((Float) ipChange.ipc$dispatch("969951611", new Object[]{this})).floatValue() : this.degrees;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076569420")) {
            ipChange.ipc$dispatch("2076569420", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.mWidth = i;
        this.mHeight = i2;
        super.initialize(i, i2, i3, i4);
    }

    public final void setDegrees(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1767980279")) {
            ipChange.ipc$dispatch("-1767980279", new Object[]{this, Float.valueOf(f)});
        } else {
            this.degrees = f;
        }
    }
}
