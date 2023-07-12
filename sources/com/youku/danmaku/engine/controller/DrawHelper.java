package com.youku.danmaku.engine.controller;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DrawHelper {
    public static Paint PAINT = null;
    public static Paint PAINT_FPS = null;
    public static RectF RECT = null;
    private static boolean USE_DRAWCOLOR_MODE_CLEAR = true;
    private static boolean USE_DRAWCOLOR_TO_CLEAR_CANVAS = true;

    static {
        Paint paint = new Paint();
        PAINT = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        PAINT.setColor(0);
        RECT = new RectF();
    }

    public static void clearCanvas(Canvas canvas) {
        if (USE_DRAWCOLOR_TO_CLEAR_CANVAS) {
            if (USE_DRAWCOLOR_MODE_CLEAR) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        RECT.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        clearCanvas(canvas, RECT);
    }

    public static void drawFPS(Canvas canvas, String str) {
        if (PAINT_FPS == null) {
            Paint paint = new Paint();
            PAINT_FPS = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            PAINT_FPS.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        float measureText = PAINT_FPS.measureText(str) + 20.0f;
        clearCanvas(canvas, canvas.getWidth() - measureText, height - 50, (int) measureText, canvas.getHeight());
        canvas.drawText(str, canvas.getWidth() - measureText, height, PAINT_FPS);
    }

    public static void fillTransparent(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public static void useDrawColorToClearCanvas(boolean z, boolean z2) {
        USE_DRAWCOLOR_TO_CLEAR_CANVAS = z;
        USE_DRAWCOLOR_MODE_CLEAR = z2;
    }

    public static void clearCanvas(Canvas canvas, float f, float f2, float f3, float f4) {
        RECT.set(f, f2, f3, f4);
        clearCanvas(canvas, RECT);
    }

    private static void clearCanvas(Canvas canvas, RectF rectF) {
        if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            return;
        }
        canvas.drawRect(rectF, PAINT);
    }
}
