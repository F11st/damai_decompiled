package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class g extends e<PointF> {
    private final PointF i;
    private final float[] j;
    private final PathMeasure k;
    private f l;

    public g(List<? extends u71<PointF>> list) {
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
        f fVar = (f) u71Var;
        Path j = fVar.j();
        if (j == null) {
            return u71Var.b;
        }
        lc1<A> lc1Var = this.e;
        if (lc1Var == 0 || (pointF = (PointF) lc1Var.b(fVar.g, fVar.h.floatValue(), fVar.b, fVar.c, e(), f, f())) == null) {
            if (this.l != fVar) {
                this.k.setPath(j, false);
                this.l = fVar;
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
