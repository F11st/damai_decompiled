package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.nm1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class s<E> extends o<E> implements Multiset<E> {
    @CanIgnoreReturnValue
    public int add(E e, int i) {
        return delegate().add(e, i);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        return delegate().count(obj);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract Multiset<E> delegate();

    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract /* bridge */ /* synthetic */ Collection delegate();

    public abstract Set<E> elementSet();

    public abstract Set<Multiset.Entry<E>> entrySet();

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    @CanIgnoreReturnValue
    public int remove(Object obj, int i) {
        return delegate().remove(obj, i);
    }

    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        return delegate().setCount(e, i);
    }

    protected boolean standardAdd(E e) {
        add(e, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    @Beta
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // com.google.common.collect.o
    protected void standardClear() {
        Iterators.d(entrySet().iterator());
    }

    @Override // com.google.common.collect.o
    protected boolean standardContains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    @Beta
    protected int standardCount(@NullableDecl Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (nm1.a(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    protected boolean standardEquals(@NullableDecl Object obj) {
        return Multisets.f(this, obj);
    }

    protected int standardHashCode() {
        return entrySet().hashCode();
    }

    protected Iterator<E> standardIterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.o
    protected boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // com.google.common.collect.o
    protected boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    protected int standardSetCount(E e, int i) {
        return Multisets.m(this, e, i);
    }

    protected int standardSize() {
        return Multisets.j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public String standardToString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        return delegate().setCount(e, i, i2);
    }

    protected boolean standardSetCount(E e, int i, int i2) {
        return Multisets.n(this, e, i, i2);
    }
}
