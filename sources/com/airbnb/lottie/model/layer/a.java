package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.m;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.aw2;
import tb.f81;
import tb.g81;
import tb.id1;
import tb.jb2;
import tb.kb1;
import tb.lc1;
import tb.s71;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class a implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final Path a = new Path();
    private final Matrix b = new Matrix();
    private final Paint c = new g81(1);
    private final Paint d = new g81(1, PorterDuff.Mode.DST_IN);
    private final Paint e = new g81(1, PorterDuff.Mode.DST_OUT);
    private final Paint f;
    private final Paint g;
    private final RectF h;
    private final RectF i;
    private final RectF j;
    private final RectF k;
    private final String l;
    final Matrix m;
    final LottieDrawable n;
    final Layer o;
    @Nullable
    private id1 p;
    @Nullable
    private com.airbnb.lottie.animation.keyframe.b q;
    @Nullable
    private a r;
    @Nullable
    private a s;
    private List<a> t;
    private final List<BaseKeyframeAnimation<?, ?>> u;
    final m v;
    private boolean w;
    private boolean x;
    @Nullable
    private Paint y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.model.layer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0102a implements BaseKeyframeAnimation.AnimationListener {
        C0102a() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
        public void onValueChanged() {
            a aVar = a.this;
            aVar.C(aVar.q.p() == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LottieDrawable lottieDrawable, Layer layer) {
        g81 g81Var = new g81(1);
        this.f = g81Var;
        this.g = new g81(PorterDuff.Mode.CLEAR);
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.n = lottieDrawable;
        this.o = layer;
        this.l = layer.g() + "#draw";
        if (layer.f() == Layer.MatteType.INVERT) {
            g81Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            g81Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        m a = layer.u().a();
        this.v = a;
        a.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            id1 id1Var = new id1(layer.e());
            this.p = id1Var;
            for (BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation : id1Var.a()) {
                baseKeyframeAnimation.a(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 : this.p.c()) {
                c(baseKeyframeAnimation2);
                baseKeyframeAnimation2.a(this);
            }
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z) {
        if (z != this.w) {
            this.w = z;
            u();
        }
    }

    private void D() {
        if (!this.o.c().isEmpty()) {
            com.airbnb.lottie.animation.keyframe.b bVar = new com.airbnb.lottie.animation.keyframe.b(this.o.c());
            this.q = bVar;
            bVar.l();
            this.q.a(new C0102a());
            C(this.q.h().floatValue() == 1.0f);
            c(this.q);
            return;
        }
        C(true);
    }

    private void d(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
    }

    private void e(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        aw2.m(canvas, this.h, this.d);
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    private void f(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        aw2.m(canvas, this.h, this.c);
        canvas.drawRect(this.h, this.c);
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void g(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        aw2.m(canvas, this.h, this.d);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void h(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        aw2.m(canvas, this.h, this.e);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void i(Canvas canvas, Matrix matrix) {
        f81.a("Layer#saveLayer");
        aw2.n(canvas, this.h, this.d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            m(canvas);
        }
        f81.b("Layer#saveLayer");
        for (int i = 0; i < this.p.b().size(); i++) {
            Mask mask = this.p.b().get(i);
            BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation = this.p.a().get(i);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.p.c().get(i);
            int i2 = b.b[mask.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.c.setColor(-16777216);
                        this.c.setAlpha(255);
                        canvas.drawRect(this.h, this.c);
                    }
                    if (mask.d()) {
                        h(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        j(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (mask.d()) {
                            f(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            d(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.d()) {
                    g(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    e(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (k()) {
                this.c.setAlpha(255);
                canvas.drawRect(this.h, this.c);
            }
        }
        f81.a("Layer#restoreLayer");
        canvas.restore();
        f81.b("Layer#restoreLayer");
    }

    private void j(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<jb2, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.a.set(baseKeyframeAnimation.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
    }

    private boolean k() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.p.b().size(); i++) {
            if (this.p.b().get(i).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void l() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (a aVar = this.s; aVar != null; aVar = aVar.s) {
            this.t.add(aVar);
        }
    }

    private void m(Canvas canvas) {
        f81.a("Layer#clearLayer");
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        f81.b("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a o(Layer layer, LottieDrawable lottieDrawable, com.airbnb.lottie.a aVar) {
        switch (b.a[layer.d().ordinal()]) {
            case 1:
                return new e(lottieDrawable, layer);
            case 2:
                return new com.airbnb.lottie.model.layer.b(lottieDrawable, layer, aVar.n(layer.k()), aVar);
            case 3:
                return new f(lottieDrawable, layer);
            case 4:
                return new c(lottieDrawable, layer);
            case 5:
                return new d(lottieDrawable, layer);
            case 6:
                return new g(lottieDrawable, layer);
            default:
                kb1.c("Unknown layer type " + layer.d());
                return null;
        }
    }

    private void s(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (q()) {
            int size = this.p.b().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.p.b().get(i);
                this.a.set(this.p.a().get(i).h());
                this.a.transform(matrix);
                int i2 = b.b[mask.a().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                if ((i2 == 3 || i2 == 4) && mask.d()) {
                    return;
                }
                this.a.computeBounds(this.k, false);
                if (i == 0) {
                    this.i.set(this.k);
                } else {
                    RectF rectF2 = this.i;
                    rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                }
            }
            if (rectF.intersect(this.i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void t(RectF rectF, Matrix matrix) {
        if (r() && this.o.f() != Layer.MatteType.INVERT) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.getBounds(this.j, matrix, true);
            if (rectF.intersect(this.j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void u() {
        this.n.invalidateSelf();
    }

    private void v(float f) {
        this.n.getComposition().m().a(this.o.g(), f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(@Nullable a aVar) {
        this.s = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.v.j(f);
        if (this.p != null) {
            for (int i = 0; i < this.p.a().size(); i++) {
                this.p.a().get(i).m(f);
            }
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        com.airbnb.lottie.animation.keyframe.b bVar = this.q;
        if (bVar != null) {
            bVar.m(f / this.o.t());
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.B(aVar.o.t() * f);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).m(f);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        this.v.c(t, lc1Var);
    }

    public void c(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.u.add(baseKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        f81.a(this.l);
        if (this.w && !this.o.v()) {
            l();
            f81.a("Layer#parentMatrix");
            this.b.reset();
            this.b.set(matrix);
            for (int size = this.t.size() - 1; size >= 0; size--) {
                this.b.preConcat(this.t.get(size).v.f());
            }
            f81.b("Layer#parentMatrix");
            int intValue = (int) ((((i / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
            if (!r() && !q()) {
                this.b.preConcat(this.v.f());
                f81.a("Layer#drawLayer");
                n(canvas, this.b, intValue);
                f81.b("Layer#drawLayer");
                v(f81.b(this.l));
                return;
            }
            f81.a("Layer#computeBounds");
            getBounds(this.h, this.b, false);
            t(this.h, matrix);
            this.b.preConcat(this.v.f());
            s(this.h, this.b);
            if (!this.h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            f81.b("Layer#computeBounds");
            if (this.h.width() >= 1.0f && this.h.height() >= 1.0f) {
                f81.a("Layer#saveLayer");
                this.c.setAlpha(255);
                aw2.m(canvas, this.h, this.c);
                f81.b("Layer#saveLayer");
                m(canvas);
                f81.a("Layer#drawLayer");
                n(canvas, this.b, intValue);
                f81.b("Layer#drawLayer");
                if (q()) {
                    i(canvas, this.b);
                }
                if (r()) {
                    f81.a("Layer#drawMatte");
                    f81.a("Layer#saveLayer");
                    aw2.n(canvas, this.h, this.f, 19);
                    f81.b("Layer#saveLayer");
                    m(canvas);
                    this.r.draw(canvas, matrix, intValue);
                    f81.a("Layer#restoreLayer");
                    canvas.restore();
                    f81.b("Layer#restoreLayer");
                    f81.b("Layer#drawMatte");
                }
                f81.a("Layer#restoreLayer");
                canvas.restore();
                f81.b("Layer#restoreLayer");
            }
            if (this.x && (paint = this.y) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.y.setColor(-251901);
                this.y.setStrokeWidth(4.0f);
                canvas.drawRect(this.h, this.y);
                this.y.setStyle(Paint.Style.FILL);
                this.y.setColor(1357638635);
                canvas.drawRect(this.h, this.y);
            }
            v(f81.b(this.l));
            return;
        }
        f81.b(this.l);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    @CallSuper
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        l();
        this.m.set(matrix);
        if (z) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.f());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.m.preConcat(aVar.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.o.g();
    }

    abstract void n(Canvas canvas, Matrix matrix, int i);

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer p() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        id1 id1Var = this.p;
        return (id1Var == null || id1Var.a().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.r != null;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        a aVar = this.r;
        if (aVar != null) {
            s71 a = s71Var2.a(aVar.getName());
            if (s71Var.c(this.r.getName(), i)) {
                list.add(a.i(this.r));
            }
            if (s71Var.h(getName(), i)) {
                this.r.x(s71Var, s71Var.e(this.r.getName(), i) + i, list, a);
            }
        }
        if (s71Var.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                s71Var2 = s71Var2.a(getName());
                if (s71Var.c(getName(), i)) {
                    list.add(s71Var2.i(this));
                }
            }
            if (s71Var.h(getName(), i)) {
                x(s71Var, i + s71Var.e(getName(), i), list, s71Var2);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }

    public void w(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.u.remove(baseKeyframeAnimation);
    }

    void x(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(@Nullable a aVar) {
        this.r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z) {
        if (z && this.y == null) {
            this.y = new g81();
        }
        this.x = z;
    }
}
