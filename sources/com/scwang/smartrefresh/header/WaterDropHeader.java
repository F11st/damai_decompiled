package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import tb.df2;
import tb.di2;
import tb.fv1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WaterDropHeader extends InternalAbstract implements RefreshHeader {
    protected static final float MAX_PROGRESS_ANGLE = 0.8f;
    protected ImageView mImageView;
    protected MaterialProgressDrawable mProgress;
    protected fv1 mProgressDrawable;
    protected RefreshState mState;
    protected WaterDropView mWaterDropView;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        a(WaterDropHeader waterDropHeader, View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setVisibility(8);
            this.a.setAlpha(1.0f);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RefreshState.RefreshFinish.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public WaterDropHeader(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        WaterDropView waterDropView = this.mWaterDropView;
        fv1 fv1Var = this.mProgressDrawable;
        if (this.mState == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((getWidth() / 2) - (Rect.width(fv1Var.getBounds()) / 2), (this.mWaterDropView.getMaxCircleRadius() + waterDropView.getPaddingTop()) - (Rect.height(fv1Var.getBounds()) / 2));
            fv1Var.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidate();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mProgressDrawable.stop();
        return 0;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView = this.mImageView;
        WaterDropView waterDropView = this.mWaterDropView;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = waterDropView.getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = i5 - i6;
        waterDropView.layout(i7, 0, i7 + measuredWidth2, waterDropView.getMeasuredHeight() + 0);
        int measuredWidth3 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int i8 = measuredWidth3 / 2;
        int i9 = i5 - i8;
        int i10 = i6 - i8;
        int i11 = (measuredWidth2 - measuredWidth3) / 2;
        if (i10 + measuredHeight > waterDropView.getBottom() - i11) {
            i10 = (waterDropView.getBottom() - i11) - measuredHeight;
        }
        imageView.layout(i9, i10, measuredWidth3 + i9, measuredHeight + i10);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ImageView imageView = this.mImageView;
        WaterDropView waterDropView = this.mWaterDropView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        imageView.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        waterDropView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), i2);
        super.setMeasuredDimension(View.resolveSize(Math.max(imageView.getMeasuredWidth(), waterDropView.getMeasuredWidth()), i), View.resolveSize(Math.max(imageView.getMeasuredHeight(), waterDropView.getMeasuredHeight()), i2));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        RefreshState refreshState;
        if (z || ((refreshState = this.mState) != RefreshState.Refreshing && refreshState != RefreshState.RefreshReleased)) {
            WaterDropView waterDropView = this.mWaterDropView;
            waterDropView.updateCompleteState(Math.max(i, 0), i3 + i2);
            waterDropView.postInvalidate();
        }
        if (z) {
            float f2 = i2;
            float max = (((float) Math.max(Math.min(1.0f, Math.abs((i * 1.0f) / f2)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            double max2 = Math.max(0.0f, Math.min(Math.abs(i) - i2, f2 * 2.0f) / f2) / 4.0f;
            this.mProgress.l(true);
            this.mProgress.j(0.0f, Math.min(0.8f, max * 0.8f));
            this.mProgress.d(Math.min(1.0f, max));
            this.mProgress.g((((0.4f * max) - 0.25f) + (((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f * 2.0f)) * 0.5f);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        WaterDropView waterDropView = this.mWaterDropView;
        this.mProgressDrawable.start();
        this.mWaterDropView.createAnimator().start();
        waterDropView.animate().setDuration(150L).alpha(0.0f).setListener(new a(this, waterDropView));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        WaterDropView waterDropView = this.mWaterDropView;
        this.mState = refreshState2;
        int i = b.a[refreshState2.ordinal()];
        if (i == 1) {
            waterDropView.setVisibility(0);
        } else if (i == 2) {
            waterDropView.setVisibility(0);
        } else if (i == 4) {
            waterDropView.setVisibility(0);
        } else if (i != 6) {
        } else {
            waterDropView.setVisibility(8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.mWaterDropView.setIndicatorColor(iArr[0]);
        }
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DensityUtil densityUtil = new DensityUtil();
        this.mSpinnerStyle = df2.Scale;
        WaterDropView waterDropView = new WaterDropView(context);
        this.mWaterDropView = waterDropView;
        waterDropView.updateCompleteState(0);
        addView(this.mWaterDropView, -1, -1);
        fv1 fv1Var = new fv1();
        this.mProgressDrawable = fv1Var;
        fv1Var.setCallback(this);
        fv1Var.setBounds(0, 0, densityUtil.dip2px(20.0f), densityUtil.dip2px(20.0f));
        this.mImageView = new ImageView(context);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(this.mImageView);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.e(-1);
        this.mProgress.setAlpha(255);
        this.mProgress.f(-1, -16737844, di2.holoRedLight, -10053376, -5609780, -30720);
        this.mImageView.setImageDrawable(this.mProgress);
        addView(this.mImageView, densityUtil.dip2px(30.0f), densityUtil.dip2px(30.0f));
    }
}
