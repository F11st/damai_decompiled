package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.eg1;
import tb.it0;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.a */
/* loaded from: classes9.dex */
public class C2847a extends AbstractC2851e<Integer> {
    public C2847a(List<u71<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(u71<Integer> u71Var, float f) {
        Integer num;
        Integer num2 = u71Var.b;
        if (num2 != null && u71Var.c != null) {
            int intValue = num2.intValue();
            int intValue2 = u71Var.c.intValue();
            lc1<A> lc1Var = this.e;
            if (lc1Var != 0 && (num = (Integer) lc1Var.b(u71Var.g, u71Var.h.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, e(), f())) != null) {
                return num.intValue();
            }
            return it0.c(eg1.c(f, 0.0f, 1.0f), intValue, intValue2);
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
