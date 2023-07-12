package com.youku.danmaku.engine.danmaku.util;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DrawingCache;
import com.youku.danmaku.engine.danmaku.model.android.DrawingCacheHolder;
import com.youku.danmaku.engine.danmaku.model.danmaku.AutoStopR2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuUtils {
    public static DrawingCache buildDanmakuDrawingCache(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DrawingCache drawingCache, int i) {
        if (drawingCache == null) {
            drawingCache = new DrawingCache();
        }
        drawingCache.build((int) Math.ceil(baseDanmaku.paintWidth), (int) Math.ceil(baseDanmaku.paintHeight), iDisplayer.getDensityDpi(), false, i);
        DrawingCacheHolder drawingCacheHolder = drawingCache.get();
        if (drawingCacheHolder != null) {
            ((AbsDisplayer) iDisplayer).drawDanmaku(baseDanmaku, drawingCacheHolder.canvas, 0.0f, 0.0f, true);
            if (iDisplayer.isHardwareAccelerated()) {
                drawingCacheHolder.splitWith(iDisplayer.getWidth(), iDisplayer.getHeight(), iDisplayer.getMaximumCacheWidth(), iDisplayer.getMaximumCacheHeight());
            }
        }
        return drawingCache;
    }

    public static float calculateTextSize(float f, float f2) {
        return f * getDispParams(f2);
    }

    private static boolean checkHit(int i, int i2, float[] fArr, float[] fArr2, float f) {
        if (i != i2) {
            return false;
        }
        return i == 1 ? fArr2[0] - f < fArr[2] : i == 6 && fArr2[2] > fArr[0];
    }

    private static boolean checkHitAtTime(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, long j) {
        float[] rectAtTime = baseDanmaku.getRectAtTime(iDisplayer, j);
        float[] rectAtTime2 = baseDanmaku2.getRectAtTime(iDisplayer, j);
        if (rectAtTime != null && rectAtTime2 != null) {
            return checkHit(baseDanmaku.getType(), baseDanmaku2.getType(), rectAtTime, rectAtTime2, iDisplayer.getSpacing());
        }
        IDanmakuSettingPlugin danmakuSettingPlugin = iDisplayer.getDanmakuSettingPlugin();
        if (danmakuSettingPlugin != null) {
            return (danmakuSettingPlugin.isNewTypesetting() || danmakuSettingPlugin.isNewCompose()) && rectAtTime == null && !baseDanmaku.isMeasured();
        }
        return false;
    }

    private static boolean checkHitAtTimeForUniform(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, long j, long j2) {
        float[] rectAtTime = baseDanmaku.getRectAtTime(iDisplayer, j);
        float[] rectAtTime2 = baseDanmaku2.getRectAtTime(iDisplayer, j2);
        if (rectAtTime == null || rectAtTime2 == null) {
            return false;
        }
        return checkHit(baseDanmaku.getType(), baseDanmaku2.getType(), rectAtTime, rectAtTime2, iDisplayer.getSpacing());
    }

    public static int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
        int i;
        CharSequence charSequence;
        if (baseDanmaku == baseDanmaku2) {
            return 0;
        }
        if (baseDanmaku == null) {
            return -1;
        }
        if (baseDanmaku2 != null && baseDanmaku.time - baseDanmaku2.time <= 0) {
            if (i < 0) {
                return -1;
            }
            int i2 = baseDanmaku.index - baseDanmaku2.index;
            if (i2 > 0) {
                return 1;
            }
            if (i2 < 0) {
                return -1;
            }
            int type = baseDanmaku.getType() - baseDanmaku2.getType();
            if (type > 0) {
                return 1;
            }
            if (type >= 0 && (charSequence = baseDanmaku.text) != null) {
                if (baseDanmaku2.text == null) {
                    return 1;
                }
                int compareTo = charSequence.toString().compareTo(baseDanmaku2.text.toString());
                if (compareTo != 0) {
                    return compareTo;
                }
                int i3 = baseDanmaku.textColor - baseDanmaku2.textColor;
                if (i3 != 0) {
                    return i3 < 0 ? -1 : 1;
                }
                int i4 = baseDanmaku.index - baseDanmaku2.index;
                if (i4 != 0) {
                    return i4 < 0 ? -1 : 1;
                }
                return baseDanmaku.hashCode() - baseDanmaku2.hashCode();
            }
            return -1;
        }
        return 1;
    }

    public static void fillText(BaseDanmaku baseDanmaku, CharSequence charSequence) {
        baseDanmaku.text = charSequence;
        if (TextUtils.isEmpty(charSequence) || !charSequence.toString().contains(BaseDanmaku.DANMAKU_BR_CHAR)) {
            return;
        }
        String[] split = String.valueOf(baseDanmaku.text).split(BaseDanmaku.DANMAKU_BR_CHAR, -1);
        if (split.length > 1) {
            baseDanmaku.lines = split;
        }
    }

    public static int getCacheSize(int i, int i2, int i3) {
        return i * i2 * i3;
    }

    public static float getDispParams(float f) {
        return f;
    }

    public static float getTextBaseLine(Paint paint, float f, float f2) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f3 = f + (f2 / 2.0f);
        float f4 = fontMetrics.descent;
        return (((Math.abs(fontMetrics.ascent) + f4) / 2.0f) - f4) + f3;
    }

    public static boolean isDuplicate(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
        if (baseDanmaku == baseDanmaku2) {
            return false;
        }
        CharSequence charSequence = baseDanmaku.text;
        CharSequence charSequence2 = baseDanmaku2.text;
        if (charSequence == charSequence2) {
            return true;
        }
        return charSequence != null && charSequence.equals(charSequence2);
    }

    public static boolean isOverSize(IDisplayer iDisplayer, BaseDanmaku baseDanmaku) {
        return iDisplayer.isHardwareAccelerated() && (baseDanmaku.paintWidth > ((float) iDisplayer.getMaximumCacheWidth()) || baseDanmaku.paintHeight > ((float) iDisplayer.getMaximumCacheHeight()));
    }

    public static void recycleDrawable(Drawable drawable) {
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            drawable.setCallback(null);
        }
    }

    public static boolean willHitInDuration(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, long j, long j2) {
        int type = baseDanmaku.getType();
        if (type == baseDanmaku2.getType() && !baseDanmaku.isOutside()) {
            long j3 = baseDanmaku2.time - baseDanmaku.time;
            if (j3 < 0) {
                return true;
            }
            if (Math.abs(j3) >= j || baseDanmaku.isTimeOut() || baseDanmaku2.isTimeOut()) {
                return false;
            }
            return type == 5 || type == 4 || checkHitAtTime(iDisplayer, baseDanmaku, baseDanmaku2, j2) || checkHitAtTime(iDisplayer, baseDanmaku, baseDanmaku2, baseDanmaku.time + baseDanmaku.getDuration());
        }
        return false;
    }

    public static boolean willHitInUniformSpeed(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, long j) {
        int type = baseDanmaku.getType();
        if (type == baseDanmaku2.getType() && !baseDanmaku.isOutside()) {
            if (baseDanmaku2.time - baseDanmaku.time < 0) {
                return true;
            }
            if (baseDanmaku.isTimeOut() || baseDanmaku2.isTimeOut()) {
                return false;
            }
            if (type == 5 || type == 4) {
                return true;
            }
            R2LDanmaku r2LDanmaku = (R2LDanmaku) baseDanmaku;
            R2LDanmaku r2LDanmaku2 = (R2LDanmaku) baseDanmaku2;
            float stepX = r2LDanmaku.getStepX();
            r2LDanmaku2.setStepAndCalculateDuration(stepX);
            if (Log.isDebug()) {
                Log.e("willHitInUniformSpeed", "\nstepX: " + stepX + "\nr2lD1.time: " + r2LDanmaku.time + "\ncurrTime: " + j + "\nr2lD2.time: " + r2LDanmaku2.time + "\nr2lD2.duration: " + r2LDanmaku2.getDuration());
            }
            if (baseDanmaku instanceof AutoStopR2LDanmaku) {
                AutoStopR2LDanmaku autoStopR2LDanmaku = (AutoStopR2LDanmaku) baseDanmaku;
                if (!autoStopR2LDanmaku.isStopped()) {
                    return checkHitAtTime(iDisplayer, baseDanmaku, baseDanmaku2, j) || checkHitAtTimeForUniform(iDisplayer, baseDanmaku, baseDanmaku2, j, autoStopR2LDanmaku.getStopDurationTime() + j);
                }
            }
            return checkHitAtTime(iDisplayer, baseDanmaku, baseDanmaku2, j);
        }
        return false;
    }
}
