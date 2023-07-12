package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMDigitTextView extends AppCompatTextView {
    public DMDigitTextView(Context context) {
        this(context, null);
    }

    public DMDigitTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMDigitTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTypeface(Typeface.createFromAsset(getContext().getApplicationContext().getAssets(), "damai_digit.otf"));
    }
}
