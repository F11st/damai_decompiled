package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;
import tb.nm1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class Functions$ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    @NullableDecl
    final V defaultValue;
    final Map<K, ? extends V> map;

    Functions$ForMapWithDefault(Map<K, ? extends V> map, @NullableDecl V v) {
        this.map = (Map) du1.p(map);
        this.defaultValue = v;
    }

    @Override // com.google.common.base.Function
    public V apply(@NullableDecl K k) {
        V v = this.map.get(k);
        return (v != null || this.map.containsKey(k)) ? v : this.defaultValue;
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$ForMapWithDefault) {
            Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault) obj;
            return this.map.equals(functions$ForMapWithDefault.map) && nm1.a(this.defaultValue, functions$ForMapWithDefault.defaultValue);
        }
        return false;
    }

    public int hashCode() {
        return nm1.b(this.map, this.defaultValue);
    }

    public String toString() {
        return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + jn1.BRACKET_END_STR;
    }
}
