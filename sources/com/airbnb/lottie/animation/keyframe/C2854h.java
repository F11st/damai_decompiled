package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import java.util.List;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.h */
/* loaded from: classes9.dex */
public class C2854h extends AbstractC2851e<PointF> {
    private final PointF i;

    public C2854h(List<u71<PointF>> list) {
        super(list);
        this.i = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public PointF i(u71<PointF> u71Var, float f) {
        return j(u71Var, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: q */
    public PointF j(u71<PointF> u71Var, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = u71Var.b;
        if (pointF3 != null && (pointF = u71Var.c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            lc1<A> lc1Var = this.e;
            if (lc1Var == 0 || (pointF2 = (PointF) lc1Var.b(u71Var.g, u71Var.h.floatValue(), pointF4, pointF5, f, e(), f())) == null) {
                PointF pointF6 = this.i;
                float f4 = pointF4.x;
                float f5 = f4 + (f2 * (pointF5.x - f4));
                float f6 = pointF4.y;
                pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
                return this.i;
            }
            return pointF2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
