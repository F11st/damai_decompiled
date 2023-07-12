package com.youku.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$drawable;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import tb.ui2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ArrowRefreshHeader extends LinearLayout implements BaseRefreshHeader {
    protected static final int ROTATE_ANIM_DURATION = 400;
    private AnimationDrawable anim;
    protected Context context;
    protected ImageView mArrowImageView;
    public int mArrowRotateHeight;
    protected TUrlImageView mBgImage;
    protected String mBgImageUrl;
    protected FrameLayout mContainer;
    protected TextView mHintView;
    public int mInitHeight;
    private LottieAnimationView mLoadingView;
    public int mMaxPullDownDistance;
    public int mRefreshingHeight;
    protected Animation mRotateCircleAnim;
    protected Animation mRotateDownAnim;
    protected Animation mRotateUpAnim;
    protected int mState;

    public ArrowRefreshHeader(Context context) {
        super(context);
        this.mState = 0;
        this.mInitHeight = -1;
        this.mBgImageUrl = "";
        this.context = context;
        initView();
    }

    private void loading(boolean z) {
        if (this.mLoadingView == null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R$id.lottieView);
            this.mLoadingView = lottieAnimationView;
            if (lottieAnimationView == null) {
                return;
            }
        }
        if (z) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.playAnimation();
            return;
        }
        this.mLoadingView.setVisibility(8);
        this.mLoadingView.pauseAnimation();
    }

    public ImageView getBgImageView() {
        return this.mBgImage;
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public int getInitHeight() {
        return this.mInitHeight;
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

    protected void initView() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mInitHeight = 0;
        this.mMaxPullDownDistance = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        Resources resources = getResources();
        int i = R$dimen.collection_refreshing_height;
        this.mArrowRotateHeight = resources.getDimensionPixelOffset(i) + this.mInitHeight;
        this.mRefreshingHeight = getResources().getDimensionPixelOffset(i) + this.mInitHeight;
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R$layout.listview_header, (ViewGroup) null);
        this.mContainer = frameLayout;
        this.mBgImage = (TUrlImageView) frameLayout.findViewById(R$id.bg_image);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        addView(this.mContainer, new LinearLayout.LayoutParams(-1, this.mInitHeight));
        setGravity(80);
        this.mHintView = (TextView) findViewById(R$id.listview_header_title);
        this.mArrowImageView = (ImageView) findViewById(R$id.listview_header_arrow);
        this.mLoadingView = (LottieAnimationView) findViewById(R$id.lottieView);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateUpAnim = rotateAnimation;
        rotateAnimation.setDuration(400L);
        this.mRotateUpAnim.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateDownAnim = rotateAnimation2;
        rotateAnimation2.setDuration(400L);
        this.mRotateDownAnim.setFillAfter(true);
        RotateAnimation rotateAnimation3 = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateCircleAnim = rotateAnimation3;
        rotateAnimation3.setDuration(400L);
        this.mRotateCircleAnim.setRepeatCount(-1);
        this.mRotateCircleAnim.setRepeatMode(-1);
        this.mRotateCircleAnim.setInterpolator(new LinearInterpolator());
        measure(-2, this.mInitHeight);
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void onMove(float f) {
        if (getVisibleHeight() > this.mInitHeight || f > 0.0f) {
            setVisibleHeight(((int) f) + getVisibleHeight());
            if (this.mState <= 1) {
                if (getVisibleHeight() > this.mArrowRotateHeight) {
                    setState(1);
                } else {
                    setState(0);
                }
            }
        }
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void refreshComplete(SpannableStringBuilder spannableStringBuilder) {
        setState(4, spannableStringBuilder);
        if (spannableStringBuilder == null) {
            new Handler().postDelayed(new Runnable() { // from class: com.youku.widget.ArrowRefreshHeader.2
                @Override // java.lang.Runnable
                public void run() {
                    ArrowRefreshHeader.this.reset();
                }
            }, 200L);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.youku.widget.ArrowRefreshHeader.3
                @Override // java.lang.Runnable
                public void run() {
                    ArrowRefreshHeader.this.reset();
                }
            }, 2000L);
        }
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public boolean releaseAction() {
        getVisibleHeight();
        boolean z = false;
        if (getVisibleHeight() >= this.mArrowRotateHeight && this.mState < 2) {
            setState(2);
            z = true;
        }
        int i = this.mState;
        int i2 = this.mInitHeight;
        if (i == 2) {
            i2 = this.mRefreshingHeight;
        }
        smoothScrollTo(i2);
        return z;
    }

    public void reset() {
        smoothScrollTo(this.mInitHeight);
        new Handler().postDelayed(new Runnable() { // from class: com.youku.widget.ArrowRefreshHeader.5
            @Override // java.lang.Runnable
            public void run() {
                ArrowRefreshHeader.this.setState(0);
            }
        }, 500L);
    }

    public void setArrowImageView(int i) {
        this.mArrowImageView.setImageResource(i);
    }

    public void setBgColor(String str) {
        int i;
        try {
            i = Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = Integer.MIN_VALUE;
        }
        if (i != Integer.MIN_VALUE) {
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(i);
            this.mBgImage.setImageDrawable(colorDrawable);
        }
    }

    public void setBgImage(String str) {
        this.mBgImageUrl = str;
        setBgImage();
    }

    public void setProgressStyle(int i) {
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void setState(int i, SpannableStringBuilder spannableStringBuilder) {
        int i2 = this.mState;
        if (i == i2) {
            return;
        }
        if (i == 0) {
            if (this.mHintView.getVisibility() == 0) {
                this.mHintView.setVisibility(8);
            }
            this.mArrowImageView.setImageResource(R$drawable.header_arrowdown);
            this.mArrowImageView.setVisibility(0);
            if (this.mState == 1) {
                this.mArrowImageView.startAnimation(this.mRotateDownAnim);
            }
        } else if (i != 1) {
            if (i == 2) {
                this.mArrowImageView.clearAnimation();
                YoukuLoading.show(this.context, this.mArrowImageView);
                this.mArrowImageView.setVisibility(8);
            } else if (i == 4) {
                this.mArrowImageView.clearAnimation();
                YoukuLoading.dismiss(this.context, this.mArrowImageView);
                this.mArrowImageView.setVisibility(8);
            }
        } else if (i2 != 1) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mRotateUpAnim);
        }
        this.mState = i;
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void setVisibleHeight(int i) {
        int i2 = this.mInitHeight;
        if (i < i2) {
            i = i2;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        this.mContainer.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void smoothScrollTo(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(getVisibleHeight(), i);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(300L).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.widget.ArrowRefreshHeader.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ArrowRefreshHeader.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }

    public void setBgImage() {
        if (this.mBgImage == null || TextUtils.isEmpty(this.mBgImageUrl) || this.mBgImage.getContext() == null) {
            return;
        }
        try {
            this.mBgImage.succListener(new IPhenixListener<ui2>() { // from class: com.youku.widget.ArrowRefreshHeader.1
                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    if (ui2Var.f() == null || ui2Var.i()) {
                        return true;
                    }
                    BitmapDrawable f = ui2Var.f();
                    Matrix matrix = new Matrix();
                    int intrinsicWidth = f.getIntrinsicWidth();
                    int intrinsicHeight = f.getIntrinsicHeight();
                    float width = ArrowRefreshHeader.this.mBgImage.getWidth() / intrinsicWidth;
                    matrix.setScale(width, width);
                    ArrowRefreshHeader.this.mBgImage.setScaleType(ImageView.ScaleType.MATRIX);
                    ArrowRefreshHeader.this.mBgImage.setImageMatrix(matrix);
                    ViewGroup.LayoutParams layoutParams = ArrowRefreshHeader.this.mBgImage.getLayoutParams();
                    layoutParams.height = (int) (intrinsicHeight * width);
                    ArrowRefreshHeader.this.mBgImage.setLayoutParams(layoutParams);
                    ArrowRefreshHeader.this.mContainer.setBackgroundColor(-1);
                    return true;
                }
            });
            this.mBgImage.setImageUrl(this.mBgImageUrl);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.widget.BaseRefreshHeader
    public void refreshComplete() {
        setState(4);
        new Handler().postDelayed(new Runnable() { // from class: com.youku.widget.ArrowRefreshHeader.4
            @Override // java.lang.Runnable
            public void run() {
                ArrowRefreshHeader.this.reset();
            }
        }, 200L);
    }

    public ArrowRefreshHeader(Context context, int i) {
        super(context);
        this.mState = 0;
        this.mInitHeight = -1;
        this.mBgImageUrl = "";
        this.mInitHeight = i;
        this.context = context;
        initView();
    }

    public ArrowRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.mInitHeight = -1;
        this.mBgImageUrl = "";
        this.context = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setState(int i) {
        setState(i, null);
    }
}
