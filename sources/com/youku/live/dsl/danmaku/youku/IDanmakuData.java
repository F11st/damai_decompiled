package com.youku.live.dsl.danmaku.youku;

import android.graphics.Paint;
import android.text.SpannableString;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDanmakuData {
    int getBorderColor();

    int getBorderCornerSize();

    float getBorderSize();

    int getFontBorderColor();

    float getFontBorderSize();

    int getFontColor();

    int getFontSize();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    int getRow();

    SpannableString getText();

    boolean isShowImmediately();

    void setFontColorGradient(Paint paint, int i, int i2);

    void setFontShadow(Paint paint);
}
