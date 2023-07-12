package com.taobao.weex.dom;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.taobao.weex.utils.TypefaceUtil;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXCustomStyleSpan extends MetricAffectingSpan {
    private final String mFontFamily;
    private final int mStyle;
    private final int mWeight;

    public WXCustomStyleSpan(int i, int i2, String str) {
        this.mStyle = i;
        this.mWeight = i2;
        this.mFontFamily = str;
    }

    public String getFontFamily() {
        return this.mFontFamily;
    }

    public int getStyle() {
        int i = this.mStyle;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public int getWeight() {
        int i = this.mWeight;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        TypefaceUtil.applyFontStyle(textPaint, this.mStyle, this.mWeight, this.mFontFamily);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        TypefaceUtil.applyFontStyle(textPaint, this.mStyle, this.mWeight, this.mFontFamily);
    }
}
