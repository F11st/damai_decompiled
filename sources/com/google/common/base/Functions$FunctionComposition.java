package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class Functions$FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
    private static final long serialVersionUID = 0;
    private final Function<A, ? extends B> f;
    private final Function<B, C> g;

    public Functions$FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
        this.g = (Function) du1.p(function);
        this.f = (Function) du1.p(function2);
    }

    @Override // com.google.common.base.Function
    public C apply(@NullableDecl A a) {
        return this.g.apply(this.f.apply(a));
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$FunctionComposition) {
            Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
            return this.f.equals(functions$FunctionComposition.f) && this.g.equals(functions$FunctionComposition.g);
        }
        return false;
    }

    public int hashCode() {
        return this.f.hashCode() ^ this.g.hashCode();
    }

    public String toString() {
        return this.g + jn1.BRACKET_START_STR + this.f + jn1.BRACKET_END_STR;
    }
}
