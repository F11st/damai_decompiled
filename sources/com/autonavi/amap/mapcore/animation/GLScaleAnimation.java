package com.autonavi.amap.mapcore.animation;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f, float f2, float f3, float f4) {
        this.mFromX = f;
        this.mToX = f2;
        this.mFromY = f3;
        this.mToY = f4;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = this.mFromX;
        float f3 = 1.0f;
        float f4 = (f2 == 1.0f && this.mToX == 1.0f) ? 1.0f : f2 + ((this.mToX - f2) * f);
        float f5 = this.mFromY;
        if (f5 != 1.0f || this.mToY != 1.0f) {
            f3 = ((this.mToY - f5) * f) + f5;
        }
        if (this.mPivotX == 0.0f && this.mPivotY == 0.0f) {
            gLTransformation.scaleX = f4;
            gLTransformation.scaleY = f3;
            return;
        }
        gLTransformation.scaleX = f4;
        gLTransformation.scaleY = f3;
    }
}
