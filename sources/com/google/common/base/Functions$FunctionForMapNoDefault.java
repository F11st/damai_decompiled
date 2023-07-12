package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class Functions$FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    final Map<K, V> map;

    Functions$FunctionForMapNoDefault(Map<K, V> map) {
        this.map = (Map) du1.p(map);
    }

    @Override // com.google.common.base.Function
    public V apply(@NullableDecl K k) {
        V v = this.map.get(k);
        du1.k(v != null || this.map.containsKey(k), "Key '%s' not present in map", k);
        return v;
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$FunctionForMapNoDefault) {
            return this.map.equals(((Functions$FunctionForMapNoDefault) obj).map);
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "Functions.forMap(" + this.map + jn1.BRACKET_END_STR;
    }
}
