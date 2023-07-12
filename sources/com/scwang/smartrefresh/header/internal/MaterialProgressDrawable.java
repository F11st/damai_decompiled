package com.scwang.smartrefresh.header.internal;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    public static final byte DEFAULT = 1;
    public static final byte LARGE = 0;
    private static final Interpolator j = new LinearInterpolator();
    static final Interpolator k = new FastOutSlowInInterpolator();
    private static final int[] l = {-16777216};
    private final List<Animation> a = new ArrayList();
    private final b b = new b(this);
    private float c;
    private View d;
    private Animation e;
    float f;
    private float g;
    private float h;
    boolean i;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements Animation.AnimationListener {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.a.j();
            this.a.f();
            b bVar = this.a;
            bVar.d = bVar.e;
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.i) {
                materialProgressDrawable.i = false;
                animation.setDuration(1332L);
                MaterialProgressDrawable.this.l(false);
                return;
            }
            materialProgressDrawable.f = (materialProgressDrawable.f + 1.0f) % 5.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MaterialProgressDrawable.this.f = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b {
        final RectF a = new RectF();
        final Paint b;
        final Paint c;
        float d;
        float e;
        float f;
        float g;
        float h;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p;
        double q;
        int r;
        int s;
        int t;
        final Paint u;
        int v;
        int w;

        b(MaterialProgressDrawable materialProgressDrawable) {
            Paint paint = new Paint();
            this.b = paint;
            Paint paint2 = new Paint();
            this.c = paint2;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 5.0f;
            this.h = 2.5f;
            this.u = new Paint(1);
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        private void b(Canvas canvas, float f, float f2, Rect rect) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.h) / 2) * this.p;
                float sin = (float) ((this.q * Math.sin(0.0d)) + rect.exactCenterY());
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path3 = this.o;
                float f4 = this.p;
                path3.lineTo((this.r * f4) / 2.0f, this.s * f4);
                this.o.offset(((float) ((this.q * Math.cos(0.0d)) + rect.exactCenterX())) - f3, sin);
                this.o.close();
                this.c.setColor(this.w);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.o, this.c);
            }
        }

        private int d() {
            return (this.j + 1) % this.i.length;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            rectF.set(rect);
            float f = this.h;
            rectF.inset(f, f);
            float f2 = this.d;
            float f3 = this.f;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.e + f3) * 360.0f) - f4;
            if (f5 != 0.0f) {
                this.b.setColor(this.w);
                canvas.drawArc(rectF, f4, f5, false, this.b);
            }
            b(canvas, f4, f5, rect);
            if (this.t < 255) {
                this.u.setColor(this.v);
                this.u.setAlpha(255 - this.t);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) / 2, this.u);
            }
        }

        public int c() {
            return this.i[d()];
        }

        public int e() {
            return this.i[this.j];
        }

        public void f() {
            h(d());
        }

        public void g() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
        }

        public void h(int i) {
            this.j = i;
            this.w = this.i[i];
        }

        public void i(int i, int i2) {
            float min = Math.min(i, i2);
            double d = this.q;
            this.h = (float) ((d <= 0.0d || min < 0.0f) ? Math.ceil(this.g / 2.0f) : (min / 2.0f) - d);
        }

        public void j() {
            this.k = this.d;
            this.l = this.e;
            this.m = this.f;
        }
    }

    public MaterialProgressDrawable(View view) {
        this.d = view;
        f(l);
        n(1);
        k();
    }

    private int b(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        int i6 = intValue & 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return ((i3 + ((int) ((((intValue2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((intValue2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((intValue2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((intValue2 & 255) - i6))));
    }

    private void i(int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        this.g = i * f5;
        this.h = i2 * f5;
        this.b.h(0);
        float f6 = f2 * f5;
        this.b.b.setStrokeWidth(f6);
        b bVar = this.b;
        bVar.g = f6;
        bVar.q = f * f5;
        bVar.r = (int) (f3 * f5);
        bVar.s = (int) (f4 * f5);
        bVar.i((int) this.g, (int) this.h);
        invalidateSelf();
    }

    private void k() {
        final b bVar = this.b;
        Animation animation = new Animation() { // from class: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                if (materialProgressDrawable.i) {
                    materialProgressDrawable.a(f, bVar);
                    return;
                }
                float c = materialProgressDrawable.c(bVar);
                b bVar2 = bVar;
                float f2 = bVar2.l;
                float f3 = bVar2.k;
                float f4 = bVar2.m;
                MaterialProgressDrawable.this.m(f, bVar2);
                if (f <= 0.5f) {
                    bVar.d = f3 + ((0.8f - c) * MaterialProgressDrawable.k.getInterpolation(f / 0.5f));
                }
                if (f > 0.5f) {
                    bVar.e = f2 + ((0.8f - c) * MaterialProgressDrawable.k.getInterpolation((f - 0.5f) / 0.5f));
                }
                MaterialProgressDrawable.this.g(f4 + (0.25f * f));
                MaterialProgressDrawable materialProgressDrawable2 = MaterialProgressDrawable.this;
                materialProgressDrawable2.h((f * 216.0f) + ((materialProgressDrawable2.f / 5.0f) * 1080.0f));
            }
        };
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setInterpolator(j);
        animation.setAnimationListener(new a(bVar));
        this.e = animation;
    }

    void a(float f, b bVar) {
        m(f, bVar);
        float c = c(bVar);
        float f2 = bVar.k;
        float f3 = bVar.l;
        j(f2 + (((f3 - c) - f2) * f), f3);
        float f4 = bVar.m;
        g(f4 + ((((float) (Math.floor(bVar.m / 0.8f) + 1.0d)) - f4) * f));
    }

    float c(b bVar) {
        return (float) Math.toRadians(bVar.g / (bVar.q * 6.283185307179586d));
    }

    public void d(float f) {
        b bVar = this.b;
        if (bVar.p != f) {
            bVar.p = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.c, bounds.exactCenterX(), bounds.exactCenterY());
        this.b.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void e(@ColorInt int i) {
        this.b.v = i;
    }

    public void f(int... iArr) {
        b bVar = this.b;
        bVar.i = iArr;
        bVar.h(0);
    }

    public void g(float f) {
        this.b.f = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b.t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    void h(float f) {
        this.c = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        List<Animation> list = this.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animation animation = list.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void j(float f, float f2) {
        b bVar = this.b;
        bVar.d = f;
        bVar.e = f2;
        invalidateSelf();
    }

    public void l(boolean z) {
        b bVar = this.b;
        if (bVar.n != z) {
            bVar.n = z;
            invalidateSelf();
        }
    }

    void m(float f, b bVar) {
        if (f > 0.75f) {
            bVar.w = b((f - 0.75f) / 0.25f, bVar.e(), bVar.c());
        }
    }

    public void n(int i) {
        if (i == 0) {
            i(56, 56, 12.5f, 3.0f, 12.0f, 6.0f);
        } else {
            i(40, 40, 8.75f, 2.5f, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.t = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.e.reset();
        this.b.j();
        b bVar = this.b;
        if (bVar.e != bVar.d) {
            this.i = true;
            this.e.setDuration(666L);
            this.d.startAnimation(this.e);
            return;
        }
        bVar.h(0);
        this.b.g();
        this.e.setDuration(1332L);
        this.d.startAnimation(this.e);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.d.clearAnimation();
        this.b.h(0);
        this.b.g();
        l(false);
        h(0.0f);
    }
}
