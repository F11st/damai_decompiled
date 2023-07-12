package com.youku.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Rotate3dAnimation extends Animation {
    private boolean isMove = true;
    private Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final float mFromDegrees;
    private final boolean mReverse;
    private final float mToDegrees;

    public Rotate3dAnimation(float f, float f2, float f3, float f4, float f5, boolean z) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mCenterX = f3;
        this.mCenterY = f4;
        this.mDepthZ = f5;
        this.mReverse = z;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromDegrees;
        float f3 = f2 + ((this.mToDegrees - f2) * f);
        float f4 = this.mCenterX;
        float f5 = this.mCenterY;
        Camera camera = this.mCamera;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.isMove) {
            if (this.mReverse) {
                camera.translate(0.0f, 0.0f, this.mDepthZ * f);
            } else {
                camera.translate(0.0f, 0.0f, this.mDepthZ * (1.0f - f));
            }
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.mCamera = new Camera();
    }

    public void setMove(boolean z) {
        this.isMove = z;
    }
}
