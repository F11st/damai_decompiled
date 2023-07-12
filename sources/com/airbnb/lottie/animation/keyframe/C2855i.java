package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.a62;
import tb.eg1;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.i */
/* loaded from: classes9.dex */
public class C2855i extends AbstractC2851e<a62> {
    private final a62 i;

    public C2855i(List<u71<a62>> list) {
        super(list);
        this.i = new a62();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public a62 i(u71<a62> u71Var, float f) {
        a62 a62Var;
        a62 a62Var2;
        a62 a62Var3 = u71Var.b;
        if (a62Var3 != null && (a62Var = u71Var.c) != null) {
            a62 a62Var4 = a62Var3;
            a62 a62Var5 = a62Var;
            lc1<A> lc1Var = this.e;
            if (lc1Var == 0 || (a62Var2 = (a62) lc1Var.b(u71Var.g, u71Var.h.floatValue(), a62Var4, a62Var5, f, e(), f())) == null) {
                this.i.d(eg1.k(a62Var4.b(), a62Var5.b(), f), eg1.k(a62Var4.c(), a62Var5.c(), f));
                return this.i;
            }
            return a62Var2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
