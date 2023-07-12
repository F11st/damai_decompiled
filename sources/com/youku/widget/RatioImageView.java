package com.youku.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baseproject.ui.R$styleable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RatioImageView extends ImageView {
    private float ratio;

    public RatioImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.ratio == 0.0f) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) / this.ratio), 1073741824));
        }
    }

    public void setRatio(float f) {
        this.ratio = f;
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RatioImageView);
        this.ratio = obtainStyledAttributes.getFloat(R$styleable.RatioImageView_ratioWidthHeight, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
