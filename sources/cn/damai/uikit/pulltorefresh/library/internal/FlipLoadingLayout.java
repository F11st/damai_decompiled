package cn.damai.uikit.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class FlipLoadingLayout extends LoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int FLIP_ANIMATION_DURATION = 150;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.pulltorefresh.library.internal.FlipLoadingLayout$a */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C2538a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray, false);
        float f = mode == PullToRefreshBase.Mode.PULL_FROM_START ? AMapEngineUtils.MIN_LONGITUDE_DEGREE : 180;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        Interpolator interpolator = LoadingLayout.ANIMATION_INTERPOLATOR;
        rotateAnimation.setInterpolator(interpolator);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(interpolator);
        rotateAnimation2.setDuration(150L);
        rotateAnimation2.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227557379")) {
            return ((Float) ipChange.ipc$dispatch("227557379", new Object[]{this})).floatValue();
        }
        int i = C2538a.a[this.mMode.ordinal()];
        return i != 1 ? (i == 2 && this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL) ? 270.0f : 0.0f : this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL ? 90.0f : 180.0f;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1041573943") ? ((Integer) ipChange.ipc$dispatch("1041573943", new Object[]{this})).intValue() : R$drawable.default_ptr_flip;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void onLoadingDrawableSet(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051634063")) {
            ipChange.ipc$dispatch("-2051634063", new Object[]{this, drawable});
        } else if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.mHeaderImage.requestLayout();
            this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.mHeaderImage.setImageMatrix(matrix);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649488144")) {
            ipChange.ipc$dispatch("1649488144", new Object[]{this, Float.valueOf(f)});
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void pullToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372300261")) {
            ipChange.ipc$dispatch("-1372300261", new Object[]{this});
        } else if (this.mRotateAnimation == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.mResetRotateAnimation);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747390317")) {
            ipChange.ipc$dispatch("747390317", new Object[]{this});
            return;
        }
        this.mHeaderImage.clearAnimation();
        this.mHeaderImage.setVisibility(4);
        this.mHeaderProgress.setVisibility(0);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void releaseToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180134779")) {
            ipChange.ipc$dispatch("1180134779", new Object[]{this});
        } else {
            this.mHeaderImage.startAnimation(this.mRotateAnimation);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796384871")) {
            ipChange.ipc$dispatch("1796384871", new Object[]{this});
            return;
        }
        this.mHeaderImage.clearAnimation();
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
    }
}
