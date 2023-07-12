package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$drawable;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.baseproject.ui.R$string;
import com.baseproject.ui.R$styleable;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class LoadingLayout extends LinearLayout {
    static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    static final int DEFAULT_ROTATION_ANIMATION_DURATION = 1200;
    private final ImageView mHeaderImage;
    private final Matrix mHeaderImageMatrix;
    private final TextView mHeaderText;
    private CharSequence mPullLabel;
    private CharSequence mRefreshingLabel;
    private CharSequence mReleaseLabel;
    private final Animation mRotateAnimation;
    private float mRotationPivotX;
    private float mRotationPivotY;
    private final TextView mSubHeaderText;
    private boolean mUseIntrinisicAnimation;

    /* compiled from: Taobao */
    /* renamed from: com.handmark.pulltorefresh.library.internal.LoadingLayout$a */
    /* loaded from: classes10.dex */
    static /* synthetic */ class C5458a {
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

    public LoadingLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setGravity(16);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.header_footer_top_bottom_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.header_footer_left_right_padding);
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        LayoutInflater.from(context).inflate(R$layout.pull_to_refresh_header, this);
        this.mHeaderText = (TextView) findViewById(R$id.pull_to_refresh_text);
        this.mSubHeaderText = (TextView) findViewById(R$id.pull_to_refresh_sub_text);
        ImageView imageView = (ImageView) findViewById(R$id.pull_to_refresh_image);
        this.mHeaderImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.mHeaderImageMatrix = matrix;
        imageView.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        this.mPullLabel = context.getString(R$string.pull_to_refresh_pull_label);
        this.mRefreshingLabel = context.getString(R$string.pull_to_refresh_refreshing_label);
        this.mReleaseLabel = context.getString(R$string.pull_to_refresh_release_label);
        setLoadingDrawable(context.getResources().getDrawable(R$drawable.default_ptr_drawable));
        reset();
    }

    private void resetImageRotation() {
        if (this.mUseIntrinisicAnimation) {
            return;
        }
        this.mHeaderImageMatrix.reset();
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
    }

    public void onPullY(float f) {
        if (this.mUseIntrinisicAnimation) {
            return;
        }
        this.mHeaderImageMatrix.setRotate(f * 90.0f, this.mRotationPivotX, this.mRotationPivotY);
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
    }

    public void pullToRefresh() {
        this.mHeaderText.setText(this.mPullLabel);
    }

    public void refreshing() {
        this.mHeaderText.setText(this.mRefreshingLabel);
        if (this.mUseIntrinisicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            this.mHeaderImage.startAnimation(this.mRotateAnimation);
        }
        this.mSubHeaderText.setVisibility(8);
    }

    public void releaseToRefresh() {
        this.mHeaderText.setText(this.mReleaseLabel);
    }

    public void reset() {
        this.mHeaderText.setText(this.mPullLabel);
        this.mHeaderImage.setVisibility(0);
        if (this.mUseIntrinisicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            this.mHeaderImage.clearAnimation();
        }
        resetImageRotation();
        if (TextUtils.isEmpty(this.mSubHeaderText.getText())) {
            this.mSubHeaderText.setVisibility(8);
        } else {
            this.mSubHeaderText.setVisibility(0);
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        if (drawable != null) {
            this.mRotationPivotX = drawable.getIntrinsicWidth() / 2.0f;
            this.mRotationPivotY = drawable.getIntrinsicHeight() / 2.0f;
        }
        this.mUseIntrinisicAnimation = drawable instanceof AnimationDrawable;
    }

    public void setPullLabel(CharSequence charSequence) {
        this.mPullLabel = charSequence;
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        this.mRefreshingLabel = charSequence;
    }

    public void setReleaseLabel(CharSequence charSequence) {
        this.mReleaseLabel = charSequence;
    }

    public void setSubHeaderText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mSubHeaderText.setVisibility(8);
            return;
        }
        this.mSubHeaderText.setText(charSequence);
        this.mSubHeaderText.setVisibility(0);
    }

    public void setSubTextAppearance(int i) {
        this.mSubHeaderText.setTextAppearance(getContext(), i);
    }

    public void setSubTextColor(ColorStateList colorStateList) {
        this.mSubHeaderText.setTextColor(colorStateList);
    }

    public void setTextAppearance(int i) {
        this.mHeaderText.setTextAppearance(getContext(), i);
        this.mSubHeaderText.setTextAppearance(getContext(), i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mHeaderText.setTextColor(colorStateList);
        this.mSubHeaderText.setTextColor(colorStateList);
    }

    public void setSubTextColor(int i) {
        setSubTextColor(ColorStateList.valueOf(i));
    }

    public void setTextColor(int i) {
        setTextColor(ColorStateList.valueOf(i));
    }

    @SuppressLint({"NewApi"})
    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, TypedArray typedArray) {
        super(context);
        Drawable drawable;
        setGravity(16);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.header_footer_top_bottom_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.header_footer_left_right_padding);
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        LayoutInflater.from(context).inflate(R$layout.pull_to_refresh_header, this);
        this.mHeaderText = (TextView) findViewById(R$id.pull_to_refresh_text);
        this.mSubHeaderText = (TextView) findViewById(R$id.pull_to_refresh_sub_text);
        ImageView imageView = (ImageView) findViewById(R$id.pull_to_refresh_image);
        this.mHeaderImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.mHeaderImageMatrix = matrix;
        imageView.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        if (C5458a.a[mode.ordinal()] != 1) {
            this.mPullLabel = context.getString(R$string.pull_to_refresh_pull_label);
            this.mRefreshingLabel = context.getString(R$string.pull_to_refresh_refreshing_label);
            this.mReleaseLabel = context.getString(R$string.pull_to_refresh_release_label);
        } else {
            this.mPullLabel = context.getString(R$string.pull_to_refresh_pull_label);
            this.mRefreshingLabel = context.getString(R$string.pull_to_refresh_refreshing_label);
            this.mReleaseLabel = context.getString(R$string.pull_to_refresh_release_label);
        }
        int i = R$styleable.PullToRefresh_ptrHeaderTextColor;
        if (typedArray.hasValue(i)) {
            ColorStateList colorStateList = typedArray.getColorStateList(i);
            setTextColor(colorStateList == null ? ColorStateList.valueOf(-16777216) : colorStateList);
        }
        int i2 = R$styleable.PullToRefresh_ptrHeaderSubTextColor;
        if (typedArray.hasValue(i2)) {
            ColorStateList colorStateList2 = typedArray.getColorStateList(i2);
            setSubTextColor(colorStateList2 == null ? ColorStateList.valueOf(-16777216) : colorStateList2);
        }
        int i3 = R$styleable.PullToRefresh_ptrHeaderBackground;
        if (typedArray.hasValue(i3) && (drawable = typedArray.getDrawable(i3)) != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                setBackground(drawable);
            } else {
                setBackgroundDrawable(drawable);
            }
        }
        int i4 = R$styleable.PullToRefresh_ptrHeaderTextAppearance;
        if (typedArray.hasValue(i4)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i4, typedValue);
            setTextAppearance(typedValue.data);
        }
        int i5 = R$styleable.PullToRefresh_ptrSubHeaderTextAppearance;
        if (typedArray.hasValue(i5)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(i5, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        int i6 = R$styleable.PullToRefresh_ptrDrawable;
        Drawable drawable2 = typedArray.hasValue(i6) ? typedArray.getDrawable(i6) : null;
        setLoadingDrawable(drawable2 == null ? context.getResources().getDrawable(R$drawable.default_ptr_drawable) : drawable2);
        reset();
    }
}
