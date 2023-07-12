package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DigitTextView extends TextView {
    @JvmOverloads
    public DigitTextView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public DigitTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DigitTextView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmOverloads
    public DigitTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTypeface(Typeface.createFromAsset(getContext().getApplicationContext().getAssets(), "damai_digit.otf"));
    }
}
