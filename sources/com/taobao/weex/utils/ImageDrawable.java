package com.taobao.weex.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageDrawable extends PaintDrawable {
    private float[] a;
    private int b;
    private int c;

    private ImageDrawable() {
    }

    @NonNull
    private static Matrix a(@NonNull ImageView.ScaleType scaleType, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        if (i3 * i2 > i4 * i) {
            f = i2 / i4;
            f3 = (i - (i3 * f)) * 0.5f;
            f2 = 0.0f;
        } else {
            f = i / i3;
            f2 = (i2 - (i4 * f)) * 0.5f;
            f3 = 0.0f;
        }
        Matrix matrix = new Matrix();
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            matrix.setScale(i / i3, i2 / i4);
        } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, i3, i4), new RectF(0.0f, 0.0f, i, i2), Matrix.ScaleToFit.CENTER);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            matrix.setScale(f, f);
            matrix.postTranslate(f3 + 0.5f, f2 + 0.5f);
        }
        return matrix;
    }

    private static void b(@NonNull ImageView.ScaleType scaleType, int i, int i2, ImageDrawable imageDrawable, BitmapShader bitmapShader) {
        Matrix a = a(scaleType, i, i2, imageDrawable.c, imageDrawable.b);
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            RectF rectF = new RectF(0.0f, 0.0f, imageDrawable.c, imageDrawable.b);
            RectF rectF2 = new RectF();
            a.mapRect(rectF2, rectF);
            i = (int) rectF2.width();
            i2 = (int) rectF2.height();
            a = a(scaleType, i, i2, imageDrawable.c, imageDrawable.b);
        }
        imageDrawable.setIntrinsicWidth(i);
        imageDrawable.setIntrinsicHeight(i2);
        bitmapShader.setLocalMatrix(a);
    }

    public static Drawable createImageDrawable(@Nullable Drawable drawable, @NonNull ImageView.ScaleType scaleType, @Nullable float[] fArr, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z && i > 0 && i2 > 0) {
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                ImageDrawable imageDrawable = new ImageDrawable();
                imageDrawable.getPaint().setFilterBitmap(true);
                imageDrawable.c = bitmap.getWidth();
                imageDrawable.b = bitmap.getHeight();
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                b(scaleType, i, i2, imageDrawable, bitmapShader);
                imageDrawable.getPaint().setShader(bitmapShader);
                return imageDrawable;
            } else if (drawable instanceof ImageDrawable) {
                ImageDrawable imageDrawable2 = (ImageDrawable) drawable;
                if (imageDrawable2.getPaint() != null && (imageDrawable2.getPaint().getShader() instanceof BitmapShader)) {
                    b(scaleType, i, i2, imageDrawable2, (BitmapShader) imageDrawable2.getPaint().getShader());
                    return imageDrawable2;
                }
            }
        }
        return drawable;
    }

    public int getBitmapHeight() {
        return this.b;
    }

    public int getBitmapWidth() {
        return this.c;
    }

    @Nullable
    public float[] getCornerRadii() {
        return this.a;
    }

    @Override // android.graphics.drawable.ShapeDrawable
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        if (Build.VERSION.SDK_INT == 21) {
            paint.setAntiAlias(false);
        }
        super.onDraw(shape, canvas, paint);
    }

    @Override // android.graphics.drawable.PaintDrawable
    public void setCornerRadii(float[] fArr) {
        this.a = fArr;
        super.setCornerRadii(fArr);
    }
}
