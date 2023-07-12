package com.youku.resource.widget.tips;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import com.youku.resource.R;
import com.youku.resource.widget.YKTextView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKTips extends YKTextView {
    public YKTips(Context context) {
        super(context);
        init(context, null);
    }

    @Override // com.youku.resource.widget.YKTextView, com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
    }

    public void setBgDrawable(int i, int i2, int i3, int i4, int i5, int i6) {
        YKTipBgDrawable yKTipBgDrawable = new YKTipBgDrawable(i, i2, i3, getResources().getDimensionPixelOffset(R.dimen.resource_size_6), i4, i5, i6);
        if (Build.VERSION.SDK_INT >= 21) {
            setBackground(yKTipBgDrawable);
        } else {
            setBackgroundDrawable(yKTipBgDrawable);
        }
        if (i == 0) {
            Resources resources = getResources();
            int i7 = R.dimen.resource_size_12;
            setPadding(resources.getDimensionPixelOffset(i7), getResources().getDimensionPixelOffset(R.dimen.resource_size_7), getResources().getDimensionPixelOffset(i7), getResources().getDimensionPixelOffset(R.dimen.resource_size_10));
        } else if (i == 1) {
            Resources resources2 = getResources();
            int i8 = R.dimen.resource_size_12;
            setPadding(resources2.getDimensionPixelOffset(i8), getResources().getDimensionPixelOffset(R.dimen.resource_size_10), getResources().getDimensionPixelOffset(i8), getResources().getDimensionPixelOffset(R.dimen.resource_size_7));
        }
    }

    public void showAnimation() {
        float translationY = getTranslationY();
        Resources resources = getResources();
        int i = R.dimen.resource_size_3;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", translationY - resources.getDimensionPixelOffset(i), translationY + getResources().getDimensionPixelOffset(i));
        ofFloat.setDuration(3960L);
        ofFloat.setRepeatCount(-1);
        if (Build.VERSION.SDK_INT >= 22) {
            ofFloat.setInterpolator(new YKTipsInterpolator());
        }
        ofFloat.start();
    }

    public YKTips(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public void setBgDrawable(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        YKTipBgDrawable yKTipBgDrawable = new YKTipBgDrawable(i, i2, i3, i7, i4, i5, i6);
        if (Build.VERSION.SDK_INT >= 21) {
            setBackground(yKTipBgDrawable);
        } else {
            setBackgroundDrawable(yKTipBgDrawable);
        }
        setPadding(i8, i9, i10, i11);
    }

    public void showAnimation(int i) {
        float translationY = getTranslationY();
        float f = i;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", translationY - f, translationY + f);
        ofFloat.setDuration(3960L);
        ofFloat.setRepeatCount(-1);
        if (Build.VERSION.SDK_INT >= 22) {
            ofFloat.setInterpolator(new YKTipsInterpolator());
        }
        ofFloat.start();
    }
}
