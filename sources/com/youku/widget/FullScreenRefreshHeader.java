package com.youku.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.utils.YoukuUIUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FullScreenRefreshHeader extends ArrowRefreshHeader {
    public boolean isEnableFullPull;

    public FullScreenRefreshHeader(Context context) {
        super(context);
        this.isEnableFullPull = false;
    }

    @Override // com.youku.widget.ArrowRefreshHeader
    protected void initView() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (this.mInitHeight == -1) {
            if (YoukuUIUtil.isTransparentStatusBar()) {
                this.mInitHeight = getResources().getDimensionPixelOffset(R$dimen.recycler_view_header_height_with_status_bar);
            } else {
                this.mInitHeight = getResources().getDimensionPixelOffset(R$dimen.recycler_view_header_height_no_status_bar);
            }
        }
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        this.mMaxPullDownDistance = i;
        int i2 = this.mInitHeight;
        this.mArrowRotateHeight = (int) ((i * 0.1f) + i2);
        this.mRefreshingHeight = (int) ((i * 0.1f) + i2);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R$layout.listview_header, (ViewGroup) null);
        this.mContainer = frameLayout;
        this.mBgImage = (TUrlImageView) frameLayout.findViewById(R$id.bg_image);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        addView(this.mContainer, new LinearLayout.LayoutParams(-1, this.mInitHeight));
        setGravity(80);
        TextView textView = (TextView) findViewById(R$id.listview_header_title);
        this.mHintView = textView;
        if (this.isEnableFullPull) {
            textView.setVisibility(8);
        }
        this.mArrowImageView = (ImageView) findViewById(R$id.listview_header_arrow);
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

    @Override // com.youku.widget.ArrowRefreshHeader, com.youku.widget.BaseRefreshHeader
    public boolean releaseAction() {
        int visibleHeight = getVisibleHeight();
        boolean z = false;
        if (getVisibleHeight() >= this.mArrowRotateHeight && this.mState < 2) {
            setState(2);
            z = true;
        }
        if (this.mState == 2 && visibleHeight >= (this.mMaxPullDownDistance * 0.2f) + this.mInitHeight && this.isEnableFullPull) {
            setState(3);
        }
        int i = this.mInitHeight;
        int i2 = this.mState;
        if (i2 == 2) {
            i = this.mRefreshingHeight;
        } else if (i2 == 3) {
            i += this.mMaxPullDownDistance;
        }
        smoothScrollTo(i);
        return z;
    }

    public void resetInitHeight(int i) {
        this.mInitHeight = i;
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(getResources().getDisplayMetrics());
        this.mMaxPullDownDistance = i2;
        int i3 = this.mInitHeight;
        this.mArrowRotateHeight = (int) ((i2 * 0.1f) + i3);
        this.mRefreshingHeight = (int) ((i2 * 0.1f) + i3);
        this.mContainer.getLayoutParams().height = i;
        requestLayout();
    }

    public void setEnableFullPull(boolean z) {
        this.isEnableFullPull = z;
    }

    @Override // com.youku.widget.ArrowRefreshHeader, com.youku.widget.BaseRefreshHeader
    public void setState(int i, SpannableStringBuilder spannableStringBuilder) {
        super.setState(i, spannableStringBuilder);
        if (this.isEnableFullPull) {
            this.mHintView.setVisibility(8);
        }
    }

    public FullScreenRefreshHeader(Context context, int i) {
        super(context, i);
        this.isEnableFullPull = false;
    }
}
