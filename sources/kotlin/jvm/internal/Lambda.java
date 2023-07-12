package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import tb.a12;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        String l = a12.l(this);
        b41.h(l, "renderLambdaToString(this)");
        return l;
    }
}
