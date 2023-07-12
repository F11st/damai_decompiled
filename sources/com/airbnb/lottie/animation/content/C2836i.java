package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.List;
import tb.eg1;
import tb.lc1;
import tb.s71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.i */
/* loaded from: classes9.dex */
public class C2836i implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String b;
    private final LottieDrawable c;
    private final PolystarShape.Type d;
    private final boolean e;
    private final BaseKeyframeAnimation<?, Float> f;
    private final BaseKeyframeAnimation<?, PointF> g;
    private final BaseKeyframeAnimation<?, Float> h;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> i;
    private final BaseKeyframeAnimation<?, Float> j;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> k;
    private final BaseKeyframeAnimation<?, Float> l;
    private boolean n;
    private final Path a = new Path();
    private C2828b m = new C2828b();

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.animation.content.i$a */
    /* loaded from: classes17.dex */
    static /* synthetic */ class C2837a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C2836i(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, PolystarShape polystarShape) {
        this.c = lottieDrawable;
        this.b = polystarShape.c();
        PolystarShape.Type i = polystarShape.i();
        this.d = i;
        this.e = polystarShape.j();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.f().createAnimation();
        this.f = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.g().createAnimation();
        this.g = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.h().createAnimation();
        this.h = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.d().createAnimation();
        this.j = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.e().createAnimation();
        this.l = createAnimation5;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (i == type) {
            this.i = polystarShape.a().createAnimation();
            this.k = polystarShape.b().createAnimation();
        } else {
            this.i = null;
            this.k = null;
        }
        abstractC2872a.c(createAnimation);
        abstractC2872a.c(createAnimation2);
        abstractC2872a.c(createAnimation3);
        abstractC2872a.c(createAnimation4);
        abstractC2872a.c(createAnimation5);
        if (i == type) {
            abstractC2872a.c(this.i);
            abstractC2872a.c(this.k);
        }
        createAnimation.a(this);
        createAnimation2.a(this);
        createAnimation3.a(this);
        createAnimation4.a(this);
        createAnimation5.a(this);
        if (i == type) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void a() {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        double d;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor(this.f.h().floatValue());
        double radians = Math.toRadians((this.h == null ? 0.0d : baseKeyframeAnimation.h().floatValue()) - 90.0d);
        double d4 = floor;
        float floatValue = this.l.h().floatValue() / 100.0f;
        float floatValue2 = this.j.h().floatValue();
        double d5 = floatValue2;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.a.moveTo(cos, sin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < ceil) {
            float cos2 = (float) (Math.cos(d7) * d5);
            double d8 = ceil;
            float sin2 = (float) (d5 * Math.sin(d7));
            if (floatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d3 = d6;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f = floatValue2 * floatValue * 0.25f;
                this.a.cubicTo(cos - (cos3 * f), sin - (((float) Math.sin(atan2)) * f), cos2 + (((float) Math.cos(atan22)) * f), sin2 + (f * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d = d7;
                d2 = d5;
                d3 = d6;
                i = i2;
                this.a.lineTo(cos2, sin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF h = this.g.h();
        this.a.offset(h.x, h.y);
        this.a.close();
    }

    private void b() {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        double d;
        int i;
        double d2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        double d3;
        float f7;
        float f8;
        float f9;
        float floatValue = this.f.h().floatValue();
        double radians = Math.toRadians((this.h == null ? 0.0d : baseKeyframeAnimation.h().floatValue()) - 90.0d);
        double d4 = floatValue;
        float f10 = (float) (6.283185307179586d / d4);
        float f11 = f10 / 2.0f;
        float f12 = floatValue - ((int) floatValue);
        int i2 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f12) * f11;
        }
        float floatValue2 = this.j.h().floatValue();
        float floatValue3 = this.i.h().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.k;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.h().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.l;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.h().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f3 = ((floatValue2 - floatValue3) * f12) + floatValue3;
            i = i2;
            double d5 = f3;
            d = d4;
            f = (float) (d5 * Math.cos(radians));
            f2 = (float) (d5 * Math.sin(radians));
            this.a.moveTo(f, f2);
            d2 = radians + ((f10 * f12) / 2.0f);
        } else {
            d = d4;
            i = i2;
            double d6 = floatValue2;
            float cos = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.a.moveTo(cos, sin);
            d2 = radians + f11;
            f = cos;
            f2 = sin;
            f3 = 0.0f;
        }
        double ceil = Math.ceil(d) * 2.0d;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 < ceil) {
                float f13 = z ? floatValue2 : floatValue3;
                int i4 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                if (i4 == 0 || d7 != ceil - 2.0d) {
                    f4 = f10;
                    f5 = f11;
                } else {
                    f4 = f10;
                    f5 = (f10 * f12) / 2.0f;
                }
                if (i4 == 0 || d7 != ceil - 1.0d) {
                    f6 = f11;
                    d3 = d7;
                    f7 = f13;
                } else {
                    f6 = f11;
                    d3 = d7;
                    f7 = f3;
                }
                double d8 = f7;
                double d9 = ceil;
                float cos2 = (float) (d8 * Math.cos(d2));
                float sin2 = (float) (d8 * Math.sin(d2));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.a.lineTo(cos2, sin2);
                    f8 = floatValue4;
                    f9 = f3;
                } else {
                    f8 = floatValue4;
                    f9 = f3;
                    double atan2 = (float) (Math.atan2(f2, f) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f14 = z ? f8 : floatValue5;
                    float f15 = z ? floatValue5 : f8;
                    float f16 = (z ? floatValue3 : floatValue2) * f14 * 0.47829f;
                    float f17 = cos3 * f16;
                    float f18 = f16 * sin3;
                    float f19 = (z ? floatValue2 : floatValue3) * f15 * 0.47829f;
                    float f20 = cos4 * f19;
                    float f21 = f19 * sin4;
                    if (i != 0) {
                        if (i3 == 0) {
                            f17 *= f12;
                            f18 *= f12;
                        } else if (d3 == d9 - 1.0d) {
                            f20 *= f12;
                            f21 *= f12;
                        }
                    }
                    this.a.cubicTo(f - f17, f2 - f18, cos2 + f20, sin2 + f21, cos2, sin2);
                }
                d2 += f5;
                z = !z;
                i3++;
                f = cos2;
                f2 = sin2;
                floatValue4 = f8;
                f3 = f9;
                f11 = f6;
                f10 = f4;
                ceil = d9;
            } else {
                PointF h = this.g.h();
                this.a.offset(h.x, h.y);
                this.a.close();
                return;
            }
        }
    }

    private void c() {
        this.n = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.f.n(lc1Var);
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.h.n(lc1Var);
        } else if (t == LottieProperty.POSITION) {
            this.g.n(lc1Var);
        } else if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.i) != null) {
            baseKeyframeAnimation2.n(lc1Var);
        } else if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.j.n(lc1Var);
        } else if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.k) != null) {
            baseKeyframeAnimation.n(lc1Var);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.l.n(lc1Var);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        int i = C2837a.a[this.d.ordinal()];
        if (i == 1) {
            b();
        } else if (i == 2) {
            a();
        }
        this.a.close();
        this.m.b(this.a);
        this.n = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        c();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        eg1.m(s71Var, i, list, s71Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof C2842n) {
                C2842n c2842n = (C2842n) content;
                if (c2842n.e() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.m.a(c2842n);
                    c2842n.a(this);
                }
            }
        }
    }
}
