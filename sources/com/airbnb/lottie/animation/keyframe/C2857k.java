package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.k */
/* loaded from: classes9.dex */
public class C2857k extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF i;
    private final PointF j;
    private final BaseKeyframeAnimation<Float, Float> k;
    private final BaseKeyframeAnimation<Float, Float> l;
    @Nullable
    protected lc1<Float> m;
    @Nullable
    protected lc1<Float> n;

    public C2857k(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = new PointF();
        this.k = baseKeyframeAnimation;
        this.l = baseKeyframeAnimation2;
        m(f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f) {
        this.k.m(f);
        this.l.m(f);
        this.i.set(this.k.h().floatValue(), this.l.h().floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).onValueChanged();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: q */
    public PointF i(u71<PointF> u71Var, float f) {
        Float f2;
        u71<Float> b;
        u71<Float> b2;
        Float f3 = null;
        if (this.m == null || (b2 = this.k.b()) == null) {
            f2 = null;
        } else {
            float d = this.k.d();
            Float f4 = b2.h;
            lc1<Float> lc1Var = this.m;
            float f5 = b2.g;
            f2 = lc1Var.b(f5, f4 == null ? f5 : f4.floatValue(), b2.b, b2.c, f, f, d);
        }
        if (this.n != null && (b = this.l.b()) != null) {
            float d2 = this.l.d();
            Float f6 = b.h;
            lc1<Float> lc1Var2 = this.n;
            float f7 = b.g;
            f3 = lc1Var2.b(f7, f6 == null ? f7 : f6.floatValue(), b.b, b.c, f, f, d2);
        }
        if (f2 == null) {
            this.j.set(this.i.x, 0.0f);
        } else {
            this.j.set(f2.floatValue(), 0.0f);
        }
        if (f3 == null) {
            PointF pointF = this.j;
            pointF.set(pointF.x, this.i.y);
        } else {
            PointF pointF2 = this.j;
            pointF2.set(pointF2.x, f3.floatValue());
        }
        return this.j;
    }

    public void r(@Nullable lc1<Float> lc1Var) {
        lc1<Float> lc1Var2 = this.m;
        if (lc1Var2 != null) {
            lc1Var2.c(null);
        }
        this.m = lc1Var;
        if (lc1Var != null) {
            lc1Var.c(this);
        }
    }

    public void s(@Nullable lc1<Float> lc1Var) {
        lc1<Float> lc1Var2 = this.n;
        if (lc1Var2 != null) {
            lc1Var2.c(null);
        }
        this.n = lc1Var;
        if (lc1Var != null) {
            lc1Var.c(this);
        }
    }
}
