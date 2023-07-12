package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import tb.df2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WaveSwipeHeader extends InternalAbstract implements RefreshHeader {
    protected static final float MAX_PROGRESS_ROTATION_RATE = 0.8f;
    protected ProgressAnimationImageView mCircleView;
    protected float mLastFirstBounds;
    protected MaterialProgressDrawable mProgress;
    protected RefreshState mState;
    protected WaveView mWaveView;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class ProgressAnimationImageView extends ImageView {
        protected Animation.AnimationListener mListener;

        public ProgressAnimationImageView(Context context) {
            super(context);
            MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(WaveSwipeHeader.this);
            WaveSwipeHeader.this.mProgress = materialProgressDrawable;
            materialProgressDrawable.e(0);
            if (WaveSwipeHeader.isOver600dp()) {
                WaveSwipeHeader.this.mProgress.n(0);
            }
            super.setImageDrawable(WaveSwipeHeader.this.mProgress);
        }

        @Override // android.view.View
        public void onAnimationEnd() {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }

        @Override // android.view.View
        public void onAnimationStart() {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        public void setAnimationListener(Animation.AnimationListener animationListener) {
            this.mListener = animationListener;
        }

        public void setProgressColorSchemeColorsFromResource(@IdRes int... iArr) {
            Resources resources = getResources();
            int[] iArr2 = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr2[i] = resources.getColor(iArr[i]);
            }
            WaveSwipeHeader.this.setColorSchemeColors(iArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum SECOND uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class VERTICAL_DRAG_THRESHOLD {
        private static final /* synthetic */ VERTICAL_DRAG_THRESHOLD[] $VALUES;
        public static final VERTICAL_DRAG_THRESHOLD FIRST;
        public static final VERTICAL_DRAG_THRESHOLD SECOND;
        public static final VERTICAL_DRAG_THRESHOLD THIRD;
        final float val;

        static {
            VERTICAL_DRAG_THRESHOLD vertical_drag_threshold = new VERTICAL_DRAG_THRESHOLD("FIRST", 0, 0.1f);
            FIRST = vertical_drag_threshold;
            VERTICAL_DRAG_THRESHOLD vertical_drag_threshold2 = new VERTICAL_DRAG_THRESHOLD("SECOND", 1, vertical_drag_threshold.val + 0.16f);
            SECOND = vertical_drag_threshold2;
            VERTICAL_DRAG_THRESHOLD vertical_drag_threshold3 = new VERTICAL_DRAG_THRESHOLD("THIRD", 2, vertical_drag_threshold.val + 0.5f);
            THIRD = vertical_drag_threshold3;
            $VALUES = new VERTICAL_DRAG_THRESHOLD[]{vertical_drag_threshold, vertical_drag_threshold2, vertical_drag_threshold3};
        }

        private VERTICAL_DRAG_THRESHOLD(String str, int i, float f) {
            this.val = f;
        }

        public static VERTICAL_DRAG_THRESHOLD valueOf(String str) {
            return (VERTICAL_DRAG_THRESHOLD) Enum.valueOf(VERTICAL_DRAG_THRESHOLD.class, str);
        }

        public static VERTICAL_DRAG_THRESHOLD[] values() {
            return (VERTICAL_DRAG_THRESHOLD[]) $VALUES.clone();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$a */
    /* loaded from: classes6.dex */
    class C6166a implements ValueAnimator.AnimatorUpdateListener {
        C6166a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveSwipeHeader waveSwipeHeader = WaveSwipeHeader.this;
            ProgressAnimationImageView progressAnimationImageView = waveSwipeHeader.mCircleView;
            progressAnimationImageView.setTranslationY(waveSwipeHeader.mWaveView.getCurrentCircleCenterY() + (progressAnimationImageView.getHeight() / 2.0f));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$b  reason: invalid class name */
    /* loaded from: classes6.dex */
    class animationAnimation$AnimationListenerC6167b implements Animation.AnimationListener {
        animationAnimation$AnimationListenerC6167b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WaveSwipeHeader.this.mProgress.stop();
            WaveSwipeHeader.this.mProgress.setAlpha(255);
            WaveSwipeHeader.this.mWaveView.startDisappearCircleAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$c */
    /* loaded from: classes6.dex */
    static /* synthetic */ class C6168c {
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
        }
    }

    public WaveSwipeHeader(Context context) {
        this(context, null);
    }

    public static boolean isOver600dp() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)) / displayMetrics.density >= 600.0f;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        final ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        Animation animation = new Animation() { // from class: com.scwang.smartrefresh.header.WaveSwipeHeader.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float f2 = 1.0f - f;
                progressAnimationImageView.setScaleX(f2);
                progressAnimationImageView.setScaleY(f2);
            }
        };
        animation.setDuration(200L);
        this.mCircleView.setAnimationListener(new animationAnimation$AnimationListenerC6167b());
        progressAnimationImageView.clearAnimation();
        progressAnimationImageView.startAnimation(animation);
        return 0;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WaveView waveView = this.mWaveView;
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        waveView.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = progressAnimationImageView.getMeasuredWidth();
        progressAnimationImageView.layout((measuredWidth - measuredWidth2) / 2, -progressAnimationImageView.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            onMoving(true, 0.99f, DensityUtil.dp2px(99.0f), DensityUtil.dp2px(100.0f), DensityUtil.dp2px(100.0f));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        WaveView waveView = this.mWaveView;
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mProgress.getIntrinsicWidth(), 1073741824);
        progressAnimationImageView.measure(makeMeasureSpec, makeMeasureSpec);
        waveView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (!z || this.mState == RefreshState.Refreshing) {
            return;
        }
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        float max = (((float) Math.max(Math.min(1.0f, f) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float f2 = f > 3.0f ? 2.0f : f > 1.0f ? f - 1.0f : 0.0f;
        float f3 = ((4.0f - f2) * f2) / 8.0f;
        if (f < 1.0f) {
            this.mProgress.j(0.0f, Math.min(0.8f, max * 0.8f));
            this.mProgress.d(Math.min(1.0f, max));
        }
        this.mProgress.g((((max * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
        progressAnimationImageView.setTranslationY(this.mWaveView.getCurrentCircleCenterY());
        float min = (i * 1.0f) / Math.min(getMeasuredWidth(), getMeasuredHeight());
        float f4 = (min * (5.0f - (2.0f * min))) / 3.5f;
        float f5 = VERTICAL_DRAG_THRESHOLD.FIRST.val;
        float f6 = f4 - f5;
        float f7 = VERTICAL_DRAG_THRESHOLD.SECOND.val;
        float f8 = (f4 - f7) / 5.0f;
        this.mLastFirstBounds = f4;
        if (f4 < f5) {
            this.mWaveView.beginPhase(f4);
        } else if (f4 < f7) {
            this.mWaveView.appearPhase(f4, f6);
        } else {
            this.mWaveView.expandPhase(f4, f6, f8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mLastFirstBounds = 0.0f;
        this.mWaveView.animationDropCircle();
        this.mProgress.setAlpha(255);
        this.mProgress.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new C6166a());
        ofFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        this.mState = refreshState2;
        int i = C6168c.a[refreshState2.ordinal()];
        if (i == 2) {
            this.mProgress.l(true);
            progressAnimationImageView.setScaleX(1.0f);
            progressAnimationImageView.setScaleY(1.0f);
            this.mProgress.setAlpha(255);
        } else if (i != 3) {
        } else {
            this.mProgress.l(false);
            this.mProgress.g(0.0f);
            this.mProgress.j(0.0f, 0.0f);
            this.mWaveView.startWaveAnimation(this.mLastFirstBounds);
            this.mLastFirstBounds = 0.0f;
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.mProgress.f(iArr);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.mWaveView.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.mProgress.f(iArr[1]);
            }
        }
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpinnerStyle = df2.MatchLayout;
        WaveView waveView = new WaveView(context);
        this.mWaveView = waveView;
        addView(waveView);
        ProgressAnimationImageView progressAnimationImageView = new ProgressAnimationImageView(context);
        this.mCircleView = progressAnimationImageView;
        addView(progressAnimationImageView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.WaveSwipeHeader);
        int color = obtainStyledAttributes.getColor(R$styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.mWaveView.setWaveColor(color);
        }
        if (color2 != 0) {
            this.mProgress.f(color2);
        } else {
            this.mProgress.f(-1);
        }
        int i2 = R$styleable.WaveSwipeHeader_wshShadowRadius;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mWaveView.setShadow(obtainStyledAttributes.getDimensionPixelOffset(i2, 0), obtainStyledAttributes.getColor(R$styleable.WaveSwipeHeader_wshShadowColor, -16777216));
        }
        obtainStyledAttributes.recycle();
    }
}
