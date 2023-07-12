package com.youku.opengl.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class d {
    private static final int a = (int) a(70.0f);
    private static final int b = (int) a(2.0f);

    private static float a(float f) {
        return f * (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static Bitmap a(Bitmap bitmap, String str, int i, int i2) {
        return a(bitmap, str, i, i2, Paint.Align.LEFT, Typeface.MONOSPACE);
    }

    public static Bitmap a(Bitmap bitmap, String str, int i, int i2, Paint.Align align, Typeface typeface) {
        if (a.b) {
            a.a("YkGLTextUtils", "drawText() - target:" + bitmap + " text:" + str + " textColor:" + i + " textSize:" + i2 + " align:" + align + " typeface:" + typeface);
        }
        if (TextUtils.isEmpty(str) || typeface == null) {
            a.b("YkGLTextUtils", "drawText() - no text or TypeFace");
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(i);
        textPaint.setTextSize(i2);
        textPaint.setTypeface(typeface);
        textPaint.setTextAlign(Paint.Align.LEFT);
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        if (a.b) {
            a.a("YkGLTextUtils", "drawText() - text bounds:" + rect);
        }
        rect.set(0, 0, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) + a, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) + b);
        if (a.b) {
            a.a("YkGLTextUtils", "drawText() - new text bounds:" + rect);
        }
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        int i3 = (((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2;
        if (a.b) {
            a.a("YkGLTextUtils", "drawText() - baseline:" + i3);
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect), Bitmap.Config.ARGB_8888);
        }
        bitmap.eraseColor(0);
        new Canvas(bitmap).drawText(str, 0.0f, i3, textPaint);
        return bitmap;
    }
}
