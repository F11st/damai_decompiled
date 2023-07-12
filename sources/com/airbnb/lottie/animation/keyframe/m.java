package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.Collections;
import tb.a62;
import tb.lc1;
import tb.u5;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class m {
    private final Matrix a = new Matrix();
    private final Matrix b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e;
    @NonNull
    private BaseKeyframeAnimation<PointF, PointF> f;
    @NonNull
    private BaseKeyframeAnimation<?, PointF> g;
    @NonNull
    private BaseKeyframeAnimation<a62, a62> h;
    @NonNull
    private BaseKeyframeAnimation<Float, Float> i;
    @NonNull
    private BaseKeyframeAnimation<Integer, Integer> j;
    @Nullable
    private b k;
    @Nullable
    private b l;
    @Nullable
    private BaseKeyframeAnimation<?, Float> m;
    @Nullable
    private BaseKeyframeAnimation<?, Float> n;

    public m(u5 u5Var) {
        this.f = u5Var.b() == null ? null : u5Var.b().createAnimation();
        this.g = u5Var.e() == null ? null : u5Var.e().createAnimation();
        this.h = u5Var.g() == null ? null : u5Var.g().createAnimation();
        this.i = u5Var.f() == null ? null : u5Var.f().createAnimation();
        b bVar = u5Var.h() == null ? null : (b) u5Var.h().createAnimation();
        this.k = bVar;
        if (bVar != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = u5Var.i() == null ? null : (b) u5Var.i().createAnimation();
        if (u5Var.d() != null) {
            this.j = u5Var.d().createAnimation();
        }
        if (u5Var.j() != null) {
            this.m = u5Var.j().createAnimation();
        } else {
            this.m = null;
        }
        if (u5Var.c() != null) {
            this.n = u5Var.c().createAnimation();
        } else {
            this.n = null;
        }
    }

    private void d() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.c(this.j);
        aVar.c(this.m);
        aVar.c(this.n);
        aVar.c(this.f);
        aVar.c(this.g);
        aVar.c(this.h);
        aVar.c(this.i);
        aVar.c(this.k);
        aVar.c(this.l);
    }

    public void b(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation<a62, a62> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(animationListener);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.a(animationListener);
        }
    }

    public <T> boolean c(T t, @Nullable lc1<T> lc1Var) {
        b bVar;
        b bVar2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f;
            if (baseKeyframeAnimation3 == null) {
                this.f = new n(lc1Var, new PointF());
                return true;
            }
            baseKeyframeAnimation3.n(lc1Var);
            return true;
        } else if (t == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.g;
            if (baseKeyframeAnimation4 == null) {
                this.g = new n(lc1Var, new PointF());
                return true;
            }
            baseKeyframeAnimation4.n(lc1Var);
            return true;
        } else {
            if (t == LottieProperty.TRANSFORM_POSITION_X) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
                if (baseKeyframeAnimation5 instanceof k) {
                    ((k) baseKeyframeAnimation5).r(lc1Var);
                    return true;
                }
            }
            if (t == LottieProperty.TRANSFORM_POSITION_Y) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation6 = this.g;
                if (baseKeyframeAnimation6 instanceof k) {
                    ((k) baseKeyframeAnimation6).s(lc1Var);
                    return true;
                }
            }
            if (t == LottieProperty.TRANSFORM_SCALE) {
                BaseKeyframeAnimation<a62, a62> baseKeyframeAnimation7 = this.h;
                if (baseKeyframeAnimation7 == null) {
                    this.h = new n(lc1Var, new a62());
                    return true;
                }
                baseKeyframeAnimation7.n(lc1Var);
                return true;
            } else if (t == LottieProperty.TRANSFORM_ROTATION) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation8 = this.i;
                if (baseKeyframeAnimation8 == null) {
                    this.i = new n(lc1Var, Float.valueOf(0.0f));
                    return true;
                }
                baseKeyframeAnimation8.n(lc1Var);
                return true;
            } else if (t == LottieProperty.TRANSFORM_OPACITY) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation9 = this.j;
                if (baseKeyframeAnimation9 == null) {
                    this.j = new n(lc1Var, 100);
                    return true;
                }
                baseKeyframeAnimation9.n(lc1Var);
                return true;
            } else if (t == LottieProperty.TRANSFORM_START_OPACITY && (baseKeyframeAnimation2 = this.m) != null) {
                if (baseKeyframeAnimation2 == null) {
                    this.m = new n(lc1Var, 100);
                    return true;
                }
                baseKeyframeAnimation2.n(lc1Var);
                return true;
            } else if (t == LottieProperty.TRANSFORM_END_OPACITY && (baseKeyframeAnimation = this.n) != null) {
                if (baseKeyframeAnimation == null) {
                    this.n = new n(lc1Var, 100);
                    return true;
                }
                baseKeyframeAnimation.n(lc1Var);
                return true;
            } else if (t == LottieProperty.TRANSFORM_SKEW && (bVar2 = this.k) != null) {
                if (bVar2 == null) {
                    this.k = new b(Collections.singletonList(new u71(Float.valueOf(0.0f))));
                }
                this.k.n(lc1Var);
                return true;
            } else if (t != LottieProperty.TRANSFORM_SKEW_ANGLE || (bVar = this.l) == null) {
                return false;
            } else {
                if (bVar == null) {
                    this.l = new b(Collections.singletonList(new u71(Float.valueOf(0.0f))));
                }
                this.l.n(lc1Var);
                return true;
            }
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        float p;
        this.a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        if (baseKeyframeAnimation != null) {
            PointF h = baseKeyframeAnimation.h();
            float f = h.x;
            if (f != 0.0f || h.y != 0.0f) {
                this.a.preTranslate(f, h.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.i;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof n) {
                p = baseKeyframeAnimation2.h().floatValue();
            } else {
                p = ((b) baseKeyframeAnimation2).p();
            }
            if (p != 0.0f) {
                this.a.preRotate(p);
            }
        }
        if (this.k != null) {
            b bVar = this.l;
            float cos = bVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-bVar.p()) + 90.0f));
            b bVar2 = this.l;
            float sin = bVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-bVar2.p()) + 90.0f));
            d();
            float[] fArr = this.e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.k.p()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        BaseKeyframeAnimation<a62, a62> baseKeyframeAnimation3 = this.h;
        if (baseKeyframeAnimation3 != null) {
            a62 h2 = baseKeyframeAnimation3.h();
            if (h2.b() != 1.0f || h2.c() != 1.0f) {
                this.a.preScale(h2.b(), h2.c());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            PointF h3 = baseKeyframeAnimation4.h();
            float f3 = h3.x;
            if (f3 != 0.0f || h3.y != 0.0f) {
                this.a.preTranslate(-f3, -h3.y);
            }
        }
        return this.a;
    }

    public Matrix g(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        PointF h = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.h();
        BaseKeyframeAnimation<a62, a62> baseKeyframeAnimation2 = this.h;
        a62 h2 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.h();
        this.a.reset();
        if (h != null) {
            this.a.preTranslate(h.x * f, h.y * f);
        }
        if (h2 != null) {
            double d = f;
            this.a.preScale((float) Math.pow(h2.b(), d), (float) Math.pow(h2.c(), d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.h().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
            PointF h3 = baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.h() : null;
            this.a.preRotate(floatValue * f, h3 == null ? 0.0f : h3.x, h3 != null ? h3.y : 0.0f);
        }
        return this.a;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> h() {
        return this.j;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> i() {
        return this.m;
    }

    public void j(float f) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.m(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.m(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.m(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.m(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.m(f);
        }
        BaseKeyframeAnimation<a62, a62> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.m(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.m(f);
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.m(f);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.m(f);
        }
    }
}
