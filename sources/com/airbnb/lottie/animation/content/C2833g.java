package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2860n;
import com.airbnb.lottie.model.content.C2871a;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import tb.lc1;
import tb.qu0;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.g */
/* loaded from: classes9.dex */
public class C2833g extends AbstractC2825a {
    private final String o;
    private final boolean p;
    private final LongSparseArray<LinearGradient> q;
    private final LongSparseArray<RadialGradient> r;
    private final RectF s;
    private final GradientType t;
    private final int u;
    private final BaseKeyframeAnimation<qu0, qu0> v;
    private final BaseKeyframeAnimation<PointF, PointF> w;
    private final BaseKeyframeAnimation<PointF, PointF> x;
    @Nullable
    private C2860n y;

    public C2833g(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, C2871a c2871a) {
        super(lottieDrawable, abstractC2872a, c2871a.a().toPaintCap(), c2871a.f().toPaintJoin(), c2871a.h(), c2871a.j(), c2871a.l(), c2871a.g(), c2871a.b());
        this.q = new LongSparseArray<>();
        this.r = new LongSparseArray<>();
        this.s = new RectF();
        this.o = c2871a.i();
        this.t = c2871a.e();
        this.p = c2871a.m();
        this.u = (int) (lottieDrawable.getComposition().d() / 32.0f);
        BaseKeyframeAnimation<qu0, qu0> createAnimation = c2871a.d().createAnimation();
        this.v = createAnimation;
        createAnimation.a(this);
        abstractC2872a.c(createAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = c2871a.k().createAnimation();
        this.w = createAnimation2;
        createAnimation2.a(this);
        abstractC2872a.c(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = c2871a.c().createAnimation();
        this.x = createAnimation3;
        createAnimation3.a(this);
        abstractC2872a.c(createAnimation3);
    }

    private int[] c(int[] iArr) {
        C2860n c2860n = this.y;
        if (c2860n != null) {
            Integer[] numArr = (Integer[]) c2860n.h();
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

    private int d() {
        int round = Math.round(this.w.f() * this.u);
        int round2 = Math.round(this.x.f() * this.u);
        int round3 = Math.round(this.v.f() * this.u);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private LinearGradient e() {
        long d = d();
        LinearGradient linearGradient = this.q.get(d);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h = this.w.h();
        PointF h2 = this.x.h();
        qu0 h3 = this.v.h();
        LinearGradient linearGradient2 = new LinearGradient(h.x, h.y, h2.x, h2.y, c(h3.a()), h3.b(), Shader.TileMode.CLAMP);
        this.q.put(d, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient f() {
        float f;
        float f2;
        long d = d();
        RadialGradient radialGradient = this.r.get(d);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h = this.w.h();
        PointF h2 = this.x.h();
        qu0 h3 = this.v.h();
        int[] c = c(h3.a());
        float[] b = h3.b();
        RadialGradient radialGradient2 = new RadialGradient(h.x, h.y, (float) Math.hypot(h2.x - f, h2.y - f2), c, b, Shader.TileMode.CLAMP);
        this.r.put(d, radialGradient2);
        return radialGradient2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.AbstractC2825a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        super.addValueCallback(t, lc1Var);
        if (t == LottieProperty.GRADIENT_COLOR) {
            C2860n c2860n = this.y;
            if (c2860n != null) {
                this.f.w(c2860n);
            }
            if (lc1Var == null) {
                this.y = null;
                return;
            }
            C2860n c2860n2 = new C2860n(lc1Var);
            this.y = c2860n2;
            c2860n2.a(this);
            this.f.c(this.y);
        }
    }

    @Override // com.airbnb.lottie.animation.content.AbstractC2825a, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader f;
        if (this.p) {
            return;
        }
        getBounds(this.s, matrix, false);
        if (this.t == GradientType.LINEAR) {
            f = e();
        } else {
            f = f();
        }
        f.setLocalMatrix(matrix);
        this.i.setShader(f);
        super.draw(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.o;
    }
}
