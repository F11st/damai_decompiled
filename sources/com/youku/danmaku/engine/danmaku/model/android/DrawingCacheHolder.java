package com.youku.danmaku.engine.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.lang.reflect.Array;
import tv.cjump.jni.NativeBitmapFactory;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DrawingCacheHolder {
    public Bitmap bitmap;
    public Bitmap[][] bitmapArray;
    public Canvas canvas;
    public boolean drawn;
    public Object extra;
    public int height;
    private int mDensity;
    public int width;

    private void eraseBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
    }

    private void eraseBitmapArray() {
        if (this.bitmapArray != null) {
            for (int i = 0; i < this.bitmapArray.length; i++) {
                int i2 = 0;
                while (true) {
                    Bitmap[][] bitmapArr = this.bitmapArray;
                    if (i2 < bitmapArr[i].length) {
                        eraseBitmap(bitmapArr[i][i2]);
                        i2++;
                    }
                }
            }
        }
    }

    private void recycleBitmapArray() {
        Bitmap[][] bitmapArr = this.bitmapArray;
        this.bitmapArray = null;
        if (bitmapArr != null) {
            for (int i = 0; i < bitmapArr.length; i++) {
                for (int i2 = 0; i2 < bitmapArr[i].length; i2++) {
                    if (bitmapArr[i][i2] != null) {
                        bitmapArr[i][i2].recycle();
                        bitmapArr[i][i2] = null;
                    }
                }
            }
        }
    }

    public void buildCache(int i, int i2, int i3, boolean z, int i4) {
        Bitmap bitmap;
        boolean z2 = true;
        if (!z ? i > this.width || i2 > this.height : i != this.width || i2 != this.height) {
            z2 = false;
        }
        if (z2 && (bitmap = this.bitmap) != null) {
            bitmap.eraseColor(0);
            this.canvas.setBitmap(this.bitmap);
            recycleBitmapArray();
            return;
        }
        if (this.bitmap != null) {
            recycle();
        }
        this.width = i;
        this.height = i2;
        Bitmap.Config config = Bitmap.Config.ARGB_4444;
        if (i4 == 32) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap a = NativeBitmapFactory.a(i, i2, config);
        this.bitmap = a;
        if (i3 > 0) {
            this.mDensity = i3;
            a.setDensity(i3);
        }
        Canvas canvas = this.canvas;
        if (canvas == null) {
            Canvas canvas2 = new Canvas(this.bitmap);
            this.canvas = canvas2;
            canvas2.setDensity(i3);
            return;
        }
        canvas.setBitmap(this.bitmap);
    }

    public final synchronized boolean draw(Canvas canvas, float f, float f2, Paint paint) {
        if (this.bitmapArray != null) {
            for (int i = 0; i < this.bitmapArray.length; i++) {
                int i2 = 0;
                while (true) {
                    Bitmap[][] bitmapArr = this.bitmapArray;
                    if (i2 < bitmapArr[i].length) {
                        Bitmap bitmap = bitmapArr[i][i2];
                        if (bitmap != null) {
                            float width = (bitmap.getWidth() * i2) + f;
                            if (width <= canvas.getWidth() && bitmap.getWidth() + width >= 0.0f) {
                                float height = (bitmap.getHeight() * i) + f2;
                                if (height <= canvas.getHeight() && bitmap.getHeight() + height >= 0.0f) {
                                    canvas.drawBitmap(bitmap, width, height, paint);
                                }
                            }
                        }
                        i2++;
                    }
                }
            }
            return true;
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, f, f2, paint);
            return true;
        }
        return false;
    }

    public void erase() {
        eraseBitmap(this.bitmap);
        eraseBitmapArray();
    }

    public synchronized void recycle() {
        Bitmap bitmap = this.bitmap;
        this.bitmap = null;
        this.height = 0;
        this.width = 0;
        if (bitmap != null) {
            bitmap.recycle();
        }
        recycleBitmapArray();
        this.extra = null;
    }

    @SuppressLint({"NewApi"})
    public void splitWith(int i, int i2, int i3, int i4) {
        int i5;
        recycleBitmapArray();
        int i6 = this.width;
        if (i6 <= 0 || (i5 = this.height) <= 0 || this.bitmap == null) {
            return;
        }
        if (i6 > i3 || i5 > i4) {
            int min = Math.min(i3, i);
            int min2 = Math.min(i4, i2);
            int i7 = this.width;
            int i8 = (i7 / min) + (i7 % min == 0 ? 0 : 1);
            int i9 = this.height;
            int i10 = (i9 / min2) + (i9 % min2 == 0 ? 0 : 1);
            int i11 = i7 / i8;
            int i12 = i9 / i10;
            Bitmap[][] bitmapArr = (Bitmap[][]) Array.newInstance(Bitmap.class, i10, i8);
            if (this.canvas == null) {
                Canvas canvas = new Canvas();
                this.canvas = canvas;
                int i13 = this.mDensity;
                if (i13 > 0) {
                    canvas.setDensity(i13);
                }
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            for (int i14 = 0; i14 < i10; i14++) {
                for (int i15 = 0; i15 < i8; i15++) {
                    Bitmap[] bitmapArr2 = bitmapArr[i14];
                    Bitmap a = NativeBitmapFactory.a(i11, i12, Bitmap.Config.ARGB_8888);
                    bitmapArr2[i15] = a;
                    int i16 = this.mDensity;
                    if (i16 > 0) {
                        a.setDensity(i16);
                    }
                    this.canvas.setBitmap(a);
                    int i17 = i15 * i11;
                    int i18 = i14 * i12;
                    rect.set(i17, i18, i17 + i11, i18 + i12);
                    rect2.set(0, 0, a.getWidth(), a.getHeight());
                    this.canvas.drawBitmap(this.bitmap, rect, rect2, (Paint) null);
                }
            }
            this.canvas.setBitmap(this.bitmap);
            this.bitmapArray = bitmapArr;
        }
    }
}
