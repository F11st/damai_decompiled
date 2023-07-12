package cn.damai.user.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import cn.damai.homepage.R$attr;
import cn.damai.homepage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.di2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class HighlightView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    public static final int MOVE = 32;
    RectF a;
    Rect b;
    Matrix c;
    private RectF d;
    private View h;
    private boolean i;
    private boolean j;
    private int k;
    private boolean n;
    private float o;
    private float p;
    private float q;
    private boolean r;
    private final Paint e = new Paint();
    private final Paint f = new Paint();
    private final Paint g = new Paint();
    private ModifyMode l = ModifyMode.None;
    private HandleMode m = HandleMode.Changing;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum HandleMode {
        Changing,
        Always,
        Never
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view) {
        this.h = view;
        m(view.getContext());
    }

    private Rect a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321634746")) {
            return (Rect) ipChange.ipc$dispatch("321634746", new Object[]{this});
        }
        RectF rectF = this.a;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.c.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    private float b(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1508248761") ? ((Float) ipChange.ipc$dispatch("-1508248761", new Object[]{this, Float.valueOf(f)})).floatValue() : f * this.h.getResources().getDisplayMetrics().density;
    }

    private void d(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "487363233")) {
            ipChange.ipc$dispatch("487363233", new Object[]{this, canvas});
            return;
        }
        this.f.setStrokeWidth(1.0f);
        canvas.drawOval(new RectF(this.b), this.f);
    }

    private void e(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147132474")) {
            ipChange.ipc$dispatch("1147132474", new Object[]{this, canvas});
            return;
        }
        Rect rect = this.b;
        int i = rect.left;
        int i2 = ((rect.right - i) / 2) + i;
        int i3 = rect.top;
        int i4 = i3 + ((rect.bottom - i3) / 2);
        float f = i;
        float f2 = i4;
        canvas.drawCircle(f, f2, this.p, this.g);
        float f3 = i2;
        canvas.drawCircle(f3, this.b.top, this.p, this.g);
        canvas.drawCircle(this.b.right, f2, this.p, this.g);
        canvas.drawCircle(f3, this.b.bottom, this.p, this.g);
    }

    private void f(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233840022")) {
            ipChange.ipc$dispatch("233840022", new Object[]{this, canvas});
            return;
        }
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), this.b.top, this.e);
        canvas.drawRect(0.0f, this.b.bottom, canvas.getWidth(), canvas.getHeight(), this.e);
        Rect rect = this.b;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.e);
        Rect rect2 = this.b;
        canvas.drawRect(rect2.right, rect2.top, canvas.getWidth(), this.b.bottom, this.e);
    }

    private void g(Canvas canvas) {
        Rect rect;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530624957")) {
            ipChange.ipc$dispatch("1530624957", new Object[]{this, canvas});
            return;
        }
        this.f.setStrokeWidth(1.0f);
        Rect rect2 = this.b;
        int i = rect2.right;
        int i2 = rect2.left;
        float f = (i - i2) / 3;
        int i3 = rect2.bottom;
        int i4 = rect2.top;
        float f2 = (i3 - i4) / 3;
        canvas.drawLine(i2 + f, i4, i2 + f, i3, this.f);
        int i5 = this.b.left;
        float f3 = f * 2.0f;
        canvas.drawLine(i5 + f3, rect.top, i5 + f3, rect.bottom, this.f);
        Rect rect3 = this.b;
        float f4 = rect3.left;
        int i6 = rect3.top;
        canvas.drawLine(f4, i6 + f2, rect3.right, i6 + f2, this.f);
        Rect rect4 = this.b;
        float f5 = rect4.left;
        int i7 = rect4.top;
        float f6 = f2 * 2.0f;
        canvas.drawLine(f5, i7 + f6, rect4.right, i7 + f6, this.f);
    }

    private void m(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636774686")) {
            ipChange.ipc$dispatch("-636774686", new Object[]{this, context});
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.cropImageStyle, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, R$styleable.CropImageView);
        try {
            this.i = obtainStyledAttributes.getBoolean(R$styleable.CropImageView_showThirds, false);
            this.j = obtainStyledAttributes.getBoolean(R$styleable.CropImageView_showCircle, false);
            this.k = obtainStyledAttributes.getColor(R$styleable.CropImageView_highlightColor, di2.holoBlueLight);
            this.m = HandleMode.values()[obtainStyledAttributes.getInt(R$styleable.CropImageView_showHandles, 0)];
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"NewApi"})
    private boolean o(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411863142")) {
            return ((Boolean) ipChange.ipc$dispatch("1411863142", new Object[]{this, canvas})).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        if (i == 17) {
            return false;
        }
        if (i < 14 || i > 15) {
            return true;
        }
        return !canvas.isHardwareAccelerated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881335921")) {
            ipChange.ipc$dispatch("881335921", new Object[]{this, canvas});
            return;
        }
        canvas.save();
        Path path = new Path();
        this.f.setStrokeWidth(this.q);
        if (!l()) {
            this.f.setColor(-16777216);
            canvas.drawRect(this.b, this.f);
            return;
        }
        Rect rect = new Rect();
        this.h.getDrawingRect(rect);
        path.addRect(new RectF(this.b), Path.Direction.CW);
        this.f.setColor(this.k);
        if (o(canvas)) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, this.e);
        } else {
            f(canvas);
        }
        canvas.restore();
        canvas.drawPath(path, this.f);
        if (this.i) {
            g(canvas);
        }
        if (this.j) {
            d(canvas);
        }
        HandleMode handleMode = this.m;
        if (handleMode == HandleMode.Always || (handleMode == HandleMode.Changing && this.l == ModifyMode.Grow)) {
            e(canvas);
        }
    }

    public int h(float f, float f2) {
        IpChange ipChange = $ipChange;
        int i = 3;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "898862126")) {
            return ((Integer) ipChange.ipc$dispatch("898862126", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)})).intValue();
        }
        Rect a = a();
        boolean z2 = f2 >= ((float) a.top) - 20.0f && f2 < ((float) a.bottom) + 20.0f;
        int i2 = a.left;
        if (f >= i2 - 20.0f && f < a.right + 20.0f) {
            z = true;
        }
        i = (Math.abs(((float) i2) - f) >= 20.0f || !z2) ? 1 : 1;
        if (Math.abs(a.right - f) < 20.0f && z2) {
            i |= 4;
        }
        if (Math.abs(a.top - f2) < 20.0f && z) {
            i |= 8;
        }
        if (Math.abs(a.bottom - f2) < 20.0f && z) {
            i |= 16;
        }
        if (i == 1 && a.contains((int) f, (int) f2)) {
            return 32;
        }
        return i;
    }

    public Rect i(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058153157")) {
            return (Rect) ipChange.ipc$dispatch("-1058153157", new Object[]{this, Float.valueOf(f)});
        }
        RectF rectF = this.a;
        return new Rect((int) (rectF.left * f), (int) (rectF.top * f), (int) (rectF.right * f), (int) (rectF.bottom * f));
    }

    void j(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010528018")) {
            ipChange.ipc$dispatch("-1010528018", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        if (this.n) {
            if (f != 0.0f) {
                f2 = f / this.o;
            } else if (f2 != 0.0f) {
                f = this.o * f2;
            }
        }
        RectF rectF = new RectF(this.a);
        if (f > 0.0f && rectF.width() + (f * 2.0f) > this.d.width()) {
            f = (this.d.width() - rectF.width()) / 2.0f;
            if (this.n) {
                f2 = f / this.o;
            }
        }
        if (f2 > 0.0f && rectF.height() + (f2 * 2.0f) > this.d.height()) {
            f2 = (this.d.height() - rectF.height()) / 2.0f;
            if (this.n) {
                f = this.o * f2;
            }
        }
        rectF.inset(-f, -f2);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        float f3 = this.n ? 25.0f / this.o : 25.0f;
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        float f4 = rectF.left;
        RectF rectF2 = this.d;
        float f5 = rectF2.left;
        if (f4 < f5) {
            rectF.offset(f5 - f4, 0.0f);
        } else {
            float f6 = rectF.right;
            float f7 = rectF2.right;
            if (f6 > f7) {
                rectF.offset(-(f6 - f7), 0.0f);
            }
        }
        float f8 = rectF.top;
        RectF rectF3 = this.d;
        float f9 = rectF3.top;
        if (f8 < f9) {
            rectF.offset(0.0f, f9 - f8);
        } else {
            float f10 = rectF.bottom;
            float f11 = rectF3.bottom;
            if (f10 > f11) {
                rectF.offset(0.0f, -(f10 - f11));
            }
        }
        this.a.set(rectF);
        this.b = a();
        this.h.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791348599")) {
            ipChange.ipc$dispatch("-791348599", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        Rect a = a();
        if (i == 32) {
            p(f * (this.a.width() / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(a)), f2 * (this.a.height() / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(a)));
            return;
        }
        if ((i & 6) == 0) {
            f = 0.0f;
        }
        if ((i & 24) == 0) {
            f2 = 0.0f;
        }
        j(((i & 2) != 0 ? -1 : 1) * f * (this.a.width() / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(a)), ((i & 8) != 0 ? -1 : 1) * f2 * (this.a.height() / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(a)));
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1174419298") ? ((Boolean) ipChange.ipc$dispatch("-1174419298", new Object[]{this})).booleanValue() : this.r;
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585608157")) {
            ipChange.ipc$dispatch("585608157", new Object[]{this});
        } else {
            this.b = a();
        }
    }

    void p(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609111920")) {
            ipChange.ipc$dispatch("609111920", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        Rect rect = new Rect(this.b);
        this.a.offset(f, f2);
        RectF rectF = this.a;
        rectF.offset(Math.max(0.0f, this.d.left - rectF.left), Math.max(0.0f, this.d.top - this.a.top));
        RectF rectF2 = this.a;
        rectF2.offset(Math.min(0.0f, this.d.right - rectF2.right), Math.min(0.0f, this.d.bottom - this.a.bottom));
        Rect a = a();
        this.b = a;
        rect.union(a);
        float f3 = this.p;
        rect.inset(-((int) f3), -((int) f3));
        this.h.invalidate(rect);
    }

    public void q(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578311346")) {
            ipChange.ipc$dispatch("578311346", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.r = z;
        }
    }

    public void r(ModifyMode modifyMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648887530")) {
            ipChange.ipc$dispatch("-648887530", new Object[]{this, modifyMode});
        } else if (modifyMode != this.l) {
            this.l = modifyMode;
            this.h.invalidate();
        }
    }

    public void s(Matrix matrix, Rect rect, RectF rectF, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739309809")) {
            ipChange.ipc$dispatch("739309809", new Object[]{this, matrix, rect, rectF, Boolean.valueOf(z)});
            return;
        }
        this.c = new Matrix(matrix);
        this.a = rectF;
        this.d = new RectF(rect);
        this.n = z;
        this.o = this.a.width() / this.a.height();
        this.b = a();
        this.e.setARGB(125, 50, 50, 50);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setAntiAlias(true);
        this.q = b(2.0f);
        this.g.setColor(this.k);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
        this.p = b(12.0f);
        this.l = ModifyMode.None;
    }
}
