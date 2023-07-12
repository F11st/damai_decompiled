package com.autonavi.base.ae.gmap.gloverlay;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GLOverlayTexture {
    public int mAnchor;
    public float mAnchorXRatio;
    public float mAnchorYRatio;
    public int mHeight;
    public int mResHeight;
    public int mResId;
    public int mResWidth;
    public int mWidth;

    public GLOverlayTexture(int i, int i2, int i3, int i4) {
        this.mResId = 0;
        this.mResId = i;
        this.mWidth = i3;
        this.mHeight = i4;
        this.mResWidth = i3;
        this.mResHeight = i4;
        this.mAnchor = i2;
    }

    public GLOverlayTexture(int i, int i2, float f, float f2, int i3, int i4) {
        this.mResId = 0;
        this.mResId = i;
        this.mWidth = i3;
        this.mHeight = i4;
        this.mResWidth = i3;
        this.mResHeight = i4;
        this.mAnchor = i2;
        this.mAnchorXRatio = f;
        this.mAnchorYRatio = f2;
    }
}
