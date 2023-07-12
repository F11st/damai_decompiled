package com.taobao.android.dinamicx.view.richtext.span;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class VerticalTopSpan extends CharacterStyle implements PublicCloneable {
    private int mLayoutBottom;
    private int mLayoutTop;

    public VerticalTopSpan(int i, int i2) {
        this.mLayoutTop = i;
        this.mLayoutBottom = i2;
    }

    @Override // com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        return new VerticalTopSpan(this.mLayoutTop, this.mLayoutBottom);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.baselineShift = -(textPaint.getFontMetricsInt().ascent - this.mLayoutTop);
    }
}
