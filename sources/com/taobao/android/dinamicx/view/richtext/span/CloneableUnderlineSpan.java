package com.taobao.android.dinamicx.view.richtext.span;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CloneableUnderlineSpan extends UnderlineSpan implements PublicCloneable {
    private static final int UNDERLINE_WIDTH = 4;
    private int mColor;

    public CloneableUnderlineSpan(int i) {
        this.mColor = 0;
        this.mColor = i;
    }

    @Override // com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        return null;
    }

    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
    }
}
