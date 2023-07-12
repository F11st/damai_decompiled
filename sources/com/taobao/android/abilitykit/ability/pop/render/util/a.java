package com.taobao.android.abilitykit.ability.pop.render.util;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
class a {
    @Nullable
    private Paint a;
    @Nullable
    private Paint b;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g = false;
    @NonNull
    private ViewGroup h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.abilitykit.ability.pop.render.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0284a extends ViewOutlineProvider {
        final /* synthetic */ int a;

        C0284a(a aVar, int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b extends ViewOutlineProvider {
        final /* synthetic */ int a;

        b(a aVar, int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, -this.a, view.getWidth(), view.getHeight(), this.a);
            outline.offset(0, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c extends ViewOutlineProvider {
        final /* synthetic */ int a;

        c(a aVar, int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            int width = view.getWidth();
            int height = view.getHeight();
            int i = this.a;
            outline.setRoundRect(0, 0, width, height + i, i);
            outline.offset(0, -this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class d extends ViewOutlineProvider {
        final /* synthetic */ int a;

        d(a aVar, int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(-this.a, 0, view.getWidth(), view.getHeight(), this.a);
            outline.offset(this.a, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class e extends ViewOutlineProvider {
        final /* synthetic */ int a;

        e(a aVar, int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth() + this.a, view.getHeight(), this.a);
            outline.offset(-this.a, 0);
        }
    }

    public a(@NonNull ViewGroup viewGroup) {
        this.h = viewGroup;
    }

    private void b(Canvas canvas) {
        if (this.e <= 0.0f || this.a == null) {
            return;
        }
        int height = this.h.getHeight();
        Path path = new Path();
        float f = height;
        path.moveTo(0.0f, f - this.e);
        path.lineTo(0.0f, f);
        path.lineTo(this.e, f);
        float f2 = this.e;
        path.arcTo(new RectF(0.0f, f - (f2 * 2.0f), f2 * 2.0f, f), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.a);
    }

    private void c(Canvas canvas) {
        if (this.f <= 0.0f || this.a == null) {
            return;
        }
        int height = this.h.getHeight();
        int width = this.h.getWidth();
        Path path = new Path();
        float f = width;
        float f2 = height;
        path.moveTo(f - this.f, f2);
        path.lineTo(f, f2);
        path.lineTo(f, f2 - this.f);
        float f3 = this.f;
        path.arcTo(new RectF(f - (f3 * 2.0f), f2 - (f3 * 2.0f), f, f2), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.a);
    }

    private void d(Canvas canvas) {
        if (this.c <= 0.0f || this.a == null) {
            return;
        }
        Path path = new Path();
        path.moveTo(0.0f, this.c);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.c, 0.0f);
        float f = this.c;
        path.arcTo(new RectF(0.0f, 0.0f, f * 2.0f, f * 2.0f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.a);
    }

    private void e(Canvas canvas) {
        if (this.d <= 0.0f || this.a == null) {
            return;
        }
        int width = this.h.getWidth();
        Path path = new Path();
        float f = width;
        path.moveTo(f - this.d, 0.0f);
        path.lineTo(f, 0.0f);
        path.lineTo(f, this.d);
        float f2 = this.d;
        path.arcTo(new RectF(f - (f2 * 2.0f), 0.0f, f, f2 * 2.0f), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.a);
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 22;
    }

    private void g() {
        if (f()) {
            float f = this.c;
            float f2 = this.d;
            if (f == f2) {
                float f3 = this.e;
                if (f == f3 && f3 == this.f) {
                    this.h.setOutlineProvider(new C0284a(this, (int) f));
                    this.h.setClipToOutline(true);
                    this.g = true;
                    return;
                }
            }
            if (f == f2 && this.e == 0.0f && this.f == 0.0f) {
                this.h.setOutlineProvider(new b(this, (int) f));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            }
            float f4 = this.e;
            float f5 = this.f;
            if (f4 == f5 && f == 0.0f && f2 == 0.0f) {
                this.h.setOutlineProvider(new c(this, (int) f4));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f == f4 && f2 == 0.0f && f5 == 0.0f) {
                this.h.setOutlineProvider(new d(this, (int) f));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f2 == f5 && f == 0.0f && f4 == 0.0f) {
                this.h.setOutlineProvider(new e(this, (int) f2));
                this.h.setClipToOutline(true);
                this.g = true;
                return;
            }
        }
        if (this.a == null) {
            Paint paint = new Paint();
            this.a = paint;
            paint.setColor(-1);
            this.a.setAntiAlias(true);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
        if (this.b == null) {
            Paint paint2 = new Paint();
            this.b = paint2;
            paint2.setXfermode(null);
        }
    }

    public void a(@NonNull Canvas canvas, @NonNull Runnable runnable) {
        if (!this.g && this.b != null && this.a != null) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.b, 31);
            runnable.run();
            d(canvas);
            e(canvas);
            b(canvas);
            c(canvas);
            canvas.restore();
            return;
        }
        runnable.run();
    }

    public void h(float f, float f2, float f3, float f4) {
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
        g();
    }
}
