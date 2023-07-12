package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.google.protobuf.k */
/* loaded from: classes10.dex */
public final class C5408k<E> extends AbstractC5396b<E> {
    private static final C5408k<Object> c;
    private final List<E> b;

    static {
        C5408k<Object> c5408k = new C5408k<>();
        c = c5408k;
        c5408k.makeImmutable();
    }

    C5408k() {
        this(new ArrayList(10));
    }

    public static <E> C5408k<E> b() {
        return (C5408k<E>) c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        a();
        this.b.add(i, e);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    /* renamed from: c */
    public C5408k<E> mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            return new C5408k<>(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        a();
        E remove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        a();
        E e2 = this.b.set(i, e);
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.b.size();
    }

    private C5408k(List<E> list) {
        this.b = list;
    }
}
