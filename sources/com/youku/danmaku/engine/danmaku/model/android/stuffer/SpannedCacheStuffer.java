package com.youku.danmaku.engine.danmaku.model.android.stuffer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import java.lang.ref.SoftReference;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpannedCacheStuffer extends SimpleTextCacheStuffer {
    private void staticLayoutDraw(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, TextPaint textPaint) {
        StaticLayout staticLayout = (StaticLayout) ((SoftReference) baseDanmaku.obj).get();
        int i = baseDanmaku.requestFlags;
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        boolean z3 = (i & 2) != 0;
        if (z3 || staticLayout == null) {
            if (z3) {
                baseDanmaku.requestFlags = i & (-3);
            }
            CharSequence charSequence = baseDanmaku.text;
            if (charSequence == null) {
                return;
            }
            if (z2) {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(baseDanmaku.text, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                baseDanmaku.paintWidth = staticLayout.getWidth();
                baseDanmaku.paintHeight = staticLayout.getHeight();
                baseDanmaku.requestFlags &= -2;
            } else {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) baseDanmaku.paintWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            baseDanmaku.obj = new SoftReference(staticLayout);
        }
        if (f != 0.0f && f2 != 0.0f) {
            canvas.save();
            canvas.translate(f, f2 + textPaint.ascent());
            z = true;
        }
        staticLayout.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void clearCache(BaseDanmaku baseDanmaku) {
        super.clearCache(baseDanmaku);
        Object obj = baseDanmaku.obj;
        if (obj instanceof SoftReference) {
            ((SoftReference) obj).clear();
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void clearCaches() {
        super.clearCaches();
        System.gc();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
    public void drawStroke(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (baseDanmaku.obj == null) {
            super.drawStroke(baseDanmaku, str, canvas, f, f2, paint);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        if (baseDanmaku.obj == null) {
            super.drawText(baseDanmaku, str, canvas, f, f2, textPaint, z);
        } else {
            staticLayoutDraw(baseDanmaku, canvas, f, f2, textPaint);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        if (baseDanmaku.text instanceof Spanned) {
            CharSequence charSequence = baseDanmaku.text;
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            baseDanmaku.paintWidth = staticLayout.getWidth();
            baseDanmaku.paintHeight = staticLayout.getHeight();
            baseDanmaku.obj = new SoftReference(staticLayout);
            return;
        }
        super.measure(baseDanmaku, textPaint, z, displayConfig);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void releaseResource(BaseDanmaku baseDanmaku) {
        clearCache(baseDanmaku);
        super.releaseResource(baseDanmaku);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z, float f3) {
        if (baseDanmaku.obj == null) {
            super.drawText(baseDanmaku, str, canvas, f, f2, textPaint, z, f3);
        } else {
            staticLayoutDraw(baseDanmaku, canvas, f, f2, textPaint);
        }
    }
}
