package com.youku.resource.utils;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CircleBorderBitmapProcessor implements BitmapProcessor {
    private final ColorStateList mBorderColor;
    private final float mBorderWidth;

    public CircleBorderBitmapProcessor() {
        this(0.0f, ColorStateList.valueOf(-16777216));
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        return ExifInterface.LONGITUDE_WEST + this.mBorderWidth + "$C" + this.mBorderColor;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (min - bitmap.getWidth()) / 2;
        int height = (min - bitmap.getHeight()) / 2;
        float f = min / 2.0f;
        float f2 = f - this.mBorderWidth;
        int i = (int) (f * 2.0f);
        Bitmap bitmap2 = bitmapSupplier.get(i, i, bitmap.getConfig() != null ? bitmap.getConfig() : PexodeOptions.CONFIG);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        if (width != 0 || height != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(width, height);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        canvas.drawCircle(f, f, f2, paint);
        if (this.mBorderWidth > 0.0f) {
            Path path = new Path();
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            paint2.setColor(this.mBorderColor.getDefaultColor());
            paint2.setStrokeWidth(this.mBorderWidth);
            path.addCircle(f, f, f - (this.mBorderWidth / 2.0f), Path.Direction.CCW);
            canvas.drawPath(path, paint2);
        }
        return bitmap2;
    }

    public CircleBorderBitmapProcessor(float f, ColorStateList colorStateList) {
        this.mBorderWidth = f;
        this.mBorderColor = colorStateList;
    }
}
