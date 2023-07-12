package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.g */
/* loaded from: classes9.dex */
public class C2853g extends AbstractC2851e<PointF> {
    private final PointF i;
    private final float[] j;
    private final PathMeasure k;
    private C2852f l;

    public C2853g(List<? extends u71<PointF>> list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.k = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public PointF i(u71<PointF> u71Var, float f) {
        PointF pointF;
        C2852f c2852f = (C2852f) u71Var;
        Path j = c2852f.j();
        if (j == null) {
            return u71Var.b;
        }
        lc1<A> lc1Var = this.e;
        if (lc1Var == 0 || (pointF = (PointF) lc1Var.b(c2852f.g, c2852f.h.floatValue(), c2852f.b, c2852f.c, e(), f, f())) == null) {
            if (this.l != c2852f) {
                this.k.setPath(j, false);
                this.l = c2852f;
            }
            PathMeasure pathMeasure = this.k;
            pathMeasure.getPosTan(f * pathMeasure.getLength(), this.j, null);
            PointF pointF2 = this.i;
            float[] fArr = this.j;
            pointF2.set(fArr[0], fArr[1]);
            return this.i;
        }
        return pointF;
    }
}
