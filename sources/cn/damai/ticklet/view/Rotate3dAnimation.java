package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class Rotate3dAnimation extends Animation {
    private static transient /* synthetic */ IpChange $ipChange;
    private Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final float mFromDegrees;
    private final boolean mReverse;
    private float mScale;
    private final float mToDegrees;
    private int mXY;

    public Rotate3dAnimation(Context context, float f, float f2, float f3, float f4, float f5, boolean z, int i, float f6) {
        this.mScale = 1.0f;
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mCenterX = f3;
        this.mCenterY = f4;
        this.mDepthZ = f5;
        this.mReverse = z;
        if (f6 == -1.0f) {
            this.mScale = context.getResources().getDisplayMetrics().density;
        } else {
            this.mScale = f6;
        }
        this.mXY = i;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360278081")) {
            ipChange.ipc$dispatch("-360278081", new Object[]{this, Float.valueOf(f), transformation});
            return;
        }
        float f2 = this.mFromDegrees;
        float f3 = f2 + ((this.mToDegrees - f2) * f);
        float f4 = this.mCenterX;
        float f5 = this.mCenterY;
        Camera camera = this.mCamera;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.mReverse) {
            camera.translate(0.0f, 0.0f, this.mDepthZ * f);
        } else {
            camera.translate(0.0f, 0.0f, this.mDepthZ * (1.0f - f));
        }
        if (this.mXY == 1) {
            camera.rotateX(f3);
        } else {
            camera.rotateY(f3);
        }
        camera.getMatrix(matrix);
        camera.restore();
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f6 = fArr[6];
        float f7 = this.mScale;
        fArr[6] = f6 / f7;
        fArr[7] = fArr[7] / f7;
        matrix.setValues(fArr);
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162872185")) {
            ipChange.ipc$dispatch("-1162872185", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.initialize(i, i2, i3, i4);
        this.mCamera = new Camera();
    }
}
