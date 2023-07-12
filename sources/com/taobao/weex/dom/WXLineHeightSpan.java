package com.taobao.weex.dom;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXLineHeightSpan implements LineHeightSpan {
    private int lineHeight;

    public WXLineHeightSpan(int i) {
        this.lineHeight = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("LineHeight", ((Object) charSequence) + " ; start " + i + "; end " + i2 + "; spanstartv " + i3 + "; v " + i4 + "; fm " + fontMetricsInt);
        }
        int i5 = this.lineHeight;
        int i6 = fontMetricsInt.descent;
        int i7 = fontMetricsInt.ascent;
        int i8 = (i5 - (i6 - i7)) / 2;
        fontMetricsInt.top -= i8;
        fontMetricsInt.bottom += i8;
        fontMetricsInt.ascent = i7 - i8;
        fontMetricsInt.descent = i6 + i8;
    }
}
