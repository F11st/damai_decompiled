package tb;

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
import android.view.ViewOutlineProvider;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class te {
    private float a;
    private float b;
    private float c;
    private float d;
    private Paint e;
    private Paint f;
    private boolean g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.te$a */
    /* loaded from: classes11.dex */
    public class C9715a extends ViewOutlineProvider {
        final /* synthetic */ int a;

        C9715a(te teVar, int i) {
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
    /* renamed from: tb.te$b */
    /* loaded from: classes11.dex */
    public class C9716b extends ViewOutlineProvider {
        final /* synthetic */ int a;

        C9716b(te teVar, int i) {
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
    /* renamed from: tb.te$c */
    /* loaded from: classes11.dex */
    public class C9717c extends ViewOutlineProvider {
        final /* synthetic */ int a;

        C9717c(te teVar, int i) {
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
    /* renamed from: tb.te$d */
    /* loaded from: classes11.dex */
    public class C9718d extends ViewOutlineProvider {
        final /* synthetic */ int a;

        C9718d(te teVar, int i) {
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
    /* renamed from: tb.te$e */
    /* loaded from: classes11.dex */
    public class C9719e extends ViewOutlineProvider {
        final /* synthetic */ int a;

        C9719e(te teVar, int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        @SuppressLint({"NewApi"})
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth() + this.a, view.getHeight(), this.a);
            outline.offset(-this.a, 0);
        }
    }

    private void c(View view, Canvas canvas) {
        if (this.c > 0.0f) {
            int height = view.getHeight();
            Path path = new Path();
            float f = height;
            path.moveTo(0.0f, f - this.c);
            path.lineTo(0.0f, f);
            path.lineTo(this.c, f);
            float f2 = this.c;
            path.arcTo(new RectF(0.0f, f - (f2 * 2.0f), f2 * 2.0f, f), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void d(View view, Canvas canvas) {
        if (this.d > 0.0f) {
            int height = view.getHeight();
            int width = view.getWidth();
            Path path = new Path();
            float f = width;
            float f2 = height;
            path.moveTo(f - this.d, f2);
            path.lineTo(f, f2);
            path.lineTo(f, f2 - this.d);
            float f3 = this.d;
            path.arcTo(new RectF(f - (f3 * 2.0f), f2 - (f3 * 2.0f), f, f2), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void e(View view, Canvas canvas) {
        if (this.a > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.a);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.a, 0.0f);
            float f = this.a;
            path.arcTo(new RectF(0.0f, 0.0f, f * 2.0f, f * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void f(View view, Canvas canvas) {
        if (this.b > 0.0f) {
            int width = view.getWidth();
            Path path = new Path();
            float f = width;
            path.moveTo(f - this.b, 0.0f);
            path.lineTo(f, 0.0f);
            path.lineTo(f, this.b);
            float f2 = this.b;
            path.arcTo(new RectF(f - (f2 * 2.0f), 0.0f, f, f2 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    private void i(View view) {
        if (g()) {
            float f = this.a;
            float f2 = this.b;
            if (f == f2) {
                float f3 = this.c;
                if (f == f3 && f3 == this.d) {
                    view.setOutlineProvider(new C9715a(this, (int) f));
                    view.setClipToOutline(true);
                    this.g = true;
                    return;
                }
            }
            if (f == f2 && this.c == 0.0f && this.d == 0.0f) {
                view.setOutlineProvider(new C9716b(this, (int) f));
                view.setClipToOutline(true);
                this.g = true;
                return;
            }
            float f4 = this.c;
            float f5 = this.d;
            if (f4 == f5 && f == 0.0f && f2 == 0.0f) {
                view.setOutlineProvider(new C9717c(this, (int) f4));
                view.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f == f4 && f2 == 0.0f && f5 == 0.0f) {
                view.setOutlineProvider(new C9718d(this, (int) f));
                view.setClipToOutline(true);
                this.g = true;
                return;
            } else if (f2 == f5 && f == 0.0f && f4 == 0.0f) {
                view.setOutlineProvider(new C9719e(this, (int) f2));
                view.setClipToOutline(true);
                this.g = true;
                return;
            }
        }
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(-1);
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setXfermode(null);
    }

    public void a(View view, Canvas canvas) {
        e(view, canvas);
        f(view, canvas);
        c(view, canvas);
        d(view, canvas);
        canvas.restore();
    }

    public void b(View view, Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f, 31);
    }

    public boolean g() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public boolean h() {
        return this.g;
    }

    public void j(View view, float f) {
        k(view, f, f, f, f);
    }

    public void k(View view, float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        i(view);
    }
}
