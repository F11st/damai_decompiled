package com.alibaba.aliweex.adapter.module.blur;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
class b {
    private float a;
    private float b = 1.0f;
    private float c = 1.0f;
    @NonNull
    private final BlurAlgorithm d;

    private b(@NonNull BlurAlgorithm blurAlgorithm) {
        this.a = 8.0f;
        this.d = blurAlgorithm;
        this.a = 8.0f;
    }

    @Nullable
    private Bitmap a(@NonNull View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight > 0 && measuredWidth > 0) {
            int d = d(measuredWidth);
            int d2 = d(measuredHeight);
            int f = f(d);
            int f2 = f(d2);
            this.c = d2 / f2;
            this.b = d / f;
            try {
                return Bitmap.createBitmap(f, f2, this.d.getSupportedBitmapConfig());
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b(@NonNull BlurAlgorithm blurAlgorithm) {
        return new b(blurAlgorithm);
    }

    private int d(float f) {
        return (int) Math.ceil(f / this.a);
    }

    @Nullable
    private Bitmap e(@NonNull View view, @ColorInt int i) {
        Bitmap a = a(view);
        if (a == null) {
            return null;
        }
        Canvas canvas = new Canvas(a);
        canvas.save();
        float f = this.a;
        canvas.scale(1.0f / (this.b * f), 1.0f / (f * this.c));
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        canvas.drawColor(i);
        canvas.restore();
        return a;
    }

    private int f(int i) {
        int i2 = i % 16;
        return i2 == 0 ? i : (i - i2) + 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @WorkerThread
    public Bitmap c(@NonNull View view, @ColorInt int i, int i2) {
        Bitmap bitmap;
        try {
            bitmap = e(view, i);
        } catch (Exception e) {
            WXLogUtils.e("WXBlurEXModule", e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            return this.d.blur(bitmap, i2);
        }
        return null;
    }
}
