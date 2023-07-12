package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* compiled from: Taobao */
/* renamed from: com.tencent.connect.avatar.c */
/* loaded from: classes11.dex */
public class C7052c extends ImageView {
    final String a;
    public boolean b;
    private Matrix c;
    private Matrix d;
    private int e;
    private float f;
    private float g;
    private Bitmap h;
    private boolean i;
    private float j;
    private float k;
    private PointF l;
    private PointF m;
    private float n;
    private float o;
    private Rect p;

    public C7052c(Context context) {
        super(context);
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.a = "TouchView";
        this.l = new PointF();
        this.m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        Rect rect = new Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        ScaleAnimation scaleAnimation;
        if (this.h == null) {
            return;
        }
        float width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.p);
        float height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.p);
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = this.f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.o = f5;
            Matrix matrix = this.c;
            PointF pointF = this.m;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.c);
            float f6 = this.o;
            float f7 = 1.0f / f6;
            float f8 = 1.0f / f6;
            PointF pointF2 = this.m;
            scaleAnimation = new ScaleAnimation(f7, 1.0f, f8, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f9 = this.g;
            if (f3 < f9) {
                float f10 = f9 / f3;
                this.o = f10;
                Matrix matrix2 = this.c;
                PointF pointF3 = this.m;
                matrix2.postScale(f10, f10, pointF3.x, pointF3.y);
                float f11 = this.o;
                PointF pointF4 = this.m;
                scaleAnimation = new ScaleAnimation(1.0f, f11, 1.0f, f11, pointF4.x, pointF4.y);
            } else {
                float width2 = this.h.getWidth() * f3;
                float height2 = this.h.getHeight() * f3;
                Rect rect = this.p;
                int i = rect.left;
                float f12 = i - f;
                int i2 = rect.top;
                float f13 = i2 - f2;
                if (f12 < 0.0f) {
                    f = i;
                    z = true;
                } else {
                    z = false;
                }
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                }
                float f14 = height2 - f13;
                if (width2 - f12 < width) {
                    f = i - (width2 - width);
                    z = true;
                }
                if (f14 < height) {
                    f2 = i2 - (height2 - height);
                    z = true;
                }
                if (z) {
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.c.setValues(fArr);
                    setImageMatrix(this.c);
                    scaleAnimation = new TranslateAnimation(fArr[2] - f, 0.0f, fArr[5] - f2, 0.0f);
                } else {
                    setImageMatrix(this.c);
                    scaleAnimation = null;
                }
            }
        }
        if (scaleAnimation != null) {
            this.i = true;
            scaleAnimation.setDuration(300L);
            startAnimation(scaleAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    C7052c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C7052c.this.clearAnimation();
                            C7052c.this.b();
                        }
                    });
                    C7052c.this.i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        this.c.getValues(r0);
        float max = Math.max(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.p) / this.h.getWidth(), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.p) / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * max) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.p)) / 2.0f);
        float height = this.p.top - (((this.h.getHeight() * max) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.p)) / 2.0f);
        this.k = height;
        float[] fArr = {max, 0.0f, this.j, 0.0f, max, height};
        this.c.setValues(fArr);
        float min = Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.f = min;
        this.g = max;
        if (min < max) {
            this.f = max;
        }
        setImageMatrix(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r0 != 6) goto L14;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L90
            if (r0 == r1) goto L89
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L37
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L89
            goto Laf
        L1d:
            float r6 = r5.a(r6)
            r5.n = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.d
            android.graphics.Matrix r0 = r5.c
            r6.set(r0)
            android.graphics.PointF r6 = r5.m
            r5.a(r6)
            r5.e = r3
            goto Laf
        L37:
            int r0 = r5.e
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.c
            android.graphics.Matrix r2 = r5.d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.c
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.c
            r0.set(r0)
            float r6 = r5.a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.c
            android.graphics.Matrix r2 = r5.d
            r0.set(r2)
            float r0 = r5.n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.c
            android.graphics.PointF r2 = r5.m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.c
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.b()
            r6 = 0
            r5.e = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.d
            android.graphics.Matrix r2 = r5.c
            r0.set(r2)
            android.graphics.PointF r0 = r5.l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.e = r1
        Laf:
            r5.b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.C7052c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth() * f3;
        float height = this.h.getHeight() * f3;
        Rect rect = this.p;
        float f4 = rect.left - f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f5 = (f + width) - rect.right;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float width2 = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) * f4) / (f5 + f4);
        Rect rect2 = this.p;
        float f6 = width2 + rect2.left;
        float f7 = rect2.top - f2;
        float f8 = (f2 + height) - rect2.bottom;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        pointF.set(f6, ((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) * f7) / ((f8 > 1.0f ? f8 : 1.0f) + f7)) + this.p.top);
    }
}
