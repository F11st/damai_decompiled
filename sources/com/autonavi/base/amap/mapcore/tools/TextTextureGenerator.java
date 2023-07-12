package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.mapcore.util.eq;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    public static int GetNearstSize2N(int i) {
        int i2 = 1;
        while (i > i2) {
            i2 *= 2;
        }
        return i2;
    }

    private void createTextParam() {
        float f;
        int i = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i;
        Paint newPaint = newPaint(null, i, 49);
        this.text_paint = newPaint;
        float f2 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f2;
        float f3 = 7.3242188f;
        try {
            Paint.FontMetrics fontMetrics = newPaint.getFontMetrics();
            f3 = fontMetrics.descent;
            f = fontMetrics.ascent;
        } catch (Exception unused) {
            f = -27.832031f;
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f3 + f)) / 2.0f) + f2 + 0.5f;
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    private static Paint newPaint(String str, int i, int i2) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i2) {
            case 49:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
            case 50:
                textPaint.setTextAlign(Paint.Align.RIGHT);
                break;
            case 51:
                textPaint.setTextAlign(Paint.Align.CENTER);
                break;
            default:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
        }
        return textPaint;
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        for (int i = 0; i < length; i++) {
            Paint paint = this.text_paint;
            fArr[0] = paint.measureText(((char) iArr[i]) + "");
            bArr[i] = (byte) ((int) (fArr[0] + ((float) (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE))));
        }
        return bArr;
    }

    public byte[] getTextPixelBuffer(int i, int i2) {
        if (this.TEXT_FONTSIZE != i2) {
            this.TEXT_FONTSIZE = i2;
            createTextParam();
        }
        try {
            char c = (char) i;
            char[] cArr = {c};
            float f = this.base_line;
            int i3 = this.TEXT_FONTSIZE;
            Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            int i4 = this.TEXT_FONTSIZE;
            byte[] bArr = new byte[i4 * i4];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c));
            if (cArr[0] > 0 && cArr[0] < 256) {
                f -= 1.5f;
            }
            float f2 = f;
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f3 = measureText - this.TEXT_FONTSIZE_TRUE;
            Paint.Align align = Paint.Align.CENTER;
            if (textAlign != align && f3 >= 4.0f) {
                this.text_paint.setTextAlign(align);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f3);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f3) / 2.0f, f2, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            } else {
                canvas.drawText(cArr, 0, 1, this.start_x, f2, this.text_paint);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            eq.b(createBitmap);
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }
}
