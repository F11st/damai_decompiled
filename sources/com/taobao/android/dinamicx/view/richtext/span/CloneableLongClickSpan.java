package com.taobao.android.dinamicx.view.richtext.span;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CloneableLongClickSpan extends CharacterStyle implements UpdateAppearance, PublicCloneable {
    private static int sIdCounter;
    private int mId;
    private LongClickSpanDelegate mLongClickSpanDelegate;

    public CloneableLongClickSpan() {
        int i = sIdCounter;
        sIdCounter = i + 1;
        this.mId = i;
    }

    @Override // com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        CloneableLongClickSpan cloneableLongClickSpan = new CloneableLongClickSpan();
        cloneableLongClickSpan.mLongClickSpanDelegate = this.mLongClickSpanDelegate;
        return cloneableLongClickSpan;
    }

    public int getId() {
        return this.mId;
    }

    public LongClickSpanDelegate getLongClickSpanDelegate() {
        return this.mLongClickSpanDelegate;
    }

    public boolean onLongClick(@NonNull View view) {
        LongClickSpanDelegate longClickSpanDelegate = this.mLongClickSpanDelegate;
        if (longClickSpanDelegate != null) {
            return longClickSpanDelegate.onLongClick(view);
        }
        return false;
    }

    public void setLongClickSpanDelegate(LongClickSpanDelegate longClickSpanDelegate) {
        this.mLongClickSpanDelegate = longClickSpanDelegate;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
    }
}
