package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.eg1;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.d */
/* loaded from: classes9.dex */
public class C2850d extends AbstractC2851e<Integer> {
    public C2850d(List<u71<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    int q(u71<Integer> u71Var, float f) {
        Integer num;
        if (u71Var.b != null && u71Var.c != null) {
            lc1<A> lc1Var = this.e;
            if (lc1Var != 0 && (num = (Integer) lc1Var.b(u71Var.g, u71Var.h.floatValue(), u71Var.b, u71Var.c, f, e(), f())) != null) {
                return num.intValue();
            }
            return eg1.l(u71Var.g(), u71Var.d(), f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: r */
    public Integer i(u71<Integer> u71Var, float f) {
        return Integer.valueOf(q(u71Var, f));
    }
}
