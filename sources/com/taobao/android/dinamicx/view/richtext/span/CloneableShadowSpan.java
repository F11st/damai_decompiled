package com.taobao.android.dinamicx.view.richtext.span;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CloneableShadowSpan extends CharacterStyle implements PublicCloneable {
    private int mColor;
    private float mDx;
    private float mDy;
    private float mRadius;

    public CloneableShadowSpan(float f, float f2, float f3, int i) {
        this.mRadius = f;
        this.mDx = f2;
        this.mDy = f3;
        this.mColor = i;
    }

    @Override // com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        return new CloneableShadowSpan(this.mRadius, this.mDx, this.mDy, this.mColor);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.mRadius, this.mDx, this.mDy, this.mColor);
    }
}
