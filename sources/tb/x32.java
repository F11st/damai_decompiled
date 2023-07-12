package tb;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class x32 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private Paint c;
    private RectF d;
    private RectF e;
    private Path f;
    private Path g;
    private Xfermode h;
    private boolean i;
    private float[] j;
    private float[] k;
    private int l;
    private int m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948564299")) {
            ipChange.ipc$dispatch("1948564299", new Object[]{this});
            return;
        }
        float[] fArr = this.j;
        float f = this.p;
        float f2 = this.o;
        float f3 = f - f2;
        fArr[1] = f3;
        fArr[0] = f3;
        float f4 = this.q;
        float f5 = f4 - f2;
        fArr[3] = f5;
        fArr[2] = f5;
        float f6 = this.s;
        float f7 = f6 - f2;
        fArr[5] = f7;
        fArr[4] = f7;
        float f8 = this.r;
        float f9 = f8 - f2;
        fArr[7] = f9;
        fArr[6] = f9;
        float[] fArr2 = this.k;
        fArr2[1] = f;
        fArr2[0] = f;
        fArr2[3] = f4;
        fArr2[2] = f4;
        fArr2[5] = f6;
        fArr2[4] = f6;
        fArr2[7] = f8;
        fArr2[6] = f8;
    }

    public void a(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319822723")) {
            ipChange.ipc$dispatch("1319822723", new Object[]{this, canvas});
            return;
        }
        this.c.reset();
        this.f.reset();
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setXfermode(this.h);
        this.f.addRoundRect(this.d, this.j, Path.Direction.CCW);
        if (Build.VERSION.SDK_INT >= 19) {
            this.g.reset();
            this.g.addRect(this.d, Path.Direction.CCW);
            this.g.op(this.f, Path.Op.DIFFERENCE);
            canvas.drawPath(this.g, this.c);
        } else {
            canvas.drawPath(this.f, this.c);
        }
        this.c.setXfermode(null);
        canvas.restore();
        if (this.o > 0.0f) {
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeWidth(this.o);
            this.c.setColor(this.n);
            this.f.reset();
            this.f.addRoundRect(this.e, this.k, Path.Direction.CCW);
            canvas.drawPath(this.f, this.c);
        }
    }

    public void b(Context context, AttributeSet attributeSet, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1747637967")) {
            ipChange.ipc$dispatch("-1747637967", new Object[]{this, context, attributeSet, view});
            return;
        }
        if ((view instanceof ViewGroup) && view.getBackground() == null) {
            view.setBackgroundColor(Color.parseColor("#00000000"));
        }
        this.a = context;
        this.b = view;
        this.j = new float[8];
        this.k = new float[8];
        this.c = new Paint();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new Path();
        this.g = new Path();
        this.h = new PorterDuffXfermode(Build.VERSION.SDK_INT >= 19 ? PorterDuff.Mode.DST_OUT : PorterDuff.Mode.DST_IN);
        this.n = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundCorner);
        if (obtainStyledAttributes == null) {
            return;
        }
        float dimension = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rLeftRadius, dimension);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rRightRadius, dimension);
        float dimension4 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rTopRadius, dimension);
        float dimension5 = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rBottomRadius, dimension);
        int i = (dimension4 > 0.0f ? 1 : (dimension4 == 0.0f ? 0 : -1));
        this.p = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rTopLeftRadius, i > 0 ? dimension4 : dimension2);
        int i2 = R$styleable.RoundCorner_rTopRightRadius;
        if (i <= 0) {
            dimension4 = dimension3;
        }
        this.q = obtainStyledAttributes.getDimension(i2, dimension4);
        int i3 = R$styleable.RoundCorner_rBottomLeftRadius;
        int i4 = (dimension5 > 0.0f ? 1 : (dimension5 == 0.0f ? 0 : -1));
        if (i4 > 0) {
            dimension2 = dimension5;
        }
        this.r = obtainStyledAttributes.getDimension(i3, dimension2);
        int i5 = R$styleable.RoundCorner_rBottomRightRadius;
        if (i4 > 0) {
            dimension3 = dimension5;
        }
        this.s = obtainStyledAttributes.getDimension(i5, dimension3);
        this.o = obtainStyledAttributes.getDimension(R$styleable.RoundCorner_rStrokeWidth, 0.0f);
        this.n = obtainStyledAttributes.getColor(R$styleable.RoundCorner_rStrokeColor, this.n);
        obtainStyledAttributes.recycle();
        if (this.i) {
            return;
        }
        e();
    }

    public void c(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-835226773")) {
            ipChange.ipc$dispatch("-835226773", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.l = i;
        this.m = i2;
        if (this.i) {
            float min = ((Math.min(i2, i) * 1.0f) / 2.0f) - this.o;
            this.p = min;
            this.q = min;
            this.s = min;
            this.r = min;
            e();
        }
        RectF rectF = this.d;
        if (rectF != null) {
            rectF.set(0.0f, 0.0f, i, i2);
        }
        RectF rectF2 = this.e;
        if (rectF2 != null) {
            float f = this.o;
            rectF2.set(f / 2.0f, f / 2.0f, i - (f / 2.0f), i2 - (f / 2.0f));
        }
    }

    public void d(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197657197")) {
            ipChange.ipc$dispatch("197657197", new Object[]{this, canvas});
            return;
        }
        canvas.saveLayer(this.d, null, 31);
        float f = this.o;
        if (f > 0.0f) {
            int i = this.l;
            int i2 = this.m;
            canvas.scale((i - (f * 2.0f)) / i, (i2 - (f * 2.0f)) / i2, i / 2.0f, i2 / 2.0f);
        }
    }

    public void f(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "275977685")) {
            ipChange.ipc$dispatch("275977685", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        float a = s60.INSTANCE.a(context, f);
        this.p = a;
        this.q = a;
        this.r = a;
        this.s = a;
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void g(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110183371")) {
            ipChange.ipc$dispatch("1110183371", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        s60 s60Var = s60.INSTANCE;
        this.p = s60Var.a(context, f);
        this.q = s60Var.a(this.a, f2);
        this.r = s60Var.a(this.a, f3);
        this.s = s60Var.a(this.a, f4);
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void h(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005260512")) {
            ipChange.ipc$dispatch("-2005260512", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        float a = s60.INSTANCE.a(context, f);
        this.r = a;
        this.s = a;
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void i(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345236295")) {
            ipChange.ipc$dispatch("1345236295", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.r = s60.INSTANCE.a(context, f);
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void j(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-212591662")) {
            ipChange.ipc$dispatch("-212591662", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.s = s60.INSTANCE.a(context, f);
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void k(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073166716")) {
            ipChange.ipc$dispatch("1073166716", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        float a = s60.INSTANCE.a(context, f);
        this.p = a;
        this.r = a;
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void l(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-56814019")) {
            ipChange.ipc$dispatch("-56814019", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        float a = s60.INSTANCE.a(context, f);
        this.q = a;
        this.s = a;
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void m(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577638282")) {
            ipChange.ipc$dispatch("-1577638282", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        float a = s60.INSTANCE.a(context, f);
        this.p = a;
        this.q = a;
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void n(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506808221")) {
            ipChange.ipc$dispatch("1506808221", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.p = s60.INSTANCE.a(context, f);
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void o(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "501170748")) {
            ipChange.ipc$dispatch("501170748", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.q = s60.INSTANCE.a(context, f);
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void p(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102169503")) {
            ipChange.ipc$dispatch("-102169503", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.n = i;
        View view = this.b;
        if (view != null) {
            view.invalidate();
        }
    }

    public void q(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2134635007")) {
            ipChange.ipc$dispatch("-2134635007", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.o = s60.INSTANCE.a(context, f);
        if (this.b != null) {
            e();
            c(this.l, this.m);
            this.b.invalidate();
        }
    }

    public void r(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1273238187")) {
            ipChange.ipc$dispatch("1273238187", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.o = s60.INSTANCE.a(context, f);
        this.n = i;
        if (this.b != null) {
            e();
            c(this.l, this.m);
            this.b.invalidate();
        }
    }

    public void s(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493540372")) {
            ipChange.ipc$dispatch("-1493540372", new Object[]{this, Integer.valueOf(i)});
        } else if (this.a == null) {
        } else {
            this.o = i;
            if (this.b != null) {
                e();
                c(this.l, this.m);
                this.b.invalidate();
            }
        }
    }
}
