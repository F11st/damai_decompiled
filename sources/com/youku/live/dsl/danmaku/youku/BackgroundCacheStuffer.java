package com.youku.live.dsl.danmaku.youku;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.plugin.DanmakuDefaultSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BackgroundCacheStuffer extends YKLTextCacheStuffer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MODE_NEW = 1;
    public static final int MODE_ORG = 0;
    public final float density;
    private DanmakuDefaultSettingPlugin mSettingPlugin;
    public final int mode;

    public BackgroundCacheStuffer(float f, boolean z) {
        if (z) {
            this.mode = 1;
        } else {
            this.mode = 0;
        }
        this.density = f;
    }

    private Paint getPaint(boolean z, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432331325")) {
            return (Paint) ipChange.ipc$dispatch("1432331325", new Object[]{this, Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i)});
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        paint.setColor(i);
        return paint;
    }

    private DanmakuDefaultSettingPlugin getSettingPlugin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301320040")) {
            return (DanmakuDefaultSettingPlugin) ipChange.ipc$dispatch("-1301320040", new Object[]{this});
        }
        if (this.mSettingPlugin == null) {
            synchronized (this) {
                if (this.mSettingPlugin == null) {
                    this.mSettingPlugin = new DanmakuDefaultSettingPlugin(this.density);
                }
            }
        }
        return this.mSettingPlugin;
    }

    private float getTextBaseLine(Paint paint, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228616214")) {
            return ((Float) ipChange.ipc$dispatch("228616214", new Object[]{this, paint, Float.valueOf(f), Float.valueOf(f2)})).floatValue();
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (((f2 + f) - fontMetrics.bottom) - fontMetrics.top) / 2.0f;
    }

    private void realDrawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, IDanmakuData iDanmakuData, Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747242856")) {
            ipChange.ipc$dispatch("747242856", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), iDanmakuData, paint});
        } else if (baseDanmaku == null || iDanmakuData == null) {
        } else {
            if (this.mode == 1) {
                Paint paint2 = new Paint();
                paint2.set(paint);
                paint = paint2;
            }
            paint.setTextSize(baseDanmaku.textSize);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setFakeBoldText(false);
            float textBaseLine = getTextBaseLine(paint, iDanmakuData.getPaddingTop(), baseDanmaku.paintHeight - iDanmakuData.getPaddingBottom());
            if (str != null) {
                canvas.drawText(str, f + iDanmakuData.getPaddingLeft(), textBaseLine, paint);
                return;
            }
            CharSequence charSequence = baseDanmaku.text;
            if (charSequence != null) {
                canvas.drawText(charSequence.toString(), f + iDanmakuData.getPaddingLeft(), textBaseLine, paint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer
    public void drawBackground(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        IDanmakuData iDanmakuData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1819282620")) {
            ipChange.ipc$dispatch("-1819282620", new Object[]{this, baseDanmaku, canvas, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), displayConfig});
            return;
        }
        super.drawBackground(baseDanmaku, canvas, f, f2, z, displayConfig);
        if (baseDanmaku == null || (iDanmakuData = (IDanmakuData) baseDanmaku.tag) == null) {
            return;
        }
        float borderSize = iDanmakuData.getBorderSize();
        if (borderSize <= 0.0f) {
            return;
        }
        int borderColor = iDanmakuData.getBorderColor();
        Paint paint = getPaint(z, borderSize, borderColor);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(borderSize);
        paint.setColor(borderColor);
        try {
            RectF rectF = new RectF((getSettingPlugin().getLineSpace() / 3.0f) + f, getSettingPlugin().getLineSpace() + f2, (f + baseDanmaku.paintWidth) - (getSettingPlugin().getLineSpace() / 3.0f), (f2 + baseDanmaku.paintHeight) - (getSettingPlugin().getLineSpace() / 2.0f));
            float f3 = baseDanmaku.paintHeight;
            canvas.drawRoundRect(rectF, f3 / 2.0f, f3 / 2.0f, paint);
        } catch (Exception unused) {
        }
    }

    @Override // com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180373")) {
            ipChange.ipc$dispatch("180373", new Object[]{this, baseDanmaku, canvas, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), displayConfig});
        } else {
            super.drawDanmaku(baseDanmaku, canvas, f, f2, z, displayConfig);
        }
    }

    @Override // com.youku.live.dsl.danmaku.youku.YKLTextCacheStuffer, com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer
    public void drawStroke(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        Paint paint2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1270557611")) {
            ipChange.ipc$dispatch("1270557611", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), Float.valueOf(f2), paint});
            return;
        }
        IDanmakuData iDanmakuData = (IDanmakuData) baseDanmaku.tag;
        if (iDanmakuData != null && iDanmakuData.getFontBorderSize() > 0.0f) {
            if (this.mode == 1) {
                Paint paint3 = new Paint();
                paint3.set(paint);
                paint2 = paint3;
            } else {
                paint2 = paint;
            }
            paint2.setShader(null);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(baseDanmaku.textShadowColor);
            paint2.setStrokeWidth(iDanmakuData.getFontBorderSize());
            realDrawText(baseDanmaku, str, canvas, f, iDanmakuData, paint2);
            return;
        }
        super.drawStroke(baseDanmaku, str, canvas, f, f2, paint);
    }

    @Override // com.youku.live.dsl.danmaku.youku.YKLTextCacheStuffer, com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        TextPaint textPaint2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "153847337")) {
            ipChange.ipc$dispatch("153847337", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), Float.valueOf(f2), textPaint, Boolean.valueOf(z)});
            return;
        }
        try {
            if (this.mode == 1) {
                TextPaint textPaint3 = new TextPaint();
                textPaint3.set(textPaint);
                textPaint2 = textPaint3;
            } else {
                textPaint2 = textPaint;
            }
            IDanmakuData iDanmakuData = (IDanmakuData) baseDanmaku.tag;
            iDanmakuData.setFontColorGradient(textPaint2, (int) baseDanmaku.paintWidth, (int) baseDanmaku.paintHeight);
            iDanmakuData.setFontShadow(textPaint2);
            realDrawText(baseDanmaku, str, canvas, f, iDanmakuData, textPaint2);
        } catch (Exception unused) {
        }
    }

    @Override // com.youku.live.dsl.danmaku.youku.YKLTextCacheStuffer, com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182746137")) {
            ipChange.ipc$dispatch("182746137", new Object[]{this, baseDanmaku, textPaint, Boolean.valueOf(z), displayConfig});
            return;
        }
        IDanmakuData iDanmakuData = (IDanmakuData) baseDanmaku.tag;
        if (this.mode == 1) {
            TextPaint textPaint2 = new TextPaint();
            textPaint2.set(textPaint);
            textPaint = textPaint2;
        }
        textPaint.setTextSize(baseDanmaku.textSize);
        super.measure(baseDanmaku, textPaint, z, displayConfig);
        if (iDanmakuData != null) {
            baseDanmaku.paintWidth += iDanmakuData.getPaddingLeft() + iDanmakuData.getPaddingRight();
            baseDanmaku.paintHeight += iDanmakuData.getPaddingBottom() + iDanmakuData.getPaddingTop();
        }
    }
}
