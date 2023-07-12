package cn.damai.uikit.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RotateLoadingLayout extends LoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int ROTATION_ANIMATION_DURATION = 1200;
    private final Matrix mHeaderImageMatrix;
    private final Animation mRotateAnimation;
    private final boolean mRotateDrawableWhilePulling;
    private float mRotationPivotX;
    private float mRotationPivotY;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray, false);
        this.mRotateDrawableWhilePulling = typedArray.getBoolean(R$styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.mHeaderImageMatrix = matrix;
        this.mHeaderImage.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.ANIMATION_INTERPOLATOR);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
    }

    private void resetImageRotation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737591460")) {
            ipChange.ipc$dispatch("-737591460", new Object[]{this});
            return;
        }
        Matrix matrix = this.mHeaderImageMatrix;
        if (matrix != null) {
            matrix.reset();
            this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1937111077") ? ((Integer) ipChange.ipc$dispatch("1937111077", new Object[]{this})).intValue() : R$drawable.default_ptr_rotate;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9178557")) {
            ipChange.ipc$dispatch("-9178557", new Object[]{this, drawable});
        } else if (drawable != null) {
            this.mRotationPivotX = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.mRotationPivotY = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971503102")) {
            ipChange.ipc$dispatch("971503102", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHeaderImageMatrix.setRotate(this.mRotateDrawableWhilePulling ? f * 90.0f : Math.max(0.0f, Math.min(180.0f, (f * 360.0f) - 180.0f)), this.mRotationPivotX, this.mRotationPivotY);
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void pullToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890793097")) {
            ipChange.ipc$dispatch("1890793097", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126197183")) {
            ipChange.ipc$dispatch("2126197183", new Object[]{this});
        } else {
            this.mHeaderImage.startAnimation(this.mRotateAnimation);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void releaseToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295414707")) {
            ipChange.ipc$dispatch("-295414707", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-170798891")) {
            ipChange.ipc$dispatch("-170798891", new Object[]{this});
            return;
        }
        this.mHeaderImage.clearAnimation();
        resetImageRotation();
    }
}
