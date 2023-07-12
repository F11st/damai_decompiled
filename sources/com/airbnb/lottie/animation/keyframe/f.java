package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import tb.aw2;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class f extends u71<PointF> {
    @Nullable
    private Path q;
    private final u71<PointF> r;

    public f(com.airbnb.lottie.a aVar, u71<PointF> u71Var) {
        super(aVar, u71Var.b, u71Var.c, u71Var.d, u71Var.e, u71Var.f, u71Var.g, u71Var.h);
        this.r = u71Var;
        i();
    }

    public void i() {
        T t;
        T t2;
        T t3 = this.c;
        boolean z = (t3 == 0 || (t2 = this.b) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.b;
        if (t4 == 0 || (t = this.c) == 0 || z) {
            return;
        }
        u71<PointF> u71Var = this.r;
        this.q = aw2.d((PointF) t4, (PointF) t, u71Var.o, u71Var.p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path j() {
        return this.q;
    }
}
