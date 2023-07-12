package com.alibaba.security.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GifImageView extends ImageView {
    private static final int b = 1000;
    float a;
    private float c;
    private float d;
    private float e;
    private Movie f;
    private long g;
    private long h;
    private long i;
    private int j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private boolean n;
    private a o;
    private int p;
    private final boolean q;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public GifImageView(Context context) {
        this(context, null);
        setLayerType(1, null);
    }

    private void a(String str, a aVar) {
        Bitmap decodeFile;
        this.f = Movie.decodeFile(str);
        this.o = aVar;
        d();
        if (this.f == null && (decodeFile = BitmapFactory.decodeFile(str)) != null) {
            setImageBitmap(decodeFile);
            return;
        }
        this.p = this.f.duration() == 0 ? 1000 : this.f.duration();
        requestLayout();
    }

    private void b() {
        if (this.f != null) {
            d();
            this.k = true;
            invalidate();
        }
    }

    private void c() {
        this.j = -1;
        d();
        invalidate();
    }

    private void d() {
        this.k = false;
        this.g = SystemClock.uptimeMillis();
        this.l = false;
        this.m = true;
        this.h = 0L;
        this.i = 0L;
    }

    private void e() {
        if (this.f == null) {
            return;
        }
        if (this.m) {
            if (!this.l || this.h <= 0) {
                return;
            }
            this.l = false;
            this.i = (this.i + SystemClock.uptimeMillis()) - this.h;
            invalidate();
            return;
        }
        c();
    }

    private void f() {
        if (this.f == null || this.l || !this.m) {
            return;
        }
        this.l = true;
        invalidate();
        this.h = SystemClock.uptimeMillis();
    }

    private boolean g() {
        return this.l;
    }

    private int getCurrentFrameTime() {
        if (this.p == 0) {
            return 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.i;
        long j = this.g;
        int i = this.p;
        int i2 = (int) ((uptimeMillis - j) / i);
        int i3 = this.j;
        if (i3 != -1 && i2 >= i3) {
            this.m = false;
            return 0;
        }
        float f = (float) ((uptimeMillis - j) % i);
        this.a = f / i;
        if (this.o != null && this.m) {
            new BigDecimal(this.a).setScale(2, 4).doubleValue();
        }
        return (int) f;
    }

    private boolean h() {
        return !this.l && this.m;
    }

    private void i() {
        if (this.n) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    private void setGifResource$4de0f83e(int i) {
        Bitmap decodeResource;
        d();
        Movie decodeStream = Movie.decodeStream(getResources().openRawResource(i));
        this.f = decodeStream;
        if (decodeStream == null && (decodeResource = BitmapFactory.decodeResource(getResources(), i)) != null) {
            setImageBitmap(decodeResource);
            return;
        }
        this.p = this.f.duration() == 0 ? 1000 : this.f.duration();
        requestLayout();
    }

    public int getDuration() {
        Movie movie = this.f;
        if (movie != null) {
            return movie.duration();
        }
        return 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f != null) {
            if (!this.l && this.m) {
                if (this.k) {
                    this.f.setTime(this.p - getCurrentFrameTime());
                } else {
                    this.f.setTime(getCurrentFrameTime());
                }
                a(canvas);
                i();
                return;
            }
            a(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Movie movie = this.f;
        if (movie != null) {
            int width = movie.width();
            int height = this.f.height();
            if (mode == 1073741824) {
                this.c = width / size;
            }
            if (mode2 == 1073741824) {
                this.d = height / size2;
            }
            this.e = Math.max(this.c, this.d);
            if (mode != 1073741824) {
                size = width;
            }
            if (mode2 != 1073741824) {
                size2 = height;
            }
            setMeasuredDimension(size, size2);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        this.n = i == 1;
        i();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.n = i == 0;
        i();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.n = i == 0;
        i();
    }

    public void setGifResource(int i) {
        Bitmap decodeResource;
        d();
        Movie decodeStream = Movie.decodeStream(getResources().openRawResource(i));
        this.f = decodeStream;
        if (decodeStream == null && (decodeResource = BitmapFactory.decodeResource(getResources(), i)) != null) {
            setImageBitmap(decodeResource);
            return;
        }
        this.p = this.f.duration() == 0 ? 1000 : this.f.duration();
        requestLayout();
    }

    public void setPercent(float f) {
        int i;
        Movie movie = this.f;
        if (movie == null || (i = this.p) <= 0) {
            return;
        }
        this.a = f;
        movie.setTime((int) (i * f));
        i();
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        setLayerType(1, null);
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.j = -1;
        this.k = false;
        this.n = true;
        this.q = false;
        setLayerType(1, null);
    }

    private void a() {
        if (this.f != null) {
            c();
        }
    }

    private void a(Canvas canvas) {
        canvas.save();
        float f = this.e;
        canvas.scale(1.0f / f, 1.0f / f);
        this.f.draw(canvas, 0.0f, 0.0f);
        canvas.restore();
    }
}
