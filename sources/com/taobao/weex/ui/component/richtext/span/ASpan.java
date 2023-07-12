package com.taobao.weex.ui.component.richtext.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.taobao.weex.utils.ATagUtil;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ASpan extends ClickableSpan {
    private String mInstanceId;
    private String mURL;

    public ASpan(String str, String str2) {
        this.mInstanceId = str;
        this.mURL = str2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        ATagUtil.onClick(view, this.mInstanceId, this.mURL);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }
}
