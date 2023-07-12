package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baseproject.ui.R$anim;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$drawable;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {
    static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
    private ImageView mArrowImageView;
    private Animation mInAnim;
    private Animation mOutAnim;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_UP_TO_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public IndicatorLayout(Context context, PullToRefreshBase.Mode mode) {
        super(context);
        int i;
        int i2;
        this.mArrowImageView = new ImageView(context);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.indicator_internal_padding);
        this.mArrowImageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.mArrowImageView);
        if (a.a[mode.ordinal()] != 1) {
            i = R$anim.slide_in_from_top;
            i2 = R$anim.slide_out_to_top;
            setBackgroundResource(R$drawable.indicator_bg_top);
            this.mArrowImageView.setImageResource(R$drawable.arrow_down);
        } else {
            i = R$anim.slide_in_from_bottom;
            i2 = R$anim.slide_out_to_bottom;
            setBackgroundResource(R$drawable.indicator_bg_bottom);
            this.mArrowImageView.setImageResource(R$drawable.arrow_up);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        this.mInAnim = loadAnimation;
        loadAnimation.setAnimationListener(this);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i2);
        this.mOutAnim = loadAnimation2;
        loadAnimation2.setAnimationListener(this);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(linearInterpolator);
        rotateAnimation2.setDuration(150L);
        rotateAnimation2.setFillAfter(true);
    }

    public void hide() {
        startAnimation(this.mOutAnim);
    }

    public final boolean isVisible() {
        Animation animation = getAnimation();
        return animation != null ? this.mInAnim == animation : getVisibility() == 0;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.mOutAnim) {
            this.mArrowImageView.clearAnimation();
            setVisibility(8);
        } else if (animation == this.mInAnim) {
            setVisibility(0);
        }
        clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        setVisibility(0);
    }

    public void pullToRefresh() {
        this.mArrowImageView.startAnimation(this.mResetRotateAnimation);
    }

    public void releaseToRefresh() {
        this.mArrowImageView.startAnimation(this.mRotateAnimation);
    }

    public void show() {
        this.mArrowImageView.clearAnimation();
        startAnimation(this.mInAnim);
    }
}
