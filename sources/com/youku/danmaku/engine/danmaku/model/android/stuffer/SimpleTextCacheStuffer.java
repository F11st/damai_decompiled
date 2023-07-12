package com.youku.danmaku.engine.danmaku.model.android.stuffer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SimpleTextCacheStuffer extends BaseCacheStuffer {
    private Float getCacheHeight(BaseDanmaku baseDanmaku, Paint paint, IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        float density = DanmakuEngineContext.getDensity() * 24.0f;
        if (iDanmakuSettingPlugin != null) {
            density = iDanmakuSettingPlugin.getLineHeight();
        }
        return Float.valueOf(density);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void clearCaches() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawBackground(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, AndroidDisplayer.DisplayConfig displayConfig) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v13 */
    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        float f3;
        float f4;
        float f5;
        int i;
        String[] strArr;
        float f6;
        int i2;
        float f7;
        float f8;
        ?? r14;
        float f9;
        float f10;
        displayConfig.definePaintParams(z);
        TextPaint paint = displayConfig.getPaint(baseDanmaku, !z);
        drawBackground(baseDanmaku, canvas, f, f2, displayConfig);
        float density = DanmakuEngineContext.getDensity() * 24.0f;
        float density2 = DanmakuEngineContext.getDensity() * 6.0f;
        IDanmakuSettingPlugin danmakuSettingPlugin = displayConfig.getDanmakuSettingPlugin();
        if (danmakuSettingPlugin != null) {
            density = danmakuSettingPlugin.getLineHeight();
            density2 = danmakuSettingPlugin.getLineSpace();
        }
        float f11 = density;
        float f12 = f11 / 2.0f;
        float f13 = f2 + (density2 / 2.0f);
        float f14 = (baseDanmaku.borderColor != 0 || baseDanmaku.ykHasBorder) ? f + displayConfig.BORDER_WIDTH + f12 : f;
        String[] strArr2 = baseDanmaku.lines;
        boolean z2 = true;
        if (strArr2 != null) {
            if (strArr2.length == 1) {
                if (displayConfig.hasStroke(baseDanmaku)) {
                    displayConfig.applyPaintConfig(baseDanmaku, paint, true);
                    float ascent = f13 - paint.ascent();
                    if (displayConfig.HAS_PROJECTION) {
                        f9 = ascent + displayConfig.sProjectionOffsetY;
                        f10 = f14 + displayConfig.sProjectionOffsetX;
                    } else {
                        f9 = ascent;
                        f10 = f14;
                    }
                    r14 = 0;
                    drawStroke(baseDanmaku, strArr2[0], canvas, f10, f9, paint);
                } else {
                    r14 = 0;
                }
                displayConfig.applyPaintConfig(baseDanmaku, paint, r14);
                drawText(baseDanmaku, strArr2[r14], canvas, f14, f13 - paint.ascent(), paint, z, f11);
                f3 = f13;
            } else {
                boolean z3 = false;
                float length = (baseDanmaku.paintHeight - (baseDanmaku.padding * 2)) / strArr2.length;
                int i3 = 0;
                while (i3 < strArr2.length) {
                    if (strArr2[i3] == null || strArr2[i3].length() == 0) {
                        i = i3;
                        strArr = strArr2;
                        f6 = f13;
                    } else {
                        if (displayConfig.hasStroke(baseDanmaku)) {
                            displayConfig.applyPaintConfig(baseDanmaku, paint, z2);
                            float ascent2 = ((i3 * length) + f13) - paint.ascent();
                            if (displayConfig.HAS_PROJECTION) {
                                f7 = ascent2 + displayConfig.sProjectionOffsetY;
                                f8 = f14 + displayConfig.sProjectionOffsetX;
                            } else {
                                f7 = ascent2;
                                f8 = f14;
                            }
                            i2 = i3;
                            drawStroke(baseDanmaku, strArr2[i3], canvas, f8, f7, paint);
                        } else {
                            i2 = i3;
                        }
                        displayConfig.applyPaintConfig(baseDanmaku, paint, z3);
                        int i4 = i2;
                        i = i4;
                        strArr = strArr2;
                        f6 = f13;
                        drawText(baseDanmaku, strArr2[i4], canvas, f14, ((i4 * length) + f13) - paint.ascent(), paint, z, f11);
                    }
                    i3 = i + 1;
                    f13 = f6;
                    strArr2 = strArr;
                    z2 = true;
                    z3 = false;
                }
                f3 = f13;
            }
        } else {
            f3 = f13;
            if (displayConfig.hasStroke(baseDanmaku)) {
                displayConfig.applyPaintConfig(baseDanmaku, paint, true);
                float textBaseLine = DanmakuUtils.getTextBaseLine(paint, f3, f11);
                if (displayConfig.HAS_PROJECTION) {
                    f4 = textBaseLine + displayConfig.sProjectionOffsetY;
                    f5 = f14 + displayConfig.sProjectionOffsetX;
                } else {
                    f4 = textBaseLine;
                    f5 = f14;
                }
                drawStroke(baseDanmaku, null, canvas, f5, f4, paint);
            }
            displayConfig.applyPaintConfig(baseDanmaku, paint, false);
            drawText(baseDanmaku, null, canvas, f14, f3, paint, z, f11);
        }
        if (baseDanmaku.underlineColor != 0) {
            Paint underlinePaint = displayConfig.getUnderlinePaint(baseDanmaku);
            float f15 = (f2 + baseDanmaku.paintHeight) - displayConfig.UNDERLINE_HEIGHT;
            canvas.drawLine(f, f15, f + baseDanmaku.paintWidth, f15, underlinePaint);
        }
        if (baseDanmaku.borderColor != 0 || baseDanmaku.ykHasBorder) {
            float f16 = displayConfig.BORDER_WIDTH / 2.0f;
            canvas.drawRoundRect(new RectF(f + f16, f3 - f16, (f + baseDanmaku.paintWidth) - f16, f3 + f11 + f16), f12, f12, displayConfig.getBorderPaint(baseDanmaku));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawStroke(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else if (TextUtils.isEmpty(baseDanmaku.text)) {
        } else {
            canvas.drawText(baseDanmaku.text.toString(), f, f2, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        float textBaseLine = DanmakuUtils.getTextBaseLine(textPaint, f2, DanmakuEngineContext.getDensity() * 24.0f);
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
        float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (baseDanmaku.lines == null) {
            CharSequence charSequence = baseDanmaku.text;
            if (charSequence != null) {
                f = textPaint.measureText(charSequence.toString());
                valueOf = getCacheHeight(baseDanmaku, textPaint, displayConfig.getDanmakuSettingPlugin());
            }
            baseDanmaku.paintWidth = f;
            baseDanmaku.paintHeight = valueOf.floatValue();
            return;
        }
        Float cacheHeight = getCacheHeight(baseDanmaku, textPaint, displayConfig.getDanmakuSettingPlugin());
        for (String str : baseDanmaku.lines) {
            if (str.length() > 0) {
                f = Math.max(textPaint.measureText(str), f);
            }
        }
        baseDanmaku.paintWidth = f;
        baseDanmaku.paintHeight = baseDanmaku.lines.length * cacheHeight.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z, float f3) {
        float textBaseLine = DanmakuUtils.getTextBaseLine(textPaint, f2, f3);
        if (str != null) {
            canvas.drawText(str, f, textBaseLine, textPaint);
        } else if (TextUtils.isEmpty(baseDanmaku.text)) {
        } else {
            canvas.drawText(baseDanmaku.text.toString(), f, textBaseLine, textPaint);
        }
    }
}
