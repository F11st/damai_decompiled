package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient c0<E> backingMap;
    transient long size;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a extends AbstractMapBasedMultiset<E>.c<E> {
        a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        E b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.i(i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class b extends AbstractMapBasedMultiset<E>.c<Multiset.Entry<E>> {
        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* renamed from: c */
        public Multiset.Entry<E> b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.g(i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    abstract class c<T> implements Iterator<T> {
        int a;
        int b = -1;
        int c;

        c() {
            this.a = AbstractMapBasedMultiset.this.backingMap.e();
            this.c = AbstractMapBasedMultiset.this.backingMap.d;
        }

        private void a() {
            if (AbstractMapBasedMultiset.this.backingMap.d != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.a >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T b = b(this.a);
                int i = this.a;
                this.b = i;
                this.a = AbstractMapBasedMultiset.this.backingMap.s(i);
                return b;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            AbstractMapBasedMultiset abstractMapBasedMultiset;
            a();
            k.e(this.b != -1);
            AbstractMapBasedMultiset.this.size -= abstractMapBasedMultiset.backingMap.x(this.b);
            this.a = AbstractMapBasedMultiset.this.backingMap.t(this.a, this.b);
            this.b = -1;
            this.c = AbstractMapBasedMultiset.this.backingMap.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMapBasedMultiset(int i) {
        init(i);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h = f0.h(objectInputStream);
        init(3);
        f0.g(this, objectInputStream, h);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        f0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e, int i) {
        if (i == 0) {
            return count(e);
        }
        du1.f(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(e);
        if (m == -1) {
            this.backingMap.u(e, i);
            this.size += i;
            return 0;
        }
        int k = this.backingMap.k(m);
        long j = i;
        long j2 = k + j;
        du1.h(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.backingMap.B(m, (int) j2);
        this.size += j;
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTo(Multiset<? super E> multiset) {
        du1.p(multiset);
        int e = this.backingMap.e();
        while (e >= 0) {
            multiset.add((E) this.backingMap.i(e), this.backingMap.k(e));
            e = this.backingMap.s(e);
        }
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@NullableDecl Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.d
    final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.d
    final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d
    final Iterator<Multiset.Entry<E>> entryIterator() {
        return new b();
    }

    abstract void init(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        du1.f(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(obj);
        if (m == -1) {
            return 0;
        }
        int k = this.backingMap.k(m);
        if (k > i) {
            this.backingMap.B(m, k - i);
        } else {
            this.backingMap.x(m);
            i = k;
        }
        this.size -= i;
        return k;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e, int i) {
        k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        c0<E> c0Var = this.backingMap;
        int v = i == 0 ? c0Var.v(e) : c0Var.u(e, i);
        this.size += i - v;
        return v;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.j(this.size);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    public final boolean setCount(@NullableDecl E e, int i, int i2) {
        k.b(i, "oldCount");
        k.b(i2, "newCount");
        int m = this.backingMap.m(e);
        if (m == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.u(e, i2);
                this.size += i2;
            }
            return true;
        } else if (this.backingMap.k(m) != i) {
            return false;
        } else {
            if (i2 == 0) {
                this.backingMap.x(m);
                this.size -= i;
            } else {
                this.backingMap.B(m, i2);
                this.size += i2 - i;
            }
            return true;
        }
    }
}
