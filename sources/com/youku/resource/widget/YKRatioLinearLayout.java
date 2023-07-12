package com.youku.resource.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import com.youku.resource.R;
import com.youku.resource.utils.ImageViewUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKRatioLinearLayout extends LinearLayout {
    public static final int RATIO_P1 = 1;
    public static final int RATIO_P16 = 16;
    public static final int RATIO_P16_S1 = 161;
    public static final int RATIO_P16_S2 = 162;
    public static final int RATIO_P16_S3 = 163;
    public static final int RATIO_P1_S1 = 11;
    public static final int RATIO_P1_S2 = 12;
    public static final int RATIO_P1_S3 = 13;
    public static final int RATIO_P1_S4 = 14;
    public static final int RATIO_P2 = 2;
    public static final int RATIO_P2_S1 = 21;
    public static final int RATIO_P2_S2 = 22;
    public static final int RATIO_P2_S3 = 23;
    public static final int RATIO_P3 = 3;
    public static final int RATIO_P3_S1 = 31;
    public static final int RATIO_P3_S2 = 32;
    public static final int RATIO_P3_S3 = 33;
    public static final int RATIO_P3_S4 = 34;
    public static final int RATIO_P4 = 4;
    public static final int RATIO_P4_S1 = 41;
    public static final int RATIO_P4_S2 = 42;
    public static final int RATIO_P9 = 9;
    public static final int RATIO_P9_S1 = 91;
    public static final int RATIO_PB = 998;
    public static final int RATIO_PV = 999;
    private int D;
    private int M;
    protected int height;
    private int[] mSize;
    private int ratio_type;
    private boolean roundCorner;
    protected int width;

    public YKRatioLinearLayout(Context context) {
        super(context);
        this.mSize = new int[2];
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.ratio_type != 0) {
            setMeasuredDimension(LinearLayout.getDefaultSize(0, i), LinearLayout.getDefaultSize(0, i2));
            int[] iArr = this.mSize;
            iArr[1] = 0;
            iArr[0] = 0;
            ImageViewUtils.getCalculatedSize(getContext(), this.ratio_type, getMeasuredWidth(), getMeasuredHeight(), this.M, this.D, this.mSize);
            int[] iArr2 = this.mSize;
            int i3 = iArr2[0];
            this.width = i3;
            this.height = iArr2[1];
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
            return;
        }
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        super.onMeasure(i, i2);
    }

    public void setRatioType(int i) {
        this.ratio_type = i;
    }

    @TargetApi(21)
    public void setViewRoundedCorner(View view, final int i, final float f) {
        if (Build.VERSION.SDK_INT < 21 || view == null || i < 0) {
            return;
        }
        if (i > 0) {
            view.setClipToOutline(true);
        } else {
            view.setClipToOutline(false);
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.youku.resource.widget.YKRatioLinearLayout.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                float f2 = f;
                if (f2 >= 0.0f) {
                    outline.setAlpha(f2);
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), i);
            }
        });
    }

    public YKRatioLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = new int[2];
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKImageView, 0, 0);
            this.ratio_type = obtainStyledAttributes.getInt(R.styleable.YKImageView_picRatio, 0);
            this.D = getResources().getDimensionPixelOffset(obtainStyledAttributes.getResourceId(R.styleable.YKImageView_D, R.dimen.dim_6));
            this.M = getResources().getDimensionPixelOffset(obtainStyledAttributes.getResourceId(R.styleable.YKImageView_M, R.dimen.dim_7));
            int i = R.styleable.YKImageView_roundCorner;
            if (obtainStyledAttributes.getResourceId(i, 0) != 0) {
                this.roundCorner = getResources().getBoolean(obtainStyledAttributes.getResourceId(i, 0));
            } else {
                this.roundCorner = obtainStyledAttributes.getBoolean(i, true);
            }
            if (this.roundCorner) {
                setViewRoundedCorner(this, getResources().getDimensionPixelOffset(R.dimen.yk_img_round_radius), 1.0f);
            }
            obtainStyledAttributes.recycle();
        }
    }
}
