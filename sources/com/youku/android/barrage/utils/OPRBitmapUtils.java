package com.youku.android.barrage.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.youku.android.barrage.OPRBarrageBitmap;
import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
@Keep
/* loaded from: classes7.dex */
public class OPRBitmapUtils {
    private static final float STROKE_WIDTH = 0.5f;
    private static final String TAG = "OPR_v2_OPRBitmapUtils";

    private static Bitmap drawText(String str, int i, int i2, String str2, boolean z, int i3, int i4) {
        LinearGradient linearGradient;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        float f = i2;
        textPaint.setTextSize(f);
        textPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
            typeface = Typeface.createFromFile(str2);
        }
        textPaint.setTypeface(typeface);
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        int i5 = rect.left;
        int i6 = rect.top;
        int i7 = rect.right;
        int i8 = rect.bottom;
        int measureText = (int) textPaint.measureText(str);
        int i9 = (int) (fontMetrics.bottom - fontMetrics.top);
        if (measureText <= 0 || i9 <= 0) {
            Log.e(TAG, "text: " + str + "w/h error: " + measureText + " x " + i9);
            if (measureText <= 0) {
                measureText = 1;
            }
            if (i9 <= 0) {
                i9 = 1;
            }
        }
        int[] iArr = {i3, i4};
        if (z) {
            linearGradient = new LinearGradient(i5, i6, i7, i8, iArr, (float[]) null, Shader.TileMode.CLAMP);
        } else {
            textPaint.setColor(i);
            linearGradient = null;
        }
        textPaint.setShader(linearGradient);
        Bitmap createBitmap = Bitmap.createBitmap(measureText, i9, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        float f2 = fontMetrics.descent;
        float abs = (((Math.abs(fontMetrics.ascent) + f2) / 2.0f) - f2) + (i9 / 2);
        Paint paint = new Paint();
        paint.setFakeBoldText(true);
        paint.setColor(-16777216);
        paint.setTextSize(f);
        paint.setTypeface(typeface);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0.5f);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawText(str, 0.0f, abs, paint);
        canvas.drawText(str, 0.0f, abs, textPaint);
        return createBitmap;
    }

    public static byte[] getBitmapDataQuick(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static OPRBarrageBitmap getOPRBarrageBitmap(String str, int i, int i2, String str2, boolean z, int i3, int i4) {
        OPRBarrageBitmap oPRBarrageBitmap = new OPRBarrageBitmap();
        Bitmap drawText = drawText(str, i, i2, str2, z, i3, i4);
        oPRBarrageBitmap.data = getBitmapDataQuick(drawText);
        oPRBarrageBitmap.width = drawText.getWidth();
        oPRBarrageBitmap.height = drawText.getHeight();
        drawText.recycle();
        return oPRBarrageBitmap;
    }
}
