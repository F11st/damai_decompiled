package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import java.util.List;
import tb.eg1;
import tb.jb2;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.keyframe.j */
/* loaded from: classes9.dex */
public class C2856j extends BaseKeyframeAnimation<jb2, Path> {
    private final jb2 i;
    private final Path j;

    public C2856j(List<u71<jb2>> list) {
        super(list);
        this.i = new jb2();
        this.j = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public Path i(u71<jb2> u71Var, float f) {
        this.i.c(u71Var.b, u71Var.c, f);
        eg1.i(this.i, this.j);
        return this.j;
    }
}
