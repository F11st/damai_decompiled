package com.taobao.android.dinamicx.view.richtext.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CloneableNoStyleClickSpan extends ClickableSpan implements PublicCloneable {
    private ClickSpanDelegate mClickDelegate;

    @Override // com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        CloneableNoStyleClickSpan cloneableNoStyleClickSpan = new CloneableNoStyleClickSpan();
        cloneableNoStyleClickSpan.mClickDelegate = this.mClickDelegate;
        return cloneableNoStyleClickSpan;
    }

    public ClickSpanDelegate getClickDelegate() {
        return this.mClickDelegate;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        ClickSpanDelegate clickSpanDelegate = this.mClickDelegate;
        if (clickSpanDelegate != null) {
            clickSpanDelegate.onClick(view);
        }
    }

    public void setClickDelegate(ClickSpanDelegate clickSpanDelegate) {
        this.mClickDelegate = clickSpanDelegate;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
    }
}
