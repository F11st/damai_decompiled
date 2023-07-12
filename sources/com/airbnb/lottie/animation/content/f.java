package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
import tb.eg1;
import tb.f81;
import tb.g81;
import tb.lc1;
import tb.qu0;
import tb.s71;
import tb.tu0;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class f implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    @NonNull
    private final String a;
    private final boolean b;
    private final com.airbnb.lottie.model.layer.a c;
    private final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    private final Path f;
    private final Paint g;
    private final RectF h;
    private final List<PathContent> i;
    private final GradientType j;
    private final BaseKeyframeAnimation<qu0, qu0> k;
    private final BaseKeyframeAnimation<Integer, Integer> l;
    private final BaseKeyframeAnimation<PointF, PointF> m;
    private final BaseKeyframeAnimation<PointF, PointF> n;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> o;
    @Nullable
    private com.airbnb.lottie.animation.keyframe.n p;
    private final LottieDrawable q;
    private final int r;

    public f(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, tu0 tu0Var) {
        Path path = new Path();
        this.f = path;
        this.g = new g81(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.c = aVar;
        this.a = tu0Var.e();
        this.b = tu0Var.h();
        this.q = lottieDrawable;
        this.j = tu0Var.d();
        path.setFillType(tu0Var.b());
        this.r = (int) (lottieDrawable.getComposition().d() / 32.0f);
        BaseKeyframeAnimation<qu0, qu0> createAnimation = tu0Var.c().createAnimation();
        this.k = createAnimation;
        createAnimation.a(this);
        aVar.c(createAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = tu0Var.f().createAnimation();
        this.l = createAnimation2;
        createAnimation2.a(this);
        aVar.c(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = tu0Var.g().createAnimation();
        this.m = createAnimation3;
        createAnimation3.a(this);
        aVar.c(createAnimation3);
        BaseKeyframeAnimation<PointF, PointF> createAnimation4 = tu0Var.a().createAnimation();
        this.n = createAnimation4;
        createAnimation4.a(this);
        aVar.c(createAnimation4);
    }

    private int[] a(int[] iArr) {
        com.airbnb.lottie.animation.keyframe.n nVar = this.p;
        if (nVar != null) {
            Integer[] numArr = (Integer[]) nVar.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    private int b() {
        int round = Math.round(this.m.f() * this.r);
        int round2 = Math.round(this.n.f() * this.r);
        int round3 = Math.round(this.k.f() * this.r);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private LinearGradient c() {
        long b = b();
        LinearGradient linearGradient = this.d.get(b);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h = this.m.h();
        PointF h2 = this.n.h();
        qu0 h3 = this.k.h();
        LinearGradient linearGradient2 = new LinearGradient(h.x, h.y, h2.x, h2.y, a(h3.a()), h3.b(), Shader.TileMode.CLAMP);
        this.d.put(b, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long b = b();
        RadialGradient radialGradient = this.e.get(b);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h = this.m.h();
        PointF h2 = this.n.h();
        qu0 h3 = this.k.h();
        int[] a = a(h3.a());
        float[] b2 = h3.b();
        float f = h.x;
        float f2 = h.y;
        float hypot = (float) Math.hypot(h2.x - f, h2.y - f2);
        RadialGradient radialGradient2 = new RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, a, b2, Shader.TileMode.CLAMP);
        this.e.put(b, radialGradient2);
        return radialGradient2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        if (t == LottieProperty.OPACITY) {
            this.l.n(lc1Var);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.o;
            if (baseKeyframeAnimation != null) {
                this.c.w(baseKeyframeAnimation);
            }
            if (lc1Var == null) {
                this.o = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.n nVar = new com.airbnb.lottie.animation.keyframe.n(lc1Var);
            this.o = nVar;
            nVar.a(this);
            this.c.c(this.o);
        } else if (t == LottieProperty.GRADIENT_COLOR) {
            com.airbnb.lottie.animation.keyframe.n nVar2 = this.p;
            if (nVar2 != null) {
                this.c.w(nVar2);
            }
            if (lc1Var == null) {
                this.p = null;
                return;
            }
            this.d.clear();
            this.e.clear();
            com.airbnb.lottie.animation.keyframe.n nVar3 = new com.airbnb.lottie.animation.keyframe.n(lc1Var);
            this.p = nVar3;
            nVar3.a(this);
            this.c.c(this.p);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader d;
        if (this.b) {
            return;
        }
        f81.a("GradientFillContent#draw");
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).getPath(), matrix);
        }
        this.f.computeBounds(this.h, false);
        if (this.j == GradientType.LINEAR) {
            d = c();
        } else {
            d = d();
        }
        d.setLocalMatrix(matrix);
        this.g.setShader(d);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.o;
        if (baseKeyframeAnimation != null) {
            this.g.setColorFilter(baseKeyframeAnimation.h());
        }
        this.g.setAlpha(eg1.d((int) ((((i / 255.0f) * this.l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        f81.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        eg1.m(s71Var, i, list, s71Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.i.add((PathContent) content);
            }
        }
    }
}
