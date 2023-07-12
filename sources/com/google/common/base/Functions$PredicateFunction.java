package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class Functions$PredicateFunction<T> implements Function<T, Boolean>, Serializable {
    private static final long serialVersionUID = 0;
    private final Predicate<T> predicate;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Function
    public /* bridge */ /* synthetic */ Boolean apply(@NullableDecl Object obj) {
        return apply((Functions$PredicateFunction<T>) obj);
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$PredicateFunction) {
            return this.predicate.equals(((Functions$PredicateFunction) obj).predicate);
        }
        return false;
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        return "Functions.forPredicate(" + this.predicate + jn1.BRACKET_END_STR;
    }

    private Functions$PredicateFunction(Predicate<T> predicate) {
        this.predicate = (Predicate) du1.p(predicate);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.common.base.Function
    public Boolean apply(@NullableDecl T t) {
        return Boolean.valueOf(this.predicate.apply(t));
    }
}
