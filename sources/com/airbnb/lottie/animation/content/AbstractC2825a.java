package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2848b;
import com.airbnb.lottie.animation.keyframe.C2850d;
import com.airbnb.lottie.animation.keyframe.C2860n;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.ArrayList;
import java.util.List;
import tb.aw2;
import tb.eg1;
import tb.f81;
import tb.g81;
import tb.k5;
import tb.lc1;
import tb.m5;
import tb.s71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.a */
/* loaded from: classes9.dex */
public abstract class AbstractC2825a implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    private final LottieDrawable e;
    protected final AbstractC2872a f;
    private final float[] h;
    final Paint i;
    private final BaseKeyframeAnimation<?, Float> j;
    private final BaseKeyframeAnimation<?, Integer> k;
    private final List<BaseKeyframeAnimation<?, Float>> l;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> m;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> n;
    private final PathMeasure a = new PathMeasure();
    private final Path b = new Path();
    private final Path c = new Path();
    private final RectF d = new RectF();
    private final List<C2827b> g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.animation.content.a$b */
    /* loaded from: classes17.dex */
    public static final class C2827b {
        private final List<PathContent> a;
        @Nullable
        private final C2842n b;

        private C2827b(@Nullable C2842n c2842n) {
            this.a = new ArrayList();
            this.b = c2842n;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2825a(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, Paint.Cap cap, Paint.Join join, float f, m5 m5Var, k5 k5Var, List<k5> list, k5 k5Var2) {
        g81 g81Var = new g81(1);
        this.i = g81Var;
        this.e = lottieDrawable;
        this.f = abstractC2872a;
        g81Var.setStyle(Paint.Style.STROKE);
        g81Var.setStrokeCap(cap);
        g81Var.setStrokeJoin(join);
        g81Var.setStrokeMiter(f);
        this.k = m5Var.createAnimation();
        this.j = k5Var.createAnimation();
        if (k5Var2 == null) {
            this.m = null;
        } else {
            this.m = k5Var2.createAnimation();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).createAnimation());
        }
        abstractC2872a.c(this.k);
        abstractC2872a.c(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            abstractC2872a.c(this.l.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
        if (baseKeyframeAnimation != null) {
            abstractC2872a.c(baseKeyframeAnimation);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(this);
        }
    }

    private void a(Matrix matrix) {
        f81.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            f81.b("StrokeContent#applyDashPattern");
            return;
        }
        float g = aw2.g(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = this.l.get(i).h().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.h;
            fArr3[i] = fArr3[i] * g;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, baseKeyframeAnimation == null ? 0.0f : g * baseKeyframeAnimation.h().floatValue()));
        f81.b("StrokeContent#applyDashPattern");
    }

    private void b(Canvas canvas, C2827b c2827b, Matrix matrix) {
        f81.a("StrokeContent#applyTrimPath");
        if (c2827b.b == null) {
            f81.b("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int size = c2827b.a.size() - 1; size >= 0; size--) {
            this.b.addPath(((PathContent) c2827b.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float floatValue = (c2827b.b.c().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((c2827b.b.d().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((c2827b.b.b().h().floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = c2827b.a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((PathContent) c2827b.a.get(size2)).getPath());
            this.c.transform(matrix);
            this.a.setPath(this.c, false);
            float length2 = this.a.getLength();
            if (floatValue3 > length) {
                float f2 = floatValue3 - length;
                if (f2 < f + length2 && f < f2) {
                    aw2.a(this.c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f2 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.i);
                    f += length2;
                }
            }
            float f3 = f + length2;
            if (f3 >= floatValue2 && f <= floatValue3) {
                if (f3 <= floatValue3 && floatValue2 < f) {
                    canvas.drawPath(this.c, this.i);
                } else {
                    aw2.a(this.c, floatValue2 < f ? 0.0f : (floatValue2 - f) / length2, floatValue3 <= f3 ? (floatValue3 - f) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.c, this.i);
                }
            }
            f += length2;
        }
        f81.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        if (t == LottieProperty.OPACITY) {
            this.k.n(lc1Var);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            this.j.n(lc1Var);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.n;
            if (baseKeyframeAnimation != null) {
                this.f.w(baseKeyframeAnimation);
            }
            if (lc1Var == null) {
                this.n = null;
                return;
            }
            C2860n c2860n = new C2860n(lc1Var);
            this.n = c2860n;
            c2860n.a(this);
            this.f.c(this.n);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        f81.a("StrokeContent#draw");
        if (aw2.h(matrix)) {
            f81.b("StrokeContent#draw");
            return;
        }
        this.i.setAlpha(eg1.d((int) ((((i / 255.0f) * ((C2850d) this.k).p()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((C2848b) this.j).p() * aw2.g(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            f81.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.n;
        if (baseKeyframeAnimation != null) {
            this.i.setColorFilter(baseKeyframeAnimation.h());
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            C2827b c2827b = this.g.get(i2);
            if (c2827b.b != null) {
                b(canvas, c2827b, matrix);
            } else {
                f81.a("StrokeContent#buildPath");
                this.b.reset();
                for (int size = c2827b.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((PathContent) c2827b.a.get(size)).getPath(), matrix);
                }
                f81.b("StrokeContent#buildPath");
                f81.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.i);
                f81.b("StrokeContent#drawPath");
            }
        }
        f81.b("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        f81.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            C2827b c2827b = this.g.get(i);
            for (int i2 = 0; i2 < c2827b.a.size(); i2++) {
                this.b.addPath(((PathContent) c2827b.a.get(i2)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float p = ((C2848b) this.j).p();
        RectF rectF2 = this.d;
        float f = p / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        f81.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        eg1.m(s71Var, i, list, s71Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        C2842n c2842n = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof C2842n) {
                C2842n c2842n2 = (C2842n) content;
                if (c2842n2.e() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    c2842n = c2842n2;
                }
            }
        }
        if (c2842n != null) {
            c2842n.a(this);
        }
        C2827b c2827b = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof C2842n) {
                C2842n c2842n3 = (C2842n) content2;
                if (c2842n3.e() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (c2827b != null) {
                        this.g.add(c2827b);
                    }
                    c2827b = new C2827b(c2842n3);
                    c2842n3.a(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (c2827b == null) {
                    c2827b = new C2827b(c2842n);
                }
                c2827b.a.add((PathContent) content2);
            }
        }
        if (c2827b != null) {
            this.g.add(c2827b);
        }
    }
}
