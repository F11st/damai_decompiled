package com.autonavi.amap.mapcore.animation;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha;
    public float mToAlpha;

    public GLAlphaAnimation(float f, float f2) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.mFromAlpha = f;
        this.mToAlpha = f2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = this.mFromAlpha;
        float f3 = f2 + ((this.mToAlpha - f2) * f);
        this.mCurAlpha = f3;
        gLTransformation.alpha = f3;
    }
}
