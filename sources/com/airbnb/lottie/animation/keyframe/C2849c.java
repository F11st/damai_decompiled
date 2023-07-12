package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.qu0;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.c */
/* loaded from: classes9.dex */
public class C2849c extends AbstractC2851e<qu0> {
    private final qu0 i;

    public C2849c(List<u71<qu0>> list) {
        super(list);
        qu0 qu0Var = list.get(0).b;
        int c = qu0Var != null ? qu0Var.c() : 0;
        this.i = new qu0(new float[c], new int[c]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public qu0 i(u71<qu0> u71Var, float f) {
        this.i.d(u71Var.b, u71Var.c, f);
        return this.i;
    }
}
