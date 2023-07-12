package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.Nullable;
import java.util.Collections;
import tb.ic1;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class n<K, A> extends BaseKeyframeAnimation<K, A> {
    private final A i;

    public n(lc1<A> lc1Var) {
        this(lc1Var, null);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A h() {
        lc1<A> lc1Var = this.e;
        A a = this.i;
        return lc1Var.b(0.0f, 0.0f, a, a, f(), f(), f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    A i(u71<K> u71Var, float f) {
        return h();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void k() {
        if (this.e != null) {
            super.k();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f) {
        this.d = f;
    }

    public n(lc1<A> lc1Var, @Nullable A a) {
        super(Collections.emptyList());
        new ic1();
        n(lc1Var);
        this.i = a;
    }
}
