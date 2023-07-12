package com.youku.live.dsl.danmaku.youku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.plugin.DanmakuDefaultSettingPlugin;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SimpleTextCacheStuffer extends BaseCacheStuffer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mDensity;
    DanmakuDefaultSettingPlugin mSettingPlugin;

    public SimpleTextCacheStuffer() {
        this.mDensity = 3.0f;
        try {
            Context applicationContext = mu0.a().getApplicationContext();
            if (applicationContext != null) {
                float f = applicationContext.getResources().getDisplayMetrics().density;
                this.mDensity = f;
                this.mSettingPlugin = new DanmakuDefaultSettingPlugin(f);
            }
        } catch (Exception unused) {
        }
    }

    private Float getCacheHeight(BaseDanmaku baseDanmaku, Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-355493123")) {
            return (Float) ipChange.ipc$dispatch("-355493123", new Object[]{this, baseDanmaku, paint});
        }
        DanmakuDefaultSettingPlugin danmakuDefaultSettingPlugin = this.mSettingPlugin;
        if (danmakuDefaultSettingPlugin != null) {
            return Float.valueOf(danmakuDefaultSettingPlugin.getLineHeight());
        }
        return Float.valueOf(this.mDensity * 24.0f);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void clearCaches() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116712682")) {
            ipChange.ipc$dispatch("1116712682", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawBackground(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1699954771")) {
            ipChange.ipc$dispatch("1699954771", new Object[]{this, baseDanmaku, canvas, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), displayConfig});
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i;
        float f8;
        String[] strArr;
        float f9;
        float f10;
        float f11;
        float f12;
        String[] strArr2;
        float f13;
        float f14;
        float f15;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        boolean z3 = false;
        if (AndroidInstantRuntime.support(ipChange, "7218662")) {
            ipChange.ipc$dispatch("7218662", new Object[]{this, baseDanmaku, canvas, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), displayConfig});
            return;
        }
        displayConfig.definePaintParams(z);
        TextPaint paint = displayConfig.getPaint(baseDanmaku, !z);
        drawBackground(baseDanmaku, canvas, f, f2, z, displayConfig);
        float f16 = this.mDensity;
        float f17 = 3.0f * f16;
        float f18 = f16 * 24.0f;
        DanmakuDefaultSettingPlugin danmakuDefaultSettingPlugin = this.mSettingPlugin;
        if (danmakuDefaultSettingPlugin != null) {
            f17 = danmakuDefaultSettingPlugin.getLineSpace() / 2.0f;
            f18 = this.mSettingPlugin.getLineHeight();
        }
        float f19 = f17;
        float f20 = f18;
        float f21 = f20 / 2.0f;
        float f22 = f2 + f19;
        if (baseDanmaku.borderColor != 0) {
            float f23 = displayConfig.BORDER_WIDTH;
            f4 = f22 + (f23 / 2.0f);
            f3 = f + f23 + f21;
        } else {
            f3 = f;
            f4 = f22;
        }
        String[] strArr3 = baseDanmaku.lines;
        if (strArr3 != null) {
            if (strArr3.length == 1) {
                if (displayConfig.hasStroke(baseDanmaku)) {
                    displayConfig.applyPaintConfig(baseDanmaku, paint, true);
                    float ascent = f4 - paint.ascent();
                    if (displayConfig.HAS_PROJECTION) {
                        f14 = ascent + displayConfig.sProjectionOffsetY;
                        f15 = f3 + displayConfig.sProjectionOffsetX;
                    } else {
                        f14 = ascent;
                        f15 = f3;
                    }
                    String str = strArr3[0];
                    strArr2 = strArr3;
                    float f24 = f14;
                    f13 = f4;
                    drawStroke(baseDanmaku, str, canvas, f15, f24, paint);
                } else {
                    strArr2 = strArr3;
                    f13 = f4;
                }
                displayConfig.applyPaintConfig(baseDanmaku, paint, false);
                drawText(baseDanmaku, strArr2[0], canvas, f3, f13 - paint.ascent(), paint, z);
                f5 = f21;
            } else {
                float f25 = f4;
                String[] strArr4 = strArr3;
                float f26 = f25;
                float length = (baseDanmaku.paintHeight - (baseDanmaku.padding * 2)) / strArr4.length;
                int i2 = 0;
                while (i2 < strArr4.length) {
                    if (strArr4[i2] == null || strArr4[i2].length() == 0) {
                        i = i2;
                        f8 = f26;
                        strArr = strArr4;
                        f9 = f21;
                    } else {
                        if (displayConfig.hasStroke(baseDanmaku)) {
                            displayConfig.applyPaintConfig(baseDanmaku, paint, z2);
                            float ascent2 = ((i2 * length) + f26) - paint.ascent();
                            if (displayConfig.HAS_PROJECTION) {
                                f11 = ascent2 + displayConfig.sProjectionOffsetY;
                                f12 = f3 + displayConfig.sProjectionOffsetX;
                            } else {
                                f11 = ascent2;
                                f12 = f3;
                            }
                            i = i2;
                            f10 = f26;
                            strArr = strArr4;
                            drawStroke(baseDanmaku, strArr4[i2], canvas, f12, f11, paint);
                        } else {
                            i = i2;
                            f10 = f26;
                            strArr = strArr4;
                        }
                        displayConfig.applyPaintConfig(baseDanmaku, paint, z3);
                        float f27 = f10;
                        f8 = f27;
                        f9 = f21;
                        drawText(baseDanmaku, strArr[i], canvas, f3, ((i * length) + f27) - paint.ascent(), paint, z);
                    }
                    i2 = i + 1;
                    f21 = f9;
                    f26 = f8;
                    strArr4 = strArr;
                    z2 = true;
                    z3 = false;
                }
                f5 = f21;
            }
        } else {
            float f28 = f4;
            f5 = f21;
            if (displayConfig.hasStroke(baseDanmaku)) {
                displayConfig.applyPaintConfig(baseDanmaku, paint, true);
                float textBaseLine = DanmakuUtils.getTextBaseLine(paint, f28, this.mDensity * 24.0f);
                if (displayConfig.HAS_PROJECTION) {
                    f6 = textBaseLine + displayConfig.sProjectionOffsetY;
                    f7 = f3 + displayConfig.sProjectionOffsetX;
                } else {
                    f6 = textBaseLine;
                    f7 = f3;
                }
                drawStroke(baseDanmaku, null, canvas, f7, f6, paint);
            }
            displayConfig.applyPaintConfig(baseDanmaku, paint, false);
            drawText(baseDanmaku, null, canvas, f3, f28, paint, z);
        }
        if (baseDanmaku.underlineColor != 0) {
            Paint underlinePaint = displayConfig.getUnderlinePaint(baseDanmaku);
            float f29 = (f2 + baseDanmaku.paintHeight) - displayConfig.UNDERLINE_HEIGHT;
            canvas.drawLine(f3, f29, f3 + baseDanmaku.paintWidth, f29, underlinePaint);
        }
        if (baseDanmaku.borderColor != 0) {
            Paint borderPaint = displayConfig.getBorderPaint(baseDanmaku);
            float f30 = displayConfig.BORDER_WIDTH;
            canvas.drawRoundRect(new RectF(f3 + f30, f2 + f30 + f19, (f3 + baseDanmaku.paintWidth) - f30, f22 + f20), f5, f5, borderPaint);
        }
    }

    protected void drawStroke(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1256500090")) {
            ipChange.ipc$dispatch("1256500090", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), Float.valueOf(f2), paint});
        } else if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else if (TextUtils.isEmpty(baseDanmaku.text)) {
        } else {
            canvas.drawText(baseDanmaku.text.toString(), f, f2, paint);
        }
    }

    protected void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677414522")) {
            ipChange.ipc$dispatch("1677414522", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), Float.valueOf(f2), textPaint, Boolean.valueOf(z)});
            return;
        }
        float textBaseLine = DanmakuUtils.getTextBaseLine(textPaint, f2, this.mDensity * 24.0f);
        if (str != null) {
            canvas.drawText(str, f, textBaseLine, textPaint);
        } else if (TextUtils.isEmpty(baseDanmaku.text)) {
        } else {
            canvas.drawText(baseDanmaku.text.toString(), f, textBaseLine, textPaint);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        String[] strArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305987608")) {
            ipChange.ipc$dispatch("-305987608", new Object[]{this, baseDanmaku, textPaint, Boolean.valueOf(z), displayConfig});
            return;
        }
        float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (baseDanmaku.lines == null) {
            CharSequence charSequence = baseDanmaku.text;
            if (charSequence != null) {
                f = textPaint.measureText(charSequence.toString());
                valueOf = getCacheHeight(baseDanmaku, textPaint);
            }
            baseDanmaku.paintWidth = f;
            baseDanmaku.paintHeight = valueOf.floatValue();
            return;
        }
        Float cacheHeight = getCacheHeight(baseDanmaku, textPaint);
        for (String str : baseDanmaku.lines) {
            if (str.length() > 0) {
                f = Math.max(textPaint.measureText(str), f);
            }
        }
        baseDanmaku.paintWidth = f;
        baseDanmaku.paintHeight = baseDanmaku.lines.length * cacheHeight.floatValue();
    }
}
