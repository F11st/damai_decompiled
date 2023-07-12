package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.eg1;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class b extends e<Float> {
    public b(List<u71<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    float q(u71<Float> u71Var, float f) {
        Float f2;
        if (u71Var.b != null && u71Var.c != null) {
            lc1<A> lc1Var = this.e;
            if (lc1Var != 0 && (f2 = (Float) lc1Var.b(u71Var.g, u71Var.h.floatValue(), u71Var.b, u71Var.c, f, e(), f())) != null) {
                return f2.floatValue();
            }
            return eg1.k(u71Var.f(), u71Var.c(), f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: r */
    public Float i(u71<Float> u71Var, float f) {
        return Float.valueOf(q(u71Var, f));
    }
}
