package com.youku.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HintRefreshHeader extends LinearLayout implements BaseRefreshHeader {
    private static final int ROTATE_ANIM_DURATION = 400;
    private LinearLayout mContainer;
    private ImageView mProgressCircle;
    private int mRefreshingHeight;
    private Animation mRotateCircleAnim;
    private int mState;

    public HintRefreshHeader(Context context) {
        super(context);
        this.mState = 0;
        initView();
    }

    private void initView() {
        this.mRefreshingHeight = getResources().getDimensionPixelOffset(R$dimen.homepage_refreshing_height);
        this.mContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R$layout.personalized_page_header, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        addView(this.mContainer, new LinearLayout.LayoutParams(-1, 0));
        setGravity(80);
        this.mProgressCircle = (ImageView) this.mContainer.findViewById(R$id.progress_circle);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateCircleAnim = rotateAnimation;
        rotateAnimation.setDuration(400L);
        this.mRotateCircleAnim.setRepeatCount(-1);
        this.mRotateCircleAnim.setRepeatMode(-1);
        this.mRotateCircleAnim.setInterpolator(new LinearInterpolator());
        measure(-2, -2);
    }

    private void smoothScrollTo(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(getVisibleHeight(), i);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.widget.HintRefreshHeader.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HintRefreshHeader.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public int getInitHeight() {
        return 0;
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public int getRefreshingHeight() {
        return this.mRefreshingHeight;
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public int getState() {
        return this.mState;
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public int getVisibleHeight() {
        return ((LinearLayout.LayoutParams) this.mContainer.getLayoutParams()).height;
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void onMove(float f) {
        if (this.mState < 2) {
            if (getVisibleHeight() > 0 || f > 0.0f) {
                setVisibleHeight(((int) f) + getVisibleHeight());
            }
            if (getVisibleHeight() >= this.mRefreshingHeight) {
                setState(1);
            }
        }
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void refreshComplete() {
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void refreshComplete(SpannableStringBuilder spannableStringBuilder) {
        setState(4);
        new Handler().postDelayed(new Runnable() { // from class: com.youku.widget.HintRefreshHeader.1
            @Override // java.lang.Runnable
            public void run() {
                HintRefreshHeader.this.reset();
            }
        }, 200L);
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public boolean releaseAction() {
        boolean z;
        int visibleHeight = getVisibleHeight();
        if (getVisibleHeight() < this.mRefreshingHeight || this.mState >= 2) {
            z = false;
        } else {
            setState(2);
            z = true;
        }
        if (this.mState == 2 && visibleHeight < this.mRefreshingHeight) {
            setState(0);
        }
        smoothScrollTo(this.mState == 2 ? this.mRefreshingHeight : 0);
        return z;
    }

    public void reset() {
        smoothScrollTo(0);
        new Handler().postDelayed(new Runnable() { // from class: com.youku.widget.HintRefreshHeader.2
            @Override // java.lang.Runnable
            public void run() {
                HintRefreshHeader.this.setState(0);
            }
        }, 500L);
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void setState(int i, SpannableStringBuilder spannableStringBuilder) {
        if (i == this.mState) {
            return;
        }
        if (i == 0) {
            this.mProgressCircle.clearAnimation();
        } else if (i == 1 || i == 2) {
            this.mProgressCircle.startAnimation(this.mRotateCircleAnim);
        }
        this.mState = i;
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void setVisibleHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public HintRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        initView();
    }

    protected void setState(int i) {
        setState(i, null);
    }
}
